package com.hy.spring_ssh.dao;

import com.hy.spring_ssh.bean.H_Student;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

@Component(value = "hstudentdao")
public class H_StudentDao implements L_StudentDao {
    @Resource(name = "HibernateTemplate")
    public HibernateTemplate hiber;

    public HibernateTemplate getHiber() {
        return hiber;
    }

    public void setHiber(HibernateTemplate hiber) {
        this.hiber = hiber;
    }

    @Override
    public void SaveorUpdete(Object o) {
       hiber.saveOrUpdate(o);
    }


    @Override
    public void delect(Object o) {
        hiber.delete(o);
    }

    @Override
    public List<?> FindAll(String hql) {
        return hiber.find(hql);
    }

    @Override
    public Object get(Class t, Integer id) {
        return hiber.get(t,id);
    }




    @Override
    public List<?> QueryAllStu(Integer page, Integer pagesize) {
        return null;
    }
}
