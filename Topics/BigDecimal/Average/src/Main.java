import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // write your code here
        Scanner sc = new Scanner(System.in);
        BigDecimal a = new BigDecimal(sc.next());
        BigDecimal b = new BigDecimal(sc.next());
        BigDecimal c = new BigDecimal(sc.next());

        BigDecimal sum = (a.add(b)).add(c);
        System.out.println(sum.divide(BigDecimal.valueOf(3), 0, RoundingMode.DOWN));
    }
}