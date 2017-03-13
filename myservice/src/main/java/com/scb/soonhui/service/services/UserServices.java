package com.scb.soonhui.service.services;

import com.scb.soonhui.persistence.dao.UserDao;
import com.scb.soonhui.persistence.entity.UserEntity;
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
public class UserServices {

    @Autowired
    private UserDao userDaoimpl;

    public UserEntity findUserById(int id){
        return userDaoimpl.findByID(id);
    }

    public List<UserEntity> findAllUsers(){
        return userDaoimpl.findAll();
    }

    public void addUser(UserEntity userEntity){
        userDaoimpl.save(userEntity);
    }

    public void updateUser(UserEntity userEntity){
        userDaoimpl.update(userEntity);
    }

    public void deleteUser(int userID){
        userDaoimpl.delete(userID);
    }

}
