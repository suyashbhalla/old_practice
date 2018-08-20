import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

class TidyNumbers {
static PrintWriter out ;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		// BufferedReader br = new BufferedReader(new
		// InputStreamReader(System.in));

		BufferedReader br = new BufferedReader(new FileReader(new File("B-large.in")));
		out= new PrintWriter("output.out");

		int T = Integer.parseInt(br.readLine());

		int Tin = 1;

		while (T-- != 0) {
			// StringTokenizer st=new StringTokenizer(br.readLine());

			ch = br.readLine().toCharArray();
			solve();
			int j = 0;
			while (j < ch.length && ch[j] == '+') {
				j++;
			}
			
			out.print("Case #"+Tin+": ");

			for (int i = j; i < ch.length; i++) {
				//System.out.print(ch[i]);
				out.print(ch[i]);
			}
			out.print("\n");

			Tin++;
		}
		out.close();
	}

	public static void solve() {
		
		int in=-1;
		while((in=isTidy())!=-1){
			if (ch[in] != '1') {
				ch[in] = (char) ((int) ch[in] - 1);
				makeAll9(in + 1);
			} else {
				if (in == 0) {
					ch[in] = '+';
				} else {
					makePrev9(in);
				}
				makeAll9(in + 1);
			}
			
		}
	}

	private static void makePrev9(int in) {
		// TODO Auto-generated method stub
		if (ch[0] == '1') {
			ch[0] = '+';
		} else {
			ch[in] = (char) ((int) ch[in] - 1);
		}
		for (int i = 1; i <= in; i++) {
			ch[i] = '9';
		}
	}

	static char ch[];

	private static void makeAll9(int i) {
		// TODO Auto-generated method stub
		for (int j = i; j < ch.length; j++) {
			ch[j] = '9';
		}
	}

	public static int isTidy() {
		for (int i = 1; i < ch.length; i++) {
			if (ch[i - 1] > ch[i]) {
				return i-1;
			}
		}
		return -1;
	}

}
