import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // write your code here
        Scanner sc = new Scanner(System.in);
        int power = sc.nextInt();
        int scale = sc.nextInt();
        BigDecimal number = new BigDecimal(sc.next());

        BigDecimal scaled = number.setScale(scale, RoundingMode.FLOOR);
        System.out.println(scaled.pow(power));
    }
}