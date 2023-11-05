public class Solution {
    public boolean solution(String s) {
        boolean answer = true;
        
        // 조건 1: 길이가 4 또는 6이어야 함
        if (s.length() != 4 && s.length() != 6) {
            answer = false;
        }
        
        // 조건 2: 숫자로만 구성되어야 함
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c < '0' || c > '9') {
                answer = false;
                break; 
            }
        }
        
        return answer;
    }
}
