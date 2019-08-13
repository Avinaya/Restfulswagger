package com.nextnepal.Rest.Model;

import com.sun.istack.internal.NotNull;
import net.bytebuddy.dynamic.loading.InjectionClassLoader;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;

@Entity
@Table(name="detail")
@EntityListeners(AuditingEntityListener.class)
public class Doctor {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @NotNull
    private String dname;

    @NotNull
    private String daddress;

    @NotNull
    private String dphoneno;

    @NotNull
    private String dspeciality;

    @NotNull
    private String dUsername;

    @NotNull
    private String dPassword;

    public Long getId()
    {
        return id;
    }

    public void setId(Long id) {

        this.id = id;
    }

    public String getDname() {
        return dname;
    }

    public void setDname(String dname) {

        this.dname = dname;
    }

    public String getDaddress() {

        return daddress;
    }

    public void setDaddress(String daddress)
    {
        this.daddress = daddress;
    }

    public String getDphoneno()
    {
        return dphoneno;
    }

    public void setDphoneno(String dphoneno) {

        this.dphoneno = dphoneno;
    }

    public String getDspeciality() {
        return dspeciality;
    }

    public void setDspeciality(String dspeciality) {
        this.dspeciality = dspeciality;
    }

    public String getdUsername() {
        return dUsername;
    }

    public void setdUsername(String dUsername) {
        this.dUsername = dUsername;
    }

    public String getdPassword() {
        return dPassword;
    }

    public void setdPassword(String dPassword) {
        this.dPassword = dPassword;
    }
}
