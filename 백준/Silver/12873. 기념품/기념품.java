import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;


public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine()); // 캠프 참가자의 수

        Queue<Integer> que = new LinkedList<>(); // 큐 선언

        for (int i = 0; i < N; i++) {
            que.add(i + 1); // 큐에 티셔츠 번호 순으로 사람 추가
        }

        for (int t = 1; t < N + 1; t++) { // (t단계) 사람수 - 1 만큼 게임 진행

            if (que.size() == 1) { // 1명 남을때까지 게임 진행
                break;
            }

            long shout = (long) Math.pow(t, 3); // 외치는 횟수 == t^3 회
            long mod = shout % que.size();


            if (mod == 0) { // 큐의 마지막 값 제거
                for (int i = 0; i < que.size() - 1; i++) { // 현재 인원 - 1 만큼 큐의 차례로 맨뒤로 보냄
                    que.add(que.remove());
                }
                que.remove(); // 맨 앞에 사람을 제거

            } else {
                for (int i = 0; i < mod - 1; i++) {
                    que.add(que.remove()); // mod - 1 까지 큐의 차례로 맨뒤로 보냄
                }
                que.remove(); //  맨 앞에 사람을 제거
            }
        }
        System.out.print(que.peek()); // 마지막 생존자 출력
    }
}