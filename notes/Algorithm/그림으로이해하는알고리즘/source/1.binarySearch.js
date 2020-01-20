const list = [1, 3, 5, 7, 9];

function bs(list, num) {
  list.sort();

  let low = 0;
  let high = list.length - 1;

  let mid, guess;
  while (low <= high) {
    mid = Math.floor((low + high) / 2);
    guess = list[mid];
    if (guess === num) {
      return mid;
    } else if (guess > num) {
      high = mid - 1;
    } else if (guess < num) {
      low = mid + 1;
    }
  }
  return "none";
}

console.log(bs(list, 3));
