package com.abdelrahman.idmanager.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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
    @Column(name = "FIRST_NAME", nullable = false)
    private String firstName;

    @NotEmpty
    @Column(name = "LAST_NAME", nullable = false)
    private String lastName;

    @NotEmpty
    @Column(name = "EMAIL", nullable = false, unique = true)
    private String email;
    
    @NotEmpty
    @Column(name = "MAC_ADDRESS", nullable = false , unique = true)
    private String macAddress;
    
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

    public String getFirstName()
    {
        return firstName;
    }

    public void setFirstName(String firstName)
    {
        this.firstName = firstName;
    }

    public String getLastName()
    {
        return lastName;
    }

    public void setLastName(String lastName)
    {
        this.lastName = lastName;
    }

    public String getEmail()
    {
        return email;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }

    public String getMacAddress()
    {
        return macAddress;
    }

    public void setMacAddress(String macAddress)
    {
        this.macAddress = macAddress;
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
