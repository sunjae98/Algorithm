import javax.imageio.IIOException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine()); // 큐의 사이즈

        // "1을 버리면 234가 남는다" -> queue ??
        Queue<Integer> queue = new LinkedList<>(); // 큐 선언

        for (int i = 0; i < N; i++) {
            queue.add(i + 1); // 큐에 1부터 N까지 차례로 값 추가
        }


        while (queue.size() != 1) { // 큐의 사이즈가 1이 아닐때 까지 반복
            queue.remove(); // 큐에 첫번째 값 제거
            queue.add(queue.poll()); // 큐에 첫번째 값을 반환 하고 제거 -> 그 값을 큐 마지막 값에 추가
        }
        System.out.print(queue.peek()); // 큐의 첫번째 값 출력
    }

}