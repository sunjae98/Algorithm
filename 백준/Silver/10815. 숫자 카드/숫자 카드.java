import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        int N = Integer.parseInt(br.readLine()); // 상근이 카드 개수
        int[] SG_CARD = new int[N]; // 상근이의 카드를 저장할 배열
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) { // 카드 숫자 입력
            SG_CARD[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(SG_CARD); // 이진탐색을 위한 오름차순 정렬

        int M = Integer.parseInt(br.readLine()); // 비교할 카드 개수
        int CARD = 0; // 카드의 숫자를 담을 변수
        st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < M; i++) {
            int left = 0;
            int right = N - 1;
            int result = 0; // 초기화
            CARD = Integer.parseInt(st.nextToken());
            while (right >= left) { // 이진탐색 시작
                int mid = (left + right) / 2;

                if (CARD == SG_CARD[mid]) {
                    result = 1; // 카드가 존재하면 1
                    break;
                }

                if (CARD > SG_CARD[mid]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
            sb.append(result + " "); // 결과값을 sb에 추가
        }

        System.out.println(sb.toString()); // sb 출력
        br.close();
    }
}