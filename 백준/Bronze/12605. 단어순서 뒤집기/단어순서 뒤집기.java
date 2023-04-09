import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Stack<String> stack = new Stack<>(); // 스택 선언

        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            String str = br.readLine(); // 한 줄을 문자열로 저장
            String[] arr = str.split(" "); // 저장한 문자열을 공백 단위로 분리하여 배열에 저장

            for (int j = 0; j < arr.length; j++) {
                stack.add(arr[j]); // 스택에 분리한 문자열 추가
            }

            System.out.print("Case #" + (i + 1) + ": "); // 출력 형식을 맞춰줌

            while (!stack.isEmpty()) { // 스택이 비어 있을 때 까지 반복
                System.out.print(stack.pop() + " "); // 스택의 최상위 값 제거 한 뒤에 리턴
            }
            
        }
        br.close();
    }
}