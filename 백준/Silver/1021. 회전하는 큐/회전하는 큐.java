import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 덱의 사이즈
        int M = Integer.parseInt(st.nextToken()); // 찾을 원소의 개수

        Deque<Integer> deq = new LinkedList<>(); // 양방향으로 순회 하므로 덱 선언

        for (int i = 1; i < N + 1; i++) { // 원소 1부터 N까지 덱에 추가
            deq.add(i);
        }

        st = new StringTokenizer(br.readLine());

        int[] num_location = new int[M]; // 찾을 원소 위치를 담을 배열

        for (int i = 0; i < M; i++) {
            num_location[i] = Integer.parseInt(st.nextToken()); // 배열에 원소 위치 입력
        }

        int count = 0; // 연산 2와 연산 3의 최소값
        int count_2 = 0; // 연산 2의 횟수
        int count_3 = 1; // 연산 3의 횟수 


        for (int i = 0; i < M; i++) {

            if (deq.peek() == num_location[i]) { // 덱의 맨 앞의 값이 찾을 원소의 위치 라면
                deq.remove(); // 연산 1 == 첫번째 원소를 뽑아냄
            } else {

                Iterator<Integer> it_2 = deq.iterator(); // 덱을 순회 하기 위해 Iterator 이용
                while (it_2.hasNext()) { // 덱의 개수만큼 반복
                    if (it_2.next() == num_location[i]) { // 탐색한 값이 찾는 원소 라면
                        break; // 반복문을 빠져나감
                    }
                    count_2++; // 연산 2 횟수 증가
                }

                Iterator<Integer> it_3 = deq.descendingIterator(); // 역순회
                while (it_3.hasNext()) { // 덱의 개수만큼 반복
                    if (it_3.next() == num_location[i]) { // 탐색한 값이 찾는 원소 라면
                        break; // 반복문을 빠져나감
                    }
                    count_3++; // 연산 3 횟수 증가
                }


                if (count_2 < count_3) { // 연산 2 횟수 < 연산 3 횟수라면 == 연산의 최솟값이 연산 2
                    count += count_2; // 연산 2의 횟수 만큼 count 증가
                    for (int j = 0; j < count_2; j++) {
                        deq.addLast(deq.removeFirst()); // 연산 2 실행 == 왼쪽으로 한 칸 이동

                    }
                    deq.remove(); // 맨 앞 원소 뽑아냄
                } else { // 연산 2 횟수 > 연산 3 횟수라면 == 연산의 최솟값이 연산 3
                    count += count_3; // 연산 3의 횟수 만큼 count 증가
                    for (int j = 0; j < count_3; j++) {
                        deq.addFirst(deq.removeLast()); // 연산 3 실행 == 오른쪽으로 한 칸 이동

                    }
                    deq.remove(); // 맨 앞 원소 뽑아냄
                }

                count_2 = 0; // 연산 2 실행 횟수 초기화
                count_3 = 1; // 연산 3 실행 횟수 초기화
            }
        }

        System.out.print(count); // 연산의 최소값 출력
        br.close(); // 버퍼 닫음
    }
}


