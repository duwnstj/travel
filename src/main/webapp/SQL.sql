

select *  from postmake;

SELECT * FROM postmake WHERE sequence_name = 'mate_no_seq'

drop table postmake;

alter sequence mate_no_seq
nocache; --nocache로 수정
 
alter sequence mate_no_seq
nocycle; --nocycle로 수정