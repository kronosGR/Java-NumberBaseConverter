import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);

        double a = scanner.nextDouble();
        double b = scanner.nextDouble();
        double c = scanner.nextDouble();

        double d = Math.sqrt(Math.pow(b, 2) - 4 * a * c);
        double x1 = (-b + d) / (2 * a);
        double x2 = (-b - d) / (2 * a);

        System.out.print(Math.min(x1, x2));
        System.out.print(" ");
        System.out.print(Math.max(x1, x2));
    }
}