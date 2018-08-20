import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;

class HAMSTER1 {

	static double v,k1,k2;
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		//BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		PrintWriter out=new PrintWriter(System.out,true);
		Reader in=new Reader();
		int T = in.nextInt();//Integer.parseInt(br.readLine());

		while (T-- != 0) {
			//StringTokenizer st = new StringTokenizer(br.readLine());

			v = in.nextInt();//Double.parseDouble(st.nextToken());
			k1 = in.nextInt();//Double.parseDouble(st.nextToken());
			k2 = in.nextInt();//Double.parseDouble(st.nextToken());

			ternerySearch();
			out.printf("%.3f %.3f\n",d,sc);
		}
	}

	static double sc,d;
	public static void ternerySearch(){
		double low=0.00,high=Math.PI/2.00,f1,f2;
		while(low<high){
			
			if(high-low<=0.001){
				d=(low+high)/2.0;
				sc=score(d);
				return;
			}
			
			f1=(2*low+high)/3.0;
			f2=(low+2*high)/3.0;
			
			if(score(f1)<score(f2)){
				low=f1;
			}else{
				high=f2;
			}
			
		}
	}
	
	public static double score(double d) {
		return ((k1 * R(d)) + (k2 * H(d)));
	}

	public static double H(double d) {
		double x=v* Math.sin(d) ;
		return x*x/ 20.00;
	}

	public static double R(double d) {
		return  v * v * Math.sin(2 * d) / 10.00;
	}
	
	static class Reader {
	    final private int BUFFER_SIZE = 1 << 16;
	    private DataInputStream din;
	    private byte[] buffer;
	    private int bufferPointer, bytesRead;
	    public Reader(){
	        din=new DataInputStream(System.in);
	        buffer=new byte[BUFFER_SIZE];
	        bufferPointer=bytesRead=0;
	    }

	    public Reader(String file_name) throws IOException{
	        din=new DataInputStream(new FileInputStream(file_name));
	        buffer=new byte[BUFFER_SIZE];
	        bufferPointer=bytesRead=0;
	    }

	    public String readLine() throws IOException{
	        byte[] buf=new byte[64]; // line length
	        int cnt=0,c;
	        while((c=read())!=-1){
	            if(c=='\n')break;
	            buf[cnt++]=(byte)c;
	        }
	        return new String(buf,0,cnt);
	    }

	    public int nextInt() throws IOException{
	        int ret=0;byte c=read();
	        while(c<=' ')c=read();
	        boolean neg=(c=='-');
	        if(neg)c=read();
	        do{ret=ret*10+c-'0';}while((c=read())>='0'&&c<='9');
	        if(neg)return -ret;
	        return ret;
	    } 

	    public long nextLong() throws IOException{
	        long ret=0;byte c=read();
	        while(c<=' ')c=read();
	        boolean neg=(c=='-');
	        if(neg)c=read();
	        do{ret=ret*10+c-'0';}while((c=read())>='0'&&c<='9');
	        if(neg)return -ret;
	        return ret;
	    }

	    public double nextDouble() throws IOException{
	        double ret=0,div=1;byte c=read();
	        while(c<=' ')c=read();
	        boolean neg=(c=='-');
	        if(neg)c = read();
	        do {ret=ret*10+c-'0';}while((c=read())>='0'&&c<='9');
	        if(c=='.')while((c=read())>='0'&&c<='9')
	            ret+=(c-'0')/(div*=10);
	        if(neg)return -ret;
	        return ret;
	    }
	    
	    private void fillBuffer() throws IOException{
	        bytesRead=din.read(buffer,bufferPointer=0,BUFFER_SIZE);
	        if(bytesRead==-1)buffer[0]=-1;
	    }
	    
	    private byte read() throws IOException{
	        if(bufferPointer==bytesRead)fillBuffer();
	        return buffer[bufferPointer++];
	    }
	    
	    public void close() throws IOException{
	        if(din==null) return;
	        din.close();
	    }
	}
}

/*
 * import java.io.BufferedReader; import java.io.IOException; import
 * java.io.InputStreamReader; import java.util.StringTokenizer;
 * 
 * class HAMSTER1 {
 * 
 * public static void main(String[] args)throws IOException{ // TODO
 * Auto-generated method stub BufferedReader br = new BufferedReader(new
 * InputStreamReader(System.in));
 * 
 * int T = Integer.parseInt(br.readLine());
 * 
 * while (T-- != 0) { StringTokenizer st=new StringTokenizer(br.readLine());
 * 
 * double v=Double.parseDouble(st.nextToken()); double
 * k1=Double.parseDouble(st.nextToken()); double
 * k2=Double.parseDouble(st.nextToken());
 * 
 * double d=(3.14159265-Math.atan((4*k1)/k2))/2.00;
 * 
 * double H=v*v*Math.sin(d)*Math.sin(d)/20.00; double R=v*v*Math.sin(2*d)/10.00;
 * System.out.println(d+" "+((k1*R)+(k2*H))); } }
 * 
 * }
 */