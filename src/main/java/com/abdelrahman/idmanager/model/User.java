package com.abdelrahman.idmanager.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "USER")
@XmlRootElement
public class User implements Serializable
{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotEmpty
    @Column(name = "Name", nullable = false)
    private String name;

    @NotEmpty
    @Column(name = "ADDRESS", nullable = false, unique = true)
    private String address;
    
    @NotEmpty
    @Column(name = "ID_PIC", nullable = false)
    private byte[] id_pic;
    
    @NotEmpty
    @Column(name = "ID_PIC_PATH", nullable = false)
    private String idPicPath;
    
    public User()
    {
    }

    public Integer getId()
    {
        return id;
    }

    public void setId(Integer id)
    {
        this.id = id;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getAddress()
    {
        return address;
    }

    public void setAddress(String address)
    {
        this.address = address;
    }

    public byte[] getId_pic()
    {
        return id_pic;
    }

    public void setId_pic(byte[] id_pic)
    {
        this.id_pic = id_pic;
    }

    public String getIdPicPath()
    {
        return idPicPath;
    }

    public void setIdPicPath(String idPicPath)
    {
        this.idPicPath = idPicPath;
    }
    
}
