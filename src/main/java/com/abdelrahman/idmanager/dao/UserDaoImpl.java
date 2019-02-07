/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.abdelrahman.idmanager.dao;

import com.abdelrahman.idmanager.model.User;
import com.abdelrahman.idmanager.utility.HibernateUtil;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author NIGHT WOLF
 */
public class UserDaoImpl extends AbstractDao<Integer, User> implements UserDao
{

    @Override
    public List<User> findAll()
    {
        return (List<User>) getAll();
    }

    @Override
    public User findById(int id)
    {
        return (User) getByKey(id);
    }

    @Override
    public User save(User user)
    {
        try
        {
            String path = "D:/Java/NetbeensProjects/IdManager/src/main/webapp/images/UserIDS/" + user.getName()+ ".jpg";
            Files.write(new File(path).toPath(), user.getId_pic());
            user.setIdPicPath(path);
        }
        catch (IOException ex)
        {
            Logger.getLogger(UserDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
        return persist(user);
    }

    @Override
    public void deleteById(int id)
    {
        User message = (User) getByKey(id);
        delete(message);
    }

    @Override
    public User updateUser(User user)
    {
        return update(user);
    }

    @Override
    public User findByEmail(String email)
    {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.getCurrentSession();
        Transaction trans = getSession().beginTransaction();
        Criteria criteria = session.createCriteria(User.class);
        criteria.add(Restrictions.eq("email", email));
        User user = (User) criteria.uniqueResult();
        trans.commit();
        return user;
    }

    @Override
    public void deleteByEmail(String email)
    {
        User user = findByEmail(email);
        delete(user);
    }

    @Override
    public User findByMac(String macAddress)
    {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.getCurrentSession();
        Transaction trans = getSession().beginTransaction();
        Criteria criteria = session.createCriteria(User.class);
        criteria.add(Restrictions.eq("macAddress", macAddress));
        User user = (User) criteria.uniqueResult();
        trans.commit();
        return user;
    }

    @Override
    public String findUserPictureID(String macAddress)
    {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.getCurrentSession();
        Transaction trans = getSession().beginTransaction();
        Criteria criteria = session.createCriteria(User.class);
        criteria.setProjection(Projections.projectionList()
                        .add(Projections.property("idPicPath"), "idPicPath"));
        criteria.add(Restrictions.eq("macAddress", macAddress));
        String path = (String) criteria.uniqueResult();
        trans.commit();
        return path;
    }
}
