package com.zwd.core.mappers;

import com.zwd.core.entity.City;
import com.zwd.core.entity.Province;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.persistence.Table;
import java.util.List;


public interface ProvinceMapper extends JpaRepository<Province,Integer> {


//    @Query("update province set code=:code,name=:name where id=:id")
//    Integer update(@Param("id") Integer id, @Param("code") String code,@Param("name") String name);
    @Query("select id,code,name from Province province where province.code=?1")
    List<Province> findCode(@Param("code") String code);
}
