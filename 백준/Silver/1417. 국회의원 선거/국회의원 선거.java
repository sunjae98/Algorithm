import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;


public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine()); // 국회의원 후보
        int dasom = Integer.parseInt(br.readLine()); // 다솜이의 득표수

        if( N == 1){ // 다솜이가 단일후보라면
            System.out.print("0");
        }
        else {
            int[] arr = new int[N - 1]; // 다솜이를 제외한 후보들의 득표수를 저장할 배열

            for (int i = 0; i < N - 1; i++) {
                arr[i] = Integer.parseInt(br.readLine()); // 다솜이를 제외한 후보들의 득표수를 배열에 저장
            }

            int count = 0; // 매수 횟수

            if (N == 1) { // 다솜이가 단일후보라면
                System.out.print("0");
            }
            while (true) { //
                Arrays.sort(arr); // 후보들을 오름차순으로 정렬

                if (dasom <= arr[arr.length - 1]) { // 다솜이의 득표수 <= 최대 득표수 라면
                    dasom++; // 다솜이가
                    arr[arr.length - 1] -= 1; // 매수함
                    count++; // 매수횟수 증가
                } else {
                    break; // 다솜이가 최다 득표자가 되면 반복문을 빠져나감
                }
            }
            System.out.print(count);
        }


    }
}