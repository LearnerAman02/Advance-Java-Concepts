public class SynchronizationPblm {
  public static void main(String[] args) {
    Stack st = new Stack(5);
    new Thread(() -> {
      for (int i = 0; i < 8; i++) {
        System.out.println("Push Thread is executing!!");
        st.push(200);
      }
    }, "PushThread").start();
    new Thread(() -> {
      for (int i = 0; i < 8; i++) {
        System.out.println("Pop Thread is executing!!");
        System.out.println("Popped : " + st.pop());
      }
    }, "PopThread").start();
    System.out.println("popped value : " + st.pop());
  }
}

// implementing stack using array
class Stack {
  Thread t1 = new Thread();
  Thread t2 = new Thread();
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

  public int pop() {
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

Race condition arises due to no synchronization between threads (Push and Pop) because there may be scenario where stack mei value push nhi hui hai ab tak and while the Push Thread is on sleep
Pop thread execute hoke pop karane ka try kar raha hai value ko
