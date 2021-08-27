## 인가(Authorization) 프로세스 구현 - DB 연동

## 개요
DB와 연동하여 자원 및 권한을 설정하고 제엏마으로 **동적 권한** 관리가 가능하도록 한다.

- 설정 클래스 소스에서 권한 관련 코드 제거
  - ```antMatcher("/user").hasRole("USER")```
- 관리자 시스템 구축
  - 회원 관리 : 권한 부여
  - 권한 관리 : 권한 생성, 삭제
  - 자원 관리 : 자원 생성, 삭제, 수정, 권한 매핑
- 권한 계층 구현
  - URL - Url 요청 시 인가 처리
  - Method - 메소드 호출 시 인가 처리
    - Method
    - Pointcut

## Url 방식 - 도메인 관계도
```
Account <- AccountRole -> Role  <- RoleResource -> Resources
```

## 주요 아키텍쳐 이해

- 스프링 시큐리티의 인가처리
```
http.antMatchers("/user").access("hasRole('USER')")
```
- 사용자가 /user 자원에 접근하기 위해서 ROLE_USER 권한이 필요하다
  - 인증정보 (사용자)
  - 요청정보 (자원)
  - 권한정보 (권한)

요청이 들어올 경우 SecurityInterceptor는 3가지의 ```인증, 요청, 권한```정보를 담아 접근 결정 관리자에게 인가처리를 요청한다.

- 인증정보의 경우 SC에서 얻을 수 있다.
- 요청정보는 해당 요청 객체를 생성해 요청 정보를 얻을 수 있다.
- 권한정보는 각각의 자원에 대한 권한 정보는 설정 클래스에서 설정한 정보를 Map 객체에 저장하기에 권한정보가 필요할 경우 Map 객체를 통해 얻을 수 있다.
  - Map 객체는 권한정보를 ```List<ConfigAttribute>``` 타입으로 저장해서 반환해준다.
    ```ExpressionBasedFilterInvocationSecurityMetadataSource.class``` 에서 해당 객체에서 필요한 권한정보를 찾아 반환해준다.

권한정보인 SecurityMatadataSource 를 얻기 위해서는 2가지 방식이 존재한다.
```
SecurityMatadataSource {
  Collection<ConfigAttribute> getAttributes(Object object)
  Collection<ConfigAttribute> getAllConfigAttibutes()
  boolean supports(Class<?> clazz)
}
```

1. Url
   - ```ExpressionBasedFilterInvocationSecurityMetadataSource -> DefaultFilterInvocationSecurityMetadataSource -> FilterInvocationSecurityMetadataSource```  
2. Method
   - ```@RolesAllowed("USER") -> MethodSecurityMetadataSource``` 
   - ```@Secured("ROLE_USER") -> MethodSecurityMetadataSource```
   - ```@PreAuthorize("hasRole('USER')") -> MethodSecurityMetadataSource```
   - ```@PostAuthorize("hasRole('USER')") -> MethodSecurityMetadataSource```
   - ```MapBasedMethodSecurityMetadataSource -> MethodSecurityMetadataSource```