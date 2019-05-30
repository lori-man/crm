package com.lori.controller;

import com.lori.entity.LinkMan;
import com.lori.entity.PageBean;
import com.lori.service.LinkManService;
import org.hibernate.criterion.DetachedCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class LinkManController {
    @Autowired
    private LinkManService linkManService;

    @RequestMapping("/linkmanfindAll")
    public String findAll(Integer currPage, Integer pageSize, HttpServletRequest req) {
        if (currPage == null) {
            currPage = 1;
        }
        if (pageSize == null) {
            pageSize = 3;
        }
        DetachedCriteria detachedCriteria = DetachedCriteria.forClass(LinkMan.class);
        PageBean<LinkMan> pageBean = linkManService.findAll(detachedCriteria, pageSize, currPage);

        req.setAttribute("pagebean", pageBean);
//        System.out.println(pageBean);
        return "jsp/linkman/list";
    }
}
