import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

class DISHLIFE {

	public static void main(String[] args)throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());

		while (T-- != 0) {
			StringTokenizer st=new StringTokenizer(br.readLine());
			
			int N=Integer.parseInt(st.nextToken());
			int K=Integer.parseInt(st.nextToken());
			
			HashSet<Integer> hs=new HashSet<Integer>();
			
			for(int i=1;i<=K;i++){
				hs.add(i);
			}
			
			int newCnt=0;
			for(int c=0;c<N;c++){
				st=new StringTokenizer(br.readLine());
				int P=Integer.parseInt(st.nextToken());
				
				
				boolean isNew=false;
				
				for(int i=0;i<P;i++){
					
					int x=Integer.parseInt(st.nextToken());
					
					if(hs.contains(x)){
						hs.remove(x);
						isNew=true;
					}
					
				}
				if(isNew){
					newCnt++;
				}
				
			}
			
			if(!hs.isEmpty()){
				System.out.println("sad");
			}else{
				if(newCnt==N){
					System.out.println("all");
				}else{
					System.out.println("some");
				}
			}
			
		}
	}

}
