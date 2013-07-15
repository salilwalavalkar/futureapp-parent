package com.salil.futureapp.web.common;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.SimpleMappingExceptionResolver;

/**
 * Global Exception Handler. #EXCEPTIONHANDLER
 * 
 * @author salil
 * @version 1.0
 */
public class CustomExceptionHandler extends SimpleMappingExceptionResolver {
    
	/**
     * Creating LoggerFactory instance of CustomExceptionHandler.
     */
    private static final Logger LOGGER = LoggerFactory
            .getLogger(CustomExceptionHandler.class);

    /**
     * Overridden method of class SimpleMappingExceptionResolver implementing
     * resolveException method.
     * 
     * @param request
     *            - HttpServletRequest object.
     * @param response
     *            - HttpServletResponse object.
     * @param handler
     *            - Object class instance.
     * @param ex
     *            - Exception object.
     * @return ModelAndView - ModelAndView object.
     */
    @Override
    public ModelAndView resolveException(final HttpServletRequest request,
            final HttpServletResponse response, final Object handler,
            final Exception ex) {
        LOGGER.error(ex.getMessage(), ex);
        return super.resolveException(request, response, handler, ex);
    }
}