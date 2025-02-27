git pull을 하면 github에 저장되어있는것을 내부 저장소로 다운(해당 브렌치 명에 들어있는 것을 다운)

```

git pull origin (branch명)

```

이전 시간에 배운 checkout과 유사하지만

checkout은 commit한 시간으로 되돌릴수있는데 그 점이 보안에 취약하기 때문에

그 부분을 막은 switch를 권장

```

git switch (branch 명)

```

태그 생성(릴리즈를 생성해야할 때 사용 / 실제 배포할 경우 버전을 표시하여 따로 표기)

```
//현재 브랜치의 최신 커밋
git tag v1.0.0

git tag v1.0.0 (commit 해시코드)

```

태그를 github에 등록하는 방법

```
// 단일
git push origin tag-name

//전체
git push --tags

```

reset / rebase / revert 는 실무에서 잘 사용하지않음

revert는 취소를 하더라도 이력은 남기 때문에 사용할 경우 revert를 권장

```

git revert (commit 해시코드)

```