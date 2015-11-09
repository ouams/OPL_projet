package opl.opl;

import org.graphstream.graph.Graph;
import org.graphstream.graph.Node;
import org.graphstream.graph.implementations.SingleGraph;

import spoon.processing.AbstractProcessor;
import spoon.reflect.code.CtInvocation;
import spoon.reflect.declaration.CtMethod;

public class App<T> extends AbstractProcessor<CtInvocation<T>> {
	static Graph graph;

	public void process(CtInvocation<T> invocated) {
		final String currMethod = invocated.getSignature().toString();

		if (invocated.getExecutable().getDeclaration() != null) {
			System.out.println("Methode courrante : " + currMethod);

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

	public static void main(String[] args) throws Exception {
		// create a JGraphT graph
		graph = new SingleGraph("CallGraph");
		final Node n = graph.addNode("main");
		n.setAttribute("ui.label", "main");

		spoon.Launcher.main(new String[] { "-p", "opl.opl.App", "-i", "sources/opl/A.java" });

		graph.display();

	}

}
