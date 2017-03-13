package com.scb.soonhui.persistence.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;

/**
 * Created with IntelliJ IDEA.
 * User: 1481702
 * Date: 2/8/17
 * Time: 3:59 PM
 * To change this template use File | Settings | File Templates.
 */
public class GenericDaoSupport {
    @Autowired
    private HibernateTemplate hibernateTemplate;
    public HibernateTemplate getHibernateTemplate() {
        return hibernateTemplate;
    }

//    @Autowired
    public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
        this.hibernateTemplate = hibernateTemplate;
    }
}
