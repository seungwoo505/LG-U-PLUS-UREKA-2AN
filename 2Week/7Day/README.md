Method

--------------------------------------------------------

forEach는 요소마다 한번씩 함수를 호출된다.

다만, return 되는 값은 없다.

매개변수로는 value, index, array

--------------------------------------------------------

map은 각 요소에 함수를 호출하며 새로운 배열을 생성한다.

매개변수로는 value, index, array

원본은 변경되지않고 새로운 배열에 저장이 된다.

--------------------------------------------------------

flatMap은 map과 유사하다. 다른 점은 평면으로 만들고 그다음 배열에 넣는다.

```
const arr = [1, 2, 3];

/* map() */
const mapArr = arr.map((num) => [num, num * 2]);
console.log(mapArr); // map 리턴값 : [[1, 2], [2, 4], [3, 6]]

/* flatMap() */
const flatMapArr = arr.flatMap((num) => [num, num * 2]);
console.log(flatMapArr); // flatMap 리턴값 : [1, 2, 2, 4, 3, 6]

```

이처럼 map을 이용할 경우 return 값 그대로 가져가며

flatMap은 배열을 푼 다음 다시 넣는다고 보면된다.

--------------------------------------------------------

filter는 boolean 값을 받으며

true인 값만 받는다.

```
const numbers = [45, 4, 9, 16, 25];
const over18 = numbers.filter(myFunction);

function myFunction(value, index, array) {
  return value > 18;
}

```

예를 들어 위 예시의 경우 18보다 큰 경우만 통과되어 over18에 저장된다.

--------------------------------------------------------

reduce는 sum 같은 것이라 보면된다.

```
const numbers = [45, 4, 9, 16, 25];
let sum = numbers.reduce(myFunction);

function myFunction(total, value, index, array) {
  return total + value;
}

```

sum의 값이 45 + 4 + 9 + 16 + 25와 같다(99)
