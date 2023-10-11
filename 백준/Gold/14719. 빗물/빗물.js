const readFileSyncAddress = "/dev/stdin"; // 백준 제출
//const readFileSyncAddress = "Sunjae/예제.txt"; // VScode 확인

const fs = require("fs");

// input에 저장
const input = fs
  .readFileSync(readFileSyncAddress)
  .toString()
  .trim()
  .split("\n");

const input_1 = input[0].split(" ");
const height = input[1].split(" ");

// 내 자신을 기준으로 왼쪽 오른쪽을 검색한 다음 왼쪽기준 가장 큰놈과 오른쪽 기준 가장 큰놈 중
// 제일 작은놈을 기준으로 나 자신을 빼면 해당 위치에서 받을 수 있는 물의 양이 나오게 됩니다.

const H = input_1[0];
const W = input_1[1];

let answer = 0;

for (let i = 1; i < W - 1; i++) {
  let left = 0;
  let right = 0;

  //왼쪽 최대 값
  for (let j = 0; j < i; j++) {
    left = Math.max(left, height[j]);
  }

  //오른쪽 최대 값
  for (let j = W - 1; j > i; j--) {
    right = Math.max(right, height[j]);
  }

  //빗물 계산
  answer += Math.max(0, Math.min(left, right) - height[i]);
}

console.log(answer);
