import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine()); // 학생의 수

        ArrayList<Integer> student = new ArrayList(); // 인덱스 별로 학생을 추가 하기 위해 ArrayList 사용
        StringTokenizer st = new StringTokenizer(br.readLine()); // 버퍼가 읽은 한줄을 분해

        int num = 0; // 번호
        student.add(0); // 0번째 인덱스 채우기

        for (int i = 1; i < n + 1; i++) { // 순서 정하기
            num = Integer.parseInt(st.nextToken()); // 순서대로 번호를 매김
            student.add(i - num, i); // i 번째 학생을 (처음 섰던 줄  - 뽑은 번호 = 최종적으로 서게 될 줄) 에 세운다.
        }

        for (int i = 1; i < n + 1; i++) { // 줄 세우기
            System.out.print(student.get(i) + " ");
        }
    }
}