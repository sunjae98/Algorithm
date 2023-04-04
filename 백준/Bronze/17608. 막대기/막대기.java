import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // 버퍼를 통해 입력

        int n = Integer.parseInt(br.readLine()); // 막대기 개수

        Stack<Integer> stack = new Stack<>(); // 맨위(오른쪽)부터 차례로 비교하기 위해 stack 이용
        
        for (int i = 0; i < n; i++) { // 막대기의 높이 설정
            stack.push(Integer.parseInt(br.readLine()));
        }


        int num = 1; // 오른쪽에서 보이는 막대기의 개수

        int right = stack.pop();// 오른쪽에서 보이는 막대, 제거 
        int left; // 바로 왼쪽에 있는 막대 (=비교대상)
        
        while (!stack.isEmpty()) { // 스택이 비어 있지 않을 때까지 반복
            left = stack.pop();   // 비교대상, 제거

            if (left > right) { // 비교대상이 오른쪽 막대의 높이 보다 크다면
                right = left; // 오른쪽에서 보이는 막대(=최고높이)로 설정
                num++; // 보이는 막대기의 개수 증가
            }
        }

        System.out.print(num); // 보이는 막대기의 수 출력
        
        br.close(); // 입력 버퍼 닫아줌
    }
}