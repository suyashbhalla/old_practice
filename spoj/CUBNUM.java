	import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

class CUBNUM {
	
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub

		Scanner s=new Scanner(System.in);
		
		
		int in=1;
		StringBuilder res=new StringBuilder();
		int cubeAr[]=new int[48];
		
		for(int i=1;i<48;i++){
			cubeAr[i]=i*i*i;
		}
		int ar[]=new int[100009];
		
		for(int i=1;i<cubeAr.length;i++){
			int cb=cubeAr[i];
			for(int j=cb;j<ar.length;j++){
				if(i==1){
					ar[j]=j;
					continue;
				}
				
				if(j>cb){
					ar[j]=Math.min(ar[j-cb]+1,ar[j]);
				}else{
					ar[j]=1;
				}
			}
		}
		while(s.hasNext()){
			int N;
			N=s.nextInt();
			
			res.append("Case #"+in+": "+ar[N]+"\n");
			in++;
			
		}
		System.out.println(res);
		s.close();
	}
	
	static class Parser {
        final private int BUFFER_SIZE = 65536; 
        private InputStream din;    
        private byte[] buffer;      
        private int bufferPointer;  
        private int bytesRead;      
        public Parser(InputStream in) {
            din = in;
            buffer = new byte[BUFFER_SIZE];
            bufferPointer = bytesRead = 0;
        }
        public int nextInt() throws IOException {
            int result = 0;
            byte c = read();
            while (c <= ' ') c = read();
            boolean neg = (c == '-');
            if (neg) c = read();
            while (c >= '0' && c <= '9') {
                result = result * 10 + c - '0';
                c = read();
            }
            if (neg) return -result;
            return result;
        }
        public String readLine() throws IOException {
            StringBuilder line = new StringBuilder();
            char c;
            while ((c = (char)(read())) != '\n') {
                line.append(c);
            }
            return line.toString();
        }
        public byte read() throws IOException {
            if (bufferPointer == bytesRead)
                fillBuffer();
            return buffer[bufferPointer++];
        }
        private void fillBuffer() throws IOException {
            bytesRead = din.read(buffer, bufferPointer = 0, BUFFER_SIZE);
            if (bytesRead == -1)
                buffer[0] = -1;
        }
    }
}
