import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt(); // 리스트에 있는 점수 갯수
		int new_score = sc.nextInt(); // 태수의 새로운 점수
		int p = sc.nextInt(); // 랭킹 리스트에 오를 수 있는 갯수

		Integer[] rank_list = new Integer[n];
		for (int i = 0; i < n; i++) {
			rank_list[i] = sc.nextInt();
		} // n개의 랭킹 리스트 점수 입력

		Arrays.sort(rank_list, Collections.reverseOrder()); // 비오름차순 정렬

		// 주어진 배열 크기 n와 랭킹 컷의 크기인 p가 같으면서,
		// 랭킹 랭킹 리스트에 올라갈 수 없을 정도로 낮다면
		if (n == p && (new_score <= rank_list[rank_list.length - 1]))
			System.out.print(-1); // -1을 출력
		else {
			int rank = 1;
			for (int i = 0; i < rank_list.length; i++) {
				if (new_score < rank_list[i]) // 새로운 점수가 랭킹 리스트보다 작다면
					rank++; // 랭크 1순위 증가
				else
					break;
			}
			System.out.print(rank);
		}
	}

}
