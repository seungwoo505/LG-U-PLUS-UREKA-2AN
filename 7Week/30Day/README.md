# XSS(Cross Site Script)

게시글, 리뷰 등등 유저가 사용할 수 있는 공간에서 해커가 의도적으로 스크립트를 심는 해킹 기법

```

<script>alert('XSS');</script>

```

위와 같이 해당 문구를 택스트 파일로 담는다.

js에서 innerHTML로 텍스트를 읽는다면 태그가 html로 읽어 동작하게된다.

그래서 innerText로 읽으면 해결은 가능하지만

```

let reviewListDiv = `<ul>`;
reviewListDiv += reviews.map((item) => `<li>${item.review}</li>`).join("");
reviewListDiv += `</ul>`;
document.getElementById("commentModalBody").innerHTML = reviewListDiv;

```

위와같이 읽어야한다면 innerHTML로 읽어야한다는 것이다.

따라서 xss에 대해서는 환경에 따라 고민을 다르게 생각해야할거같다.

# 미니 프로젝트

페어랑 같이 주제 및 프로젝트 파일을 만들었다.(공동 파일)

그래도 말이 통하는 친구여서 다행이다.