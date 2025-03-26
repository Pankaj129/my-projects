import java.util.Arrays;

public class ArrayAssending {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int arr[] = new int[] { 5, 55, 46, 8, 36, 29 };
		for (int j = 0; j < arr.length; j++) {
			boolean flag = true;
			for (int i1 = 0; i1 < arr.length - 1; i1++) {
				if (arr[i1] > arr[i1 + 1]) {
					int temp = arr[i1];
					arr[i1] = arr[i1 + 1];
					arr[i1 + 1] = temp;
					flag = false;
				}

			}
			if (flag) {
				break;
			}
			System.out.println(Arrays.toString(arr));
		}

	}

}
