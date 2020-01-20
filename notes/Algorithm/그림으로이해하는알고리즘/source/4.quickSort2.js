function quicksort(arr) {
  if (arr.length <= 1) return arr;

  var pivot = arr[arr.length - 1];
  var left = [];
  var right = [];

  for (var i = 0; i < arr.length - 1; i++) {
    if (arr[i] < pivot) {
      left.push(arr[i]);
    } else {
      right.push(arr[i]);
    }
  }

  return [...quicksort(left), pivot, ...quicksort(right)];
}

console.log(quicksort([11,8,14,3,6,2,7]));
