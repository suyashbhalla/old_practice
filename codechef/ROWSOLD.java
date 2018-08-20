import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class ROWSOLD {

	public static void main(String[] args)throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());

		while (T-- != 0) {
			
			char ch[]=br.readLine().toCharArray();
			
			int N=ch.length-1;
			
			int i=N,cnt=0;
			
			long ans=0;
			while(i>=0&&ch[i]=='1'){
				i--;
			}
			int pos=i;
			while(i>=0){
				if(ch[i]=='1'){
					long s=1+cnt+(pos-i);
					long ct=1;
					while(i>0&&ch[i-1]=='1'){
						ct++;
						i--;
					}
					ans+=(s*ct);
					pos-=ct;
					cnt++;
				}
				i--;
			}
			
			System.out.println(ans);
		}
	}

}
