package com.zwd.core.controller;


import com.zwd.core.entity.Area;
import com.zwd.core.service.AreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.xml.ws.soap.Addressing;
import java.util.Map;

@Controller
@EnableAutoConfiguration
@RequestMapping(value = "/area")
public class AreaController {
    @Autowired
    private AreaService areaService;
    @RequestMapping(value = "/add")
    public String saveArea(Area area, Model model){
        System.out.println("哈哈哈");
        model.addAttribute("addInfo",areaService.add(area));
        return "area/add";
    }

    /**
     * 根据id查找信息
     * @param id
     * @param model
     * @return
     */
    @RequestMapping(value = "/find")
    public String findArea(int id,Model model){

        model.addAttribute("Area",areaService.find(id));
        return "area/select";
    }

    /**
     * 根据id进行删除
     *
     * @return String
     **/
    @RequestMapping(value = "/delete")
    public String delete(int id, Map<String, String> map) {

        areaService.delete(id);
        map.put("msg", "删除成功");
        return "area/delete";
    }
    /*
   更新信息
    */
    @RequestMapping(value = "/update")
    public String update(Area area, Model model) {

        model.addAttribute("msg",areaService.update(area));
        return "area/update";
    }
}
