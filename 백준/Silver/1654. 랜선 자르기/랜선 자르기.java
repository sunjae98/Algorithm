import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int K = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        int[] RAN_line = new int[K];
        long sum_line = 0;
        for (int i = 0; i < K; i++) {
            RAN_line[i] = Integer.parseInt(br.readLine());
            sum_line +=  RAN_line[i];
        }

        long max_line = sum_line / N ;
        long min_line = 1;
        long mid_line = 0;
        int count = 0;


         // count가 많다는 것은 mid_line이 짧다는것 -> mid line을 길게 해줘야데 == min line = mid_kone
        while (max_line >= min_line) {
            mid_line = (max_line + min_line) / 2;

            for (int i = 0; i < K; i++) {
                count += RAN_line[i] / mid_line;
            }

            if(count>=N){
                min_line = mid_line +1;
            }
            else if(count < N) {
                max_line = mid_line -1;
            }
           
            count =0;
        }
        System.out.println(max_line);

    }
}