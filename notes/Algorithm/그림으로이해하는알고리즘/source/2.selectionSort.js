const list = [4, 3, 6, 1, 2];

function selectionSort(list) {
  let array = [];
  let length = list.length;
  for (let i = 0; i < length; i++) {
    let foundNum = findSmallest(list);
    // let foundNum = findBiggest(list);
    let index = list.indexOf(foundNum);
    list = [...list.slice(0, index), ...list.slice(index + 1, list.length)];
    array.push(foundNum);
  }

  return array;
}

function findSmallest(list) {
  let min = Number.MAX_VALUE;

  for (n of list) {
    if (n < min) min = n;
  }
  return min;
}

function findBiggest(list) {
    let max = Number.MIN_VALUE;
  
    for (n of list) {
      if (n > max) max = n;
    }
    return max;
  }

console.log(selectionSort(list));
