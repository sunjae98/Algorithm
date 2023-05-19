import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); // 카드 개수
        int m = Integer.parseInt(st.nextToken()); // 합체 횟수

        st = new StringTokenizer(br.readLine());
        long[] card = new long[n]; // 카드 숫자를 저장할 배열

        for (int i = 0; i < n; i++) {
            card[i] = Integer.parseInt(st.nextToken()); //배열에 카드 숫자 입력
        }

        Arrays.sort(card); // 오름차순 정렬


        for (int i = 0; i < m; i++) { // 합체 놀이를 m 회 실행
            long combine = card[0] + card[1]; // 제일 작은 두수를 합침
            card[0] = combine; // 계산한 값으로 덮어씀
            card[1] = combine; // 계산한 값으로 덮어씀
            Arrays.sort(card); // 오름차순 정렬
        }

        long sum = 0; // 숫자의 합계
        for (int i = 0; i < n; i++) {
            sum += card[i]; // 모든 배열의 값을 sum 더해줌
        }

        System.out.println(sum);
        br.close();
    }
}