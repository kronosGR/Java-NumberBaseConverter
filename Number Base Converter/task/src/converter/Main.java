package converter;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Main {

    static Scanner sc = new Scanner(System.in);

    static String toBinary(String number) {
        BigInteger bin = BigInteger.ZERO;
        BigInteger rem = BigInteger.ONE;
        BigInteger i = BigInteger.ONE;
        BigInteger num = new BigInteger(number);

        while (num != BigInteger.ZERO) {
            rem = num.mod(BigInteger.valueOf(2));
            num = num.divide(BigInteger.valueOf(2));
            bin = bin.add(rem.multiply(i));
            i = i.multiply(BigInteger.TEN);
        }
        return String.valueOf(bin);
    }

    static String toAnyBase(int toAnybase, String number) {
        return BigDecimal.valueOf(Long.parseLong(number)).toBigInteger().toString(toAnybase);
    }

    static String binToDec(String number) {
        BigInteger num = new BigDecimal(number).toBigInteger();
        BigDecimal decimalNumber = BigDecimal.ZERO;
        int i = 0;
        BigInteger remainder;

        while (!num.equals(BigInteger.ZERO)) {
            remainder = num.mod(BigInteger.TEN);
            num = num.divide(BigInteger.TEN);
            decimalNumber = decimalNumber.add(new BigDecimal(remainder.multiply(BigInteger.TWO.pow(i))));
            ++i;
        }
        return decimalNumber.toString();
    }

    static String fromAnyBaseToDec(int fromBase, String number) {
        return new BigInteger(number, fromBase).toString();
    }

    static int octalToDec(String number) {
        return Integer.parseInt(number, 8);
    }

    static BigDecimal fractionalToDecimal(String fractional, int base) {
        // TODO
        //return new BigInteger(fractional, base);
        BigDecimal result = BigDecimal.ZERO;
        for (int i= 0;i<fractional.length(); i++){
            int number =Integer.valueOf(String.valueOf(fractional.charAt(i)), base);
            if (number == 0){
                result = result.add(BigDecimal.valueOf(number));
            } else {
                result = result.add(BigDecimal.valueOf((number * Math.pow ((double)base, (-(i+1))))));
            }
        }

        return result;
    }

    static String fractionalFromDecimal(BigDecimal fractional, int base) {
        List result = (List) (new ArrayList());
        BigDecimal remaining = fractional;
        int precision = 1;
        while ((precision <= 5) && (remaining.compareTo(BigDecimal.ZERO) != 0)) {
            remaining = remaining.multiply(new BigDecimal(String.valueOf(base)));
            int integerPart = remaining.intValue();
            if (integerPart > 0) {
                result.add(Integer.toString(integerPart, base));
                remaining = remaining.subtract(new BigDecimal(String.valueOf(integerPart)));
            } else {
                result.add("0");
            }
            precision++;
        }

        return String.join("", result);
    }

    static int toOctal(int number) {
        int dec = number;
        int octal = 0;
        int i = 1;

        while (dec != 0) {
            octal += dec % 8 * i;
            dec = dec / 8;
            i *= 10;
        }
        return octal;
    }

    static void convert(int src, int trg, String num) {
        String dec = "";
        String res = "";

        if (num.contains(".")) {
            String[] numA = num.split("\\.");
            String integer = numA[0];
            String fract = numA[1];

            String integ = "";
            if (src == 2) {
                integ = binToDec(num);
            } else if (src > 2 && src < 37) {
                integ = fromAnyBaseToDec(src, integer);
            } else {
                integ = "0";
            }

            if (trg == 2) {
                res = toBinary(integ);
            } else if (trg > 2 && trg < 37) {
                res = toAnyBase(trg, integ);
            } else {
                res =  "0";
            }

            BigDecimal decF = fractionalToDecimal(fract, src);
            String newF = fractionalFromDecimal(decF, trg);
            String tmp = res;

            int len = newF.length();
            if (len < 6) {
                for (int i = 1; i < 6 - len; i++) {
                    newF += "0";
                }
            }

            res = tmp + "." + newF;

        } else {
            if (src == trg) {
                res = String.valueOf(num);
            } else {
                if (src  == 2) {
                    dec = binToDec(num);
                } else if (src > 2 && src < 37) {
                    dec = fromAnyBaseToDec(src, num);
                } else {
                    dec = "0";
                }

                if (trg == 2) {
                    res = String.valueOf(toBinary(dec));
                } else if (trg > 2 && trg < 37) {
                    res = toAnyBase(trg, dec);
                } else {
                    res = "0";
                }
            }
        }

        System.out.println("Conversion result: " + res);

    }


    public static void menu() {
        loop:
        while (true) {
            System.out.println("Enter two numbers in format: {source base} {target base} (To quit type /exit)");
            String choice = sc.nextLine();

            if (choice.equals("/exit")) {
                break;
            }

            String[] bases = choice.split(" ");
            String srcBase = bases[0];
            String tgtBase = bases[1];

            while (true) {
                System.out.println("Enter number in base " + srcBase + " to convert to base " + tgtBase + " (To go back type /back)");
                String ch = sc.nextLine();
                if (ch.equals("/back")) {
                    break;
                }

                convert(Integer.parseInt(srcBase), Integer.parseInt(tgtBase), ch);
            }

        }
    }

    public static void main(String[] args) {
        // write your code here
        menu();


    }
}
