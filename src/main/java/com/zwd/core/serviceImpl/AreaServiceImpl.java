package com.zwd.core.serviceImpl;

import com.zwd.core.entity.Area;
import com.zwd.core.mappers.AreaMapper;
import com.zwd.core.mappers.CityMapper;
import com.zwd.core.service.AreaService;
import com.zwd.core.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AreaServiceImpl implements AreaService{
    @Autowired
    private AreaMapper areaMapper;
    @Autowired
    private CityService cityService;
    @Override
    public String add(Area area) {
        if(cityService.findCode(area.getCitycode()).isEmpty()||areaMapper.save(area)== null)
        {
            return "添加失败";
        };
        return "添加成功";
    }

    @Override
    public Area find(int id) {
        return areaMapper.findOne(Long.valueOf(id));

    }

    public String delete(int id){
//        cityService.deleteforCode(area.getCode());
        areaMapper.delete(Long.valueOf(id));
        return "删除成功";
    }

    @Override
    public String update(Area area) {

//        cityService.updateCode(selectId(area.getId()).getCode(),area.getCode());
        if (cityService.findCode(area.getCitycode())==null||areaMapper.saveAndFlush(area)==null)
        {
            return "更新失败";
        };

        return "更新成功";
    }

    @Override
    public void deleteforCityCode(String citycode) {
        areaMapper.deleteforCitycode(citycode);
    }
}
