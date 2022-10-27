package converter;

import java.util.Scanner;

public class Main {

    static Scanner sc = new Scanner(System.in);

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

    static void fromDecimal(){
        System.out.println("Enter number in decimal system: ");
        int number = sc.nextInt();
        System.out.println("Enter target base: ");
        int target = sc.nextInt();

        switch (target){
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
        System.out.println();
    }

    public static void menu() {
        loop:
        while (true) {
            System.out.println("Do you want to convert /from decimal or /to decimal? (To quit type /exit)");
            String choice = sc.nextLine();

            switch (choice) {
                case "/from":
                    fromDecimal();
                    break;
                case "/to":
                    toDecimal();
                    break;
                case "/exit":
                    break loop;
            }
        }
    }

    static void binToDec(String number) {
        Long num = Long.parseLong(number);
        int decimalNumber = 0;
        int i = 0;
        Long remainder;

        while (num != 0) {
            remainder = num % 10;
            num /= 10;
            decimalNumber += (remainder * Math.pow(2.0, (double) i));
            ++i;
        }
        System.out.println("Conversion to decimal result: " + decimalNumber);
    }

    static void octalToDec(String number) {
        System.out.println("Conversion to decimal result: " + Integer.parseInt(number, 8));
    }

    static void hexToDec(String number) {
        System.out.println("Conversion to decimal result: " + Integer.parseInt(number, 16));
    }

    static void toDecimal() {
        System.out.println("Enter source number: ");
        String src = sc.nextLine();
        System.out.println("Enter source base: ");
        int base = sc.nextInt();

        switch (base) {
            case 2:
                binToDec(src);
                break;
            case 8:
                octalToDec(src);
                break;
            case 16:
                hexToDec(src);
                break;
        }

    }

    public static void main(String[] args) {
        // write your code here
        menu();


    }
}
