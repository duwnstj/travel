package net.daum.vo;



import java.sql.Timestamp;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Entity
@SequenceGenerator(// 오라클 시퀀스 생성기
		name = "mate_noseq_gename", 
		sequenceName = "mate_no_seq", // 시퀀스 이름
		initialValue = 1, // 시퀀스 시작값
		allocationSize = 1

)
@Table(name = "community_board")
@EqualsAndHashCode(of = "mate_no")
public class Community_boardVO {

	@Id // 기본키
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "mate_noseq_gename")
	private Long mate_no;// 기본키 게시글 번호


	private int mate_hit; //조회수
	private String mate_title; //제목
	
	@Column(length=4000)
	private String mate_cont; // 내용
	
	@CreationTimestamp //하이버네이트 기능으로 등록시점 날짜를 기록
	private Timestamp makedate;//등록 날짜
	
	@UpdateTimestamp
	private Timestamp updatedate;//하이버네이트 기능으로 업데이트 날짜 자동 기록
	
	private int mate_matching; //매칭상태 매칭된상태면 1, 매칭 안된 상태면 2
	private String mate_sumnail; //썸네일(이미지 썸네일)
	private int mate_limited; //제한인원 설정
	private String mt_hashtag; //해시태그
	private int bbs_ref;//원본글과 답변글을 묶어주는 글 그룹번호 역할
	private int bbs_level; //답변글 정렬 순서
	
	/*
	 * @OneToMany(mappedBy="cm_board",cascade=CascadeType.ALL,fetch=FetchType.EAGER)
	 * private List<Cm_replVO> repls;//외래키로 댓글창에 기본키 참조
	 */	
	
	@OneToMany(mappedBy="cm_board",cascade=CascadeType.ALL,fetch=FetchType.LAZY)
	private List<Cm_ImgVO> images;//외래키로 게시판 이미지 테이블에 기본키 참조

}
