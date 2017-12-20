package com.zwd.core.service;

import com.zwd.core.entity.Area;
import com.zwd.core.entity.Province;

public interface AreaService {

    public String add(Area area);
    public  String delete(int id);
    Area find(int id);
    public String update(Area area);

    void deleteforCityCode(String citycode);
}
