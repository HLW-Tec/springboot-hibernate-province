package com.zwd.core.controller;

import com.zwd.core.entity.City;
import com.zwd.core.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;
@Controller
@EnableAutoConfiguration
@RequestMapping("/city")
public class CityController {
    @Autowired
    private CityService cityService;

    @RequestMapping(value = "/add")
    public String saveCity(City city, Model model){
        System.out.println("哈哈哈"+city.getName());
        model.addAttribute("addInfo",cityService.add(city));
        return "city/add";
    }

    /**
     * 根据id查找信息
     * @param id
     * @param model
     * @return
     */
    @RequestMapping(value = "/find")
    public String findCity(int id,Model model){

        model.addAttribute("city",cityService.find(id));
        return "city/select";
    }

    /**
     * 根据id进行删除
     *
     * @return String
     **/
    @RequestMapping(value = "/delete")
    public String delete(int id, Map<String, String> map) {

        cityService.delete(id);
        map.put("msg", "删除成功");
        return "city/delete";
    }
    /*
   更新信息
    */
    @RequestMapping(value = "/update")
    public String update(City city, Model model) {

        model.addAttribute("msg",cityService.update(city));
        return "city/update";
    }

}
