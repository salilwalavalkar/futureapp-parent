package com.salil.futureapp.dao.base;

import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.orm.hibernate3.HibernateTemplate;

/**
 * Abstract Class provide the Instance of HibernateTemplate to execute the query
 * by it's implementor classes.  #HIBERNATE
 * 
 * @author salil
 * @version 1.0
 */
public abstract class AbstractDaoImpl implements IDao {

    /**
     * Creating LoggerFactory instance of AbstractDaoImpl.
     */
    private static final Logger LOGGER = LoggerFactory
            .getLogger(AbstractDaoImpl.class);
    /**
     * Instance of HiberanteTemplate.
     */
    protected HibernateTemplate hibernateTemplate;

    /**
     * Create a Instance of HibernateTemplate which is used by it Object at dao
     * layer by extending the AbstractDaoImpl.
     * 
     * @param sessionFactory
     *            - session factory interface provide the session instance.
     */
    public void setSessionFactory(final SessionFactory sessionFactory) {
        LOGGER.debug("Hibernate Template  session is created : Begin");
        hibernateTemplate = new HibernateTemplate(sessionFactory);
        LOGGER.debug("Hibernate Template  session is created : End");
    }
}
