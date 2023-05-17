import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        int sum= 0 ;
        Arrays.sort(arr); // 2 2 3 3

        Stack<Integer> stack = new Stack<>(); //int형 스택 선언

        for (int i = 0; i < N; i++) {
            stack.add(arr[i]);
        }

        while (true) {
            sum += stack.peek();
            stack.pop();
            sum += stack.peek();
            stack.pop();
            stack.pop();
            if(stack.size() < 3){
                while (stack.size() != 0) {
                    sum += stack.peek();
                    stack.pop();
                }
                break;
            }
        }


        System.out.println(sum);
    }
}