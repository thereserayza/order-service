package com.ibm.ojt;

import java.util.Arrays;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.convert.CustomConversions;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurerAdapter;

@Configuration
public class RepositoryConfig extends RepositoryRestConfigurerAdapter {
	
    @Override
	public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config) {
        config.exposeIdsFor(Order.class);
    }
    
    public CustomConversions customConversions() {
		return new CustomConversions(Arrays.asList(new StringToLocalDateTimeConverter()));
    }
}