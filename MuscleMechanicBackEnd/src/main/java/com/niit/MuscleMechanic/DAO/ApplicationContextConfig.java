package com.niit.MuscleMechanic.DAO;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.niit.MuscleMechanic.model.Authorities;
import com.niit.MuscleMechanic.model.BillingAddress;
import com.niit.MuscleMechanic.model.Cart;
import com.niit.MuscleMechanic.model.CartItem;
import com.niit.MuscleMechanic.model.Category;
import com.niit.MuscleMechanic.model.Customer;
import com.niit.MuscleMechanic.model.CustomerOrder;
import com.niit.MuscleMechanic.model.Product;
import com.niit.MuscleMechanic.model.ShippingAddress;
import com.niit.MuscleMechanic.model.Supplier;
import com.niit.MuscleMechanic.model.Users;

@Configuration
@ComponentScan("com.niit.MuscleMechanic")
@EnableTransactionManagement

public class ApplicationContextConfig {

	/*
	 * Hibernate.dialect property tells Hibernate to generate the appropriate
	 * SQL statements for the chosen database. Dialect is the SQL dialect that
	 * your database uses. hibernate.dialect property makes Hibernate to
	 * generate the appropriate SQL statements for the chosen database.
	 */
	public Properties hibernateProperties() {
		Properties properties = new Properties();
		properties.put("hibernate.dialect", "org.hibernate.dialect.H2Dialect");
		properties.put("hibernate.show_sql", "true");
		properties.put("hibernate.format_sql", "true");
		properties.put("hibernate.hbm2ddl.auto", "update");
		return properties;

		/*
		 * 
		 * 
		 */
	}
	/*
	 * Specifying the datasource to the Hibernate with driver class name, url
	 * username and password
	 */

	@Bean
	public DataSource dataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("org.h2.Driver");
		dataSource.setUrl("jdbc:h2:tcp://localhost/~/MyDB1");
		dataSource.setUsername("karthik");
		dataSource.setPassword("");
		return dataSource;
	}

	@Bean
	public SessionFactory sessionFactory(DataSource dataSource) {
		LocalSessionFactoryBuilder builder = new LocalSessionFactoryBuilder(dataSource);
		builder.addProperties(hibernateProperties());
		builder.addAnnotatedClasses(Product.class,Users.class,Supplier.class,ShippingAddress.class,BillingAddress.class,CustomerOrder.class,Customer.class,Cart.class,CartItem.class,Category.class,CustomerOrder.class,Authorities.class);
		return builder.buildSessionFactory();

	}

	@Bean
	public HibernateTransactionManager transactionManager(SessionFactory s) {
		HibernateTransactionManager txManager = new HibernateTransactionManager();
		txManager.setSessionFactory(s);
		return txManager;
	}
}
