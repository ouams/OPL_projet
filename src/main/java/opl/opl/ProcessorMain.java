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
				if (inv.getExecutable().getDeclaration() != null) {
					if (graph.getNode(inv.getExecutable().getSimpleName()) == null) {
						final Node n = graph.addNode(inv.getExecutable().getSimpleName());
						n.addAttribute("ui.label", inv.getExecutable().getSimpleName());
					}
					
					if (graph.getNode(inv.getParent(CtMethod.class).getSimpleName()) != null) {
						final String parent = inv.getParent(CtMethod.class).getSimpleName();
						graph.addEdge(String.valueOf(graph.getEdgeCount() + 1), parent, inv.getExecutable().getSimpleName(), true);
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
