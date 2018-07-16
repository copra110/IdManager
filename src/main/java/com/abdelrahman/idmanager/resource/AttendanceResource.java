/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.abdelrahman.idmanager.resource;

import com.abdelrahman.idmanager.dao.AttendanceDao;
import com.abdelrahman.idmanager.dao.AttendanceDaoImpl;
import com.abdelrahman.idmanager.dao.UserDao;
import com.abdelrahman.idmanager.dao.UserDaoImpl;
import com.abdelrahman.idmanager.model.Attendance;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author NIGHT WOLF
 */
@Path("/attendances")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class AttendanceResource
{
    private final AttendanceDao attendanceDao = new AttendanceDaoImpl();
    private final UserDao userDao = new UserDaoImpl();
    @GET
    public List<Attendance> getAttendances()
    {
        return attendanceDao.findAll();
    }
    
    @GET
    @Path("/list")
    public List<Attendance> getAttendancesWithUsers()
    {
        List<Attendance> atts=attendanceDao.findAll();
        for(Attendance tempAtt:atts)
        {
            tempAtt.setUser(userDao.findByMac(tempAtt.getMacAddress()));
        }
        return atts;
    }
    
    @POST
    public Attendance addAttendance(Attendance attendance)
    {
        return attendanceDao.save(attendance);
    }
}
