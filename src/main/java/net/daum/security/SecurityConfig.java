package net.daum.security;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.rememberme.JdbcTokenRepositoryImpl;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;

import lombok.extern.java.Log;

@Log
@EnableWebSecurity // 이 애노테이션은 스프링 웹 시큐리티로 인식되게 한다.
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	// 스프링 웹 시큐리티 설정을 담당하는 WebSecurityConfigurerAdapter 클래스를 상속받는다.

	@Autowired
	DataSource dataSource; // DBCP 커넥션 풀 관리 DataSource를 통한 sql문 처리

	@Bean // 스프링 빈등록
	public PasswordEncoder passwordEncoder() {// 비번 암호화 빈등록
		return new BCryptPasswordEncoder();
	}// PasswordEncoder 빈등록하고 다른클래스에서 의존성 주입해야 에러 안나고 사용가능함.

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// HttpSecurity는 웹과 관련된 다양한 보안설정을 걸어 줄 수 있다.

		log.info("security config 시작.......");

		http.authorizeRequests().antMatchers("/guest/**").permitAll();
		/*
		 * authorizeRequests()는 시큐리티 처리에서 HttpServletRequest에 해당한다. antMatchers()에서는 특정한
		 * 경로를 지정한다. permitAll()은 모든 사용자가 접근할 수 있다는 것을 의미한다.
		 */
		http.authorizeRequests().antMatchers("/manager/**").hasRole("MANAGER");// hasRole()은 특정권한을 가진 사람만이 접근할 수 있다는 것을
		// 의미한다.
		http.authorizeRequests().antMatchers("/admin/**").hasRole("ADMIN");// /admin 매핑주소로
		// 접근할 때는 'ADMIN'이라는 권한이 있어야만 하는 설정 추가

		http.formLogin().loginPage("/login");
		/*
		 * http.formLogin()을 추가하면 스프링 시큐리티에서 제공하는 기본 로그인 페이지가 나 오게 한다.이때 사용하는 매핑주소는
		 * /login이 된다.
		 * 
		 * loginPage("/login")을 사용하면 매핑주소가 login인 사용자 즉 커스텀 로그인 페이지를 만들 수 있다.
		 */

		http.exceptionHandling().accessDeniedPage("/accessDenied");// 403 접근금지 에러가 났을 때 실행
		http.logout().logoutUrl("/logout").invalidateHttpSession(true);// 세션 무효화=>로그아웃

	}// configure() 메서드

}
