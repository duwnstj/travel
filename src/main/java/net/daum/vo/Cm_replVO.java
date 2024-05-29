/*
 * package net.daum.vo;
 * 
 * import java.sql.Timestamp;
 * 
 * import javax.persistence.Entity; import javax.persistence.FetchType; import
 * javax.persistence.GeneratedValue; import javax.persistence.GenerationType;
 * import javax.persistence.Id; import javax.persistence.JoinColumn; import
 * javax.persistence.ManyToOne; import javax.persistence.SequenceGenerator;
 * import javax.persistence.Table;
 * 
 * import org.hibernate.annotations.CreationTimestamp; import
 * org.hibernate.annotations.UpdateTimestamp;
 * 
 * import lombok.EqualsAndHashCode; import lombok.Getter; import lombok.Setter;
 * import lombok.ToString;
 * 
 * @Setter
 * 
 * @Getter
 * 
 * @ToString
 * 
 * @Entity
 * 
 * @SequenceGenerator(//시퀀스 생성기 name="repl_no_seq_gename", sequenceName =
 * "repl_no_seq", initialValue = 1, allocationSize = 1 )
 * 
 * @Table(name="cm_repl")
 * 
 * @EqualsAndHashCode(of="mt_replno")
 * 
 * public class Cm_replVO {
 * 
 * @Id
 * 
 * @GeneratedValue( strategy = GenerationType.SEQUENCE, //사용할 전략을 시퀀스로 선택
 * generator = "repl_no_seq_gename" ) private Long mt_replno ;//댓글번호
 * 
 * @ManyToOne(fetch = FetchType.EAGER)
 * 
 * @JoinColumn(name="mate_no") private Community_boardVO cm_board;
 * 
 * private String mt_replyer; // 댓글 작성자 private String mt_replcont ; //댓글내용
 * 
 * @CreationTimestamp private Timestamp cr_date;//작성한 날짜
 * 
 * @UpdateTimestamp private Timestamp mt_update; //댓글 수정 날짜
 * 
 * 
 * }
 */