import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 지구, 태양, 달 입력
        int E = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        // 1년 부터 시작
        int year = 1;
        int e = 1;
        int s = 1;
        int m = 1;

        while (true) {
            if (E == e && S == s && M == m) { // 처음 입력한 값과 반복문을 실행한 후의 값이 동일하다면
                break; // 반복문을 빠져나감
            }

            year++; // 1년 증가 할때마다
            e++; // 지구 증가
            s++; // 태양 증가
            m++; // 달 증가

            // 범위를 벗어나면 1로 초기화
            if (e > 15) {
                e = 1;
            }
            if (s > 28) {
                s = 1;
            }
            if (m > 19) {
                m = 1;
            }

        }

        System.out.print(year); // 증가한 년도 출력

        br.close();
    }
}