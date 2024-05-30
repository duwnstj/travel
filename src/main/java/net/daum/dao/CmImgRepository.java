package net.daum.dao;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import net.daum.vo.Cm_ImgVO;

public interface CmImgRepository extends JpaRepository<Cm_ImgVO, Long> {

	

	

}
