package com.vector.basic.dao.impl;

import com.vector.basic.dao.GenericDao;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

@SuppressWarnings("unchecked")
abstract public class GenericDaoImpl<T, PK extends Serializable> extends
        HibernateDaoSupport implements GenericDao<T, PK> {
    protected Log logger = LogFactory.getLog(GenericDaoImpl.class);

    public void setSuperSessionFactory(SessionFactory factory) {
        super.setSessionFactory(factory);
    }

    protected JdbcTemplate jdbcTemplate;

    protected Class<T> persistType;

    /**
     * set the query(hql) in the app-dao.xml, then can use by
     * getAllByQueryName(..);
     */
    protected Map<String, String> querys = new HashMap<String, String>();

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void setPersistType(Class<T> persistType) {
        this.persistType = persistType;
    }

    public GenericDaoImpl(Class<T> persistType) {
        this.persistType = persistType;
    }

    public T get(PK id) {
        return (T) getHibernateTemplate().get(persistType, id);
    }
}
