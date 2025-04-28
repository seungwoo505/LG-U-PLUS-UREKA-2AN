프로젝트를 진행할 때 DB에 직접 접근을 하거나 API KEY 그리고 보안 인증 키 등등 필요한 경우가 있는데 js 또는 jsx 코드 안에 작성할 경우
브라우저에서 개발자모드로 코드를 확인할 수 있어 보안에 취약해질 수 있다는 문제가 있다.

그런 경우에는 .env 파일을 생성하여 파일 안에 보안에 중요한 부분을 넣고 js나 jsx 코드에 불러오는 형식으로 하면 키 값이 노출될 일이 없다.

## 네이밍 규칙

Vite에서 환경 변수를 클라이언트 코드에서 사용하려면 반드시 `VITE_` 접두사를 붙여야 한다.

- `VITE_API_KEY=abcdef123456` (O)
- `API_KEY=abcdef123456` (X - 클라이언트 코드에서 접근 불가)

## 환경 별 .env 파일

다양한 환경에 따라 다른 `.env`파일을 사용할 수 있다.

- `.env` - 기본 파일, 모든 환경에서 로드
- `.env.local` - 로컬 환경 변수, git에서 무시해야 함
- `.env.development` - 개발 환경
- `.env.production` - 프로덕션 환경
- `.env.test` - 테스트 환경

## 환경 변수 사용하기

```

// Weather.jsx 예시
import React, { useEffect } from 'react'

const Weather = () => {
  useEffect(() => {
// 환경 변수 사용
    const apiKey = import.meta.env.VITE_API_KEY;
    const apiUrl = import.meta.env.VITE_API_URL;

    console.log('API Key:', apiKey);
    console.log('API URL:', apiUrl);

// API 호출 등의 로직...
  }, []);

  return <div>날씨 API 활용하기</div>
}

export default Weather

```

## 보안 참고사항

- `.env.local`, `.env.*.local` 파일은 `.gitignore`에 추가하여 API 키와 같은 민감한 정보가 저장소에 공개되지 않도록 해야 합니다.
- 브라우저 코드에서 사용되는 모든 환경 변수는 최종 빌드에 포함되므로 정말 비밀로 유지해야 하는 값은 서버 측에서만 사용하세요.
