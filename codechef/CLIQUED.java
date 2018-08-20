import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class CLIQUED {

	static class Graph {
		ArrayList<Vertex> graph;
		int N;
		int K;
		int X;

		Graph(int N, int K, int X) {
			this.N = N;
			this.K = K;
			this.X = X;
			graph = new ArrayList<Vertex>();
			for (int i = 0; i < N; i++) {
				graph.add(new Vertex(i));
			}
			graph.add(new Vertex(N));
			setOldRoads();

		}

		public void addEdge(int a, int b,long w) {
			graph.get(a).addEdge(b, w);
			graph.get(b).addEdge(a, w);
		}

		public void setOldRoads() {
			
			for (int i = 0; i < K; i++) {
				addEdge(i, N, X);
			}
		}
	}

	static class Vertex implements Comparable<Vertex> {
		int val;
		int prev;
		ArrayList<Edge> set;
		Long distance;

		Vertex(int val) {
			this.val = val;
			set = new ArrayList<Edge>();
			distance = Long.MAX_VALUE;
		}

		public void addEdge(int b,long w) {

			set.add(new Edge(w, b));

		}

		@Override
		public int compareTo(Vertex o) {
			// TODO Auto-generated method stub
			return this.distance.compareTo(o.distance);
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + val;
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
			Vertex other = (Vertex) obj;
			if (val != other.val)
				return false;
			return true;
		}
	}

	static class Edge {
		long weight;
		int dest;

		public Edge(long weight, int dest) {
			super();
			this.weight = weight;
			this.dest = dest;
		}

	}

	/**
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());

		while (T-- != 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			int N = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			int X = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			int S = Integer.parseInt(st.nextToken());

			Graph g = new Graph(N, K, X);


			while (M-- != 0) {
				st = new StringTokenizer(br.readLine());

				int a = Integer.parseInt(st.nextToken()) - 1;
				int b = Integer.parseInt(st.nextToken()) - 1;
				long c = Long.parseLong(st.nextToken());
				g.addEdge(a, b, c*2);
			}
			djisktra(g, S - 1);
			
			for (int i=0;i<g.graph.size()-1;i++) {
				System.out.print(((g.graph.get(i).distance)/2) + " ");
			}
			System.out.println();
		}
	}

	public static void djisktra(Graph g, int s) {

		PriorityQueue<Vertex> queue = new PriorityQueue<Vertex>();
		Vertex start = g.graph.get(s);
		start.distance = 0L;
		queue.add(start);
		

		while (!queue.isEmpty()) {
			Vertex v = queue.poll();
			for (Edge e : v.set) {
				Vertex u = g.graph.get(e.dest);
				if (v.distance + e.weight < u.distance) {
					u.distance = v.distance + e.weight;
					u.prev = v.val;
					queue.offer(u);
				}
			}

		}

	}

}
