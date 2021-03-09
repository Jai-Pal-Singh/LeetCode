package bipartite_graph;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Solution {
	public boolean isBipartite(int[][] graph) {
		Integer length = graph.length;
		Integer[] colour = new Integer[length];
		Arrays.fill(colour, Color.NO_COLOR.getValue());
		
		for(int i = 0; i < length; i++) {
			if(colour[i].equals(Color.NO_COLOR.getValue())) {
				if(bipatiteUtil(graph, i, colour)==false) {
					return false;
				}
			}
		}
		return true;
	}

	private boolean bipatiteUtil(int[][] graph, int i, Integer[] colour) {
		Queue<Integer> queue = new LinkedList<>();
		queue.add(i);
		colour[i] = Color.RED.getValue();
		while(!queue.isEmpty()) {
			Integer u = queue.remove();
			System.out.println("Node : " + u + " , Color : " + colour[u]);
			for(Integer v = 0; v < graph[u].length; v++) {
				if(colour[graph[u][v]].equals(Color.NO_COLOR.getValue())) {
					queue.add(graph[u][v]);
					colour[graph[u][v]] = 1 - colour[u];
					
					System.out.print("Queue : ");
					queue.stream().forEach(System.out::print);
					System.out.println();
				}
				else if(colour[graph[u][v]].equals(colour[u])){
					System.out.println("Node " + graph[u][v] + " has same colour as parent node " + u);
					return false;
				}
			}
		}
		return true;
	}
}
