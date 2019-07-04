package com.mercury.dao;

import com.mercury.domain.Customer;

public class CustomerDao extends BaseDao<Customer> {

   /* *//**
     * 保存客户
     *
     * @param customer
     *//*
    public void save(Customer customer) {
        getHibernateTemplate().save(customer);
    }

    *//**
     * 查看总条目数量
     *
     * @param detachedCriteria
     * @return
     *//*
    public Integer findCount(DetachedCriteria detachedCriteria) {
        detachedCriteria.setProjection(Projections.rowCount());
        List<Long> list = (List<Long>) getHibernateTemplate().findByCriteria(detachedCriteria);
        if (list.size() > 0) {
            return list.get(0).intValue();
        }
        return null;
    }

    *//**
     * 查找指定分页条目
     *
     * @param detachedCriteria
     * @param begin
     * @param pageSize
     * @return
     *//*
    public List<Customer> findByPage(DetachedCriteria detachedCriteria, Integer begin, Integer pageSize) {
        detachedCriteria.setProjection(null);
        return (List<Customer>) getHibernateTemplate().findByCriteria(detachedCriteria,begin,pageSize);
    }

    public Customer findById(Long id) {
        return getHibernateTemplate().get(Customer.class, id);
    }

    public void delete(Customer customer) {
        getHibernateTemplate().delete(customer);
    }

    public void update(Customer customer) {
        getHibernateTemplate().update(customer);
    }

    public List<Customer> findAll() {
        return (List<Customer>) getHibernateTemplate().find("from Customer");
    }*/
}
