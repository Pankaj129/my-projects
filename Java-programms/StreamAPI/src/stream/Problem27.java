package stream;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Problem27 {
    public static void main(String[] args) {
        //27 Find the kth smallest element in a list of integers. || Most Asked
        Scanner sc = new Scanner(System.in);
        List<Integer> list = Arrays.asList(1,2,3,4,5,9, 6, 8, 7);
        System.out.println("enter the which number smallest integer you want");
        int k = sc.nextInt();
        int smallest = list.stream().sorted().skip(k-1).findFirst().get();

        System.out.println("smallest : "+smallest);

    }
}
