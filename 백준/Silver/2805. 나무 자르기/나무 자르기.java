import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 나무 개수
        int M = Integer.parseInt(st.nextToken()); // 집에 가져갈 나무
        long[] arr = new long[N]; // 나무 길이를 저장할 배열

        long max = 0, min = 0, mid = 0;

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            if (arr[i] > max) { // 가장 큰 나무 찾기
                max = arr[i];
            }
        }

        while (min <= max) { // 이분탐색 시작
            mid = (max + min) / 2;
            long sum = 0;
            for (int i = 0; i < N; i++) {
                if (arr[i] > mid) {
                    sum += (arr[i] - mid); // 나무 절단하기
                }
            }

            if (sum == M) { // 절단한 나무가 할당량을 채우면
                break; // 반복문을 빠져나감
            } else if (sum > M) { // 많이 잘랐으면
                min = mid + 1; // 절단기 높여줌
            } else { // 덜 잘랐으면
                max = mid - 1; // 절단기 낮춰줌
            }
        }

        System.out.println((max + min) / 2);
    }
}