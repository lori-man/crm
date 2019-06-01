package com.lori.dao;

import com.lori.entity.LinkMan;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import java.util.List;

public class LinkManDao extends HibernateDaoSupport {

    public  List<LinkMan> findByPage(DetachedCriteria detachedCriteria, Integer begin, Integer pageSize) {
        detachedCriteria.setProjection(null);
        return (List<LinkMan>) getHibernateTemplate().findByCriteria(detachedCriteria, begin, pageSize);
    }

    public Integer findCount(DetachedCriteria detachedCriteria) {
        detachedCriteria.setProjection(Projections.rowCount());
        List<Long> list = (List<Long>) getHibernateTemplate().findByCriteria(detachedCriteria);
        if (list.size() > 0) {
            return list.get(0).intValue();
        }
        return null;
    }

    public void save(LinkMan linkMan) {
        getHibernateTemplate().save(linkMan);
    }

    public LinkMan findById(Long lkm_id) {
        return getHibernateTemplate().get(LinkMan.class, lkm_id);
    }

    public void update(LinkMan linkMan) {
        getHibernateTemplate().update(linkMan);
    }

    public void delete(LinkMan linkMan) {
        getHibernateTemplate().delete(linkMan);
    }
}
