//simply waha pe RACE CONDITION pe pblm isiliye arise ho rhi thi because PopThread stack mei value push hone se pehle hi access kr raha tha jisse WRONG VALUE reading yaa phir INDEX OUT BOUND exception aa rha tha
//so ab hum SYNCHRONIZE krenge inn dono threads ko so that hum ek thread ho and than only other thread works on the same object(Stack)
public class SynchronizationSoln {
  public static void main(String[] args) {
    Stack st = new Stack(5);
    new Thread(() -> {
      for (int i = 0; i < 10; i++) {
        System.out.println("Push Thread is executing!!");
        st.push(100);
      }
    }, "PushThread").start();
    new Thread(() -> {
      for (int i = 0; i < 10; i++) {
        System.out.println("Pop Thread is executing!!");
        System.out.println("Popped : " + st.pop() + ", count : " + (i + 1));
      }
    }, "PopThread").start();
  }
}

// implementing stack using array
class Stack {
  Thread t1 = new Thread();
  Thread t2 = new Thread();
  Object lock = new Object();
  int stackptr = -1;
  int[] arr;

  public Stack(int capacity) {
    arr = new int[capacity];
  }

  public boolean isEmpty() {
    return stackptr < 0;
  }

  public boolean isFull() {
    return stackptr >= arr.length - 1;
  }

  public void push(int x) {
    synchronized (lock) {
      if (isFull()) {
        System.out.println("Stack FULL hai boss!!");
        return;
      }
      stackptr++;
      // stack mei push krne se pehle thread ko sleep kara dete hai
      try {
        Thread.sleep(1000);
      } catch (Exception e) {
        System.out.println("Exception : " + e.getMessage());
      }
      arr[stackptr] = x;
    }
  }

  public int pop() {
    synchronized (lock) {
      if (isEmpty()) {
        System.out.println("Stack empty hai boss!!");
        return Integer.MIN_VALUE;
      }
      int val = arr[stackptr];
      arr[stackptr] = Integer.MIN_VALUE;
      try {
        Thread.sleep(1000);
      } catch (Exception e) {
        System.out.println("Exception : " + e.getMessage());
      }
      stackptr--;
      return val;
    }
  }
}
