package com.salil.futureapp.web.common;

import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Enumeration;

import javax.servlet.ServletContextEvent;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.context.ContextLoaderListener;

/**
 * ContextLoaderListener extends Object implements ServletContextListener 
 * Bootstrap listener to start up Spring's root WebApplicationContext. 
 * Simply delegates to ContextLoader #CONTEXTLISTENER
 * 
 * @author salil
 * @version 1.0
 */
public class CustomContextListener extends ContextLoaderListener {
	
	/**
	 * Creating LoggerFactory instance of CustomContextListener.
	 */
	private static final Logger LOGGER = LoggerFactory
			.getLogger(CustomContextListener.class);

	/**
	 * Context destroyed.
	 * 
	 * @param servletContextEvent
	 *            - Servlet Context Event.
	 * @see javax.servlet.ServletContextListener#contextDestroyed(javax.servlet.ServletContextEvent)
	 */
	@Override
	public void contextDestroyed(final ServletContextEvent servletContextEvent) {
		deRegisterDrivers();
		LOGGER.debug("Destroying context.");
	}
	
	/**
	 * Since version 6.0.24, Tomcat ships with a memory leak detection feature,
	 * which in turn can lead to this kind of warning messages when there's a
	 * JDBC 4.0 compatible driver in the webapp's /WEB-INF/lib which
	 * auto-registers itself during webapp's startup using the ServiceLoader
	 * API, but which did not auto-deregister itself during webapp's shutdown. 
	 * So we force de register the drivers.
	 */
	private void deRegisterDrivers()
	{
		Enumeration<Driver> drivers = DriverManager.getDrivers();
		while (drivers.hasMoreElements()) {
			Driver driver = drivers.nextElement();
			ClassLoader driverclassLoader = driver.getClass().getClassLoader();
			ClassLoader thisClassLoader = this.getClass().getClassLoader();
			if (driverclassLoader != null && thisClassLoader != null
					&& driverclassLoader.equals(thisClassLoader)) {
				try {
					LOGGER.warn("Deregistering: " + driver);
					DriverManager.deregisterDriver(driver);
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}

	/**
	 * Context Initialized
	 * 
	 * @param servletContextEvent
	 *            - Servlet Context Event.
	 * @see javax.servlet.ServletContextListener#contextInitialized(javax.servlet.ServletContextEvent)
	 */
	@Override
	public void contextInitialized(final ServletContextEvent servletContextEvent) {
		LOGGER.debug("Initializing context.");
		super.contextInitialized(servletContextEvent);
	}
}
