package com.mercury.dao;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

public class BaseDao<T> extends HibernateDaoSupport {
    private Class clazz;

    public BaseDao() {
        //反射：获得Class
        Class clazz = this.getClass();//正在被调用的那个Class
        //
        Type type = clazz.getGenericSuperclass(); //参数化类型
        System.out.println(type);
        //得到这个type就是一个参数化类型，将type强制转化成参数化类型
        ParameterizedType parameterizedType = (ParameterizedType) type;
        //通过参数化类型得到实际参数类型
        Type[] types = parameterizedType.getActualTypeArguments();
        //只要得到一个实际参数即可
        this.clazz = (Class) types[0];
    }

    /**
     * 保存
     * @param t
     */
    public void save(T t) {
        getHibernateTemplate().save(t);
    }

    /**
     * 更新
     * @param t
     */
    public void update(T t) {
        getHibernateTemplate().update(t);
    }

    /**
     * 删除
     * @param t
     */
    public void delete(T t) {
        getHibernateTemplate().delete(t);
    }

    /**
     * 根据id查找
     * @param id
     * @return
     */
    public T findById(Serializable id) {
        return (T) getHibernateTemplate().find(clazz.getSimpleName(),id);
    }

    /**
     * 查询所有
     * @return
     */
    public List<T> findAll() {
        return (List<T>) getHibernateTemplate().find("from " + clazz.getSimpleName());
    }

    /**
     * 分页查询
     * @param detachedCriteria
     * @param begin
     * @param currSize
     * @return
     */
    public List<T> findByPage(DetachedCriteria detachedCriteria, Integer begin, Integer currSize) {
        detachedCriteria.setProjection(null);
        return (List<T>) getHibernateTemplate().findByCriteria(detachedCriteria, begin, currSize);
    }

    /**
     * 查询条件个数
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

}
