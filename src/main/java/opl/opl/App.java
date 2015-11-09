package opl.opl;

import org.graphstream.graph.Graph;
import org.graphstream.graph.Node;
import org.graphstream.graph.implementations.SingleGraph;

import spoon.processing.AbstractProcessor;
import spoon.reflect.code.CtInvocation;
import spoon.reflect.declaration.CtMethod;

/**
 * Class using a spoon processor to create a callgraph of any java program file.
 *
 * @author sais
 *
 * @param <T>
 */
public class App<T> extends AbstractProcessor<CtInvocation<T>> {
	static Graph graph;

	/*
	 * (non-Javadoc)
	 *
	 * @see
	 * spoon.processing.Processor#process(spoon.reflect.declaration.CtElement)
	 */
	public void process(CtInvocation<T> invocated) {
		// Get the current method name
		final String currMethod = invocated.getSignature().toString();

		// Test if the current method is not a system call
		if (invocated.getExecutable().getDeclaration() != null) {
			System.out.println("Methode courrante : " + currMethod);

			// If the corresponding node doesn't exists, it is added to the
			// graph
			if (graph.getNode(invocated.getSignature().toString()) == null) {
				final Node n = graph.addNode(currMethod);
				n.addAttribute("ui.label", currMethod);
			} else {
				if (graph.getNode(invocated.getParent(CtMethod.class).getSimpleName()) != null) {
					final String parent = invocated.getParent(CtMethod.class).getSimpleName();
					System.out.println("PARENT : " + parent);
					graph.addEdge(String.valueOf(graph.getEdgeCount() + 1), currMethod, parent);
				}

			}

		}

	}

	/**
	 * Main function
	 *
	 * @param args
	 * @throws Exception
	 */
	public static void main(String[] args) throws Exception {
		// create a JGraphT call graph
		graph = new SingleGraph("CallGraph");

		// Add main node to the graph
		final Node n = graph.addNode("main");
		n.setAttribute("ui.label", "main");

		// Launch spoon Processor
		spoon.Launcher.main(new String[] { "-p", "opl.opl.App", "-i", "sources/opl/A.java" });

		// Display call graph
		graph.display();

	}

}
