import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Assignment implements Comparable<Assignment> {
    int d; // 과제 소요 시간
    int t; // 과제 마감 기간

    Assignment(int d, int t) { // 생성자
        this.d = d;
        this.t = t;
    }

    @Override
    public int compareTo(Assignment a) { // 마감기한 기준으로 내림차순 정렬
        return a.t - this.t;
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine()); // 과제 개수
        Assignment[] as = new Assignment[n]; // 과제 객체

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int di = Integer.parseInt(st.nextToken()); // 과제 소요 시간
            int ti = Integer.parseInt(st.nextToken()); // 과제 마감 기간
            as[i] = new Assignment(di, ti); // 객체에 저장
        }

        Arrays.sort(as); // 정렬

        int day = as[0].t; // 가장 늦은 마감 기간

        for (int i = 0; i < n; i++) {
            if (as[i].t <= day) {
                day = as[i].t;
            }
            day -= as[i].d;
        }

        System.out.print(day);
    }
}