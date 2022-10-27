import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();
        List<Integer> nums = Stream.of(line.split(" ")).map(String::trim).map(Integer::parseInt).collect(Collectors.toList());
        List<Integer> fNums = new ArrayList<>();

        int i = 0;
        for (int l : nums) {
            if (i % 2 != 0){
                fNums.add(l);
            }
            i++;
        }
        Collections.reverse(fNums);
        fNums.forEach(it -> System.out.print(it + " "));
    }
}