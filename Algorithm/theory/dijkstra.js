let number = 6;
let INF = 10000000;

let a = [
  [0, 2, 5, 1, INF, INF],
  [2, 0, 3, 2, INF, INF],
  [5, 3, 0, 3, 1, 5],
  [1, 2, 3, 0, 1, INF],
  [INF, INF, 1, 2, 0, 2],
  [INF, INF, 5, INF, 2, 0]
];

let v = Array(6); // 방문한 노드 
let d = Array(6); // 거리

function getSmallIndex() {
  let min = INF;
  let index = 0;
  for (let i = 0; i < number; i++) {
    if (d[i] < min && !v[i]) {
      min = d[i];
      index = i;
    }
  }
  return index;
}

function dijkstra(start) {
  for (let i = 0; i < number; i++) {
    d[i] = a[start][i];
  }
  v[start] = true;
  for (let i = 0; i < number - 2; i++) {
    let current = getSmallIndex();
    v[current] = true;
    for (let j = 0; j < 6; j++) {
      if (!v[j]) {
        if (d[current] + a[current][j] < d[j]) {
          d[j] = d[current] + a[current][j];
        }
      }
    }
  }
}

function main() {
  dijkstra(0);
  let result = "";
  for (let i = 0; i < number; i++) {
    result += " " + d[i];
  }
  console.log(result);
}

main();
