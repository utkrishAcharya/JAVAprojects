package thread;



import java.util.Scanner;

public class Threadd {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter your max number: ");
        int max = sc.nextInt();
        sc.close();

        Thread odd = new Oddthread(max);
        Thread even = new Eventhread(max);

        odd.start();
        even.start();
    }
}
