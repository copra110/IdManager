/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.abdelrahman.idmanager.dao;

import com.abdelrahman.idmanager.model.User;
import java.util.List;

/**
 *
 * @author NIGHT WOLF
 */
public interface UserDao
{
    List<User> findAll();

    User findById(int id);
    
    User findByEmail(String email);
    
    User findByMac(String macAddress);

    User save(User user);
    
    User updateUser(User user);

    void deleteById(int id);
    
    void deleteByEmail(String email);
    
    String findUserPictureID(String macAddress);
}
