# git

처음 시작할 때 init을 하여 초기화

```

git init

```

github의 저장소를 경유지로 지정

```

git remote add origin (github주소)

```

github 저장소 안에 있는 모든 파일을 가져온다.

```

git clone (github주소) .

```

만약 전역으로 처리를 하려면 --global

변경을 저장하는 이메일괴 이름 저장

```

git config user.email zoozoo1302@gmail.com
git config user.name seungwoo

```

git의 로그를 확인할 수 있다.

oneline은 한줄로 요약해서 보여준다.

branch는 모든 branches를 표시 ( branch가 없을 시에는 기준 branch만 표시 )

graph는 가지치기를 하듯이 보기 편하게 만들어준다.

```

git log --oneline --branches --graph

```

add를 통해 스테이션(로컬 저장소)에 등록(저장되지않음)

```

git add 파일명

```

commit 통해 스테이션(로컬 저장소)에 저장

```

git commit -m "메시지"

```

push를 통해 원격 저장소(github)에 저장 (처음 할 때는 아이디 비번 입력(또는 Token))

```

git push origin main

```

branch 만 적으면 모든 브랜치 명이 표시

이름과 함께 지정시 그 명이 생성

```

git branch 이름

```

해당되는 branch 또는 commit된 순간으로 이동

commit은 권장하지않고 branch를 새로 생성하여 분리하는 것을 추천

```

git checkout (branch명/commit해쉬코드)

```


메인을 두고 거기에서 받아올 대상을 지정하여 변경 대상을 탐색 후 변경

만약 충돌(서로 수정이 되어 어떤 것으로 변경이 될지 명확하지않을 경우)이 날 경우 직접 수정을 해야함

```
git merge (병합할 brach명)

```