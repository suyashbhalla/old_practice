import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class EC_CONB {

	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		while (N-- != 0) {
			int x=Integer.parseInt(br.readLine());
			if(x%2==0) {
				int lsb=0,ans=0;
				while(x!=0) {
					lsb=x&1;
					ans=ans|lsb;
					ans=ans<<1;
					x=x>>1;
				}
				ans>>=1;
				System.out.println(ans);
			}else {
				System.out.println(x);
			}
		}
	}

}
