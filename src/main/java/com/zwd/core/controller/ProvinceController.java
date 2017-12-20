package com.zwd.core.controller;

import com.zwd.core.entity.Province;
import com.zwd.core.exception.Wrong;
import com.zwd.core.mappers.ProvinceMapper;
import com.zwd.core.service.ProvinceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

@Controller
@EnableAutoConfiguration
@RequestMapping("/province")
public class ProvinceController {
    @Autowired
    private ProvinceService provinceService;

    @RequestMapping(value = "/add")
    public String saveProvince(Province province, Model model){
        System.out.println("哈哈哈");
        model.addAttribute("addInfo",provinceService.add(province));
        return "province/add";
    }

    /**
     * 根据id查找信息
     * @param id
     * @param model
     * @return
     */
    @RequestMapping(value = "/find")
    public String findProvince(int id,Model model){

        model.addAttribute("province",provinceService.find(id));
        return "province/select";
    }

    /**
     * 根据id进行删除
     *
     * @return String
     **/
    @RequestMapping(value = "/delete")
    public String delete(int id, Map<String, String> map) {

                provinceService.delete(id);
                map.put("msg", "删除成功");
                return "province/delete";
}
    /*
   更新信息
    */
    @RequestMapping(value = "/update")
    public String update(Province province, Model model) {

        model.addAttribute("msg",provinceService.update(province));
        return "province/update";
    }

}
