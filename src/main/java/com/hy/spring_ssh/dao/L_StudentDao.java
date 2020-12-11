package com.hy.spring_ssh.dao;

import com.hy.spring_ssh.bean.H_Student;

import java.util.List;

public interface L_StudentDao<T>{
    void SaveorUpdete(T t);

    void delect(T t);

    List<?> FindAll(String hql);

    T get(Class<T> t,Integer id);

    List<?> QueryAllStu(Integer page, Integer pagesize);
}
