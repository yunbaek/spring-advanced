## 스프링 지원 프록시
- 프록시 팩토리
- 포인트컷, 어드바이스, 어드바이져
  - 포인트컷 : 어디에 부가 기능을 적용할지, 어디에 부가 기능을 적용하지 않을 지 판단하는 필터링 로직. 주로 클래스와 메서드 이름으로 필터링. 이름 그대로 어떤 포인트(Point)에 기능을 적용할 지 하지 않을지 잘라서(cut) 구분
  - 어드바이스 : 프록시가 호출하는 부가 기능. 프록시 로직
  - 어드바이져 : 단순하게 하나의 포링트컷과 하나의 어드바이스를 가지고 있는 것. **포인트컷 1 + 어드바이스 1**


## 빈 후처리기
### 빈 후처리기 - BeanPostProcessor
- 스프링이 빈 저장소에 등록할 목적으로 생성한 객체를 빈 저장소에 등록하기 직전에 도작하고 싶다면 빈 후처리기를 사용.
- 빈을 생성한 후에 무언가를 처리하는 용도로 사용
### 빈 등록 과정
1. 생성: 스프링 빈 대상이 되는 객체를 생성
2. 전달: 생성된 객체를 빈 저장소에 등록하기 직전에 빈 후처리기에 전달
3. 후 처리 작업: 빈 후처리기는 전달된 스프링 빈 객체를 조작하거나 다른 객체로 바꿔치기
4. 등록: 빈 후처리기가 빈을 반환. 전달 된 빈을 그대로 반환하면 해당빈이 등록, 바꿔치기 하면 다른 객체가 빈 저장소에 등록

### BeanPostProcessor interface - spring 제공
- 빈 후처리기를 사용하려면 `BeanPostProcessor` 인터페이스를 구현하고, 스프링 빈으로 등록
- `postProcessBeforeInitialization`: 객체 생성 이후에 `@PostConstruct` 와 같은 초기화가 발생하기 전에 호출되는 포스트 프로세서
- `postProcessAfterInitialization`: 객체 생성 이후에 `@PostConstruct` 와 같은 초기화가 발생한 다음 호출되는 포스트 프로세서  