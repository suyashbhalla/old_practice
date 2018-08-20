import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

class SIMDISH {

	public static void main(String[] args)throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());

		while (T-- != 0) {
			StringTokenizer st=new StringTokenizer(br.readLine());
			
			HashSet<String> hash=new HashSet<String>();
			hash.add(st.nextToken());
			hash.add(st.nextToken());
			hash.add(st.nextToken());
			hash.add(st.nextToken());
			st=new StringTokenizer(br.readLine());
			int cnt=0;
			while(st.hasMoreTokens()){
				if(hash.contains(st.nextToken())){
					cnt++;
				}
			}
			if(cnt>=2){
				System.out.println("similar");
			}else{
				System.out.println("dissimilar");
			}
		}
	}

}
