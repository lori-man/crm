package com.lori.dao;

import com.lori.entity.BaseDict;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import java.util.List;

public class BaseDictDao extends HibernateDaoSupport {

    /**
     * 根据类型名称查询字典的方法
     * @param dictTypeCode
     * @return
     */
    public List<BaseDict> findByTypeCode(String dictTypeCode) {
        return (List<BaseDict>) getHibernateTemplate().find(
                "from BaseDict where dict_type_code=? ",dictTypeCode);
    }
}
