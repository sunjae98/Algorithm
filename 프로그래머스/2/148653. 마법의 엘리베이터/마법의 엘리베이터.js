function solution(storey) {
    
    // 각 자리수를 탐색하며 0이 되게함
    var answer = 0;
    
    // 숫자 -> 문자열 -> 자릿수 별로 배열에 저장
    let digitArray = storey.toString().split("").map(Number)
    
    for(let i = digitArray.length - 1; i >= 0; i--){
        if(digitArray[i] < 5){
            answer += digitArray[i]
        }
        else if(digitArray[i] > 5){
            answer += 10 - digitArray[i]
            digitArray[i-1]++;
        }
        else{
             if(digitArray[i-1]>=5){
              digitArray[i-1] += 1;
              answer+=10-digitArray[i];
          }
          else{
              answer+=digitArray[i];
          }
        }
    }
    
    if(digitArray[0]>5){
      answer+=1;
  }
    
    return answer;
}