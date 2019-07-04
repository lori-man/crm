package com.mercury.web;

import com.mercury.domain.BaseDict;
import com.mercury.service.BaseDiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@Controller
public class BaseDictController {
    @Autowired
    private BaseDiceService baseDiceService;


    /*@RequestMapping("/findbytypecode")
    public String findByTypeCode(@RequestParam(value = "dict_type_code") String dictTypeCode, HttpServletResponse rep) throws IOException {
        System.out.println(dictTypeCode);
        List<BaseDict> list = baseDiceService.findByTypeCode(dictTypeCode);
        System.out.println(list.toString());

        //将list转换成jason
        *//**
         * JSONConfig:转JSON配置对象
         * JSONArray：将数组和list集合专成json
         * JSONObject：将对象和Map专程json
         *//*
        JsonConfig jsonConfig = new JsonConfig();
        jsonConfig.setExcludes(new String[]{"dictSort", "dictEnable", "dictMemo"});

        JSONArray jsonArray = JSONArray.fromObject(list,jsonConfig);
        System.out.println(jsonArray.toString());
        rep.getWriter().print(jsonArray.toString());
        return null;
    }*/

    /**
     * 根据类型名称查询字典的方法
     * @return
     */
    @RequestMapping("/findbytypecode")
    @ResponseBody
    public List<BaseDict> find(@RequestParam(value = "dict_type_code") String dictTypeCode, HttpServletResponse rep)
            throws IOException {
        int i=0;
        List<BaseDict> list = baseDiceService.findByTypeCode(dictTypeCode);
        return list;
    }
}
