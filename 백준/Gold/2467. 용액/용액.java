import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        long sum = 0;
        int result_1 = 0;
        int result_2 = 0;
        long min = Integer.MAX_VALUE;
        int minIndex = 0;
        int k = 1;
        for (int i = 0; i < N - 1; i++) {
            int left = i + 1;
            int right = N - 1;
            while (left <= right) {
                int mid = (left + right) / 2;
                sum = arr[i] + arr[mid];

                if (Math.abs(sum) < min) {
                    result_1 = arr[i];
                    result_2 = arr[mid];
                    min = Math.abs(sum);
                }

                if (sum == 0) {
                    break;
                } else if (sum > 0) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
        }

        System.out.println(result_1 + " " + result_2);
    }
}