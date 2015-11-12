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
 * Class that create a call graph from a source file executed with Spoon
 *
 * @author sais, badache
 *
 */
public class ProcessorMain extends AbstractProcessor<CtMethod> {
	// Global graph for the whole execution
	static Graph graph;
	/*
	 * (non-Javadoc)
	 *
	 * @see
	 * spoon.processing.Processor#process(spoon.reflect.declaration.CtElement)
	 */
	public void process(CtMethod arg0) {
		// Every elements which are function calls are registered here
		List<CtInvocation> elements = arg0.getElements(new TypeFilter(CtInvocation.class));

		// If we have at least one element
		if (elements != null) {
			// For each element of the list
			for (CtInvocation inv : elements) {
				// Getting its name
				final String current = inv.getExecutable().getSimpleName();
				
				// If it is not a native function (e.g println, error ...)
				if (inv.getExecutable().getDeclaration() != null) {
					// If the corresponding node doesn't exist, we create it
					if (graph.getNode(inv.getExecutable().getSimpleName()) == null) {
						final Node n = graph.addNode(current);
						n.addAttribute("ui.label", current);
					}
					
					// If the current method call has a parent (e.g main is a parent of a function called inside it)
					if (inv.getParent(CtMethod.class).getSimpleName() != null) {
						// Getting the parent's name
						final String parent = inv.getParent(CtMethod.class).getSimpleName();
						
						// If the parent does not have a dedicated node yet, we create it
						if (graph.getNode(parent) == null) {
							final Node n = graph.addNode(parent);
							n.addAttribute("ui.label", parent);
						}	
						
						// We add an oriented edge between parent and current method call
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
		
		// Launching the main process about creating the graph
		spoon.Launcher.main(new String[] { "-p", "opl.opl.ProcessorMain", "-i", "sources/opl/A.java" });

		graph.display();
	}

}
