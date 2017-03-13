package com.scb.soonhui.persistence.dao.impl;

import com.scb.soonhui.persistence.dao.BlogDao;
import com.scb.soonhui.persistence.entity.BlogEntity;
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
public class BlogDaoImpl extends GenericDaoSupport implements BlogDao {
    
    @Override
    public BlogEntity findByID(int ID) {
        BlogEntity blogEntity = getHibernateTemplate().load(BlogEntity.class, ID);
        return blogEntity;
    }

    @Override
    public List<BlogEntity> findAll() {
        List<BlogEntity> blogEntityList = getHibernateTemplate().loadAll(BlogEntity.class);
        return blogEntityList;
    }

    @Override
    @Transactional(readOnly = false)
    public void save(BlogEntity entity) {
        getHibernateTemplate().save(entity);
    }

    @Override
    @Transactional(readOnly = false)
    public void update(BlogEntity entity) {
        getHibernateTemplate().update(entity);
    }

    @Override
    @Transactional(readOnly = false)
    public void delete(int ID) {
        BlogEntity blogEntity = getHibernateTemplate().load(BlogEntity.class,ID);
        getHibernateTemplate().delete(blogEntity);
    }

}
