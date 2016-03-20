package com.vector.basic.dao;

import java.io.Serializable;


public interface GenericDao<T, PK extends Serializable> {
    public T get(PK id);
}
