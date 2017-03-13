package com.scb.soonhui.persistence.dao;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: 1481702
 * Date: 2/8/17
 * Time: 3:57 PM
 * To change this template use File | Settings | File Templates.
 */
public interface BaseDao<T> {
    T findByID(int Id);
    List<T> findAll();
    void save(T entity);
    void update(T entity);
    void delete(int Id);
}

