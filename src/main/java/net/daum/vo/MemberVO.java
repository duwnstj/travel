package net.daum.vo;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@Entity
@Table(name="member")
@EqualsAndHashCode(of="member_id")
public class MemberVO {
   
   @Id
   private String member_id;
   
   
   private String member_name;
   private String resident_id;
   private String resident_id2;
   private String member_pwd;
   private String member_phone01;
   private String member_phone02;
   private String member_phone03;
   private String mail_id;
   private String mail_domain;
   private String sample6_postcode;
   private String sample6_address;
   private String sample6_detailAddress;
   private String sample6_extraAddress;
   private String role="NOPAIDUSER";
   
   @CreationTimestamp
   private Timestamp member_joinDate;
   
//   @OneToMany(mappedBy ="member")
//   private List<Community_boardVO> cmboard = new ArrayList<>();
//   

   
}