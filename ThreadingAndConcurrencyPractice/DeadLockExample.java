
class A {

	Object key1 = new Object();
	Object key2=new Object();
	
	public void a() {
		synchronized (key1) {
			System.out.println(Thread.currentThread().getName()+" I am in a()");
			b();
		}
	}
	public void b() {
		synchronized (key2) {
			System.out.println(Thread.currentThread().getName()+" I am in b()");
			c();
		}
	}
	public void c() {
		synchronized (key1) {
			System.out.println(Thread.currentThread().getName()+" I am in c()");
		}
	}
}

public class DeadLockExample {

	public static void main(String[] args)throws InterruptedException{
		
		A ob=new A();
		
		Runnable  r1=()->ob.a();
		Runnable  r2=()->ob.b();

		Thread t1=new Thread(r1);
		t1.setName("Thread 1");
		t1.start();
		Thread t2=new Thread(r2);
		t2.start();
		t2.setName("Thread 2");
		
		t1.join();
		t2.join();
	}

}
