const numbers = [1, 2, 3, 4, 5];

const double = numbers.map(num => num \* 2); -> [2, 4, 6, 8, 10]

const evens = numbers.filter(num => num % 2 === 0); -> [2, 4]

const sum = numbers.reduce((total, current) => total + current, 0); -> 15 (1 + 2 + 3 + 4 + 5의 결과)

const fruits = ['사과', '바나나', '오렌지'];

fruits.forEach(fruit => console.log(fruit)); -> 사과 \n 바나나 \n 오렌지 \n

const users = [
{id : 1, name : "김철수"},
{id : 2, name : "이영희"},
{id : 3, name : "박민수"}
];

const user = users.find(user => user.id === 2); -> {id : 2, name : "이영희"}

const numbers2 = [1, 2, 3, -1, 4];

const hasNegative = numbers2.some(num => num < 0); -> true (-1 이 있기 때문에 true (or과 같다))

const users2 = [
{name : "김철수", age : 25},
{name : "이영희", age : 30},
{name : "박민수", age : 18}
];
const allAdults = users.every(user => user.age >= 20); -> false (18이 false이기 때문에 (AND와 같다))
const allAdults2 = users.every(user => user.age >= 18); -> true (전부 true)

const sentences = ['Hello world', 'I love JavaScript'];
const words = sentences.flatMap(sentence => sentence.split(" ")); -> [ 'Hello', 'world', 'I', 'love', 'JavaScript' ]

const numbers3 = [3, 2, 4, 1, 5];
numbers3.sort((a, b) => a - b); -> [ 1, 2, 3, 4, 5 ] (오름차순)
numbers3.sort((a, b) => b - a); -> [ 5, 4, 3, 2, 1 ] (내림차순)

const fruits2 = ['사과', '바나나', '오렌지', '포도'];
const index = fruits2.findIndex(fruit => fruit === '오렌지'); - > 2
const index = fruits2.findIndex(fruit => fruit === '수박'); - > -1
