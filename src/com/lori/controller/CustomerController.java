package com.lori.controller;

import com.lori.entity.Customer;
import com.lori.entity.PageBean;
import com.lori.service.CustomerService;
import com.lori.utils.UpLoadUtils;
import org.hibernate.criterion.DetachedCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;

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
    public String save(Customer customer,@RequestParam("upload")MultipartFile multipartFile) throws IOException {

        if (multipartFile != null) {
//            System.out.println(multipartFile.toString());
            String path = "F:/crm";

            //一个目录下存放相同文件名，随机文件名
            String uuidFileNmae = UpLoadUtils.getUuidFileName(multipartFile.getOriginalFilename());

            String realPath = UpLoadUtils.getPath(uuidFileNmae);

            String url = path + realPath;
            File file = new File(url);
            if (!file.exists()) {
                file.mkdirs();
            }
            File dictFile = new File(url + uuidFileNmae);
            dictFile.createNewFile();
            multipartFile.transferTo(dictFile);
//            System.out.println(dictFile.toString());
            customer.setCustImage(url + uuidFileNmae);

        }
        System.out.println(customer);
        customerService.save(customer);
        return "welcome";
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
