package net.daum.vo;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "Dermymember")
public class DermyMemberVO {
    
    @Id
    private Long member_no; //기본키
    
    private Long member_id;  
    private String username;
    private String password;
    private String hashtag;
    
    @OneToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
    @JoinColumn(name="member")
    private List<Community_boardVO> cm_boards;
}