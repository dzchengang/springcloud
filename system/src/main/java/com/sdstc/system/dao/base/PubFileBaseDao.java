package com.sdstc.system.dao.base;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import com.sdstc.system.model.PubFile;


public interface PubFileBaseDao {
   void  insert(PubFile dto);
   void  updateByPK(PubFile dto);
   void  updateSelectiveByPK(PubFile dto);
   void  deleteByPK(@Param("id") Long id,@Param("customerId") Long customerId);
   PubFile  selectByPK(@Param("id") Long id,@Param("customerId") Long customerId);
   List<PubFile> selectByDto(PubFile dto);
   
}