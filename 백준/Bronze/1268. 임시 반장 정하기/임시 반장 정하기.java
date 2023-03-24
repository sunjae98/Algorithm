import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[][] student = new int[n][5]; // n명의 학생 , 1~5학년 까지 이중 배열 선
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < 5; j++) {
				student[i][j] = sc.nextInt(); // 각 학생의 반 부여
			}
		}
		int count = 0; // 학생 별 다른 학생과 반이 겹치는 숫자
		int[] count_student = new int[n]; // 학생별 1~5 학년 까지 겹치는 숫자
		for (int i = 0; i < n; i++) { // n 명의 학생
			
			Set<Integer> s = new HashSet<>(); // 중복 제거를 위한 set 배열 사용 
			for (int k = 0; k < 5; k++) { // 1 ~ 5 학년
				for (int l = 0; l < n; l++) { // 비교 할 학생
					if (i == l) {
						continue;
					} else if (student[i][k] == student[l][k]) { // 비교대상이 동일 하지 않고 비교대상과 반이 같으면 count++
						s.add(l);
					}
				}
			}
			count_student[i] = s.size(); // 학생마다 몇번 반이 겹치는지 배열에 값 부여
			
		}

		int max = 1;
		int index = 0;
		for (int i = 0; i < n; i++) {
			if (count_student[i] > max) {// 가장 반이 많이 겹치는 학생
				max = count_student[i];
				index = i;
			}
		}
		System.out.print(index + 1); // 인덱스는 0부터 시작하므로 +1
	}
}
