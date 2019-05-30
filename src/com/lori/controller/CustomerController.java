package com.lori.controller;

import com.lori.entity.Customer;
import com.lori.entity.PageBean;
import com.lori.service.CustomerService;
import com.lori.utils.UpLoadUtils;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
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

        if (multipartFile != null && multipartFile.getSize() > 0) {
//            System.out.println(multipartFile.getSize());
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
//        System.out.println(customer);
        customerService.save(customer);
        return "redirect:findAll.do";
    }

    /**
     * 分页查询客户
     *
     * @param currPage
     * @return
     */
    @RequestMapping("/findAll")
    public String findAll(Integer currPage, Integer pageSize, HttpServletRequest req, Customer customer) {
        if (currPage == null) {
            currPage = 1;
        }
        if (pageSize == null) {
            pageSize = 3;
        }
        //接受参数
        //最好使用离线查询
        DetachedCriteria detachedCriteria = DetachedCriteria.forClass(Customer.class);

        if (customer.getCustName() != null) {
            System.out.println(customer.toString());
            detachedCriteria.add(Restrictions.like("custName", "%" + customer.getCustName() + "%"));
        }
        if (customer.getBaseDicrIndustry() != null) {
            System.out.println(customer.getBaseDicrIndustry().getDictId());
            if (customer.getBaseDicrIndustry().getDictId() != null && !"".equals(customer.getBaseDicrIndustry().getDictId())) {
                detachedCriteria.add(Restrictions.eq("baseDicrIndustry.dictId", customer.getBaseDicrIndustry().getDictId()));
            }
        }
        if (customer.getBaseDictLevel() != null) {
            System.out.println(customer.getBaseDictLevel().getDictId());
            if (customer.getBaseDictLevel().getDictId() != null && !"".equals(customer.getBaseDictLevel().getDictId())) {
                detachedCriteria.add(Restrictions.eq("baseDictLevel.dictId", customer.getBaseDictLevel().getDictId()));
            }
        }
        if (customer.getBaseDicrSource()!= null) {
            if (customer.getBaseDicrSource().getDictId() != null && !"".equals(customer.getBaseDicrSource().getDictId())) {
                detachedCriteria.add(Restrictions.eq("baseDicrSource.dictId", customer.getBaseDicrSource().getDictId()));
            }
        }

        PageBean<Customer> pageBean = customerService.findByPage(detachedCriteria, currPage, pageSize);
//        System.out.println(pageBean);
        req.setAttribute("pageBean", pageBean);
        req.setAttribute("customer", customer);
        return "/jsp/customer/list";
    }

    @RequestMapping("/delete")
    public String deleteById(String custId) {
//        System.out.println(custId);
        long id = Long.parseLong(custId);
//        System.out.println(id);
        Customer customer = customerService.findById(id);
        System.out.println(customer);

        if (customer.getCustImage() != null) {
            File file = new File(customer.getCustImage());
            if (file.exists()) {
                file.delete();
            }
        }
        customerService.delete(customer);
        return "redirect:findAll.do";
    }

    @RequestMapping("/edit")
    public String edit(@RequestParam("custId") String custId, HttpServletRequest req) {
        long id = Long.parseLong(custId);
        Customer customer = customerService.findById(id);
//        System.out.println(customer);

//        System.out.println(customer.getBaseDicrIndustry().getDictId());
        req.setAttribute("customer",customer);
        return "jsp/customer/edit";
    }

    @RequestMapping("/customer_update")
    public String customer_update(Customer customer, @RequestParam("upload") MultipartFile multipartFile) throws IOException {
        System.out.println(multipartFile.getSize());
        if (multipartFile.getSize()>0) {
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

        customerService.update(customer);
        return "redirect:findAll.do";
    }
}
