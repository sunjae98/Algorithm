import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    // 유클리드 호재법(최대공약수) - 재귀함수 사용
    //1. 두 수 중 큰 수를 작은 수로 나누어 나머지를 구한다. (106 % 16 = 10)
    //2. 작은 수를 방금 구한 나머지로 나눈다. (16 % 10 = 6)
    //3. 나머지가 0이 될때까지 반복한다.
    //4. 나머지가 0이 될 때 나눴던 수가 최대 공약수이다.
    static int GCD(int a, int b) {
        if (b == 0) {
            return a;
        }
        return GCD(b, a % b);

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine()); // 이미 심어져 있는 가로수의 수
        int[] tree = new int[N]; // 가로수의 위치를 저장할 배열
        int[] dis = new int[N - 1]; // 가로수간의 거리를 저장할 배열

        for (int i = 0; i < N; i++) { // 가로수 심기
            tree[i] = Integer.parseInt(br.readLine());
        }

        for (int i = 0; i < N - 1; i++) { // 거리 구하기
            dis[i] = tree[i + 1] - tree[i];
        }


        int GCD = 0;
        GCD = GCD(dis[0], dis[1]); // 두 수의 최대 공약수를 구하거

        for (int i = 2; i < N - 1; i++) {
            GCD = GCD(GCD, dis[i]); // 최대 공약수와 나머지 수에 대해 다시 최대 공약수를 구함
        }

        int count = 0;
        int result = 0;
        count =(tree[N-1]-tree[0])/GCD+1;; // 전체 가로수의 수 :(최대위치-최소위치)/최대공약수+1
        result = count - (tree.length); // 심어져 있는 가로수를 빼줌

        System.out.print(result);

        br.close();
    }
}