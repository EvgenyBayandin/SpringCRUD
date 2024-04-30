package com.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import org.springframework.web.filter.HiddenHttpMethodFilter;

public class MySpringMvcDispatcherServletInititializer extends AbstractAnnotationConfigDispatcherServletInitializer {

    @Override
    protected Class<?>[] getRootConfigClasses() {
        return null;
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{SpringConfig.class};
    }

    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }

    @Override
    public void onStartup(ServletContext aServletContext) throws ServletException {
        super.onStartup(aServletContext);
        registerHiddenHttpMethodFilter(aServletContext);
    }

    private void registerHiddenHttpMethodFilter(ServletContext aContext) {
       aContext.addFilter("hiddenHttpMethodFilter",
               new HiddenHttpMethodFilter()).addMappingForUrlPatterns(null, true, "/*");
    }
}
