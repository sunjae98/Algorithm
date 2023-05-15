import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder(); // 문자열을 변경하기 위한 StringBuilder 사용
        StringTokenizer st;

        int CASE = 0; // 케이스 횟수를 저장할 변수
        int result = 0; // 결과를 저장할 변수

        while (true) {
            st = new StringTokenizer(br.readLine());

            int L = Integer.parseInt(st.nextToken()); // 사용일수 입력
            int P = Integer.parseInt(st.nextToken()); // 연속일수 입력
            int V = Integer.parseInt(st.nextToken()); // 휴가일수 입력

            if (L == 0 && P == 0 && V == 0) { // 0 0 0 을 입력받으면
                break; // 반복문을 빠져나감
            }

            CASE++; // 케이스 횟수 증가
            result = (V / P) * L; // 휴가일수를 연속일수로 나눈뒤 사용일수 곱해줌

            if (V % P <= L) { // 나눈 나머지가 사용일수 보다 작거나 같다면
                result += V % P; // 나머지를 결과값에 더해줌
            } else {
                result += L; // 반대라면 사용일수를 더헤줌
            }

            sb.append("Case " + CASE + ": " + result + "\n"); // 출력형식에 맞춰 문자열 추가
        }
        System.out.println(sb.toString()); // 문자열 출력
        br.close();
    }
}