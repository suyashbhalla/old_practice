import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class PTRELIC {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String time = br.readLine();
		long high = timeInMs(time);
		long low=0,mid;
		
		
		while (low<high) {

			mid = (low + high) / 2;

			String midTime = timeInString(mid);

			System.out.println(midTime);

			String inp = br.readLine();

			if (inp.equals("SAPPHIRE") || inp.equals("GOLD")) {
				high = mid-1;
			}else {
				low = mid+1;
			}
			if(low==mid||mid==high){
				System.out.println("PLATINUM: "+timeInString(mid));
				break;
			}

		}
	}
	
	
	private static long timeInMs(String time) {
		StringTokenizer st = new StringTokenizer(time, ":");

		long t = Long.parseLong(st.nextToken())*60*60*1000;
		t += Double.parseDouble(st.nextToken())*60*1000;
		t += Double.parseDouble(st.nextToken())*1000;
		t += Double.parseDouble(st.nextToken());
		return t;
	}
	
	
	private static String timeInString(long ms) {
		String ret = "";

		int s=(int)(ms%1000);
		int sec = (int) (ms / 1000) % 60 ;
		int min = (int) ((ms / (1000*60)) % 60);
		int h   = (int) ((ms / (1000*60*60)) % 24);

	
		ret += h + ":";
		
		if (min < 10) {
			ret += "0" + min + ":";
		} else {
			ret += min + ":";
		}

		
		
		if (sec < 10) {
			ret += "0" + sec + ":";
		} else {
			ret += sec + ":";
		}

		if (s < 10) {
			ret += "00" + s;
		} else if (s < 100) {
			ret += "0" + s;
		} else {
			ret += s;
		}

		return ret;
	}

}
