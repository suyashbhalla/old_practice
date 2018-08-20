import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class GOODSET {

	public static void main(String[] args)throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());

		while (T-- != 0) {
			
			int N=Integer.parseInt(br.readLine());
			
			for(int i=0;i<N*2;i++){
				if(i%2!=0){
					System.out.print(i+" ");
				}
			}
			System.out.println();
		}
	}

}
