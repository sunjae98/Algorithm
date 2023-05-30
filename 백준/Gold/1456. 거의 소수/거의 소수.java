import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long A = Long.parseLong(st.nextToken());
        long B = Long.parseLong(st.nextToken());

        int max = 10000000; // 거의 소수는 소수^2 이므로 10^7 까지 반별
        boolean notPrimeNum[] = new boolean[max + 1]; // 소수를 판별할 배열

        //0과 1은 소수가 아님
        notPrimeNum[0] = true;
        notPrimeNum[1] = true;

        //에라토스테네스의 체를 이용하여 소수 판별
        for (int i = 2; i <= Math.sqrt(B); i++) {
            for (int j = i * 2; j < max + 1; j += i) {
                notPrimeNum[j] = true;
            }
        }

        ArrayList<Long> arrayList = new ArrayList<>();
        for (int i = 2; i <= max; i++) {
            if (B <= i) { // 최적화
                break;
            }
            if (!notPrimeNum[i]) { // 소수일때
                for (int j = 2; ; j++) {
                    if ((long) Math.pow(i, j) > B) {// 최적화
                        break;
                    }
                    arrayList.add((long) Math.pow(i, j)); // 거의 소수를 리스트에 저장
                }
            }
        }

        Collections.sort(arrayList); // 오름차순 정렬

        int left = 0;
        int right = arrayList.size() - 1;
        while (left <= right) { // 범위에 속하는 가장 작은 수의 인덱스를 찾기 위해 이분탐색 
            int mid = (left + right) / 2;
            if (arrayList.get(mid) >= A) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        System.out.println(arrayList.size() - left); // 범위에 맞게 형식을 맞춰줌

//        for (int i = 2; i < max +1; i++) {
//            if (!notPrimeNum[i]) { // 탐색하는 값이 소수일때
//                for (int j = 2; j < 24; j++) { // 10^7 < 2^24 < 10^8
//                    long index = (long)Math.pow((double) i, (double) j); // 탐색하려는 수 : i^j
//                    if(index > max){
//                        break;
//                    }
//                    if (A <= index && index <= B) { // 인덱스가 범위에 부합하면
//                        if (!arrayList.contains(index)) { // 중복 값 제거
//                            arrayList.add(index); // 거의소수 배열의 값을 true 로 설정
//                        }
//                    }
//                }
//            }
//        }
//
//        System.out.println(arrayList.size()); // ArrayList 의 사이즈
//        br.close();

    }
}