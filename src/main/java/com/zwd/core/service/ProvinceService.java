package com.zwd.core.service;

import com.zwd.core.entity.Province;

import java.util.List;

public interface ProvinceService {

    public String add(Province province);
    public  String delete(int id);
    Province find(int id);
    public String update(Province province);
    public List<Province> findCode(String code);
}
