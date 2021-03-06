package com.example.demo.config;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class WebConfig extends WebMvcConfigurerAdapter{

	 @Bean
	    public SqlSessionFactory sqlSessionFactory(DataSource dataSource) throws Exception{
	        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
	        sqlSessionFactoryBean.setDataSource(dataSource);
	        Resource[] arrResource = new PathMatchingResourcePatternResolver()
	                .getResources("classpath:mapper/**/*Mapper.xml");
	        sqlSessionFactoryBean.setMapperLocations(arrResource);
	        sqlSessionFactoryBean.getObject().getConfiguration().setMapUnderscoreToCamelCase(true);
	        return sqlSessionFactoryBean.getObject();
	    }
}
