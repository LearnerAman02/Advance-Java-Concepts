--------------------- CRITICAL SECTION Problem solution -----------------------------



import java.util.*;
public class Main
{
    static int count = 45;
    static Object lock = new Object();
    public static void increment(int val){
        synchronized(lock){
            int temp = count;
            temp += val;
            count = temp;
        }
    }
	public static void main(String[] args) {
		System.out.println("Hello World");
		Thread t1 = new Thread(()->increment(2),"t1");
		Thread t2 = new Thread(()->increment(2),"t2");
		Thread t3 = new Thread(()->increment(2));
		Thread t4 = new Thread(()->increment(2));
		
		t1.start();
		t2.start();
		t3.start();
		t4.start();
		
		try{
		    t1.join();
		    t2.join();
		    t3.join();
		    t4.join();
		}
		catch(Exception e){
		    System.out.println("Exception : "+e.getMessage());
		}
		
		System.out.println("final count : "+count);
	}
}
