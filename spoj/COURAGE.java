import java.io.IOException;
import java.util.Scanner;

class COURAGE {

	static class Node {
		long sum;
		long min;

		Node(long sum, long min) {
			this.sum = sum;
			this.min = min;
		}

		Node merge(Node right) {
			return new Node(this.sum + right.sum, Math.min(this.min, right.min));
		}

		@Override
		public String toString() {
			return "Node [sum=" + sum + ", min=" + min + "]";
		}

	}

	static Node segmentTree[];

	public static Node merge(Node left, Node right) {
		return new Node(left.sum + right.sum, Math.min(left.min, right.min));
	}

	public static void createSegmentTree(long ar[], int low, int high, int pos) {
		if (low == high) {
			segmentTree[pos] = new Node(ar[low], ar[low]);
			return;
		}
		int mid = (low + high) / 2;
		createSegmentTree(ar, low, mid, 2 * pos + 1);
		createSegmentTree(ar, mid + 1, high, 2 * pos + 2);
		segmentTree[pos] = segmentTree[2 * pos + 1].merge(segmentTree[2 * pos + 2]);
	}

	
	
	public static Node executeQuery(int L, int R, int low, int high, int pos) {

		if (low >= L && high <= R) {
			return segmentTree[pos];
		}
		
		
		if (low > R || high < L) {
			return new Node(0, Integer.MAX_VALUE);
		}
		
		int mid = (low + high) / 2;
		
		if(mid<L)
        {
            return executeQuery(L, R, mid+1, high, 2*pos+2);
        }
        if(R<=mid)
        {
            return executeQuery(L, R, low, mid, 2*pos+1);
        }

		return merge(executeQuery(L, R, low, mid, 2 * pos + 1), executeQuery(L, R, mid + 1, high, 2 * pos + 2));
	}

	public static int getSize(int N) {
		int s = 1;
		while (s < N) {
			s <<= 1;
		}
		s <<= 1;
		return s - 1;
	}

	public static void updateSegmentTree(int low, int high, int pos, int X, long Y) {
		
		
		if (X < low || X > high) {
			return;
		}
		
		if (low == high) {
			segmentTree[pos].sum += Y;
			segmentTree[pos].min = segmentTree[pos].sum;
			return;
		}
		int mid = (low + high) / 2;
		
		
		if(X<=mid){
			updateSegmentTree(low, mid, 2 * pos + 1, X, Y);
		}
		if(mid<X){
			updateSegmentTree(mid + 1, high, 2 * pos + 2, X, Y);
		}
		
		segmentTree[pos] = merge(segmentTree[2 * pos + 1], segmentTree[2 * pos + 2]);
	}

	
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		 Scanner in=new Scanner(System.in);

		int N =in.nextInt();
		long ar[] = new long[N];

		for (int i = 0; i < N; i++) {
			ar[i] =in.nextLong();
		}

		segmentTree = new Node[getSize(N)];

		createSegmentTree(ar, 0, N - 1, 0);

		int Q =in.nextInt();

		StringBuilder ans=new StringBuilder("");
		
		while (Q-- != 0) {
			String op = "";
			int L, R;
			

			op =in.next();

			L = in.nextInt();
			R = in.nextInt();
			if (op.charAt(0) == 'C') {
				Node t = executeQuery(L, R, 0, N - 1, 0);
				long a= t.sum - t.min;
				ans.append(a+"\n");
			} else if (op.charAt(0) == 'G') {
				updateSegmentTree(0, N - 1, 0, R, L);
			} else if (op.charAt(0) == 'E') {
				updateSegmentTree(0, N - 1, 0, R, -L);
			} else {
				System.out.println(0);
			}

		}
		System.out.print(ans);

		
	}

}