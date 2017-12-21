package com.zwd.core.serviceImpl;

import com.zwd.core.entity.City;
import com.zwd.core.mappers.CityMapper;
import com.zwd.core.service.AreaService;
import com.zwd.core.service.CityService;
import com.zwd.core.service.ProvinceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CityServiceImpl implements CityService{
    @Autowired
    private CityMapper cityMapper;
    @Autowired
    private ProvinceService provinceService;
    @Autowired
    private AreaService areaService;
    @Override
    public String add(City city) {

        if(provinceService.findCode(city.getProvincecode()).isEmpty()||cityMapper.save(city)==null)
        {
            return "添加失败";
        };
        System.out.println(provinceService.findCode(city.getProvincecode()));
        return "添加成功";
    }

    @Override
    public City find(int id) {
        return cityMapper.findOne(id);

    }

    public String delete(int id){
        City city=find(id);
        try {
            cityMapper.delete(id);                    //当id不存在时，抛出异常
            areaService.deleteforCityCode(city.getCode());
        }
        catch (Exception e)
        {
            e.printStackTrace();
            return "删除失败";
        }
        return "删除成功";
    }

    @Override
    public String update(City city) {


//        cityService.updateCode(selectId(city.getId()).getCode(),city.getCode());
        if (cityMapper.saveAndFlush(city)==null||provinceService.findCode(city.getProvincecode())==null)
        {
            return "更新失败";
        };

        return "更新成功";
    }

    @Override
    public List<City> findCode(String provincecode) {
        return cityMapper.findCode(provincecode);
    }

    @Override
    public void deleteforProvinceCode(String provincecode) {
        cityMapper.deleteforProvinceCode(provincecode);
    }
}
