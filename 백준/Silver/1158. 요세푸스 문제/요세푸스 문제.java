import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		Queue<Integer> que = new LinkedList<>(); // 큐

		int n = sc.nextInt();
		int k = sc.nextInt();

		StringBuffer sb = new StringBuffer(); // append 함수 사용 위하여 StringBuffer 클래스 이용

		sb.append("<");

		for (int i = 0; i < n; i++) {
			que.add(i + 1); // 큐에 n 값 할당
		}

		while (que.size() > 1) {

			for (int i = 0; i < k - 1; i++) {
				int temp = que.poll(); // k-1번째 까지으 항목을 temp에 저장
				que.add(temp); // temp에 옮겨진 항목은 que 맨 끝으로 옮김

			}

			int num = que.poll();
			sb.append(num).append(", "); // que 맨 앞의 값(=k번째 항목)을 StingBuffer에 저장

		}
		int num = que.poll();
		sb.append(num).append(">"); // size = 1 에서 하나를 출력

		System.out.println(sb);

	}

}
