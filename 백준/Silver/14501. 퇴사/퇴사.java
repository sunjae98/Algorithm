import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine()); // 남은 근무기간

        int[] T = new int[N + 1]; // 상담기간
        int[] P = new int[N + 1]; // 상담비용
        int[] dp = new int[N + 2]; // 수익을 비교하기위한 dp 배열 (상담 비용은 다음날에 지급되므로 +1)

        for (int i = 1; i < N+1; i++) { // 상담일정표 작성
            st = new StringTokenizer(br.readLine());
            T[i] = Integer.parseInt(st.nextToken());
            P[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = N; i > 0; i--) { // 역순으로 dp 배열을 설정

            if (i + T[i] > N + 1) { // 상담이 불가능할때 (i일차 + 상담기간 > 퇴사 하는날)
                dp[i] = dp[i + 1]; // 상담을 못하므로 다음 dp 값으로 설정
            }
            else { // 상담이 가능할때
                // 1. 상담을 하지않음 : dp[i+1]
                // 2. 상담을 진행한다 : p[i](수익) + dp[i + T[i]](기존 dp 값)
                dp[i] = Math.max(dp[i + 1], P[i] + dp[i + T[i]]); // 두가지의 경우 중 큰값을 dp배열에 할당
            }
        }

        System.out.println(dp[1]); // dp의 맨 앞의값(총 수익)출력

    }
}