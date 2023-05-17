import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] expect = new int[N]; // 예상등수를 저장할 배열
        int[] rank = new int[N]; // 기존랭크를 저장할 배열
        int[] dissatisfy = new int[N]; // 불만도를 저장할 배열
        long sum = 0; // 불만도 합

        for (int i = 0; i < N; i++) { // 예상등수 입력
            expect[i] = Integer.parseInt(br.readLine());
        }

        for (int i = 0; i < N; i++) { // 랭크를 오름차순으로 설정
            rank[i] = i+1;
        }

        Arrays.sort(expect); // 예상등수를 오름차순으로 배열

        for (int i = 0; i < N; i++) {
            dissatisfy[i] = Math.abs(expect[i]-rank[i]); // 불만도 = 예상등수 - 기존랭크
            sum += dissatisfy[i]; // 불만도를 더함
        }

        System.out.println(sum); // 결과 출력
    }
}