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

2. 인증 여부에 따라 로그인/로그아웃 표현
   - ```sec:authorize="isAnonymous()"```
   - ```sec:authorize="isAuthenticated()""```

## WebAuthenticationDetails, AuthenticationDetailsSource

1. webAuthenticationDetails
   - 인증 과정 중 전달된 데이터를 저장
   - Authentication 의 details 속성에 저장
2. AuthenticationDetailsSource
   - WebAuthenticationDetails 객체를 생성

## SimpleUrlAuthenticationFailureHandler, SimpleUrlAuthenticationSuccessHandler

1. SimpleUrlAuthenticationFailureHandler
    - 로그인에 실패하여 UserDetailsService 혹은 AuthenticationProvider Exception 이 발생한 경우 filter 을 통해  SimpleUrlAuthenticationFailureHandler 에게 전달되며 요청을 처리한다.
2. SimpleUrlAuthenticationSuccessHandler
    - 로그인에 성공한 경우 filter 를 통해 SimpleUrlAuthenticationSuccessHandler 이 요청을 받아 처리한다.