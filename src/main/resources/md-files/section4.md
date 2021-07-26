# Authentication 프로세스 구현

## AjaxAuthenticationFilter
- AbstractAuthenticationProcessingFilter 상속
- 필터 작동 조건
   - AntPathRequetMatcher("/api/login") 요청정보와 매칭하고 요청 방식이 Ajax 이면 필터가 작동하도록 구현
- AjaxAuthenticationToken 생성하여 AuthenticationManager 에게 전달하여 인증 처리
   - Token 에는 User 정보가 담겨 있음
- Filter 추가
   - ```http.addFilterBefore(UsernamePasswordAuthenticationFilter.class, AjaxAuthenticationFilter())```

## DSL 로 Config 설정하기
```DSL(Domain-specific language) : 특정한 도메인을 적용하는데 특화된 컴퓨터 언어```
- Custom DSLs
    - AbstractHttpConfigurer
        - 스프링 시큐리티 초기화 설정 클래스
        - 필터, 핸들러, 메서드, 속성 등을 한 곳에 정의하여 처리할 수 있는 편리함 제공
        - ```public void init(H http) throws Exception``` : 초기화
        - ```public void configure(H http)``` : 설정
    - HttpSecurity 의 ```apply(C configurer)``` 메서드 사용