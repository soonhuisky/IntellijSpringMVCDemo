package com.scb.soonhui.service.services;

import com.scb.soonhui.persistence.dao.BlogDao;
import com.scb.soonhui.persistence.entity.BlogEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: 1481702
 * Date: 2/9/17
 * Time: 3:28 PM
 * To change this template use File | Settings | File Templates.
 */
@Service
public class BlogServices {

    @Autowired
    private BlogDao blogDaoimpl;

    public BlogEntity findBlogById(int id){
        return blogDaoimpl.findByID(id);
    }

    public List<BlogEntity> findAllBlogs(){
        return blogDaoimpl.findAll();
    }

    public void addBlog(BlogEntity userEntity){
        blogDaoimpl.save(userEntity);
    }

    public void updateBlog(BlogEntity userEntity){
        blogDaoimpl.update(userEntity);
    }

    public void deleteBlog(int userID){
        blogDaoimpl.delete(userID);
    }
}
