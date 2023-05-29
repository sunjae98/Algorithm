import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static int GCD(int m, int n) { // 유클리드 호제법 (재귀함수)
        if (m % n == 0) {
            return n;
        }
        return GCD(n, m % n);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        //분수 1
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        //분수 2
        st = new StringTokenizer(br.readLine());
        int c = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());

        //두개의 분수 통분
        int A = (a * d) + (b * c);
        int B = b * d;

        //최대공약수로 나눠주기
        int gcd = GCD(A, B);
        int result_1 = A / gcd;
        int result_2 = B / gcd;

        //출력형식에 맞춰줌
        System.out.println(result_1 + " " + result_2);
        br.close();
    }
}