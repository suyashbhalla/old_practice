import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class NEO01 {

	public static void main(String[] args)throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());

		while (T-- != 0) {
			
			int N = Integer.parseInt(br.readLine());
			
			
			StringTokenizer st=new StringTokenizer(br.readLine());
			
			long ans=0,np=0,psum=0,nsum=0,temp,sum=0,max=Long.MIN_VALUE;
			
			
			for(int i=0;i<N;i++){
				temp=Long.parseLong(st.nextToken());
				if(temp<0){
					nsum+=temp;
					max=Math.max(temp, max);
				}else{
					psum+=temp;
					np++;
				}
				sum+=temp;
				
			}
			
			ans=nsum+(psum*np);
			
			if(max!=Long.MIN_VALUE){
				ans=Math.max(ans,((np+1)*(psum+max))+(nsum-max));
			}
			
			
			System.out.println(Math.max(ans,sum*N));
		}
	}
	
}
