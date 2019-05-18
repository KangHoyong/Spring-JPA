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
        
  - [PostsDto 구현](https://github.com/KangHoyong/Spring-webservice/tree/master/web%20/src/main/java/com/example/web/postsDto) 
  
  - [PostsService 구현](https://github.com/KangHoyong/Spring-webservice/blob/master/web%20/src/main/java/com/example/web/service/PostsService.java#L23)
  
  - Postman + 웹 콘솔로 검증 
     - DB : local환경에선 DB로 H2를 사용 H2 DB를 관리할 수 있는 웹 클라이언트 접속하여 사용 
     
  - [생성시간 / 수정시간 자동화 - JPA Auditing](hhttps://github.com/KangHoyong/Spring-webservice/blob/master/web%20/src/main/java/com/example/web/BaseTimeEntity.java) 
     - 매번 DB에 insert하기전, update 하기전에 날짜 데이터를 등록 / 수정 하는 코드 
        
  - [handlebars-spring-boot-starter](https://github.com/allegro/handlebars-spring-boot-starter): 웹 헨들러 사용 
  
  - [부트스트랩](https://getbootstrap.com) : 프론트엔드 라이브러리 다운받아서 진행 CDN 이용하여 작성 안함 CDN서버 폭파하면 같이 망함!!
  * Front-End 영역
    * [Main.js 등록](https://github.com/KangHoyong/Spring-webservice/blob/master/web%20/src/main/resources/static/js/main.js#L1)
    * [Posts.js 수정 삭제 목록](https://github.com/KangHoyong/Spring-webservice/blob/master/web%20/src/main/resources/static/js/post.js#L4)
    * [Posts-Modal 영역](https://github.com/KangHoyong/Spring-webservice/blob/master/web%20/src/main/resources/templates/main.hbs#L42)
    * [Posts-목록 출력 영역](https://github.com/KangHoyong/Spring-webservice/blob/master/web%20/src/main/resources/templates/main.hbs#L19)
    * [Posts상세 보기 삭제 수정](https://github.com/KangHoyong/Spring-webservice/blob/master/web%20/src/main/resources/templates/post.hbs#L11)

## Introduction
스프링 부트로더 공부 
1. 게시판 만들기 
 * 글등록 
 * 게시글 리스트 화면 출력 ![KakaoTalk_Photo_2019-05-12-17-45-08](https://user-images.githubusercontent.com/9815703/57579885-ba145580-74dd-11e9-9caf-0443951eec3a.png)
 * 게시글 수정
 * 게시글 삭제
 
2. 게시판 댓글 서비스 만들기 (현재 진행중)
 


 


## 개발환경 
[개발환경 build.gradle](https://github.com/KangHoyong/Spring-webservice/blob/master/web/build.gradle)




## Developer
[@KangHoyong](https://github.com/KangHoyong)


## 참고 사이트 
https://jojoldu.tistory.com/251?category=635883
