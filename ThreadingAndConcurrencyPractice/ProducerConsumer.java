
class PCProblem{
	
	static int buffer[]=new int[10];
	static int count=0;
	
	static class Producer{
		public void produce(){
			while(isFull(buffer)){}
			buffer[count++]=1;
		}

	}
	static class Consumer{
		public void consume(){
			while(isEmpty(buffer)){}
			buffer[--count]=0;
		}
	}

	static boolean isEmpty(int[] buffer) {
		return count==0;
	}
	
	static boolean isFull(int[] buffer) {
		return buffer.length==count;
	}
}


class PC{
	static Object key=new Object();
	
	static int buffer[]=new int[10];
	static int count=0;
	
	static class Producer{
		public void produce(){
			synchronized(key){
				if(isFull(buffer)){
					try {
						key.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				buffer[count++]=1;
				key.notify();
			}
		}
	}
	static class Consumer{
		public void consume(){
			synchronized(key){
				if(isEmpty(buffer)){
					try {
						key.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				buffer[--count]=0;
				key.notify();
			}
		}
	}
	static boolean isEmpty(int[] buffer) {
		return count==0;
	}
	
	static boolean isFull(int[] buffer) {
		return buffer.length==count;
	}
}

public class ProducerConsumer {

	public static void main(String[] args)throws InterruptedException{
		/*PCProblem.Producer producer=new PCProblem.Producer();
		PCProblem.Consumer consumer=new PCProblem.Consumer();*/
		PC.Producer producer=new PC.Producer();
		PC.Consumer consumer=new PC.Consumer();
		Runnable r1=()->{
			for(int i=0;i<50;i++){
				producer.produce();
			}
			System.out.println("Fifty Items Produced");
		};
		Runnable r2=()->{
			for(int i=0;i<50;i++){
				consumer.consume();
			}
			System.out.println("Fifty Items Consumed");
		};
		
		Thread producerThread=new Thread(r1);
		Thread consumerThread=new Thread(r2);
		
		consumerThread.start();
		producerThread.start();
		
		
		consumerThread.join();
		producerThread.join();
		
		//System.out.println(PCProblem.count);
		System.out.println(PC.count);
	}

}
