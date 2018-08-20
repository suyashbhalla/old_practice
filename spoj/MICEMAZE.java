import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.PriorityQueue;

class MICEMAZE {

	static class Graph {

		int V;
		ArrayList<Vertex> list;

		public Graph(int V) {
			this.V = V;
			list = new ArrayList<Vertex>();

			for (int i = 0; i < V; i++) {
				Vertex temp = new Vertex(i);
				list.add(i, temp);
			}
		}

		public void addEdge(int a, int b, int w) {
			list.get(a).addEdge(new Edge(b, w));
		}

	}

	static class Vertex implements Comparable<Vertex> {
		int pred;
		int val;
		int shorDistance;

		HashSet<Edge> edgeList;

		public Vertex(int val) {
			this.val = val;
			edgeList = new HashSet<Edge>();
			pred = -1;
			shorDistance = Integer.MAX_VALUE;
		}

		public void addEdge(Edge e) {
			edgeList.add(e);
		}

		@Override
		public int compareTo(Vertex o) {
			// TODO Auto-generated method stub
			Integer x = this.shorDistance;
			Integer y = o.shorDistance;
			return x.compareTo(y);
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((edgeList == null) ? 0 : edgeList.hashCode());
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
			if (edgeList == null) {
				if (other.edgeList != null)
					return false;
			} else if (!edgeList.equals(other.edgeList))
				return false;
			if (val != other.val)
				return false;
			return true;
		}

	}

	static class Edge {
		int dest;
		int weight;

		public Edge(int dest, int weight) {
			super();
			this.dest = dest;
			this.weight = weight;
		}

	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		// BufferedReader br = new BufferedReader(new
		// InputStreamReader(System.in));

		Parser in = new Parser(System.in);

		int N = in.nextInt();// Integer.parseInt(br.readLine());

		Graph graph = new Graph(N);

		int E = in.nextInt();// Integer.parseInt(br.readLine());

		int T = in.nextInt();// Integer.parseInt(br.readLine());

		int M = in.nextInt();// Integer.parseInt(br.readLine());

		while (M-- != 0) {
			// StringTokenizer st = new StringTokenizer(br.readLine());

			int a = in.nextInt() - 1;// Integer.parseInt(st.nextToken()) - 1;
			int b = in.nextInt() - 1;// Integer.parseInt(st.nextToken()) - 1;
			int w = in.nextInt();// Integer.parseInt(st.nextToken());

			graph.addEdge(b, a, w);

		}

		dijkstra(graph, E - 1);
		int count = 0;
		for (int i = 0; i < N; i++) {
			if (graph.list.get(i).shorDistance <= T) {
				count++;
			}
		}
		System.out.println(count);

	}

	public static void dijkstra(Graph graph, int s) {

		int V = graph.V;

		PriorityQueue<Vertex> queue = new PriorityQueue<Vertex>();
		graph.list.get(s).shorDistance = 0;
		queue.add(graph.list.get(s));

		while (!queue.isEmpty()) {
			Vertex u = queue.poll();
			for (Edge e : u.edgeList) {
				Vertex v = graph.list.get(e.dest);
				if (u.shorDistance + e.weight < v.shorDistance) {
					v.shorDistance = u.shorDistance + e.weight;
					queue.add(v);
				}
			}
		}

	}

	static class Parser {
		final private int BUFFER_SIZE = 65536;
		private InputStream din;
		private byte[] buffer;
		private int bufferPointer;
		private int bytesRead;

		public Parser(InputStream in) {
			din = in;
			buffer = new byte[BUFFER_SIZE];
			bufferPointer = bytesRead = 0;
		}

		public int nextInt() throws IOException {
			int result = 0;
			byte c = read();
			while (c <= ' ')
				c = read();
			boolean neg = (c == '-');
			if (neg)
				c = read();
			while (c >= '0' && c <= '9') {
				result = result * 10 + c - '0';
				c = read();
			}
			if (neg)
				return -result;
			return result;
		}

		public String readLine() throws IOException {
			StringBuilder line = new StringBuilder();
			char c;
			while ((c = (char) (read())) != '\n') {
				line.append(c);
			}
			return line.toString();
		}

		public byte read() throws IOException {
			if (bufferPointer == bytesRead)
				fillBuffer();
			return buffer[bufferPointer++];
		}

		private void fillBuffer() throws IOException {
			bytesRead = din.read(buffer, bufferPointer = 0, BUFFER_SIZE);
			if (bytesRead == -1)
				buffer[0] = -1;
		}
	}
}
