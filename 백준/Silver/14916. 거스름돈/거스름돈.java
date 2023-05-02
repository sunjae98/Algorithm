import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int money = 0;

        // 표를 통해 규칙성 확인
        if(n == 1 || n == 3){ // 거슬러 줄 수 없는 경우
            System.out.print(-1);
        }

        else {
            if (n % 5 == 0) { // 나머지가 0 일 때
                money = n / 5 ;
            } else if (n % 5 == 1) {  // 나머지가 1 일 때
                money = 3 + (n /5 - 1);
            } else if (n % 5 == 2) { // 나머지가 2 일 때
                money = 1 + ( n/5);
            } else if (n % 5 == 3) { // 나머지가 3 일 때
                money = 4 + (n /5 - 1);
            } else if (n % 5 == 4) { // 나머지가 4 일 때
                money = 2 + (n /5 );
            }

            System.out.print(money);
        }

    }
}