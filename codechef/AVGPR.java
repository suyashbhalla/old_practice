import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

class AVGPR {

    public static void main(String[] args) throws IOException {

	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	int T = Integer.parseInt(br.readLine());

	while (T-- != 0) {

	    int N = Integer.parseInt(br.readLine());

	    StringTokenizer st = new StringTokenizer(br.readLine());

	    int ar[] = new int[N];
	    HashMap<Integer, Integer> map=new HashMap<Integer,Integer>();
	    for (int i = 0; i < N; i++) {
		ar[i] = Integer.parseInt(st.nextToken());
		if(map.containsKey(ar[i])) {
		    map.put(ar[i], map.get(ar[i])+1);
		}else {
		    map.put(ar[i], 1);
		}
	    }
	    Integer ar2[]=new Integer[map.size()];
	    ar2=map.keySet().toArray(ar2);

	    Arrays.sort(ar2);
	    
	    long count = 0;
	    for (int i = 0; i < ar2.length; i++) {
		long freq=map.get(ar2[i]);
		if(freq>1) {
		    long n=(freq*(freq-1))/2;
		    count+=n;
		}
		for (int j = i + 1; j < ar2.length; j++) {
		    if (ar2[i] % 2 == 0 && ar2[j] % 2 != 0) {
			continue;
		    }
		    if (ar2[j] % 2 == 0 && ar2[i] % 2 != 0) {
			continue;
		    }
		    int avg = (ar2[i] + ar2[j]) / 2;
		    if (Arrays.binarySearch(ar2, i, j, avg) >= 0) {
			freq=map.get(ar2[j]);
			long freq2=map.get(ar2[i]);
			count+=freq*freq2;
		    }
		}
	    }
	    System.out.println(count);

	}
    }

}
