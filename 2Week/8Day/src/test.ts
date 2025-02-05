import { Name } from "ajv";

interface Shape{
    getArea : () => number
}

interface A{

}

//interface를 상속하고싶을 때는 implements
class Rectangle implements Shape, B{
    public constructor(protected readonly width:number, protected readonly height:number){}

    public getArea():number {
        return this.width * this.height;
    };

    public toString():string {
        return `Rectangle[width : ${this.width}, height : ${this.height}]`;
    }
}

const myRect = new Rectangle(10, 20);
console.log(myRect.getArea());

//인터페이스끼리 상속하고싶을 때는 extends를 사용하면된다.
interface B extends A{

}

//class를 상속하고싶으면 extends
class Square extends Rectangle{
    public constructor(width:number){
        super(width, width);
    }

    //override : 상위 클래스의 메소드를 서브 클래스에서 내용을 다르게하고싶을 때 사용
    public override toString():string {
        return `Square[width : ${this.width}]`;
    }
}

const myRect2 = new Square(10);
console.log(myRect2.getArea());
console.log(myRect2.toString());

/**
 * abstract
 * 상위 개념이 가지고있는 것들을
 * 하위에서 구체화하는 것
 * 
 * 예를 들어 동물이라는 개념에서
 * 조류, 포유류, 어류 등등의 하위 개념이 존재
 * 더 나아가 포유류 중에 인간, 고양이, 강아지 등등이 존재
 * 또한 인간 중에서도 이승우, 전은수, 마재형이 존재한다.
 * 
 * 이처럼 상위 개념에서 구현하기 어려운 것들이 있다.
 * 그런 것들을 개념적으로 가지고만있고 하위에서 구체화하는 것이다.
*/ 

/**
 * 제네릭을 사용하는 이유는
 * 타입을 유동적으로 하고 싶을 때 사용
 */
class NameValue<T>{
    private _value:T | undefined;

    constructor(private name : string){}

    public setValue(value : T){
        this._value = value;
    }

    public getValue():T|undefined{
        return this._value;
    }

    public toString():string{
        return `${this.name} : ${this._value}`;
    }
}

let value = new NameValue<number>('myNumber');

value.setValue(10);
console.log(value.getValue());
console.log(value.toString());

class A2<T>{
    constructor(private a:T){}

    public toString():string{
        return a+'';
    }
}

type Wrapper<T> = { value : T};

const a:Wrapper<A2<number>>={value : new A2(10)};

console.log(a);

//타입을 지정안했을 경우 기본 타입을 지정할 수 있다.
class NameValue2<T=string>{
    private _value:T | undefined;

    constructor(private name : string){}

    public setValue(value : T){
        this._value = value;
    }

    public getValue():T|undefined{
        return this._value;
    }

    public toString():string{
        return `${this.name} : ${this._value}`;
    }
}

let a2 = new NameValue2('myNumber');
a2.setValue('myValue');
console.log(a2.toString());

interface Point{
    x:number,
    y:number
};

//전체가 아닌 부분적으로만 사용하고싶을 때 사용
let a3:Partial<Point>={};
a3.x=10;
//a3.z=10; //이건 벗어나는 것이라 에러

interface Car{
    make : string;
    model : string;
    mileage? : number;
}

//모든 속성을 필수로 작성해야할 때 사용
let myCar:Required<Car>={
    make : 'Ford',
    model : 'Focus',
    mileage : 12000 // Required으로 선언 시 선택으로 만들어도 무조건 선언되야함
}

const nameAgeMap : Record<string, number> = {
    'Alice' : 21,
    'Bob' : 25,

}

console.log(nameAgeMap);

interface Person {
    name : string;
    age : number;
    location? : string;
}

//Omit은 특정 유형을 제거
const bob: Omit<Person, 'age' | 'location'> = {
    name : 'Bob',
    //age : 20, // age는 제거되었으니 할당 불가
    //location : 'paju'// location는 제거되었으니 할당 불가
};

//Pick은 특정 유형을 제외하고 제거
const bob2: Pick<Person, 'name'> = {
    name : 'Bob',
    //age : 20, // age는 제거되었으니 할당 불가
    //location : 'paju'// location는 제거되었으니 할당 불가
};

type Primitive = string | number | boolean;

//Exclude은 타입을 제거한다.
const value2: Exclude<Primitive, string> = true; //string을 제외한 나머지 타입만 허용

type PointGenerator = () => {x : number, y : number};

//리턴 값만 따른다는 의미 즉 x, y의 타입을 지정된 것.
const point : ReturnType<PointGenerator> = {
    x : 10,
    y : 20
};

type PointGenerator2 = (p : {x : number, y : number}) => void;

//파라미터 값만 따른다는 의미 즉 x, y의 타입을 지정된 것.
//파라미터가 여러개를 가질 수 있으니 그 중 몇번째를 따를 것인지 선택해야함
const point2 : Parameters<PointGenerator2>[0] = {
    x : 10,
    y : 20
};

interface Person2 {
    name: string;
    age: number;
}

//Readonly는 처음 할당된 후에는 수정할 수 없다.
const person2: Readonly<Person2> = {
    name: "Dylan",
    age: 35,
};
//person2.name = 'Israel'; //Readonly이기 때문에 수정 불가

interface Person3 {
    name : string;
    age : number
};

//keyof 는 해당하는 객체를 유니온하여 혀용하는 타입으로 생성
function printPersonProperty(person : Person3, property : keyof Person3){
    console.log(`Printing person property ${property} : ${person[property]}`);
}

let p = {
    name : "lsw",
    age : 20
};

printPersonProperty(p, "name");
//printPersonProperty(p, "names"); //Person3에 names가 없기 때문에 에러

type StringMap = { [key: string]: unknown };

// key 값이 string이면 자유롭게 작성 가능
function createStringPair(property: keyof StringMap, value: string): StringMap {
  return { [property]: value };
}

/**
 * "strictNullChecks": true를 할 경우
 * undefined의 타입을 지정해야한다. 
 */

interface House {
    sqft : number;
    yard? : {
        sqft:number
    };
};

function Home(house : House){
    const yardSize = house.yard?.sqft;
    if(yardSize===undefined) console.log("No yard");
    else console.log(`yard is ${yardSize} sqft`);
}

let home:House={sqft:500};

Home(home);

//??를 사용하게되면 null 또는 undefined 일 땐 Not Available, 그 외엔 기본이 나온다.
function printMileage(mileage : number | null | undefined){
    console.log(`Mileage : ${mileage ?? 'Not Available'}`);
}

printMileage(null); // Not Available
printMileage(0); // 0

/**
 * getValue()의 리턴 값이 undefined 일 수 있기 때문에 length 사용이 불가능하다.
 * 그러나 !는 그것을 무시한다.
 * 
 * 다만 오류는 여전히 발생하기에 undefined가 발생안하는 것이 확실할 때 사용하는 것을 추천
 * 
 * 의문 : ? 를 쓰면 value3가 유효한지 체크를 하는데 !를 왜 사용하는지 의문 -> 답 : 개발 과정에서 오류를 내기 위해
 */
function getValue() : string | undefined {
    return "test";
}

let value3 = getValue();
console.log('value length : ', value3!.length);

//배열이 비어있으면 undefined가 나온다.
//그걸 막는걸 "noUncheckedIndexedAccess": true 이다.
// 왜 오류가 발생 안되는지 의문
const json = `[1, 2, 3]`;
let array : number[] =JSON.parse(json);
let value4 = array[0];
console.log(value4);