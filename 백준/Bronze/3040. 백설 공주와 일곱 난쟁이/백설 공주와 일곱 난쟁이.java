import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int[] arr = new int[9]; // 아홉 난쟁이 
		int sum = 0; 
		
		for (int i = 0; i < 9; i++) {
			arr[i] = sc.nextInt(); // 난쟁이 모자 숫자 입력 
		}

		for (int j = 0; j < 9; j++) {
			sum += arr[j]; // 난쟁이 모자 숫자의 합 
		}

		for (int i = 0; i < 8; i++) {
			for (int j = i + 1; j < 9; j++) {
				if (sum - arr[i] - arr[j] == 100) { // 전체에서 2명의 수를 뺏을때 100이 되면 
					arr[i] = 0; //해당 배열값을 0으로 
					arr[j] = 0; //해당 배열값을 0으로 
					Arrays.sort(arr); //오름차순 정렬 
					for (int k = 2; k < 9; k++) { // [ 0, 0, ~~~ , n] 형식이므로 3번째부터 출
						System.out.println(arr[k]);
					}
				}
			}
		}
	}
}
