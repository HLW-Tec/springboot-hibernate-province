package com.zwd.core.mappers;

import com.zwd.core.entity.Area;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface AreaMapper extends JpaRepository<Area,Long> {


//    @Query("update province set code=:code,name=:name where id=:id")
//    int update(Integer id, String code, String name,String citycode);
  @Query("delete from Area where citycode=?1")
  void deleteforCitycode(@Param("citycode") String citycode);
}
