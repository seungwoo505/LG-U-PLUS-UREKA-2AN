"use strict";
// 타입스크립트는 변수 명 옆에 타입 명 지정
// 타입을 안적어도 들어가는 값이 무엇인지 파악하고 자동으로 String으로 타입이 지정됨
//다만 개발자가 좀 더 파악하기 쉽게하기위해 명시하는게 좋음
let firstName = "이승우";
// 타입이 다르기 때문에 사용 불가
//firstName = 33;
console.log(firstName);
/**
 * json의 경우 보통 통신 후에
 * 값을 받는 용도로 사용이 되는데
 * 어떤 값이 들어올지 알 수 없기 때문에
 * any 타입으로 받아드린다.
 */
const json = JSON.parse("55");
console.log(typeof json); // "55"를 파싱해서 string 값으로 예상이 되나 실제로는 number
//any 타입은 모든 타입을 허용한다. <- 타입 검사 비활성화
//타입스크립트 특성이 타입을 명시하여 타입 오류를 최대한 배제하는 것이 목표이기에 any를 사용하는 것은 지양해야한다.
let u = true;
/**
 * any의 경우 모든 타입을 허용하고 자유롭게 조작이 가능한데
 * 그렇기에 TS를 사용하는 의미를 상실시킨다.
 *
 * 그래서 좀 더 안전한 unknown 를 사용하는 것을 추천한다.
 *
 * unknown는 any와 동일하게 어떤 타입이든 할당을 할 수 있지만, 바로 사용할 수 없다.
 * 반드시 타입 검사를 거쳐야 사용이 가능하다.
 *
 * 즉 어떤 값이 올지모르지만 개발자가 원하는 결과 값이 있으니 그 타입일 때 동작하게 만드는 것이다.
 */
//let u:unknown = true;
/**
 * never은 사용안한다는 의미
 *
 * 잘 사용하지않음 <- 정의를 안하면 되니까 굳이 never 까지 사용할 이유가 많이 있지않음
 *
 * 고급 제네릭에서 사용되기도 한다.
 */
//let u:never = true;
/**
 * 또한 자바스크립트에서는 undefined와 null 또한 하나의 타입으로 보기 때문에
 * 타입스크립트의 변수에 타입 명으로 지정핧 수 있다.
 */
u = "string";
Math.round(u);
const names = [];
//string 타입을 넣을려고하기 때문에 저장됨
names.push("Dylan");
//number 타입을 넣을려고하기 때문에 에러
//names.push(3);
//배열이 변경되는 것을 막기위해 readonly 사용하면 변경이 아에안됨
const names2 = ["lsw"];
//readonly 이기 때문에 넣지못함
//names2.push("Dylan");
//튜플이란 길이와 인덱스에 따른 타입이 정의된 배열
let ourTuple;
//지정된 값 개수 이상을 넣거나 타입에 맞게 배치를 안할 경우 에러
ourTuple = [5, false, 'string'];
/**
 * 그래프는 x, y 의 값이 있을 것이다.
 * 그런데 graph의 몇번째 인덱스가 x인지 y인지 알 수가 없다.
 * 그래서 의미는 없지만 타입 명 앞에 표시를 하여 이게 해당하는 것이 무엇인지 파악하여 작성할 수 있게 도와준다.
 */
const graph = [55.2, 41.3];
const [, y] = graph;
console.log(y);
const car = {
    type: "Toyota",
    model: "Corolla",
    year: 2009
};
//car.type = 2; //car.type의 타입이 string이기 때문에 number 타입인 2는 에러
//car.mileage = 2000; // car에 들어갈 수 있는 object는 type, model, year 이기 때문에 mileage는 에러
/**
 * [index:string] 을 사용하면 string 타입으로 작성된 index는 무엇이든 상관없다는 의미이다.
 * 그리고 value 값은 number 타입
 */
const nameAgeMap = {};
nameAgeMap.mileage = 2000; //car는 타입이 없어 사용이 불가능 했지만 nameAgeMap의 경우에는 상관없이 사용이 가능하다.
//nameAgeMap.Mark = "test"; //index의 타입을 맞췄으나 value 값이 number가 아닌 string이기 때문에 에러
/**
 * 타입으로는 string, numeric
 *
 * 기본적으로 0부터 차례대로 증가하며 값을 배정 시 처음에는 0에서 증가하다가 배정한 값이 있으면 그 값을 넣고 그 다음은 그 값이에서 증가를한다.
 * string 타입이면 다음 값은 필수로 입력을 해줘야한다. (증가할 수 없기 때문 -> 다만 입력받기 전의 값들은 0부터 증가되어 할당된다.)
 */
var CardinalDirections;
(function (CardinalDirections) {
    CardinalDirections[CardinalDirections["North"] = 0] = "North";
    CardinalDirections[CardinalDirections["East"] = 3] = "East";
    CardinalDirections[CardinalDirections["South"] = 4] = "South";
    CardinalDirections["West"] = "test";
})(CardinalDirections || (CardinalDirections = {}));
;
let currentDirection = CardinalDirections.North; //이전에 할당된 값이 없기 때문에 0으로 인식된다.
console.log(CardinalDirections);
console.log(currentDirection);
const rectangle = {
    height: 20,
    width: 10
};
const coloredRectangle = {
    height: 20,
    width: 10,
    color: 'red'
};
console.log(rectangle);
console.log(coloredRectangle);
/**
 * function의 매개변수 중 사용할 수도 있고 사용안할수도 있는 매개변수가 있다면 매개변수 명 뒤에 ?를 붙일 수 있다.
 * ?를 안붙였을 때와 다르게 에러는 발생되지는않지만 b의 값이 undefined이기 때문에 정상적이지못한 결과 값이 나올 수 있기때문에
 * (b || 0)와 같이 b가 undefined일 때를 대비해둬야한다.
 */
function getTime(a, b) {
    return a * (b || 0);
}
console.log(getTime(1, 2));
/**
 * 값을 미리 지정할 수도 있다.
 * b를 지정하지않을 경우 10의 값을 할당한다.
 *
 * 이러면 b의 값이 undefined일 경우를 고려하지않아도되기에
 * 미리 할당하는 것을 추천
 */
function getTime2(a, b = 10) {
    return a * b;
}
console.log(getTime2(1));
/**
 * 매개변수를 받는 것을 Object를 받고 싶을 때 사용할 수 있다.
 * 만약 매개변수 중 일부만 이용하고 싶으면 Object 값 중 일부를 선택하여 지정하면된다.
 */
function divide({ dividend, divisor }) {
    return dividend / divisor;
}
function divide2({ divisor }) {
    return divisor;
}
const divObj = {
    dividend: 100,
    divisor: 2
};
console.log(divide(divObj));
console.log("divide2 : ", divide2(divObj));
//a, b는 동일하고 3번째 이후로 계속 받고 싶을 때 ...를 통해 3번째 매개변수부터 묶어 리스트에 넣는다.
function add(a, b, ...rest) {
    return a + b + rest.reduce((p, c) => p + c, 0);
}
console.log(add(1, 2, 3, 4, 5));
const negateFunction = (value) => value * -1;
console.log(negateFunction(10));
let x = "hello";
/**
 * as, <>를 통해 형변환 가능(표현 방법만 다를뿐 전부 동일한 기능)
 * 다만 가지고있는 값이 변환하려는 타입과 다르면 형변환이 이루어지지않는다.
 * x = 10
 * 이건 number 타입 이기에 string으로 변환이 안되기에 undefined가 나온다.
 *
 * 다만 tsx 파일에서는 <>를 사용할 수 없다.
 *
 * 즉, as 를 사용하는게 좋다.
 */
console.log(x.length);
console.log(x.length);
class Person {
    //생성자 new 키워드와 함께 호출시 이게 호출된다.
    constructor(name, age) {
        this.name = name;
        this.age = age;
    }
    getName() {
        return this.name;
    }
}
const person = new Person('lsw', 20);
//person.name = "Jane"; //private 이기 때문에 접근 불가
person.age = 30;
console.log(person);
class Person2 {
    //생성자 new 키워드와 함께 호출시 이게 호출된다.
    constructor(name, age) {
        this.name = name;
        this.age = age;
    }
    getName() {
        return this.name;
    }
}
const person2 = new Person2('lsw', 20);
//person.name = "Jane"; //private 이기 때문에 접근 불가
//person2.age = 30; //private 이기 때문에 접근 불가
console.log(person2.getName()); // private 이기 때문에 접근이 불가능하나 getName을 통해 우회하여 접근 가능
