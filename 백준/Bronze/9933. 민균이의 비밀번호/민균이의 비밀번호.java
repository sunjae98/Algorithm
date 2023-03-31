import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        String[] arr = new String[N]; // 길이가 N인 문자열 배열 선언

        for (int i = 0; i < N; i++) {
            arr[i] = br.readLine(); // 각 배열에 N개의 단어 입력
        }

        int result1 = 0; // 비밀번호의 길이
        char result2 = '0'; // 가운데 글자

        for (int i = 0; i < N; i++) {
            StringBuilder sb = new StringBuilder(arr[i]); // 단어
            String reverse = sb.reverse().toString(); // 뒤집은 단어

            if (arr[i].equals(reverse)) { // 단어가 펠린드롬 일 때
                result1 = arr[i].length(); 
                result2 = arr[i].charAt(arr[i].length() / 2);
                break; // 비밀번호 이므로 반복문을 빠져나감
            }

            for (int j = 0; j < N; j++) { // 반복문을 돌며 문자를 비교
                if (arr[j].equals(reverse)) { // 단어 == 뒤집은단어
                    result1 = arr[j].length();
                    result2 = arr[j].charAt(arr[j].length() / 2);
                    break; // 비밀번호 이므로 반복문을 빠져나감
                }
            }
        }


        System.out.print(result1 + " " + result2);


        br.close();
    }
}