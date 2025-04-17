function a(){
    for(let i = 0; i < 10000000000; i++){
    }
    return 1;
}

function b(){
    return a() + 1;
}

function c(){
    return b() + 1;
}

console.log('시작');
const result = c();
console.log("결과 : ", result);

function execute(){
    console.log("111111");
    setTimeout(() => {console.log("222222");}, 1000);

    console.log("3333333");
}

execute();

const arr1 = [1, 2, 3];
const arr2 = new Array(arr1.length).fill(0);

console.log(arr1);
console.log(arr2);

const obj1 = {a : 1, b : 2};
const obj2 = new Object(obj1);
console.log(obj1);
console.log(obj2);

const num1 = 1;
const num2 = new Number(5);

console.log(typeof num1);
console.log(num2);

const number = 1;
console.log(number.toLocaleString());

console.log(Number.MAX_SAFE_INTEGER);
console.log(Number.MAX_VALUE);
console.log(Number.MIN_SAFE_INTEGER);
console.log(Math.round(1.5));
console.log(Math.floor(1.5));
console.log(Math.ceil(1.5));
console.log(Math.random());

const str = '문자열';
console.log(str.length);

const str2 = {
    0 : '문',
    1 : '자',
    2 : '열',
    len : 3
};

console.log('str : ', str2.len);