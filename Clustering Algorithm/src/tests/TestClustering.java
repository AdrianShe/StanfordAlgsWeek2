package tests;

import static org.junit.Assert.*;
import implementation.ClusterExplicitDistance;

import org.junit.Before;
import org.junit.Test;

import util.Graph;

public class TestClustering {
	
	Graph g;
	
	@Before
	public void constructCluster() {
		g = new Graph(5);
		g.addEdge(1,2,3);
		g.addEdge(1,3,6);
		g.addEdge(1,4,9);
		g.addEdge(1,5,12);
		g.addEdge(2,3,4);
		g.addEdge(2,4,8);
		g.addEdge(2,5,16);
		g.addEdge(3, 4, 12);
		g.addEdge(3,5,2);
		g.addEdge(4,5,7);
	}
	
	@Test
	public void testClusteringOneIts() {
		ClusterExplicitDistance cluster = new ClusterExplicitDistance(4, g);
		cluster.runClustering();
		assertEquals(16, cluster.findMaxSpacing());
	}
	
	@Test
	public void testClusteringTwoIts() {
		ClusterExplicitDistance cluster = new ClusterExplicitDistance(3, g);
		cluster.runClustering();
		assertEquals(16, cluster.findMaxSpacing());
	}
	
	@Test
	public void testClusteringThreeIts() {
		ClusterExplicitDistance cluster = new ClusterExplicitDistance(2, g);
		cluster.runClustering();
		assertEquals(12, cluster.findMaxSpacing());
	}
	
	@Test
	public void testClusteringFourIts() {
		ClusterExplicitDistance cluster = new ClusterExplicitDistance(1, g);
		cluster.runClustering();
		assertEquals(0, cluster.findMaxSpacing());
	}

}
