package com.rcggs.metadata.configuration;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import com.rcggs.metadata.dao.IClientDao;
import com.rcggs.metadata.dao.IFileTypeDao;
import com.rcggs.metadata.dao.IJobDao;
import com.rcggs.metadata.dao.impl.ClientDaoImpl;
import com.rcggs.metadata.dao.impl.FileTypeDaoImpl;
import com.rcggs.metadata.dao.impl.JobDaoImpl;
import com.rcggs.metadata.services.ClientService;
import com.rcggs.metadata.services.FileTypeService;
import com.rcggs.metadata.services.JobService;
import com.rcggs.metadata.services.impl.ClientServiceImpl;
import com.rcggs.metadata.services.impl.FileTypeServiceImpl;
import com.rcggs.metadata.services.impl.JobServiceImpl;

@Configuration
@PropertySource("classpath:application.properties")
public class BeanConfigarations {
		
	@Value("${DriverName}")
    private String driverName;
	@Value("${db.url}")
    private String url;
	@Value("${db.username}")
    private String username;
	@Value("${db.password}")
    private String password;
	
	@Bean
	public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(driverName);
        dataSource.setUrl(url);
        dataSource.setUsername(username);
        dataSource.setPassword(password);
        return dataSource;
    }
    
    @Bean
    public DataSourceTransactionManager transactionManager() {
        DataSourceTransactionManager dataSourceTransactionManager = new DataSourceTransactionManager();
        dataSourceTransactionManager.setDataSource(dataSource());
        return dataSourceTransactionManager;
    }

	@Bean
    public JdbcTemplate getJdbcTemplate() {
        JdbcTemplate jdbcTemplate = new JdbcTemplate();
        jdbcTemplate.setDataSource(dataSource());
        return jdbcTemplate;
    }
    
    @Bean	
	public ClientService getClientService(){
		return new ClientServiceImpl();
	}
    
    @Bean 
    public IClientDao getIclientDao(){
    	return new ClientDaoImpl();
    }
	
    @Bean
    public FileTypeService getFileTypeService(){
		return new FileTypeServiceImpl();
	}
    
    @Bean
    public IFileTypeDao getIFileTypeDao(){
		return new FileTypeDaoImpl();
	}
    
    @Bean
    public JobService getJobService(){
		return new JobServiceImpl();
	}
    
    @Bean
    public IJobDao getIJobDao(){
		return new JobDaoImpl();
	}
    

}
