```

setTimeout(function, milliseconds); // 일회성 처리

setInterval(function, milliseconds); // 다회성 처리

```

setTimeout은 milliseconds 후에 function을 처리한다는 의미

setInterval는 매 milliseconds 후마다 function을 처리한다는 의미

만약 setInterval 를 중지하고 싶다면 clearInterval 를 통해 중지 가능

--------------------------------------------------------------------------------------------------------

cookie - 정보 중에 개인적으로 가지고있지만 새로고침으로도 안사라져야한다면 쿠키를 통해 반영구적 저장이 가능하다.

다만 보안적인 문제가 존재한다. 

그래서 개인정보 같은 치명적인 정보는 담으면 안되고 간단한 정보정도 담는 것을 추천

또한 만료 시간을 지정하면 시간이 도래하거나 브라우저가 종료 되면 자동으로 소멸된다.

만료 시간을 지정하지않았을 경우 영구히 존재하게된다.

각각 필요한 상황에 따라 맞춰 지정을 하는 것이 중요

ex)

```

document.cookie = "username=John Smith; expires=Thu, 18 Dec 2013 12:00:00 UTC; path=/"; - 만료 시간 지정

document.cookie = "username=John Doe"; - 만료 시간 미지정

document.cookie = "username=; expires=Thu, 01 Jan 1970 00:00:00 UTC; path=/;"; - 강제로 쿠키를 지우고 싶을 경우

```

---------------------------------------------------------------------------------------------------------

```

Arrow Function

const x = (x, y) => x * y

or

const x = (x, y) => {return x * y}

```

왜 우리는 화살표 함수가 나오게 되었고 사용을 해야하는가 =>

우선 예시를 보자면 

```

let obj={
	myVar: 'foo',
  myMeth: function jes(){ //obj가 메모리에 만들어질 때 같이 만들어진다
          console.log(this.myVar); //수행 컨텍스트가 obj
	}
}
obj.myMeth(); // foo

```

일반적으로 다른 언어에서 보는 것과 동일하게 나온다.

그러나 이렇게 작성하면 어떻게 나올까

```

let obj = {
  myVar: 'foo',
  
  myMeth: function jes() { 
    console.log(this.myVar);   //수행 컨텍스트가 obj
 
    setTimeout(function hkd() { //1초 뒤에 Window에 의해 객체가 만들어진다. 소유주가 Window
      console.log(this.myVar); //수행 컨텍스트가 window
    }, 1000);
  }
}
obj.myMeth(); //foo  undefined

```

setTimeout 안에 넣는 것만 추가했을 뿐인데 setTimeout 안의 값이 undefined 으로 바뀐 것을 볼 수 있다.

setTimeout의 실행 주체가 obj가 아니라 window 이기 때문에 그런 것이다.

window를 바라봤을 때 myVar의 값이 없으니 undefined가 나온 것이다.

해결 방법은

```

let obj = {
  myVar: 'foo',
  
  myMeth: function jes() { 
    console.log(this.myVar) ; //수행 컨텍스트가 obj
  
    setTimeout(function hkd() {
      console.log(this.myVar, this);
    }.bind(this), 1000); //수행 컨텍스트가 obj
  }
}
obj.myMeth(); // foo  foo

```

이렇게 작성하면 기대했던 바와 같이 동일하게 출력되는 것을 알 수 있다.

.bind(this) 이걸 통해 this를 obj로 고정한다는 의미이다.

그리고 여기서 화살표 함수를 사용해야하는 이유가 나온다.

```

let obj = {
  myVar: 'foo',
  
  myMeth: function jes() { 
    console.log(this.myVar) ; //수행 컨텍스트가 obj
  
    setTimeout(() => { //화살표 함수, function()객체가 만들어질때 this를 바인딩, bind()한 것처럼 lexical scope을 갖는다
      console.log(this.myVar); //수행 컨텍스트가 obj
    }, 1000);
  }
}
obj.myMeth(); // foo  foo

```

위와같이 동일한 결과 값을 도출한다는 것을 알 수 있다.

위에 bind 한 것처럼 나온다는 것이다.

다만

```

let obj = {
  myVar: 'foo',
  
  myMeth: () =>{ //미리 만들어져 바인딩 되지 않고 호출 시 바인딩 됨
    console.log(this.myVar) ; //수행 컨텍스트가 window
  
    setTimeout(() => {
      console.log(this.myVar); //수행 컨텍스트가 window
    }, 1000);
  }
}
obj.myMeth(); // undefined undefined

```

function jes() 이 부분 까지 화살표 함수로 만들면 안된다.

만약 할 경우 위처럼 둘 다 undefined 가 나오게된다.

화살표 함수는 자신만의 this를 가지지않고 상위 this 그대로 사용하기 때문이다.

그러니 obj가 아닌 window 를 바라보게되고 그 안의 setTimeout도 상위가 window를 바라보기에 똑같이 window를 바라보게 된다.

그 전에는 myMeth에 function을 사용했기 때문에 obj를 바라보고 setTimeout 안에는 화살표 함수이기에 상위인 obj를 바라보게된것이다.

그래서 원하는 바와 같이 나오게된 것이다.

---------------------------------------------------------------------------------------------------------

비동기

비동기를 하게되면 작성한 순서대로 완료가 되지않는다.

먼저 끝난 순서대로 결과 값이 나오기 때문에 조절을 잘 해야한다.

만약 무조건 이 결과 값이 나와야만한다면 기다리게하고 결과가 도출된 후에 진행이 되도록 코드를 작성해야한다는 것이다.

에초에 비동기라는게 동기적으로 처리를 안하겠다는데 어찌 순서대로 처리되길 바라는가?

순서대로 원한다면 비동기로 빠진 것에 함께 묶어 비동기 안에서 순서대로(동기적으로) 처리되길 기다릴 수 밖에...