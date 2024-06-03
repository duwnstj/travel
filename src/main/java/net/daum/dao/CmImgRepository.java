package net.daum.dao;





import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import net.daum.vo.Cm_ImgVO;

public interface CmImgRepository extends JpaRepository<Cm_ImgVO, Long> {

	
	@Query("Select i from Cm_ImgVO i where i.mateno2 = :mateno")
	Cm_ImgVO getByMateno2(@Param("mateno") Long mateno2);

	
	
	

	

	

}
