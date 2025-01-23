console.log("자바스크립트");

// window는 생략 가능 => alert(); (이렇게 작성해도 됨)
window.alert("1번 작동");
alert("2번 작동");

document.write("자바스크립트");
document.getElementById('myTitle').innerHTML = "자바스크립트";
window.print();

let x, y, z;
x = 5;
y = 6;
z = x + y;

console.log(x, y, z);

console.log("John" + " " + "Doe");

/*
    선언을 안해도 정상적으로 돌아가나
    선언을 하는게 바람직한 코드
*/
x = 5;
y = 6;
z = x + y;
console.log(z);