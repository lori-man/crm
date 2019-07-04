package com.mercury.service;

import com.mercury.dao.CustomerDao;
import com.mercury.domain.Customer;
import com.mercury.domain.PageBean;
import org.hibernate.criterion.DetachedCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class CustomerService {
    @Autowired
    private CustomerDao customerDao;

    /**
     * 保存客户：save
     *
     * @param customer
     */
    public void save(Customer customer) {
        customerDao.save(customer);
    }

    /**
     * 分页查询
     *
     * @param detachedCriteria
     * @param pageSize
     * @param currPage
     * @return
     */
    public PageBean<Customer> findByPage(DetachedCriteria detachedCriteria, Integer currPage, Integer pageSize) {
        PageBean<Customer> pageBean = new PageBean<>();
        pageBean.setCurrPage(currPage);

        pageBean.setPageSize(pageSize);

        //封装总数量
        Integer totalCount=customerDao.findCount(detachedCriteria);
        pageBean.setTotalCount(totalCount);

        //封装总页数
        Double tc = totalCount.doubleValue();
        Double num = Math.ceil(tc / pageSize);
        pageBean.setTotalPage(num.intValue());

        //封装集合
        Integer begin = (currPage - 1) * pageSize;
        System.out.println(begin);
        List<Customer> list = customerDao.findByPage(detachedCriteria, begin, pageSize);
        pageBean.setList(list);

        return pageBean;
    }

    /**
     * 根据id寻找
     * @param id
     */
    public Customer findById(Long id) {
        return customerDao.findById(id);
    }

    /**
     * 删除
     *
     * @param customer
     */
    public void delete(Customer customer) {
        customerDao.delete(customer);
    }

    public void update(Customer customer) {
        customerDao.update(customer);
    }

    public List<Customer> findAll() {
        return customerDao.findAll();
    }
}
