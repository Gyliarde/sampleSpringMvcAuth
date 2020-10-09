package br.com.farias.config;


import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.filter.DelegatingFilterProxy;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

public class WebAppInitializer implements WebApplicationInitializer {


    @Override
    public void onStartup(final ServletContext container) throws ServletException {


        AnnotationConfigWebApplicationContext root = new AnnotationConfigWebApplicationContext();

        root.register(SecurityConfig.class);
        root.scan("br.com.farias");

        container.addListener(new ContextLoaderListener(root));
        container.addFilter("securityFilter", new DelegatingFilterProxy("springSecurityFilterChain"))
                .addMappingForUrlPatterns(null, false, "/*");

        ServletRegistration.Dynamic dispatcher = container.addServlet("mvc", new DispatcherServlet(root));
        dispatcher.setLoadOnStartup(1);
       dispatcher.addMapping("/");
    }


}
