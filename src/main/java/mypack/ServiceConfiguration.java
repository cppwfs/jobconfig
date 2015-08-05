package mypack;

import java.util.Enumeration;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.cloud.Cloud;
import org.springframework.cloud.CloudFactory;
import org.springframework.cloud.bootstrap.BootstrapConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

/**
 * Created by glennrenfro on 7/30/15.
 */
@EnableAutoConfiguration
@Configuration
public class ServiceConfiguration {

	@Configuration
	@Profile("cloud")
	protected static class CloudConfig {
		@Bean
		public Cloud cloud() {
			Cloud cloud = new CloudFactory().getCloud();
			System.out.println(cloud.getApplicationInstanceInfo());
			Properties p = cloud.getCloudProperties();
			Map<String, Object> propMap = cloud.getApplicationInstanceInfo().getProperties();
			Iterator<String> iter = propMap.keySet().iterator();
			while(iter.hasNext()){
				String propKey = iter.next();
				System.out.println("*****PROPERTIES****  "+ propKey+"<==>"+propMap.get(propKey));

			}
			Enumeration keys = p.keys();
			while(keys.hasMoreElements()){
				String key = (String) keys.nextElement();
				System.out.println("*****ClOUDPROPERTIES****  "+ key+"<==>"+p.getProperty(key));
			}
			return cloud;
		}
		@Bean
		public SimpleClass latestValue(){
			return new SimpleClass("CLOWDY");
		}
	}

	@Configuration
	@Profile("local")
	protected static class LocalConfig { 
		@Bean
		public SimpleClass latestValue(){
			return new SimpleClass("HOWDY");
		}
	}

	@BootstrapConfiguration
	@Profile("local")
	protected static class BootConfig {
	}
}
