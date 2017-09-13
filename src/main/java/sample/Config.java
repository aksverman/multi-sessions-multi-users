package sample;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.session.jdbc.config.annotation.web.http.EnableJdbcHttpSession;
import org.springframework.transaction.PlatformTransactionManager;

/**
 * @author Ankush.Verman
 */

// tag::class[]
@Configuration
@EnableJdbcHttpSession
public class Config {

	/*@Bean
	public LettuceConnectionFactory connectionFactory() {
		return new LettuceConnectionFactory();
	}*/
	
	
	@Bean
	public DataSource dataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://10.98.8.100:3306/security_dev?useSSL=false&useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC");
		dataSource.setUsername("devuser");
		dataSource.setPassword("leo$123");
		return dataSource;
	}
	
	@Bean(name = "txManager")
	public PlatformTransactionManager	txManager() {
		return new DataSourceTransactionManager(dataSource());
	}
}
// end::class[]
