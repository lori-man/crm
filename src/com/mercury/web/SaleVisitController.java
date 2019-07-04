package com.mercury.web;

import com.mercury.domain.PageBean;
import com.mercury.domain.SaleVisit;
import com.mercury.service.CustomerService;
import com.mercury.service.SaleVisitService;
import org.hibernate.criterion.DetachedCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
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
    public String add(@DateTimeFormat(pattern = "yyyy-MM-dd")SaleVisit saleVisit) {
        System.out.println(saleVisit);
        saleVisitService.save(saleVisit);
        System.out.println();
        return "redirect:salevisit_findAll.do";
    }
}
