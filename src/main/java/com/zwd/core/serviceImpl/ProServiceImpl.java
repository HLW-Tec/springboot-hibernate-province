package com.zwd.core.serviceImpl;

import com.zwd.core.entity.City;
import com.zwd.core.entity.Province;
import com.zwd.core.exception.Wrong;
import com.zwd.core.mappers.ProvinceMapper;
import com.zwd.core.service.CityService;
import com.zwd.core.service.ProvinceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.constraints.Null;
import java.util.List;

@Service
public class ProServiceImpl implements ProvinceService {
    @Autowired
    private ProvinceMapper provinceMapper;
    @Autowired
    private CityService cityService;
    @Override
    public String add(Province province) {

         if(provinceMapper.save(province)== null)
        {
            return "添加失败";
        };
         return "添加成功";
    }

    @Override
    public Province find(int id) {
        return provinceMapper.findOne(id);

    }

    public String delete(int id){
//        cityService.deleteforCode(province.getCode());
        Province province=find(id);
        try {
            provinceMapper.delete(id);              //当id不存在时，抛出异常
            cityService.deleteforProvinceCode(province.getCode());
        }
        catch (Exception e)
        {
            e.printStackTrace();
            return "删除失败";
        }
         return "删除成功";
    }

    @Override
    public String update(Province province) {


//        cityService.updateCode(selectId(province.getId()).getCode(),province.getCode());
        if (provinceMapper.saveAndFlush(province)==null)
        {
            return "更新失败";
        };

        return "更新成功";
    }

    @Override
    public List<Province> findCode(String code) {
        System.out.println("zzzz"+code);
        return provinceMapper.findCode(code);
    }
}
