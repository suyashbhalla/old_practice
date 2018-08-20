import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class OverSizedPanCake {

	public static void main(String[] args)throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new FileReader(new File("A-large.in")));
		PrintWriter out=new PrintWriter("output.out");
		//BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		int Tin=1;
		
		while (T-- != 0) {
			
			StringTokenizer st=new StringTokenizer(br.readLine());
			
			S=new StringBuilder(st.nextToken());
			StringBuilder temp=new StringBuilder();
			for(int i=0;i<S.length();i++){
				temp.append("+");
			}
			
			
			
			int K=Integer.parseInt(st.nextToken());
			int cnt=0;
			for(int i=0;i<=S.length()-K;i++){
				if(S.charAt(i)=='-'){
					replaceK(i,K);
					cnt++;
				}
			}
			String temp2=S.toString();
			
			out.print("Case #"+Tin+": ");
			
			if(temp2.equals(temp.toString())){
				//System.out.println(cnt);
				out.print(cnt);
			}else{
				//System.out.println("Impossible");
				out.print("IMPOSSIBLE");
			}
			out.print("\n");
			Tin++;
		}
		out.close();
	}
	static StringBuilder S;
	public static void replaceK(int i,int K){
		for(int j=i;j<i+K;j++){
			S.replace(j,j+1,""+(S.charAt(j)=='+'?'-':'+'));
		}
	}
	
	

}
