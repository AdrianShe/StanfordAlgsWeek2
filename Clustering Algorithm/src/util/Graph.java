
package util;


import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Adrian She
 * @since: 07/15/2014
 */
public class Graph implements GraphInterface, Iterable<LinkedList<Edge>>{

	/* (non-Javadoc)
	 * @see util.GraphInterface#addVertex(int)
	 */
	int numVerticies;
	ArrayList<LinkedList<Edge>> graph;
	Integer[][] matrix;
	
	public Graph() {
		// Default capacity 1000 verticies
		graph = new ArrayList<LinkedList<Edge>>(1000);
		numVerticies = 1000;
		for (int i = 1; i <= numVerticies; i++) {
			addVertex(i);
		}
		matrix = new Integer[1000][1000];
	}
	
	public Graph(int numVertex) {
		graph = new ArrayList<LinkedList<Edge>>(numVertex);
		numVerticies = numVertex;
		for (int i = 1; i <= numVerticies; i++) {
			addVertex(i);
		}
		matrix = new Integer[numVertex][numVertex];
	}
	
	@Override
	public void addVertex(int i) {
		// TODO Auto-generated method stub
			graph.ensureCapacity(i);
			LinkedList<Edge> edgeList = new LinkedList<Edge>();
			graph.add(i-1, edgeList);
			if (i > numVerticies) {
				numVerticies = i;
			}
	}

	/* (non-Javadoc)
	 * @see util.GraphInterface#addEdge(int, int, int)
	 */
	@Override
	public void addEdge(int s, int d, int w) {
		// TODO Auto-generated method stub
		graph.get(s-1).add(new Edge(s,d,w));
		graph.get(d-1).add(new Edge(d,s,w));
		matrix[s-1][d-1] = w;
		matrix[d-1][s-1] = w;
	}
	
	@Override
	public Integer getNumVerticies() {
		// TODO Auto-generated method stub
		return numVerticies;
	}

	@Override
	public ArrayList<LinkedList<Edge>> getGraph() {
		// TODO Auto-generated method stub
		return graph;
	}

	@Override
	public List<Edge> getEdges() {
		// TODO Auto-generated method stub
		List<Edge> edges = new ArrayList<Edge>();
		for (LinkedList<Edge> ListOfEdge : graph) {
			for (int i = 0; i < ListOfEdge.size(); i++) {
				Edge e = ListOfEdge.get(i);
				if (!edges.contains(e)) {
					edges.add(e);
				}
			}
		}
		return edges;
	}
	
	public int containsEdge(int i, int j) {
		return matrix[i][j];
	}
	
	@Override
	public List<Edge> sortEdges(List<Edge> loe) {
		// TODO Auto-generated method stub
		 final class EdgeComparator implements Comparator<Edge> {
			@Override
			public int compare(Edge arg0, Edge arg1) {
				// TODO Auto-generated method stub
				return arg0.getWeight() - arg1.getWeight();
			}
		}
		
		Collections.sort(loe, new EdgeComparator());
		return loe;
	}

	@Override
	public Iterator<LinkedList<Edge>> iterator() {
		// TODO Auto-generated method stub
		return graph.iterator();
	}
	
	public void printGraph() {
		for (LinkedList<Edge> ListOfEdge : graph) {
			for (int i = 0; i < ListOfEdge.size(); i++) {
				Edge e = ListOfEdge.get(i);
				System.out.println(e.getSource() + " " + e.getDestination() + " " + e.getWeight());
			}
		}
	}

	
	
}
