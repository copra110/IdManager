/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.abdelrahman.idmanager.dao;

import com.abdelrahman.idmanager.model.Attendance;
import java.util.List;

/**
 *
 * @author NIGHT WOLF
 */
public class AttendanceDaoImpl extends AbstractDao<Integer, Attendance> implements AttendanceDao
{

    @Override
    public List<Attendance> findAll()
    {
        return (List<Attendance>) getAll();
    }

    @Override
    public Attendance findById(int id)
    {
        return (Attendance)getByKey(id);
    }

    @Override
    public Attendance save(Attendance attendnace)
    {
        return persist(attendnace);
    }

    @Override
    public Attendance updateUser(Attendance attendance)
    {
        return update(attendance);
    }

    @Override
    public void deleteById(int id)
    {
        Attendance att = (Attendance)getByKey(id);
        delete(att);
    }
    
}
