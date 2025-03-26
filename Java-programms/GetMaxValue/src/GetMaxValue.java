import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class GetMaxValue {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter string : ");
		List<Integer> list = new ArrayList<>();
		for (int i = 0; i < 4; i++) {
			System.out.print("enter index " + i + " :  ");
			list.add(sc.nextInt());
		}
		System.out.println(getMaxValue(list));
		sc.close();

	}

	private static int getMaxValue(List<Integer> arr) {
		// TODO Auto-generated method stub
		List<Integer> sortedList = new ArrayList<>();
		//List<Integer> arr = arr1.stream().distinct().collect(Collectors.toList());
		Collections.sort(arr);
		System.out.println(arr);
		for (int index = 0; index < arr.size(); index++) {
			//System.out.println("index " + index);
			if (index < 1 && arr.get(index) == 1) {
				sortedList.add(arr.get(index));
				System.out.println("1st if : " + sortedList);
			} else if (index == 0 && arr.get(index) != 1) {
				sortedList.add(1);
				System.out.println("2 nd if : " + sortedList);
			} else if ((arr.get(index) - sortedList.get(index - 1)) <= 1) {
				sortedList.add(arr.get(index));
				System.out.println(arr.get(index) + " 3rd if : " + sortedList);
			} else {
				sortedList.add(sortedList.get(index-1)+1);
			}

			// System.out.println(index+" "+arr.get(index));
			// sortedList.add(arr.get(index)-(arr.get(index)-1));
			System.out.println("final index " + index + " " + sortedList);
		}
		System.out.println(sortedList);
		return sortedList.get(sortedList.size() - 1);

	}

}
