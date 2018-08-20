import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.PriorityQueue;

class TRVCOST {

	static class Graph {
		ArrayList<Vertex> list;

		Graph(int N) {
			list = new ArrayList<Vertex>();
			for (int i = 0; i < N; i++) {
				list.add(i,new Vertex(i));
			}
		}

		public void addAdj(int a, int b, int w) {
			list.get(a).addEdge(b, w);
			list.get(b).addEdge(a, w);
		}

	}

	static class Vertex implements Comparable<Vertex> {
		HashSet<Edge> set;
		int distance;
		

		int val;

		public Vertex(int val) {
			// TODO Auto-generated constructor stub
			this.val=val;
			distance = Integer.MAX_VALUE;
			set = new HashSet<Edge>();
		}

		public void addEdge(int b, int w) {
			set.add(new Edge(b, w));
		}

		
		
		

		@Override
		public int compareTo(Vertex o) {
			// TODO Auto-generated method stub
			return new Integer(this.distance).compareTo(o.distance);
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

	/**
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		// BufferedReader br = new BufferedReader(new
		// InputStreamReader(System.in));
		//Scanner scan = new Scanner(System.in);

		Parser in=new Parser(System.in);
		
		int N = in.nextInt();//scan.nextInt();// Integer.parseInt(br.readLine());

		Graph graph = new Graph(500);

		while (N-- != 0) {
			// StringTokenizer st=new StringTokenizer(br.readLine());

			int a =in.nextInt();// scan.nextInt();// Integer.parseInt(st.nextToken());
			int b = in.nextInt();//scan.nextInt();// Integer.parseInt(st.nextToken());
			int w = in.nextInt();//scan.nextInt();// Integer.parseInt(st.nextToken());
			graph.addAdj(a, b, w);
		}

		int s = in.nextInt();//scan.nextInt();// Integer.parseInt(br.readLine());

		dijkstra(graph, s);

		int Q = in.nextInt();//scan.nextInt();// Integer.parseInt(br.readLine());
		N = graph.list.size();
		while (Q-- != 0) {
			int U = in.nextInt();//scan.nextInt();// Integer.parseInt(br.readLine());
			
			int ans=graph.list.get(U).distance;
			if(ans==Integer.MAX_VALUE){
				System.out.println("NO PATH");
			}else{
				System.out.println(ans);
			}
		}

	}

	public static void dijkstra(Graph graph, int s) {

		PriorityQueue<Vertex> queue = new PriorityQueue<Vertex>();

		graph.list.get(s).distance = 0;
		queue.add(graph.list.get(s));

		while (!queue.isEmpty()) {

			Vertex u = queue.poll();

			for (Edge e : u.set) {
				Vertex v = graph.list.get(e.dest);
				if (u.distance + e.weight < v.distance) {
					v.distance = u.distance + e.weight;
					queue.offer(v);
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
