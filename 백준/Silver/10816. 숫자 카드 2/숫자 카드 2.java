import java.io.*;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());// 상근이가 가지고 있는 숫자 카드의 개수
        StringTokenizer st = new StringTokenizer(br.readLine()); // 공백 단위로 입력받기 위해 StringTokenizer 사용
        HashMap<Integer, Integer> Map = new HashMap<>(N); // key value 이용 하기 위해 Hashmap 사용

        for (int i = 0; i < N; i++) { // 숫자 카드에 적혀있는 정수
            int num = Integer.parseInt(st.nextToken()); // 숫자 카드 입력


            if (Map.containsKey(num)) { // 입력한 숫자 카드를 가지고 있다면
                Map.put(num, Map.get(num) + 1); // 개수 증가
            }
            else{
                Map.put(num,  1); // 입력한 숫자 카드를 가지고 있지 않다면 value = 1
            }

        }


        int M = Integer.parseInt(br.readLine()); // 비교할 숫자 카드의 개수
        st = new StringTokenizer(br.readLine()); // 공백 단위로 입력받기 위해 StringTokenizer 사용


        int [] result = new int [M];
        for (int i = 0; i < M; i++) { // 숫자 카드에 적혀있는 정수
            int num = Integer.parseInt(st.nextToken()); // 숫자 카드 입력

            if(Map.containsKey(num)){ //입력한 숫자 카드를 상근이가 가지고 있으면
                result[i] = Map.get(num); // 가지고 있는 개수 저장
            }
            else {
                result[i] = 0;
            }

            bw.write(result[i] + " "); // 결과값 출력
        }

        bw.close(); //스트림을 닫음

    }
}

