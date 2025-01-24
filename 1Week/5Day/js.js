/**
 * var 같은 경우 글로벌 변수로 가지지만
 * let 같은 경우 글로벌 변수로 가지지않게 하기위해
 * 글로벌 변수를 뜻하는 window.aa 와 같이 window를 사용하지못한다.
 * 그래서 aa 일때는 100이 나오고 window.aa는 undefined가 나온다.
 * 
 */
let aa = 100;

console.log(window.aa);
console.log(aa);

function bb(){
    console.log(window.aa);
    console.log(aa);
};

window.bb();
bb();

const fruits = ["Banana", "Orange", "Apple"];


/**
 * 아래 두개는 같은 행위를 한다.
 */
for(let i of fruits){
    console.log(i);
}

fruits.forEach((i) => console.log(i));