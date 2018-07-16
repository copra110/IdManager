/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.abdelrahman.idmanager.resource;

import com.abdelrahman.idmanager.dao.UserDao;
import com.abdelrahman.idmanager.dao.UserDaoImpl;
import com.abdelrahman.idmanager.model.User;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author NIGHT WOLF
 */
@Path("/users")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class UserResource
{
    private final UserDao userDao = new UserDaoImpl();
    @GET
    public List<User> getUsers()
    {   
        return userDao.findAll();
    }
    
    @POST
    public User addUser(User user)
    {
        return userDao.save(user);
    }
    
    @GET
    @Path("/{category}/{value}")
    public User getUser(@PathParam("category") String category,@PathParam("value") String value)
    {
        User user;
        switch(category)
        {
            case "email":
            {
                user= userDao.findByEmail(value);
                break;
            }
            case "macAddress":
            {
                user= userDao.findByMac(value);
                break;
            }
            default:
            {
                user= userDao.findByMac(value);
                break;
            }
        }
        return user;
    }
    
    @DELETE
    @Path("/{userEmail}")
    public void deleteMessage(@PathParam("userEmail") String email)
    {
        userDao.deleteByEmail(email);
    }
}
