package com.scb.soonhui.persistence.dao.impl;

import com.scb.soonhui.persistence.dao.UserDao;
import com.scb.soonhui.persistence.entity.UserEntity;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: 1481702
 * Date: 2/8/17
 * Time: 4:01 PM
 * To change this template use File | Settings | File Templates.
 */
@Repository
public class UserDaoImpl extends GenericDaoSupport implements UserDao {

    @Override
    public UserEntity findByID(int ID) {
        UserEntity UserEntity = getHibernateTemplate().load(UserEntity.class, ID);
        return UserEntity;
    }

    @Override
    public List<UserEntity> findAll() {
        List<UserEntity> UserEntityList = getHibernateTemplate().loadAll(UserEntity.class);
        return UserEntityList;
    }

    @Override
    @Transactional(readOnly = false)
    public void save(UserEntity entity) {
        getHibernateTemplate().save(entity);
    }

    @Override
    @Transactional(readOnly = false)
    public void update(UserEntity entity) {
        getHibernateTemplate().saveOrUpdate(entity);
    }

    @Override
    @Transactional(readOnly = false)
    public void delete(int ID) {
        UserEntity userEntity = getHibernateTemplate().load(UserEntity.class,ID);
        getHibernateTemplate().delete(userEntity);
    }
}
