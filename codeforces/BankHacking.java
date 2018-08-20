import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.StringTokenizer;

public class BankHacking {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		int ar[] = new int[N];

		ArrayList<Integer> as[] = new ArrayList[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());

		ar[0] = Integer.parseInt(st.nextToken());
		int max = ar[0];
		as[0] = new ArrayList<Integer>();

		ArrayList<Integer> m=new ArrayList<Integer>();
		
		int cntMax=0,cntMaxLone=0;
		
		for (int i = 1; i < N; i++) {
			ar[i] = Integer.parseInt(st.nextToken());
			
			max=Math.max(ar[i],max);
			
			as[i] = new ArrayList<Integer>();
		}
		
		
		int u, v;

		for (int i = 0; i < N - 1; i++) {
			st = new StringTokenizer(br.readLine());
			u = Integer.parseInt(st.nextToken()) - 1;
			v = Integer.parseInt(st.nextToken()) - 1;

			as[u].add(v);
			as[v].add(u);
			
			
		}
		
		
		for(int j=0;j<N;j++){
			if(ar[j]==max){
				cntMax++;
			}else if(ar[j]==max-1){
				cntMaxLone++;
			}
		}
		
		int ans=max+2;
		
		for(int i=0;i<N;i++){
			int x=cntMax,y=cntMaxLone;
			if(ar[i]==max){
				x--;
			}else if(ar[i]==max-1){
				y--;
			}
			for(Integer j:as[i]){
				if(ar[j]==max){
					x--;
					y++;
				}else if(ar[j]==max-1){
					y--;
				}
			}
			if(x==0){
				ans=Math.min(ans, max+1);
				if(y==0){
					ans=Math.min(ans, max);
				}
			}
			
		}
		System.out.println(ans);
		
		
		
	}
	
	
}
