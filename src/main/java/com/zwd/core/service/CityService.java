package com.zwd.core.service;

import com.zwd.core.entity.City;
import com.zwd.core.entity.Province;

import java.util.List;

public interface CityService {

    public String add(City city);
    public  String delete(int id);
    City find(int id);
    public String update(City city);

    List<City> findCode(String code);

    void deleteforProvinceCode(String provincecode);
}
