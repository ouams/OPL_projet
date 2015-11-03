package opl.opl;

import spoon.processing.AbstractProcessor;
import spoon.reflect.declaration.CtMethod;

/**
 * Hello world!
 *
 */
public class App extends AbstractProcessor<CtMethod>{
	
  
	@Override
	public void process(CtMethod arg0) {
		System.out.println(arg0.getParameters().toString());
	}


	
	
	public static void main(String[] args) throws Exception {
		spoon.Launcher.main(new String[]{
			"-p",
			"opl.opl.App",
			"-i",
			"sources/opl/A.java"
		});
		
		
	}
}
