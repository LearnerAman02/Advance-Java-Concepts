import java.util.*;

public class ExceptionHandling {
  public static void main(String[] args) {
    // ARITHMETIC exception handling!!
    Scanner sc = new Scanner(System.in);
    System.out.print("Enter num1 : ");
    int num1 = sc.nextInt();
    System.out.print("Enter num2 : ");
    int num2 = sc.nextInt();
    try {
      int div = num1 / num2;
      System.out.println("Division answer : " + div);
    } catch (ArithmeticException e) {
      System.out.println("error : " + e.getMessage());
    }

    // ARRAY index OUT OF BOUND error
    int[] arr = new int[5];
    try {
      arr[6] = 78;
    } catch (ArrayIndexOutOfBoundsException e) {
      System.out.println("Index put of bound ho gaya!!");
    }

    // Array index OUT OF BOUND error OR ARITHMETIC EXCEPTION
    int a[] = new int[5];
    try {
      a[6] = 10 / 0;
    } catch (IndexOutOfBoundsException | ArithmeticException e) {
      System.out.println("Exception Occured!!");
    }

    int b[] = new int[5];
    try {
      b[6] = 10 / 0;// RIGHT to LEFT execution hoga isiliye (10/0) sabse pehle execute hoke
                    // exception throw krega
    } catch (IndexOutOfBoundsException e) {
      System.out.println("Index out of bound Occured!!");
    } catch (ArithmeticException e) {
      System.out.println("Arithmetic exception occured!!");
    }
  }
}

// NOTE jab hum NESTED TRY CATCH block likhenge uss case mei hume Child Class
// exception pehle likhni hai than PARENT CLASS exception otherwise it will be
// giving an error!!