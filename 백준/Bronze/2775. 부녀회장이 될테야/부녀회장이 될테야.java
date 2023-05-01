import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[][] apt = new int[15][15]; // 15 x 15 의 아파트 생성

        for (int i = 0; i < 15; i++) {
            apt[0][i] = i; // 0층 사람들 입주
            apt[i][1] = 1; // 1호는 1명으로 고정
        }

        for (int i = 1; i < 15; i++) { // 1층 ~ 14층
            for (int j = 2; j < 15; j++) { // 2호 ~ 14호
                apt[i][j] = apt[i][j - 1] + apt[i - 1][j]; // i층 입주민 = 왼쪽방 입주민 + 아래층 입주민
            }
        }

        int T = Integer.parseInt(br.readLine());
        int k = 0;
        int n = 0;

        int result[] = new int[T]; // 결과값을 저장할 배열

        for (int i = 0; i < T; i++) { // 테스트 케이스 횟수
            k = Integer.parseInt(br.readLine()); // k층이고
            n = Integer.parseInt(br.readLine()); // n호의
            result[i] = apt[k][n]; // 입주민
        }

        for (int i = 0; i < T; i++) {
            System.out.println(result[i]); // 출력형식에 맞게 출력
        }
        br.close();
    }
}