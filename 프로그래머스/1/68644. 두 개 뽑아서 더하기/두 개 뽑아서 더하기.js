function solution(numbers) {
    var answer = [];

    const N = numbers.length;
    let sum = 0;

    // 중복 제거
    const set = new Set();

    for (let i = 0; i < N; i++) {
        for (let j = i + 1; j < N; j++) {
            sum = numbers[i] + numbers[j];
            set.add(sum);
        }
    }

    answer = Array.from(set);
    answer.sort((a,b)=> a-b)

    return answer
}
