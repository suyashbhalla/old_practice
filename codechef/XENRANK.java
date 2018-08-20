import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class XENRANK {

	public static void main(String[] args)throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());

		while (T-- != 0) {
			StringTokenizer st=new StringTokenizer(br.readLine());
			
			long u=Long.parseLong(st.nextToken());
			long v=Long.parseLong(st.nextToken());
			
			long ans=0;
			
			if((u+v)%2==0){
				ans=(u+v)/2;
				ans*=(v+u+1);
			}else{
				ans=(u+v+1)/2;
				ans*=(v+u);
			}
			ans+=(u+1);
			System.out.println(ans);
		}
	}

}
