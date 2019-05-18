package com.lori.controller;

import com.lori.entity.Customer;
import com.lori.entity.PageBean;
import com.lori.service.CustomerService;
import org.hibernate.criterion.DetachedCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    /**
     * 客户管理，跳转到添加用户页面
     */
    @RequestMapping("/customer_saveUI")
    public String customer_save() {
        return "/jsp/customer/add";
    }

    /**
     * 保存客户：save
     * @param customer
     * @return
     */
    @RequestMapping("/customer_save")
    public String save(Customer customer) {
        System.out.println(customer);
        customerService.save(customer);
        return "/index";
    }

    /**
     * 分页查询客户
     * @param currPage
     * @return
     */
    @RequestMapping("/findAll")
    public String findAll( Integer currPage,Integer pageSize, HttpServletRequest req) {
        if (currPage == null) {
            currPage = 1;
        }
        if (pageSize == null) {
            pageSize = 3;
        }
        //接受参数
        //最好使用离线查询
        DetachedCriteria detachedCriteria = DetachedCriteria.forClass(Customer.class);

       PageBean<Customer> pageBean=customerService.findByPage(detachedCriteria,currPage,pageSize);
        System.out.println(pageBean);
        req.setAttribute("pageBean",pageBean);
        return "/jsp/customer/list";
    }
}
