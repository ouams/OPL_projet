package opl.opl;

import java.util.List;

import org.graphstream.graph.Graph;
import org.graphstream.graph.Node;
import org.graphstream.graph.implementations.SingleGraph;

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
	static Graph graph;
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
				final String current = inv.getExecutable().getSimpleName();
				
				if (inv.getExecutable().getDeclaration() != null) {
					if (graph.getNode(inv.getExecutable().getSimpleName()) == null) {
						final Node n = graph.addNode(current);
						n.addAttribute("ui.label", current);
					}
					
					System.out.println("fct " + current + " parent " + inv.getParent(CtMethod.class).getSimpleName());
					
					if (inv.getParent(CtMethod.class).getSimpleName() != null) {
						final String parent = inv.getParent(CtMethod.class).getSimpleName();
						
						if (graph.getNode(parent) == null) {
							final Node n = graph.addNode(parent);
							n.addAttribute("ui.label", parent);
						}	
						graph.addEdge(String.valueOf(graph.getEdgeCount() + 1), parent, current, true);
					}
				}
			}
		}
	}

	public static void main(String[] args) throws Exception {
		// create a JGraphT call graph
		graph = new SingleGraph("CallGraph");

		// Add main node to the graph
		final Node n = graph.addNode("main");
		n.setAttribute("ui.label", "main");
		
		spoon.Launcher.main(new String[] { "-p", "opl.opl.ProcessorMain", "-i", "sources/opl/A.java" });

		graph.display();
	}

}
