const numbers = [1, 2, 3, 4, 5];

// map() - 배열의 모든 요소를 변환하여 새 배열 반환
const double = numbers.map(num => num * 2);

console.log(numbers);
console.log(double);

//filter() - 조건에 맞는 요소만 포함하는 새 배열 반환
const evens = numbers.filter(num => num % 2 === 0);

console.log(numbers);
console.log(evens);

//reduce() - 배열의 요소를 하나의 값으로 줄이기
const sum = numbers.reduce((total, current) => total + current, 0);

console.log(sum);

//forEach() - 배열의 각 요소에 대해 함수 실행
const fruits = ['사과', '바나나', '오렌지'];

fruits.forEach(fruit => console.log(fruit));

//find() - 조건을 만족하는 첫 번째 요소 반환
const users = [
    {id : 1, name : "김철수"},
    {id : 2, name : "이영희"},
    {id : 3, name : "박민수"}
];

const user = users.find(user => user.id === 2);
console.log(user);

//some() - 하나라도 조건을 만족하면 true 반환
const numbers2 = [1, 2, 3, -1, 4];

const hasNegative = numbers2.some(num => num < 0);
console.log(hasNegative);

//every() - 모든 요소가 조건을 만족하면 true 반환
const users2 = [
    {name : "김철수", age : 25},
    {name : "이영희", age : 30},
    {name : "박민수", age : 18}
];
const allAdults = users.every(user => user.age >= 20);
const allAdults2 = users.every(user => user.age >= 18);

console.log(allAdults);
console.log(allAdults2);

//flatMap() - map() 후 결과를 1레벨 평탄화
const sentences = ['Hello world', 'I love JavaScript'];
const words = sentences.flatMap(sentence => sentence.split(" "));

console.log(words);

//sort() - 배열 요소 정렬
const numbers3 = [3, 2, 4, 1, 5];
numbers3.sort((a, b) => a - b);

console.log(numbers3);

//findIndex() - 조건을 만족하는 첫 번째 요소의 인덱스 반환
const fruits2 = ['사과', '바나나', '오랜지', '포도'];
const index = fruits2.findIndex(fruit => fruit === '오렌지');

console.log(index);