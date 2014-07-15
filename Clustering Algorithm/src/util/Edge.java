package util;
/*
 * @author: Adrian She
 * @since: 07/15/2014
 * 
 * Utility class for an edge of an undirected graph
 */

public class Edge {
			
		int source;
		int destination;
		int weight;
		
		public Edge(int s, int d, int w) {
			source = s;
			destination = d;
			weight = w;
		}
		
		public int getSource() {
			return source;
		}
		
		public int getDestination() {
			return destination;
		}
		
		public int getWeight() {
			return weight;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + destination;
			result = prime * result + source;
			result = prime * result + weight;
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Edge other = (Edge) obj;
			if (source == other.destination && destination == other.source) 
				return true;
			if (destination != other.destination)
				return false;
			if (source != other.source)
				return false;
			if (weight != other.weight)
				return false;
			return true;
		}

}
