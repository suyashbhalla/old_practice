import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.StringTokenizer;

public class FindTheBone {

	/**
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args)throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st=new StringTokenizer(br.readLine());		
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		int ar[]=new int[N+1];
		
		ar[1]=1;
		
		HashSet<Integer> hs=new HashSet<Integer>();
		
		st=new StringTokenizer(br.readLine());		
		
		for(int i=0;i<M;i++){
			hs.add(Integer.parseInt(st.nextToken()));
		}
		int u,v,t;
		int ans=1;
		if(hs.contains(1)){
			System.out.println(1);
			System.exit(0);
		}
		for(int i=0;i<K;i++){
			st=new StringTokenizer(br.readLine());
			u = Integer.parseInt(st.nextToken());
			v = Integer.parseInt(st.nextToken());
			t=ar[u];
			ar[u]=ar[v];
			ar[v]=t;
			if(ar[u]==1){
				if(hs.contains(u)){
					ans=u;
					break;
				}else{
					ans=u;
				}
			}
			if(ar[v]==1){
				if(hs.contains(v)){
					ans=v;
					break;
				}else{
					ans=v;
				}
			}
		}

		System.out.println(ans);
		
	}

}
