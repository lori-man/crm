package com.mercury.service;

import com.mercury.dao.LinkManDao;
import com.mercury.domain.LinkMan;
import com.mercury.domain.PageBean;
import org.hibernate.criterion.DetachedCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class LinkManService {
    @Autowired
    private LinkManDao linkManDao;


    public PageBean<LinkMan> findAll(DetachedCriteria detachedCriteria, Integer pageSize, Integer currPage) {
        PageBean<LinkMan> pageBean = new PageBean<>();
        pageBean.setPageSize(pageSize);
        pageBean.setCurrPage(currPage);

        Integer totalCount = linkManDao.findCount(detachedCriteria);
        pageBean.setTotalCount(totalCount);

        //设置总页数
        Integer totalPage = (totalCount % pageSize) == 0 ? (totalCount / pageSize) : (totalCount / pageSize + 1);
        pageBean.setTotalPage(totalPage);

        Integer begin = (currPage - 1) * pageSize;
        List<LinkMan> list = linkManDao.findByPage(detachedCriteria, begin, pageSize);
        pageBean.setList(list);

        return pageBean;
    }

    public void save(LinkMan linkMan) {
        linkManDao.save(linkMan);
    }

    public LinkMan findById(Long lkm_id) {
        return linkManDao.findById(lkm_id);
    }

    public void update(LinkMan linkMan) {
        linkManDao.update(linkMan);
    }

    public void delete(LinkMan linkMan) {
        linkManDao.delete(linkMan);
    }
}
