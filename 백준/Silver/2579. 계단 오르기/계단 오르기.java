import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine()); // 계단 개수
        int[] score = new int[301]; // 층별 점수
        int[] dp = new int[301]; // n층 도착시 최대 점수

        dp[0] = 0; // 시작점

        for (int i = 1; i < N + 1; i++) { // 게임을 위한 계단 생성
            score[i] = Integer.parseInt(br.readLine());
        }

        //n-3층을 기준으로
        dp[1] = score[1];
        dp[2] = score[1] + score[2];
        dp[3] = Math.max(score[1], score[2]) + score[3]; // 1층->3층 or 2층 ->3

        for (int i = 4; i < N + 1; i++) {
            // n층을 밟는경우
            // 1. n-3층 -> n-2층 -> n-1층 -> n층 (1칸 + 1칸 + 1칸) : 규칙 2에 위배되므로 제외
            // 2. n-3층 -> n-1층 -> n층 (2칸 + 1칸) => dp[i-3] + score[i - 1]
            // 3. n-2층 -> n층 (2칸) => dp[i - 2]
            // 4. n-3층 -> n-2층 -> n층 (1칸 + 2칸) => dp[i-3] -> dp[i-2] : 3의 경우와 동일하므로 제외
            dp[i] = Math.max(dp[i - 3] + score[i - 1], dp[i - 2]) + score[i];
        }

        System.out.print(dp[N]); // 최대 점수 출력

    }
}