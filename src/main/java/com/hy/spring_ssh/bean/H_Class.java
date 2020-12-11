package com.hy.spring_ssh.bean;

import javax.persistence.*;

@Entity
@Table(name="class")
public class H_Class {
    private Integer cid;
    private String cname;
    private String clx;

    @Id
    @Column(name = "cid")
    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }
    @Column(name = "cname")
    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }
    @Column(name = "clx")
    public String getClx() {
        return clx;
    }

    public void setClx(String clx) {
        this.clx = clx;
    }


}