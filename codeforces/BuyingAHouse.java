import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class BuyingAHouse {

	public static void main(String[] args)throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st=new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken())-1;
		int K = Integer.parseInt(st.nextToken());

		int ar[]=new int[N];
		
		st=new StringTokenizer(br.readLine());
		
		for(int i=0;i<N;i++){
			ar[i]=Integer.parseInt(st.nextToken());
		}
		
		int left=10,right=10;
		int i=M-1;
		boolean isLeftFound=false;
		while(i>=0){
			
			if(ar[i]!=0&&K>=ar[i]){
				isLeftFound=true;
				break;
			}
			left+=10;
			i--;
		}
		i=M+1;
		boolean isRightFound=false;
		while(i<N){
			if(ar[i]!=0&&K>=ar[i]){
				isRightFound=true;
				break;
			}
			right+=10;
			i++;
		}
		if(isLeftFound&&isRightFound){
			System.out.println(Math.min(left, right));
		}else if(isLeftFound){
			System.out.println(left);
		}else if(isRightFound){
			System.out.println(right);
		}else{
			System.out.println(0);
		}
	}

}
