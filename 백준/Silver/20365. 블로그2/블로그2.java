import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); //  색을 칠해야 하는 문제의 수

        String str = br.readLine(); // 문자열 입력
        char[] chars = str.toCharArray(); // 문자열을 한 글자씩 쪼개서 이를 chars 에 입력

        int B_result = 0; // B 먼저 전체 색칠
        int R_result = 0; // R 먼저 전체 색칠
        int result = 0; // 결과값

        // 인접한 중복 문자를 제거 (ex : AABBCDDD -> ABCD)
        char prev = '0';
        int k = 0; // 인덱스 설정을 위한 변수
        int modified_B_count = 0; // 수정된 B의 개수
        int modified_R_count = 0; // 수정된 R의 개수

        for (char c : chars) // 향상된 for 문
        {
            if (prev != c) // 이전 값이 입력한 문자가 아니라면
            {
                if (c == 'B') { // 값이 B이면
                    modified_B_count++; // +1
                } else { // 반대 경우
                    modified_R_count++;
                }
                chars[k++] = c; // 입력한 문자를 chars 배열에 재설정
                prev = c; // 이전 값으로 설정
            }
        }

        B_result = 1 + modified_R_count; // B로 다칠하고 수정된 R의 개수를 더해줌
        R_result = 1 + modified_B_count; // 반대 경우

        result = Math.min(B_result, R_result); // 둘 중 최솟값 출력
        System.out.println(result); //결과값출력
        br.close();
    }
}