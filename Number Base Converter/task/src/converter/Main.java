package converter;

import java.util.Scanner;

public class Main {

    public static void toBinary(int number) {
        int bin = 0;
        int rem = 1;
        int step = 1;
        int i = 1;
        int num = number;

        while (num != 0) {
            rem = num % 2;
            num /= 2;
            bin += rem * i;
            i *= 10;
        }
        System.out.println("Conversion result: " + bin);
    }

    public static void toOctal(int number) {
        int dec = number;
        int octal = 0;
        int i = 1;

        while (dec != 0) {
            octal += dec % 8 * i;
            dec = dec / 8;
            i *= 10;
        }
        System.out.println("Conversion result: " + octal);
    }

    public static void toHexa(int number) {
        System.out.println("Conversion result: " + Integer.toHexString(number));
    }

    public static void main(String[] args) {
        // write your code here

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number in decimal system:");
        int number = sc.nextInt();
        System.out.println("Enter target base:");
        int target = sc.nextInt();

        switch (target) {
            case 2:
                toBinary(number);
                break;
            case 8:
                toOctal(number);
                break;
            case 16:
                toHexa(number);
                break;
        }
    }
}
