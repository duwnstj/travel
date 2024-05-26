package net.daum.vo;

import javax.persistence.Entity;
import javax.persistence.Id;
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
}