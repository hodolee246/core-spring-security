# Authentication 프로세스 구현

## AjaxAuthenticationFilter
- AbstractAuthenticationProcessingFilter 상속
- 필터 작동 조건
   - AntPathRequetMatcher("/api/login") 요청정보와 매칭하고 요청 방식이 Ajax 이면 필터가 작동하도록 구현
- AjaxAuthenticationToken 생성하여 AuthenticationManager 에게 전달하여 인증 처리
   - Token 에는 User 정보가 담겨 있음
- Filter 추가
   - ```http.addFilterBefore(UsernamePasswordAuthenticationFilter.class, AjaxAuthenticationFilter())```