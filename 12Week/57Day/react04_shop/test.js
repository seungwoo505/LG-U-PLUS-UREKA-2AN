// function execute() {
//   console.log('1111')
//   setTimeout(() => {
//     console.log('2222')
//   }, 1000)
//   console.log('3333')
// }
// execute()

const arr1 = [1, 2, 3]
const arr2 = new Array(arr1.length).fill(0)

console.log(arr1)
console.log(arr2)

const obj1 = { a: 1, b: 2 }
const obj2 = new Object(obj1)
console.log(obj1)
console.log(obj2)

const num = 1
const num2 = new Number(5)
console.log(typeof num)
console.log(num2)

// const str1 = '문자'

const str = '문자열'
console.log(str.length) //
const str2 = {
  0: '문',
  1: '자',
  2: '열',
  length: 3,
}
console.log('str2 ', str2[0])

const number = 100000000
console.log(number.toLocaleString()) // 1,000,000;

console.log(Number.MAX_SAFE_INTEGER) // 9007199254740991;
console.log(Number.MIN_SAFE_INTEGER) // 9007199254740991;
console.log(Math.round(1.5))
console.log(Math.floor(1.5))
console.log(Math.ceil(1.5))
console.log(Math.random()) // 0.123456789
