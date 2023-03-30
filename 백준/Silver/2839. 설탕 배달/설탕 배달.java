import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int bag_3kg;
        int bag_5kg;
        int result = -1; // 기본값

        //표를 통해 규칙성 확인

        if(N == 3){
            result = 1;
        } else if (N == 4  ||  N == 7) { // 3kg 봉지와 5kg 봉지로 담을 수 없는 것은 4, 7 뿐이다.
            result = -1;
        }
        else {  // N 을 5로 나누었을 때 나머지 0 1 2 3 4 에 따라 생각 (N>5)
            if (N % 5 == 0) { // 나머지가 0 일 때
                result = N / 5;
            } else if (N % 5 == 1) {  // 나머지가 1 일 때 -> 5의배수 + 1
                result = (N / 5) + 1;
            } else if (N % 5 == 2) { // 나머지가 2 일 때 -> 12 + 5의배수
                result = (N / 5) + 2;
            } else if (N % 5 == 3) { // 나머지가 3 일 때
                result = (N / 5) + 1;
            } else if (N % 5 == 4) { // 나머지가 4 일 때 -> 5의 배수 - 1
                result = (N / 5) + 2;
            }

        }

        System.out.print(result);
        br.close();
    }
}