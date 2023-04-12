import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 교과서의 수
        int M = Integer.parseInt(st.nextToken()); // 교과서 더미의 수

        int count = 0;

        for (int i = 0; i < M; i++) { // 더미의 수 만큼 반복
            int book_count = Integer.parseInt(br.readLine()); // 더미별 책의 개수
            Integer[] arr = new Integer[book_count]; // 각 더미의 정보를 담을 배열

            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < book_count; j++) { // 더미별 책의 개수만큼 반복
                arr[j] = Integer.parseInt(st.nextToken()); // 밑에 있는 순서대로 책의 번호를 저장
            }

            Integer[] temp = Arrays.copyOf(arr, arr.length); //  arr를 임시 배열에 복사하여 저장
            Arrays.sort(temp, Collections.reverseOrder()); // 내림차순으로 정렬


            if (!Arrays.toString(arr).equals(Arrays.toString(temp))) { // 기존 배열과 내림차순으로 정렬한 배열이 동일하지 않으면
                count++; // count 값 증가
            }
        }

        if (count == 0) {
            System.out.print("Yes");
        } else {
            System.out.print("No");
        }

    }
}