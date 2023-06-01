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
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st;

        long[] a = new long[N];
        long[] b = new long[N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            a[i] = Integer.parseInt(st.nextToken());
            b[i] = Integer.parseInt(st.nextToken());
        }

//        //공통분모로 분모맞추기
//        long B=1;
//        for (int i = 0; i < N; i++) {
//            B = B * b[i];
//        }
//
//        //분모들의 최대공약수 구하기
//        long b_gcd = b[0];
//        for (int i = 1; i < N; i++) {
//            b_gcd = GCD(b_gcd, b[i]);
//        }
//
//        // 공통분모를 분모들의 최대공배수로 초기화
//        B = B/b_gcd;

        // 분모의 최소공배수
        long B = b[0];
        for (int i = 1; i < N; i++) {
            B = (B * b[i]) / (GCD(B,b[i]));
        }

        // 바뀐 분모에 분자맞추기
        long[] A = new long[N];
        for (int i = 0; i < N; i++) {
            A[i] = (a[i] * (B / b[i]));
        }

        //분자들의 최대 공약수 구하기
        long A_gcd = A[0];
        for (int i = 1; i < N; i++) {
            A_gcd = GCD(A_gcd, A[i]);
        }

        //최종 답
        long result_1 = A_gcd;
        long result_2 = B;

        //기약분수로 맞춰주기 위하여 최대공약수를 구함
        long result_gcd = GCD(result_2, result_1);
        System.out.println(result_1 / result_gcd + " " + result_2 / result_gcd);
        br.close();
    }
}