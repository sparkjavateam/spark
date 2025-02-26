package spark.servlet;

import java.util.Enumeration;

import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;


public class FilterConfigWrapper implements FilterConfig {
 
    private FilterConfig delegate;

    public FilterConfigWrapper(FilterConfig delegate) {
        this.delegate = delegate;
    }
    
    /**
     * @return
     * @see javax.servlet.FilterConfig#getFilterName()
     */
    @Override
    public String getFilterName() {
        return delegate.getFilterName();
    }

    /**
     * @param name
     * @return
     * @see javax.servlet.FilterConfig#getInitParameter(java.lang.String)
     */
    @Override
    public String getInitParameter(String name) {
        if (name.equals("applicationClass")) {
            return "spark.servlet.MyApp";
        }
        return delegate.getInitParameter(name);
    }

    /**
     * @return
     * @see javax.servlet.FilterConfig#getInitParameterNames()
     */
    @Override
    public Enumeration<String> getInitParameterNames() {
        return delegate.getInitParameterNames();
    }

    /**
     * @return
     * @see javax.servlet.FilterConfig#getServletContext()
     */
    @Override
    public ServletContext getServletContext() {
        return delegate.getServletContext();
    }
    
}