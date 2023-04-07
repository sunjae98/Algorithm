import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine()); // 펼처진 카드 개수

        StringTokenizer st;
        HashMap<String, Integer> map = new HashMap<>(); // key, value -> Hashmap 이용

        String fruit = "0"; // 과일
        int num = 0; // 개수

        for (int i = 0; i < N; i++) { // 카드 개수 만큼 반복
            st = new StringTokenizer(br.readLine());
            fruit = st.nextToken(); // 과일 입력
            num = Integer.parseInt(st.nextToken()); // 개수 입력

            if (map.containsKey(fruit)) { // 중복되는 과일이 있다면
                map.put(fruit, (map.get(fruit) + num)); // num을 기존 value 에 더해줌
            } else { // 중복한 과일이 없다면
                map.put(fruit, num); // 맵에 (key : 과일, value : 개수 )저장
            }
        }

        if (map.containsValue(5)) { // 개수의 합이 5인 과일이 있다면
            System.out.print("YES"); // YES 출력
        } else { // 없다면
            System.out.print("NO"); // NO 출력
        }

    }
}