package com.lori.web;

import com.lori.domain.Customer;
import com.lori.domain.PageBean;
import com.lori.domain.SaleVisit;
import com.lori.service.CustomerService;
import com.lori.service.SaleVisitService;
import org.hibernate.criterion.DetachedCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class SaleVisitController {
    @Autowired
    private SaleVisitService saleVisitService;

    @Autowired
    private CustomerService customerService;

    @RequestMapping("/salevisit_findAll")
    public String findAll(Integer currPage, Integer pageSize, HttpServletRequest req) {
        if (currPage == null) {
            currPage = 1;
        }
        if (pageSize == null) {
            pageSize = 3;
        }
        //接受参数
        //最好使用离线查询
        DetachedCriteria detachedCriteria = DetachedCriteria.forClass(SaleVisit.class);

        PageBean<SaleVisit> pageBean = saleVisitService.findByPage(detachedCriteria, currPage, pageSize);
        req.setAttribute("pageBean", pageBean);
        return "jsp/salevisit/list";
    }

    @RequestMapping("/salevisit_addUI")
    public String addUI() {
        return "jsp/salevisit/add";
    }


    @RequestMapping("/salevisit_add")
    public String add() {


        return "redirect:salevisit_findAll.do";
    }
}
