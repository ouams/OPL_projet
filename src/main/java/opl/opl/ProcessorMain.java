package opl.opl;

import java.util.List;

import org.graphstream.graph.Edge;
import org.graphstream.graph.Graph;
import org.graphstream.graph.Node;
import org.graphstream.graph.implementations.SingleGraph;

import spoon.Launcher;
import spoon.processing.AbstractProcessor;
import spoon.reflect.code.CtInvocation;
import spoon.reflect.declaration.CtClass;
import spoon.reflect.declaration.CtMethod;
import spoon.reflect.visitor.filter.TypeFilter;

/**
 * Class that create a call graph from a source file executed with Spoon
 *
 * @author sais, badache
 *
 */
public class ProcessorMain extends AbstractProcessor<CtMethod<?>> {
	// Global graph for the whole execution
	static Graph graph;

	/*
	 * (non-Javadoc)
	 *
	 * @see
	 * spoon.processing.Processor#process(spoon.reflect.declaration.CtElement)
	 */
	public void process(CtMethod<?> arg0) {
		// Every elements which are function calls are registered here
		List<CtInvocation<?>> elements = arg0.getElements(new TypeFilter(CtInvocation.class));

		// If we have at least one element
		if (elements != null) {

			// For each element of the list
			for (CtInvocation<?> inv : elements) {

				// Getting its name
				String current = inv.getExecutable().getSimpleName();

				// Get the class name where the called method belongs
				if (inv.getExecutable().getDeclaration() != null) {
					System.out.println("fct : " + current + " class :"
							+ inv.getExecutable().getDeclaration().getParent(CtClass.class).getSimpleName());
				}

				// If it is not a native function (e.g println, error ...)
				if (inv.getExecutable().getDeclaration() != null) {
					// If the corresponding node doesn't exist, we create it
					if (graph.getNode(current) == null) {
						final Node n = graph.addNode(current);
						if (inv.getExecutable().getDeclaration().getParent(CtClass.class) != null)
							n.addAttribute("ui.label", current + " - ["
									+ inv.getExecutable().getDeclaration().getParent(CtClass.class).getSimpleName()
									+ "]");
					}

					// If the current method call has a parent (e.g main is a
					// parent of a function called inside it)
					if (inv.getParent(CtMethod.class).getSimpleName() != null) {
						// Getting the parent's name
						CtMethod<?> parent = inv.getParent(CtMethod.class);

						// If the parent does not have a dedicated node yet, we
						// create it
						if (graph.getNode(parent.getSimpleName()) == null) {

							final Node n = graph.addNode(parent.getSimpleName());

							if (inv.getExecutable().getDeclaration().getParent(CtClass.class) != null)
								n.addAttribute("ui.label", parent.getSimpleName() + " - " + inv.getExecutable()
										.getDeclaration().getParent(CtClass.class).getSimpleName());
						}

						// We add an oriented edge between parent and current if
						// it doesn't exists yet
						String id = parent.getSimpleName() + "-" + current;
						Edge edge = graph.getEdge(id);

						if (edge != null) {
							edge.changeAttribute("ui.label", (Integer) edge.getAttribute("ui.label") + 1);
						} else {
							graph.addEdge(id, parent.getSimpleName(), current, true);
							Edge e = graph.getEdge(id);
							e.addAttribute("ui.label", 1);
						}

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

		// Lancement du processeur
		Launcher spoon = new Launcher();
		spoon.addProcessor(new ProcessorMain());
		spoon.run(new String[] { "-i", "sources/opl/ActionPiscine/src/", "-x" });

		graph.display(true);
	}

}
