import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine()); // 수의 개수
        int[] arr = new int[n]; // 수를 저장할 배열

        for (int i = 0; i < n; i++) { // 배열에 저장
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr); // 오름차순 정렬

        if (n == 3) {
            int num = Integer.parseInt(Integer.toString(arr[1]) + Integer.toString(arr[0]));
            System.out.print(num);
        } else {
            int[] result = new int[12];
            int count = 0;
            for (int i = 0; i < 4; i++) {
                for (int j = 0; j < 4; j++) {
                    if (i != j) {
                        String A = Integer.toString(arr[i]);
                        String B = Integer.toString(arr[j]);
                        result[count] = Integer.parseInt(A + B);
                        count++;
                    }
                }
            }
            Arrays.sort(result);
            System.out.print(result[2]);
        }

    }
}