package com.hy.spring_ssh.servlce;

import com.hy.spring_ssh.bean.H_Class;
import com.hy.spring_ssh.bean.H_Student;
import com.hy.spring_ssh.dao.H_StudentDao;
import org.hibernate.criterion.DetachedCriteria;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

@Transactional
@Service(value = "stuServlce")
public class H_StuServlce{
    @Resource(name = "hstudentdao")
    public H_StudentDao hstudDao;

    public H_StudentDao getHstudDao() {
        return hstudDao;
    }

    public void setHstudDao(H_StudentDao hstudDao) {
        this.hstudDao = hstudDao;
    }

    public List<H_Student> Query(){
        String sql="from H_Student hst,H_Class hcl where hst.cid=hcl.cid";
        return (List<H_Student>) hstudDao.FindAll(sql);
    }

    public void delect(Integer student){
        H_Student student1=new H_Student();
        student1.setSid(student);
        hstudDao.delect(student1);
    }
    public List<H_Class> QueryClass(){
        String sql="from H_Class";
        return (List<H_Class>) hstudDao.FindAll(sql);
    }

    public void AddStudent(H_Student student){
         hstudDao.SaveorUpdete(student);
    }

    public void setStudent(H_Student student) {

        hstudDao.SaveorUpdete(student);
    }

    public H_Student Setstudent(Integer id){

        return (H_Student) hstudDao.get(H_Student.class,id);
    }


     public List<H_Student> QueryStu(Integer cid,String name,String sex){
        String hql="from H_Student hst,H_Class hcl where hst.cid=hcl.cid";
        if (cid!=null && !cid.equals("") && !cid.equals("-1")){
              hql= hql+" and hst.cid='"+cid+"'";
        }if(name!=null && !name.isEmpty()){
            hql=hql+" and hst.cname='"+name+"'";
         }if(name!=null && !sex.isEmpty()){
            hql=hql+" and hst.ssex='"+sex+"'";
         }

        return (List<H_Student>) hstudDao.FindAll(hql);
     }


}
