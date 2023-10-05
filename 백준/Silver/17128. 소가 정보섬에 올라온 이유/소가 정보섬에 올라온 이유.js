const readFileSyncAddress = "/dev/stdin"; // 백준 제출
//const readFileSyncAddress = "Sunjae/예제.txt"; // VScode 확인

const fs = require("fs");

// input에 저장
const input = fs
  .readFileSync(readFileSyncAddress)
  .toString()
  .trim()
  .split("\n");

// 소 N 마리, 장난치는 횟수 Q
const [N, Q] = input[0].split(" ").map(Number);
const cow = input[1].split(" ").map(Number);
const joke = input[2].split(" ").map(Number);

let S_arr = [];
let S_total = 0;

// 초기 S_arr 배열 및 S_total 계산
for (let i = 0; i < N; i++) {
  S_arr[i] = cow[i] * cow[(i + 1) % N] * cow[(i + 2) % N] * cow[(i + 3) % N];
  S_total += S_arr[i];
}

let result = []; //q번에 걸쳐 계산한 s 저장

// Q 개의 줄에 걸쳐 계산결과(S) 출력
for (let i = 0; i < Q; i++) {
  for (let j = 0; j < 4; j++) {
    let index = (joke[i] - j + N - 1) % N;
    // console.log(index);
    S_arr[index] *= -1;
    S_total += 2 * S_arr[index];
  }
  result.push(S_total);
}
console.log(result.join("\n"));
