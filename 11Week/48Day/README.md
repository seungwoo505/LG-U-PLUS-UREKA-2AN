# Emmet 뭄법

## 자식 요소 >

```

//div>ul>li

<div>
    <ul>
        <li></li>
    </ul>
</div>

```

## 형제 요소 +

```

//div>p+span

<div>
    <p></p>
    <span></span>
</div>

```

## 올라가기 ^

```

//div>ul>li^p+a

<div>
    <ul>
        <li></li>
    </ul>
    <p></p>
    <a></a>
</div>

//div>ul>li^^div

<div>
    <ul>
        <li></li>
    </ul>
</div>
<div>
</div>

```

## 반복하기 \*

```

//div>ul>li*5

<div>
    <ul>
        <li></li>
        <li></li>
        <li></li>
    </ul>
</div>

```

## 그룹화 ()

```

//div>(header>ul>li*2)+footer

<div>
    <header>
        <ul>
          <li></li>
          <li></li>
        </ul>
    </header>
    <footer></footer>
</div>

```

## 클래스 .class

```

//div.container

<div class="container">
</div>

```

## 아이디 #id

```

//span#hello

<span id="hello">
</span>

```

## 속성 [attr]

```

//td[title="bye" colspan=5]

<td title="bye" colspan="5">
</td>

```

## 넘버링 $ (순서대로 시작) / $@ (@숫자부터 시작)

```

//ul>li.item$*5

<ul>
    <li class="item1"></li>
    <li class="item2"></li>
    <li class="item3"></li>
    <li class="item4"></li>
    <li class="item5"></li>
</ul>

//ul>li.item$@5*5

<ul>
    <li class="item5"></li>
    <li class="item6"></li>
    <li class="item7"></li>
    <li class="item8"></li>
    <li class="item9"></li>
</ul>

```

## 텍스트 {}

```

//.fruit{banana}

<div class="fruit">banana</div>

//.container>ul.list>li.list-item*5>a{list$}

<div class="container">
    <ul class="list">
      <li class="list-item"><a href="">list1</a></li>
      <li class="list-item"><a href="">list2</a></li>
      <li class="list-item"><a href="">list3</a></li>
      <li class="list-item"><a href="">list4</a></li>
      <li class="list-item"><a href="">list5</a></li>
    </ul>
</div>

```
