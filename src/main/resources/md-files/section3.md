## PasswordEncoder

- 비밀번호를 안전하게 암호화 하도록 제공
- Spring Security 5.0 이전에는 기본 PasswordEncdoer 가 평문을 지원하는 NoOpPasswordEncoder (현재 Deprecated)

1. 생성
    - PasswordEncoder pe = PasswordEncoderFactories.createDelegatingPasswordEncoder()
    - 여러개의 PasswordEncoder 유형을 선언한 뒤, 상황에 맞게 사용할 수 있도록 지원하는 Encoder
    
2. 암호화 포맷 : {id}encodedPassword
    - 기본 포맷은 Bcrypt
    - 알고리즘 종류는 noop, pdkdf2, sha256...

3. 인터페이스
    - encode() : 암호화
    - matchers() : 패스워드 비교

## 로그아웃 및 화면 보안 처리

1. 로그아웃 방법
    - ```<form>``` 태그를 사용해 POST 요청
    - ```<a>``` 태그를 사용해 GET 요청
        - SecurityContextLogoutHandler 이용