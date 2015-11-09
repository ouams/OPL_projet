package opl.opl;

import java.util.List;

import spoon.processing.AbstractProcessor;
import spoon.reflect.code.CtInvocation;
import spoon.reflect.declaration.CtMethod;
import spoon.reflect.visitor.filter.TypeFilter;

public class ProcessorMain extends AbstractProcessor<CtMethod> {

	public void process(CtMethod arg0) {
		System.out.println(arg0.getSimpleName());
		List<CtInvocation> elements = arg0.getElements(new TypeFilter(CtInvocation.class));
		if (elements != null) {
			for (CtInvocation inv : elements) {

				System.out.println(inv.getExecutable().getSimpleName());
			}
		}
	}

	public static void main(String[] args) throws Exception {

		spoon.Launcher.main(new String[] { "-p", "opl.opl.ProcessorMain", "-i", "sources/opl/A.java" });

	}

}
