## 프로젝트 : 스프링부트로 프로젝트
1. SpringBoot & JPA 로 간단한 API 만들기 (게시판 만들기)
  - 도메인 코드 만들기 
  - 테스트 코드 작성 JUnit
  
     1. [PostServiceTest](https://github.com/KangHoyong/Spring-webservice/blob/master/web%20/src/test/java/com/example/web/PostsServiceTest.java#L33) : DTO 테스트 
     2. [PostsRepositoryTest](https://github.com/KangHoyong/Spring-webservice/blob/master/web%20/src/test/java/com/example/web/PostsRepositoryTest.java#L28) : 게시글 테스트 
     3. [WebControllerTest](https://github.com/KangHoyong/Spring-webservice/blob/master/web%20/src/test/java/com/example/web/WeControllerTest.java#L21) : 메인페이지 로딩 테스트 
     
     given : 테스트 기반 환경 구축단계 
      
     when : 테스트 하고자 하는 행위 선언
       
       - Posts 가 DB 에 insert 되는것을 확인하기 위함  
      
     then : 테스트 결과 검증 
        
       - 실제로 DB에 insert 되었는지 확인하기 위해 조회후, 입력된 값 확인 
        
  - Posts
    1. [Posts.java : Entity class 실제 DB의 테이블과 메칭될 클래스 생성](https://github.com/KangHoyong/Spring-JPA/blob/master/web_/src/main/java/com/example/web/posts/Posts.java#L24) 

    2. [Repository.java : Mybatis Dao 부분 DB Layer 접근자](https://github.com/KangHoyong/Spring-JPA/blob/master/web_/src/main/java/com/example/web/posts/PostsRepository.java#L10)

  - BaseTimeEntity
    1. [BaseTimeEntity클래스는 모든 Entity들의 상위 클래스가 되어 Entity들의 createdDate, modifiedDate를 자동으로 관리하는 역할입니다.](https://github.com/KangHoyong/Spring-JPA/blob/master/web_/src/main/java/com/example/web/BaseTimeEntity.java) 

  - PostsService 
    1. [Service 메소드도 생성해서 트랜잭션 관리](https://github.com/KangHoyong/Spring-JPA/blob/master/web_/src/main/java/com/example/web/service/PostsService.java#L23)
     
  - 웹 헨들러 사용 
    1. [handlebars-spring-boot-starter](https://github.com/allegro/handlebars-spring-boot-starter): 웹 헨들러 사용 
  
 
## Introduction
스프링 부트로더 공부 
1. 게시판 만들기 
 * 글등록 
 * 게시글 리스트 화면 출력 ![KakaoTalk_Photo_2019-05-12-17-45-08](https://user-images.githubusercontent.com/9815703/57579885-ba145580-74dd-11e9-9caf-0443951eec3a.png)
 * 게시글 수정
 * 게시글 삭제
 
2. 게시판 댓글 
 * 댓글 등록 
 * 댓글 리스트 출력 
 

## 개발환경 
[개발환경 build.gradle](https://github.com/KangHoyong/Spring-JPA/blob/master/web_/build.gradle)


## Developer
[@KangHoyong](https://github.com/KangHoyong)


## 참고 사이트 
https://jojoldu.tistory.com/251?category=635883
