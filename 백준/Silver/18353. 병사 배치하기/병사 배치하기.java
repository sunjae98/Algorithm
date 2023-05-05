import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine()); // 병사 수
        int[] soldier = new int[N]; // 병사 전투력을 저장할 배열
        int[] dp = new int[N]; // LSB 저장

        st = new StringTokenizer(br.readLine());
        for (int i = N-1; i >= 0; i--) { // 병사를 역순으로 나열
            soldier[i] = Integer.parseInt(st.nextToken());
            dp[i] = 1; // dp값 초기화
        }

        for (int i = 1; i < N; i++) {
            //i 앞의 모든 값들에 대해
            for (int j = 0; j < i; j++) {
                if (soldier[j] < soldier[i]) {
                    //i번째 값에 대한 가장 긴 증가 부분 수열 길이 구하기
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }

        int max = dp[0]; //
        for (int i = 1; i < N; i++) {
            max = Math.max(max, dp[i]); //가장 긴 증가 부분 수열 길이
        }
        System.out.println(N - max); // 총 병사수 - 가장 긴 증가 부분 수열 길이

    }
}
