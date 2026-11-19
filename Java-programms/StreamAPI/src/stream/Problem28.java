package stream;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

public class Problem28 {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("1a2b3c", "4g56hi", "xyz789");

        Pattern pattern = Pattern.compile("[^0-9]");

        List<String> answer = list.stream().map(x -> pattern.matcher(x).replaceAll("")).toList();

        System.out.println(answer);
    }
}
