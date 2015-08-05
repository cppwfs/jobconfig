package mypack;

/**
 * Created by glennrenfro on 7/30/15.
 */
public class SimpleClass {
	public SimpleClass(String greeting) {
		this.greeting = greeting;
	}

	public SimpleClass() {
		this.greeting = "hello";
	}

	private String greeting;
	public String hello(){
		return greeting;
		
	}
}
