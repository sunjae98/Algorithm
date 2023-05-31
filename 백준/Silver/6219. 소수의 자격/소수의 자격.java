import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int D = Integer.parseInt(st.nextToken());

        int max = 4000000;

        boolean notPrimeNum[] = new boolean[max + 1]; // 소수를 판별할 배열


        //에라토스테네스의 체를 이용하여 소수 판별
        for (int i = 2; i <= max; i++) {
            for (int j = i * 2; j <= max; j += i) {
                notPrimeNum[j] = true;
            }
        }

        int count = 0;
        for (int i = A; i <= B; i++) { // 범위에 속하는 숫자를 탐색
            if (!notPrimeNum[i]) { // 탐색한 숫자가 소수 일때
                String s = Integer.toString(i); // 문자열로 변환
                if (s.contains(Integer.toString(D))) { // D가 포함되어있으면
                    count++; // count 증가
                }
            }
        }

        System.out.println(count);
    }
}