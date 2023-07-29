import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;


public class Main {
    static int n; // 카드의 개수
    static int k; // 선택한 카드 개수
    static HashSet<String> Set = new HashSet<>(); // HashSet 으로 중복 제거
    static boolean[] visited; // 사용 여부
    static int[] cards; // 카드에 적힌 숫자를 저장할 배열
    static int[] arr; // 카드 조합을 저장할 배열

    static void dfs(int depth) {
        if (depth == k) { // k개의 카드가 선택되면
            StringBuilder sb = new StringBuilder(); // 카드를 합치기 위해 StringBuiler 이용
            for (int i = 0; i < k; i++) {
                sb.append(String.valueOf(cards[arr[i]])); // 카드 합치기
            }
            Set.add(sb.toString()); // Set 에 추가하여 중복제거
            return;
        } else {
            for (int i = 0; i < n; i++) {
                if (!visited[i]) { // 사용하지 않았다면
                    visited[i] = true; // 사용했다고 표시
                    arr[depth] = i; // 카드 조합에 해당 숫자 저장
                    dfs(depth + 1); // 다음 숫자 탐색
                    visited[i] = false; // 사용 안했다고 표시
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        k = Integer.parseInt(br.readLine());
        visited = new boolean[n];
        cards = new int[n];
        arr = new int[n];

        for (int i = 0; i < n; i++) { // 카드 입력
            cards[i] = Integer.parseInt(br.readLine());
        }
        dfs(0); // dfs 탐색

        System.out.print(Set.size()); // set의 크기 출력
    }
}