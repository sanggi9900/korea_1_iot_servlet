package org.example.demo;

/*
    == 서블릿 ==

    1. 서블릿 정의
    : Java EE(Enterprise Edition)의 일부
    : 웹 서버에서 실행되는 Java 프로그램
    - 클라이언트의 요청을 처리하고 그 결과를 웹 브라우저에 '응답'하는 역활

    2. 서블릿의 작동 구조
    : Apache Tomcat과 같은 '서블릿 컨테이너'에서 실행

    cf) 서블릿 컨테이너
        : 클라이언트로 부터 Http 요청을 받아 서블릿에 전달하고
            , 서블릿에서 응답을 처리한 후 다시 클라이언트로 응답을 반환하는 역활

     : 서블릿 라이프사이클(ex : 리액트 실행마운팅)
     - init(): 서블릿이 처음 호출될 때 실행, 초기화 작업을 담당
     - servlet(): 클라이언트 요청이 있을 때마다 호출
                    , doGet()이나 doPost() 등과 같은 Http 메서드에 따라 요청을 처리
     - destroy(): 서블릿이 종료될 때 호출되어 리소스를 정리

     : .HTTP 요청 & 응답 처리
     - HttpServletRequest와 HttpServletResponse 객체를 사용하여 처리

     3. 서블릿 개발의 특징
     - 핸들러 관리
        : 각각의 요청을 처리하는 메서드를 직접정의
        : HTTP 요청을 수돋으로 처리하고 응답을 작성

     - 매핑 작성
        : 서블릿 매핑은 web.xml과 같은 배포 기술자나 어노테이션을 통해 설정

     cf) jsp (java server page)
         : HTML 코드내에 JAVA 코드를 작성
         : <% 소스코드 %> | <%= 소스코드 =%>

 */


public class Servlet {
}
