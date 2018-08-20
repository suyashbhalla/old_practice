import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class CHEFWORK {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		int[][] ar = new int[2][N];

		StringTokenizer st = new StringTokenizer(br.readLine());

		for (int i = 0; i < N; i++) {
			ar[0][i] = Integer.parseInt(st.nextToken());
		}

		st = new StringTokenizer(br.readLine());

		for (int i = 0; i < N; i++) {
			ar[1][i] = Integer.parseInt(st.nextToken());
		}
		
		int authorTranslatorMin=Integer.MAX_VALUE;
		int authorMin=100000;
		int transMin=100000;
		
		for(int i=0;i<N;i++) {
			if(ar[1][i]==1) {
				//Author
				if(authorMin>ar[0][i]) {
					authorMin=ar[0][i];
				}
			}else if(ar[1][i]==2) {
				//Translator
				if(transMin>ar[0][i]) {
					transMin=ar[0][i];
				}
			}else {
				//AuthorTranslator
				if(authorTranslatorMin>ar[0][i]) {
					authorTranslatorMin=ar[0][i];
				}
			}
		}
		if(authorMin+transMin<=authorTranslatorMin) {
			System.out.println(authorMin+transMin);
		}else {
			System.out.println(authorTranslatorMin);
		}

	}

}
