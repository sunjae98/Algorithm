import javax.imageio.IIOException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine()); // 지방의 수
        int[] arr = new int[N]; // 각 지방의 예산요청을 저장할 배열

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) { // 예산요청을 저장
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr); // 지방의 예산요청을 오름차순 정렬

        long min = 0; // 가장 적은 예산요청
        long max = arr[N - 1]; // 가장 높은 예산요청
        long mid = 0; // 중간값

        long budget = Integer.parseInt(br.readLine()); // 총 예산
        long sum = 0; // 각 예산의 합
        while (min <= max) { // 이분탐색 시작
//            System.out.println(min + " " + mid + " " + max + "   ");
            mid = (min + max) / 2; // 특정한 정수 상한액
            for (int i = 0; i < N; i++) { // 특정한 정수 상한액
                if (arr[i] <= mid) { // 지방의 예산요청이 상한액 이하라면
                    sum += arr[i]; // 합계에 지방의 예산요청을 저장
                }
                else { // 초과한다면
                    sum += mid; // 합계에 상한액을 저장
                }
            }

            if (sum > budget) { // 예산을 초과하면
                max = mid - 1;  // 최댓값을 줄여줌
            } else { // 예산보다 모자르면
                min = mid + 1;  // 최솟값을 줄여줌
            }
            sum = 0; // 초기화
        }
//        System.out.println(min + " " + mid + " " + max + "   ");
        System.out.println(max); // 결과값출력
        br.close();
    }
}