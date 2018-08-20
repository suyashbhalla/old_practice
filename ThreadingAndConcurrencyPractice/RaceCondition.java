class LongWrapper{
	int val;
	LongWrapper(){
		val=0;
	}
	void increment(){
		val++;
	}
	
	/*synchronized void increment(){
		val++;
	}*/
}
public class RaceCondition {

	public static void main(String[] args)throws InterruptedException {
		// TODO Auto-generated method stub
		LongWrapper in=new LongWrapper();
		

		Runnable r=()->{
			for(int i=0;i<1000;i++){
				in.increment();
			}
		};
		
		Thread t1[]=new Thread[1000];
		for(int i=0;i<1000;i++){
			t1[i]=new Thread(r);
			t1[i].start();
		}
		
		for(int i=0;i<1000;i++){
			t1[i].join();
		}
		System.out.println(in.val);
	}

}
