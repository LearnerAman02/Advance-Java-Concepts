-------------------- CRITICAL SECTION PROBLEM ------------------------

import java.util.*;
public class Main
{
    static int count = 5;
    public static void increase(){
        for(int i=1;i<=100000;i++){
            count += 1;
        }
    }
	public static void main(String[] args) {
		System.out.println("Hello World");
		Thread t1 = new Thread(()->increase());
		Thread t2 = new Thread(()->increase());
		
		t1.start();
		t2.start();
		try{
		    t1.join();
		    t2.join();
		}
		catch(Exception e){
		    
		}
		System.out.println("count : "+count);//less than  200005
	}
}

------------------- use MUTUAL EXCLUSION/ SEMAPHORES to avoid CRITICAL SECTION Problem ---------------------------
	In java we use synchronized method to achieve synchronization between threads!!

import java.util.*;
public class Main
{
    static int count = 5;
    static Object lock = new Object();
    public static void increase(){
        synchronized(lock){
            for(int i=1;i<=100000;i++){
                count += 1;
            }
        }
    }
	public static void main(String[] args) {
		System.out.println("Hello World");
		Thread t1 = new Thread(()->increase());
		Thread t2 = new Thread(()->increase());
		
		t1.start();
		t2.start();
		try{
		    t1.join();
		    t2.join();
		}
		catch(Exception e){
		    
		}
		System.out.println("count : "+count);//proper output ---> 200005
	}
}
