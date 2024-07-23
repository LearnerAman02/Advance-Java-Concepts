public class SynchronizationPblm {
  public static void main(String[] args) {
    Stack st = new Stack(5);
    new Thread(() -> {
      for (int i = 0; i < 10; i++) {
        st.push(100);
        System.out.println("Pushed!!");
      }
    }, "Pusher").start();
    new Thread(() -> {
      for (int i = 0; i < 10; i++) {
        System.out.println("Popped : " + st.pop());
      }
    }, "Popper").start();
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
