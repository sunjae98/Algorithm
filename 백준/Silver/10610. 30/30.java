import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String N = br.readLine(); // N을 문자열로 입력받음
        char[] arr = N.toCharArray(); // 문자열을 배열로 저장

        // 30의 배수이기 위한 조건
        // 1. 0이 있어야 함
        // 2. 3의 배수여야함 == 각 자리수의 합이 3의 배수
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i] - '0'; // char -> int : Ascii code 이용
        }

        if (N.contains("0") && (sum % 3 == 0)) { // 조건1과 조건2를 만족한다면
            Arrays.sort(arr); // 오름차순 정렬
            for (int i = arr.length - 1; i >= 0; i--) { // 역방향 출력
                System.out.print(arr[i]);
            }

        } else {
            System.out.print("-1"); // 마르코가 만들고 싶어하는 수가 없음
        }

        br.close();
    }
}