import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here

        Scanner sc = new Scanner(System.in);
        double vX1 = sc.nextInt();
        double vX2 = sc.nextInt();
        double vY1 = sc.nextInt();
        double vY2 = sc.nextInt();

        double angle = Math.atan2(vX2, vX1) - Math.atan2(vY2, vY1);

        System.out.println(Math.abs(Math.toDegrees(angle)));
    }
}