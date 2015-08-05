package mypack;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.context.annotation.Import;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by glennrenfro on 7/8/15.
 */
@Import(ServiceConfiguration.class)
@RestController
public class MyAppController {
	@Value("${foo: }")
	private String name;
	@Value("${password: }")
	private String password;
	
	@Autowired
	SimpleClass myclass;

	
		@RequestMapping("/")
		public String home() {
			return "Hello World! "+ name + "<-->"+password+"<-->"+myclass.hello() ;
		}

		public static void main(String[] args) {
			SpringApplication.run(MyAppController.class, args);
		}
	}
