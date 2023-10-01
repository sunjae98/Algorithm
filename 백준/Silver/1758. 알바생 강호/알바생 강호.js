const readFileSyncAddress = "/dev/stdin"; // 백준 제출
//const readFileSyncAddress = "Sunjae/예제.txt"; // VScode 확인

const fs = require("fs");

// input에 저장
const [n, ...input] = fs
  .readFileSync(readFileSyncAddress)
  .toString()
  .trim()
  .split("\n")
  .map(Number);

input.sort((a, b) => b - a);

let tip = 0;
let give = 0;
for (let i = 0; i < n; i++) {
  give = input[i] - i;
  if (give > 0) tip += parseInt(give);
  else break;
}

console.log(tip);
