import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class OrganizingContainerBalls {

	public static String organizingContainers(List<List<Integer>> container) {
		// Write your code here
		int n = container.size();
		int[] capacities = new int[n];
		int[] amounts = new int[n];

		for (int i = 0; i < n; ++i) {
			for (int j = 0; j < n; ++j) {
				capacities[i] += container.get(i).get(j);
				amounts[j] += container.get(i).get(j);

				System.out.print("=> " + i + " : " + j+" val ");
				System.out.println(container.get(i).get(j));
				System.out.println(" cap " + capacities[i] + " : " + amounts[j]);
		        System.out.println(Arrays.toString(capacities)+"\n"+Arrays.toString(amounts));

			}
		}
		Arrays.sort(capacities);
		Arrays.sort(amounts);
        //System.out.println(Arrays.toString(capacities)+"\n"+Arrays.toString(amounts));
		return Arrays.equals(capacities, amounts) ? "Possible" : "Impossible";

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		List<List<Integer>> cap = new ArrayList<>();
		List<Integer> amt1 = new ArrayList<>();
		List<Integer> amt2 = new ArrayList<>();
		List<Integer> amt3 = new ArrayList<>();

		amt1.add(0);
		amt1.add(2);
		amt1.add(1);

		amt2.add(1);
		amt2.add(1);
		amt2.add(1);

		amt3.add(2);
		amt3.add(0);
		amt3.add(0);

		cap.add(amt1);
		cap.add(amt2);
		cap.add(amt3);

		System.out.println(organizingContainers(cap));

	}

}
