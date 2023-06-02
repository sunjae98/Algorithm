import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static long GCD(long m, long n) { // 유클리드 호제법 (재귀함수)
        if (m % n == 0) {
            return n;
        }
        return GCD(n, m % n);
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); // 행성의 개수

        // 행성의 정렬 주기 입력
        long[] T = new long[N-2];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N-2; i++) {
            T[i] = Long.parseLong(st.nextToken());
        }

        // 행성 정렬 주기의 최대 공배수
        long lcm = T[0];
        for (int i = 1; i < N-2; i++) {
            lcm = (lcm * T[i]) / GCD(lcm, T[i]);
        }

        System.out.println(lcm);
    }
}