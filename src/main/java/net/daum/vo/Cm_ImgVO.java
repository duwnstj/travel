package net.daum.vo;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.CreationTimestamp;
import org.springframework.web.multipart.MultipartFile;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@Entity
@SequenceGenerator(
		name = "cmimg_no_seq_gename",
		sequenceName ="cmimg_no_seq",
		initialValue = 1,
		allocationSize = 1
		)
@Table(name="cm_img")
@EqualsAndHashCode(of="cmimg_no")
public class Cm_ImgVO {
	@Id
	@GeneratedValue(
			strategy = GenerationType.SEQUENCE,
			generator = "cmimg_no_seq_gename"
			)
	private Long cmimg_no;
	//부모 엔티티빈에서 외래키로 게시글번호 참조
	
	private String uploadFile; // 파일의 저장 경로를 저장하는 필드
	
	 @Transient
	private MultipartFile uploadFile2 ;
	
	@CreationTimestamp
	private Timestamp uploaddate;
	
	
	

	
}
