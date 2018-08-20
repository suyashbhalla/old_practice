import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class PINS {

    public static void main(String[] args) throws IOException{
	// TODO Auto-generated method stub
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	int T = Integer.parseInt(br.readLine());
	StringBuilder result =new StringBuilder();
	while (T-- != 0) {
	    int N = Integer.parseInt(br.readLine());
	    result.append(1+" "+1);
	    int x=N/2;
	    for(int i=1;i<=x;i++) {
		result.append("0");
	    }
	    result.append("\n");
	}
	System.out.println(result.toString());
    }

}
