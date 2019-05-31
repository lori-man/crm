package com.lori.controller;

import com.lori.entity.Customer;
import com.lori.entity.LinkMan;
import com.lori.entity.PageBean;
import com.lori.service.CustomerService;
import com.lori.service.LinkManService;
import org.hibernate.criterion.DetachedCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class LinkManController {
    @Autowired
    private LinkManService linkManService;

    @Autowired
    private CustomerService customerService;

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

    @RequestMapping("/linkmanSaveUI")
    public String saveUI(HttpServletRequest req) {
        List<Customer> list = customerService.findAll();
        req.setAttribute("list", list);
        return "jsp/linkman/add";
    }

    @RequestMapping("/linkmanSave")
    public String saveLinkMan(LinkMan linkMan, @RequestParam("custId") long custId) {
        System.out.println(linkMan);
        Customer customer = customerService.findById(custId);
        linkMan.setCustomer(customer);


        linkManService.save(linkMan);
        return "jsp/linkman/list";
    }
}
