package net.daum.vo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Entity
@SequenceGenerator(// 오라클 시퀀스 생성기
		name = "mate_noseq_gename", sequenceName = "mate_no_seq", // 시퀀스 이름
		initialValue = 1, // 시퀀스 시작값
		allocationSize = 1

)
@Table(name = "community_board")
@EqualsAndHashCode(of = "mate_no")
public class Community_boardVO {

	@Id // 기본키
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "mate_noseq_gename")
	private int mate_no;// 기본키

	private String mate_id;
	private int mate_hit;
	private String mate_title;
	private String mate_cont;
	private String makedate;
	private String updatedate;
	private int mate_matching;
	private String mate_sumnail;
	private int mate_postuse;
	private int mate_limited;

}
