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
public interface AttendanceDao
{
    List<Attendance> findAll();

    Attendance findById(int id);

    Attendance save(Attendance attendnace);
    
    Attendance updateUser(Attendance attendance);

    void deleteById(int id);
}
