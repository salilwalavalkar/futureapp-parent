package com.salil.futureapp.web.common;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

/**
 * Custom tag library for formating date string.
 * @author salil
 * #CUSTOMTAGLIBRARY 
 */
public class CustomDateTagHandler extends TagSupport {

    /**
     * Serial version uid.
     */
	private static final long serialVersionUID = 150601155689699881L;
	
	/**
     * Default date pattern.
     */
    private static String DEFAULT_DATE_PATTERN = "dd-MMM-yyyy, hh:mm:ss a";
    /**
     * Variable for blank string.
     */
    private static String BLANK = "";
    /**
     * Input date.
     */
    private Date input;
    /**
     * Java time zone.
     */
    private String javaTimeZone;
    /**
     * Pattern.
     */
    private String pattern;
    /**
     * Time zone description.
     */
    private String timeZoneDesc;

    /**
     * Process Tag.
     * 
     * @see javax.servlet.jsp.tagext.TagSupport#doStartTag()
     */
    @Override
    public int doStartTag() {
        try {
            JspWriter out = pageContext.getOut();
            out.print(fmtDate());
        } catch (IOException e) {
            throw new Error(e.getMessage(), e);
        }
        return SKIP_BODY;

    }

    /**
     * Format and return date.
     * 
     * @return formatted date string.
     */
    private String fmtDate() {

        if (input == null) {
            return BLANK;
        }

        SimpleDateFormat sdf = new SimpleDateFormat(
                isEmptyOrBlank(pattern) ? DEFAULT_DATE_PATTERN : pattern.trim());

        if (!isEmptyOrBlank(javaTimeZone)) {
            sdf.setTimeZone(TimeZone.getTimeZone(javaTimeZone.trim()));
        }

        if (isEmptyOrBlank(timeZoneDesc)) {
            return sdf.format(input);
        } else {
            return sdf.format(input) + ", " + timeZoneDesc.trim();

        }
    }

    /**
     * Gets boolean value true or false in a string after applying trim
     * function.
     * 
     * @param String
     *            - str.
     */
    private boolean isEmptyOrBlank(final String str) {
        return (str == null) || str.trim().isEmpty();
    }

    /**
     * End Tag.
     */
    @Override
    public int doEndTag() {
        return EVAL_PAGE;
    }

    /**
     * Getter for input.
     * 
     * @return the input.
     */
    public Date getInput() {
        return input;
    }

    /**
     * Setter for input.
     * 
     * @param input
     *            - input to set.
     */
    public void setInput(final Date input) {
        this.input = input;
    }

    /**
     * Getter for javaTimeZone.
     * 
     * @return the javaTimeZone.
     */
    public String getJavaTimeZone() {
        return javaTimeZone;
    }

    /**
     * Setter for javaTimeZone.
     * 
     * @param javaTimeZone
     *            -javaTimeZone to set.
     */
    public void setJavaTimeZone(final String javaTimeZone) {
        this.javaTimeZone = javaTimeZone;
    }

    /**
     * Getter for timeZoneDesc.
     * 
     * @return the timeZoneDesc
     */
    public String getTimeZoneDesc() {
        return timeZoneDesc;
    }

    /**
     * Setter for timeZoneDesc.
     * 
     * @param timeZoneDesc
     *            - timeZoneDesc to set.
     */
    public void setTimeZoneDesc(final String timeZoneDesc) {
        this.timeZoneDesc = timeZoneDesc;
    }

    /**
     * Getter for pattern.
     * 
     * @return the pattern
     */
    public String getPattern() {
        return pattern;
    }

    /**
     * Setter for pattern.
     * 
     * @param pattern
     *            - pattern to set.
     */
    public void setPattern(final String pattern) {
        this.pattern = pattern;
    }

}
