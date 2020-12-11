package com.hy.spring_ssh.bean;


import org.springframework.web.multipart.MultipartFile;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "student")
public class H_Student {
    private Integer sid;
    private String sname;
    private Integer sage;
    private String ssex;
    private Integer cid;
    private String sahao;
    private Date datatime;
    private String file;


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @GeneratedValue(strategy =GenerationType.SEQUENCE,generator = "hibernate_sequence")
    @Column(name = "sid")
    public Integer getSid() {
        return sid;
    }

    public void setSid(Integer sid) {
        this.sid = sid;
    }
    @Column(name = "sname")
    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }
    @Column(name = "sage")
    public Integer getSage() {
        return sage;
    }

    public void setSage(Integer sage) {
        this.sage = sage;
    }
    @Column(name = "ssex")
    public String getSsex() {
        return ssex;
    }

    public void setSsex(String ssex) {
        this.ssex = ssex;
    }

    @Column(name = "cid")
    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }
    @Column(name = "sahao")
    public String getSahao() {
        return sahao;
    }

    public void setSahao(String sahao) {
        this.sahao = sahao;
    }
    @Column(name = "years")
    public Date getDatatime() {
        return datatime;
    }

    public void setDatatime(Date datatime) {
        this.datatime = datatime;
    }

    @Column(name="stufile")
    public String getFile() {
        return file;
    }

    public void setFile(String file) {
        this.file = file;
    }


    @Override
    public String toString() {
        return "H_Student{" +
                "sid=" + sid +
                ", sname='" + sname + '\'' +
                ", sage=" + sage +
                ", ssex='" + ssex + '\'' +
                ", cid=" + cid +
                ", sahao='" + sahao + '\'' +
                ", datatime=" + datatime +
                ", file='" + file + '\'' +
                '}';
    }
}
