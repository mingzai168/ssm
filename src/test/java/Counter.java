import java.util.Scanner;

public class Counter {

    public static void main(String[] args) {

        Counter counter = new Counter();
        counter.pay();
    }

    public void pay( ){
        Scanner scanner = new Scanner(System.in);
        int  k = Integer.parseInt(scanner.next());
        int  n = Integer.parseInt(scanner.next());
        int x = 129/10;
        int y = 129/10/5;
        int z = 129/10/5/2 ;

        if ( n == k ){
            System.out.println("需要"+x+"张10元纸币，需要"+y+"张5元纸币，需要"+z+"张2元纸币。刚好等于"+n+"元");
        }else {
            System.out.println("纸币不能刚好等于"+n+"元");
        }
    }
}
