

select * from community_board;

drop table community_board;

alter sequence mate_no_seq
nocache; --nocache로 수정
 
alter sequence mate_no_seq
nocycle; --nocycle로 수정

--생성된 gongji_no_seq시퀀스 번호값 확인
select mate_no_seq.nextval as "시퀀스 번호값" from dual;

insert set 

alter sequence repl_no_seq
nocache;
alter sequence repl_no_seq
nocycle;