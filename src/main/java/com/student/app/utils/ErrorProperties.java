package com.student.app.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ErrorProperties {

	//instead of using this we can use spring annotation like to load properies ex.
	/*
	 * @PropertySource("classpath:/com/myco/app.properties")
public class AppConfig {
   @Autowired
   Environment env;

   @Bean
   public TestBean testBean() {
       TestBean testBean = new TestBean();
       testBean.setName(env.getProperty("testbean.name"));
       return testBean;
   }
}


 @Value("${test.prop}")
 private String attr;

	 */
	public Properties getProperties() {
		Properties props = new Properties();
		InputStream is = null;
		try {
			 is = ErrorProperties.class.getResourceAsStream("/errorMessage.properties");
			props.load(is);
		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			try {
				is.close();
			} catch (IOException e) {
			}
		}

		return props;
	}
}
