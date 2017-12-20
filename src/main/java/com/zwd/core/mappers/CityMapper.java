package com.zwd.core.mappers;

import com.zwd.core.entity.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CityMapper extends JpaRepository<City,Long> {

//    @Query("update province set code=:code,name=:name where id=:id")
//    int update(Integer id, String code, String name,String citycode);
    @Query(value = "select id,code,name,provincecode from City city where city.code=?1")
    List<City> findCode(@Param("code") String code);
    @Query("delete from City city where city.provincecode=?1")
    void deleteforProvinceCode(String provincecode);
}
