package com.lori.service;

import com.lori.dao.SaleVisitDao;
import com.lori.domain.PageBean;
import com.lori.domain.SaleVisit;
import org.hibernate.criterion.DetachedCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class SaleVisitService {
    @Autowired
    private SaleVisitDao saleVisitDao;


    public PageBean<SaleVisit> findByPage(DetachedCriteria detachedCriteria, Integer currPage, Integer pageSize) {
        PageBean<SaleVisit> pageBean = new PageBean<>();
        pageBean.setCurrPage(currPage);

        pageBean.setPageSize(pageSize);

        //封装总数量
        Integer totalCount=saleVisitDao.findCount(detachedCriteria);
        pageBean.setTotalCount(totalCount);
        System.out.println(totalCount);
        if (totalCount == null) {
            totalCount = 0;
        }

        //封装总页数
        Double tc = totalCount.doubleValue();
        Double num = Math.ceil(tc / pageSize);
        pageBean.setTotalPage(num.intValue());

        //封装集合
        Integer begin = (currPage - 1) * pageSize;
        System.out.println(begin);
        List<SaleVisit> list = saleVisitDao.findByPage(detachedCriteria, begin, pageSize);
        pageBean.setList(list);

        return pageBean;
    }

    public void save(SaleVisit saleVisit) {
        saleVisitDao.save(saleVisit);
    }
}
