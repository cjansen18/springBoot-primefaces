package com.chrisjansen.raptor.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * This changes the initial welcome screen of the applicaiton.
 *
 * Created by Chris Jansen on 2/25/2016.
 */
@Configuration
public class WelcomePageConfig extends WebMvcConfigurerAdapter {

        @Override
        public void addViewControllers( ViewControllerRegistry registry ) {
            registry.addViewController( "/" ).setViewName( "forward:/index.jsf" );
            registry.setOrder( Ordered.HIGHEST_PRECEDENCE );
            super.addViewControllers( registry );
        }

}

