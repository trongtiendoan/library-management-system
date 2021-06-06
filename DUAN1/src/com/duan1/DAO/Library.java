/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.duan1.DAO;

import java.util.List;

/**
 *
 * @author Admin
 */
public abstract class Library <E,K>{
    abstract public void insert(E entity);
    abstract public void update(E entity);
    abstract public void delete(K key);
    abstract public List<E> selectAll();
    abstract public E selectByID(K key);
    abstract protected List<E> selectBySql(String sql, Object...args);
    /*
    Các XyzDAO con phải cài đặt mã cho các phương thức của EduSysDAO
    selectBySql() chỉ cho DAO con kế thừa mà không cho phép sử dụng bên ngoài
    */
}
