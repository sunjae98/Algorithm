import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        double N = Integer.parseInt(br.readLine());
        double sqrt = Math.sqrt(N); //N의 제곱근
        double result = Math.floor(sqrt);// 소숫점 뒷자리를 버림
        System.out.print((int)result); //결과값



//        for (int i = 1; i < N + 1; i++) { // 1번째 사람 -> 1,2,...,n 번째 창문 열기
//            arr[i] = 1;
//        }
//
//
//        for (int k = 2; k < N + 1; k++) { // n번재 사람
//            for (int m = 1; k * m < N + 1; m++) { // n의 배수 창문 열기 or 닫기
//                if (arr[k * m] == 1) { // 창문이 열려있다면
//                    arr[k * m] = 0; // 닫기
//                } else { // 창문이 닫혀있다면
//                    arr[k * m] = 1; // 열기
//                }
//            }
//        }
//
//        int sum = 0;
//        for (int i = 1; i < N + 1; i++) {
//            if (arr[i] == 1) { // 창문이 열려있다면
//                sum++; // 합계 증가
//            }
//        }
//
//        System.out.print(sum);




    }

}