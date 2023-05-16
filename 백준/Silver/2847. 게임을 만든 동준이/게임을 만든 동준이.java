import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); // 레벨의 수

        int[] arr = new int[100]; // 각 레벨 점수를 저장할 배열
        for (int i = 0; i < N; i++) { // 레벨 점수 입력
            arr[i] = Integer.parseInt(br.readLine());
        }

        int result = 0; // 감소 횟수
        
        for (int i = N - 1; i > 0; i--) { // 역순으로 값을 비교
            if (arr[i] <= arr[i - 1]) { // 뒤의 값이 앞의 값보다 작거나 같으면
                while (true) { // while문 실행
                    arr[i - 1] -= 1; // 앞의 값을 1 감소시킴
                    result++; // 감소 횟수 증가
                    if (arr[i] > arr[i - 1]) { // 뒤의 값이 앞의 값보다 커지면
                        break; // 반복문을 빠져나감
                    }
                }
            }
        }

        System.out.print(result);
        br.close();
    }
}