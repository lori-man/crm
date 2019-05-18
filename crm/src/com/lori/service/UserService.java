package com.lori.service;

import com.lori.dao.UserDao;
import com.lori.entity.User;
import com.lori.util.MD5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(isolation=Isolation.DEFAULT,propagation=Propagation.REQUIRED)
public class UserService {
    @Autowired
    private UserDao userDao;

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    /**
     * 注册
     * @param user
     */
    public void regist(User user) {
        user.setUserPassword(MD5Util.md5(user.getUserPassword()));
        user.setUserState("1");

        userDao.save(user);
    }

    /**
     * 登入
     *
     * @param user
     * @return
     */
    public User login(User user) {
        //对用户的密码加密
        user.setUserPassword(MD5Util.md5(user.getUserPassword()));
        //调用
        User user1 = userDao.login(user);

        return user1;
    }
}
