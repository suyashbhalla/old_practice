import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class MFLAR10 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		while (true) {
			StringTokenizer str = new StringTokenizer(br.readLine());
			String first=str.nextToken();
			boolean isTaut=true;
			if(first.equals("*")) {
				break;
			}
			while(str.hasMoreTokens()) {
				if(Character.toLowerCase(first.charAt(0))!=Character.toLowerCase(str.nextToken().charAt(0))) {
					isTaut=false;
					break;
				}
			}
			if(isTaut) {
				System.out.println("Y");
			}else {
				System.out.println("N");
			}
		}
	}

}
