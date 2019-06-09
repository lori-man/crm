package com.lori.dao;

import com.lori.domain.User;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import java.util.List;

public class UserDao extends BaseDao<User> {

    /**
     * 保存用户
     * @param user
     */
    public void save(User user) {
        this.getHibernateTemplate().save(user);
    }

    /**
     * 根据用户名,密码查询账号
     * @param user
     */
    public User login(User user) {
        List<User> list = (List<User>) getHibernateTemplate().find(
                "from User where user_code=? and user_password =?", user.getUserCode(),
                user.getUserPassword());
        if (list.size() > 0) {
            return list.get(0);
        }
        return null;
    }
}
