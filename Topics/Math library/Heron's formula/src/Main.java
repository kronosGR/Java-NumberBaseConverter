import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();

        double p = (a + b + c) / 2.0;
        double s = Math.sqrt(p * (p - a) * (p - b) * (p - c));

        System.out.println(s);
    }
}