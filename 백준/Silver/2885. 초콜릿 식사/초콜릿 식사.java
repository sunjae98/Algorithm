 import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int K = Integer.parseInt(br.readLine()); // 상근이가 먹어야할 정사각형 초콜릿 조각

        int a = 0;
        for (double i = 0; i < 21; i++) { // 2^20 = 1,048,576
            if (K > Math.pow(2, i)) { // K가 2^i 값 보다 크면
                a++; // num -> +1
            } else { //
                break; // 반복문을 빠져나감
            }
        }

        int chocolate = (int) Math.pow(2, a); // 구매해야하는 가장 작은 초콜릿의 크기
        int CHO = chocolate; // 초콜릿을 쪼개기위한 복사본
        int count = 0; // 쪼개는 횟수

        while (true) { // 상근이가 초콜릿을 다먹을때까지 반복
            if (K >= CHO) { // 먹어야할 양이 쪼깬 초콜릿보다 많으면
                K = K - CHO; // 초콜릿을 먹임
            }
            if (K == 0) { // 상근이가 초콜릿 할당량를 채움
                break; // 반복문을 빠져나감
            } else { //
                CHO = (CHO / 2); // 초콜릿을 반으로 쪼갬
                count++; // 쪼갠 횟수 증가
            }
        }

        System.out.println(chocolate + " " + count);
        br.close();
        
    }
}