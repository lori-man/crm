package com.lori.dao;

import com.lori.entity.Customer;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.Projections;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import java.util.List;

public class CustomerDao extends HibernateDaoSupport {

    /**
     * 保存客户
     *
     * @param customer
     */
    public void save(Customer customer) {
        getHibernateTemplate().save(customer);
    }

    /**
     * 查看总条目数量
     *
     * @param detachedCriteria
     * @return
     */
    public Integer findCount(DetachedCriteria detachedCriteria) {
        detachedCriteria.setProjection(Projections.rowCount());
        List<Long> list = (List<Long>) getHibernateTemplate().findByCriteria(detachedCriteria);
        if (list.size() > 0) {
            return list.get(0).intValue();
        }
        return null;
    }

    /**
     * 查找指定分页条目
     *
     * @param detachedCriteria
     * @param begin
     * @param pageSize
     * @return
     */
    public List<Customer> findByPage(DetachedCriteria detachedCriteria, Integer begin, Integer pageSize) {
        detachedCriteria.setProjection(null);
        return (List<Customer>) getHibernateTemplate().findByCriteria(detachedCriteria,begin,pageSize);
    }
}
