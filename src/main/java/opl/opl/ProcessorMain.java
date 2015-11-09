package opl.opl;

import java.util.List;

import spoon.processing.AbstractProcessor;
import spoon.reflect.code.CtInvocation;
import spoon.reflect.declaration.CtMethod;
import spoon.reflect.visitor.filter.TypeFilter;

/**
 * Class that create a call graph
 *
 * @author sais
 *
 */
public class ProcessorMain extends AbstractProcessor<CtMethod> {

	/*
	 * (non-Javadoc)
	 *
	 * @see
	 * spoon.processing.Processor#process(spoon.reflect.declaration.CtElement)
	 */
	public void process(CtMethod arg0) {
		List<CtInvocation> elements = arg0.getElements(new TypeFilter(CtInvocation.class));

		if (elements != null) {

			for (CtInvocation inv : elements) {
				// If the curr invocation has a parent which is not a system
				// call
				if ((inv.getParent(CtMethod.class) != null) && (inv.getExecutable().getDeclaration() != null)) {
					System.out.println("fct : " + inv.getExecutable().getSimpleName() + "    Parent :  "
							+ inv.getParent(CtMethod.class).getSimpleName());
				}

			}
		}
	}

	public static void main(String[] args) throws Exception {

		spoon.Launcher.main(new String[] { "-p", "opl.opl.ProcessorMain", "-i", "sources/opl/A.java" });

	}

}
