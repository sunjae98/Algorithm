import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 듣도 못한 사람의 수
        int M = Integer.parseInt(st.nextToken()); // 보도 못한 사람의 수

        int count = 0;
        String person = "0";

        HashMap<String, Integer> map = new HashMap<>(); // 전체 명단을 저장할 hashmap
        ArrayList<String> not_LS = new ArrayList<>(); // 듣보잡 명단을 저장할 list

        for (int i = 0; i < N; i++) {
            map.put(br.readLine(), 1); // 듣도 못한 명단 (value = 1)에 추가
        }
        for (int i = 0; i < M; i++) {
            person = br.readLine();
            if (map.containsKey(person)) { // 추가한 사람이 듣도 못한 명단에 포함되어 있다면
                not_LS.add(person); // 듣보잡 명단에 추가함
                count++;// 듣보잡 1명 증가
            }
            map.put(person, 2); // 보도 못한 명단 ( value = 2)에 추가
        }

        System.out.println(count); // 듣보잡의 수

        Collections.sort(not_LS); // 사전순으로 정렬
        for (int i = 0; i < not_LS.size(); i++) {
            System.out.println(not_LS.get(i)); // 듣보잡 명단 출력
        }

    }
}