package com.gcu.cst326clc.data;

import java.util.List;

public interface DataAccessInterface <T>{
    List<T> getAll();
    T getById(int id);
    boolean create(T t);
    boolean update(T t);
    boolean delete(T t);
}