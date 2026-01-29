package com.example.books.aop;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.books.controller.BookController;

@SpringBootTest
class LogAspectTest {

    @Autowired
    private BookController bookController;

    @Test
    @DisplayName("도서 등록 AOP 테스트")
    void addBookAopTest() {
        System.out.println("\n========== 도서 등록 AOP 테스트 시작 ==========\n");
        
        String result = bookController.addBook("스프링 부트");
        
        System.out.println("\n========== 도서 등록 AOP 테스트 종료 ==========\n");
        
        assertNotNull(result);
        assertTrue(result.contains("도서 등록"));
    }
    
    @Test
    @DisplayName("도서 수정 AOP 테스트")
    void updateBookAopTest() {
        System.out.println("\n========== 도서 수정 AOP 테스트 시작 ==========\n");
        
        String result = bookController.updateBook("자바 프로그래밍");
        
        System.out.println("\n========== 도서 수정 AOP 테스트 종료 ==========\n");
        
        assertNotNull(result);
        assertTrue(result.contains("도서 수정"));
    }
    
    @Test
    @DisplayName("도서 조회 AOP 테스트")
    void selectBookAopTest() {
        System.out.println("\n========== 도서 조회 AOP 테스트 시작 ==========\n");
        
        String result = bookController.selectBook("클린 코드");
        
        System.out.println("\n========== 도서 조회 AOP 테스트 종료 ==========\n");
        
        assertNotNull(result);
        assertTrue(result.contains("도서 조회"));
    }
    
    @Test
    @DisplayName("모든 메서드 AOP 테스트")
    void allMethodsAopTest() {
        System.out.println("\n========== 전체 AOP 테스트 시작 ==========\n");
        
        // 1. 도서 등록
        System.out.println(">>> 1. 도서 등록 호출");
        bookController.addBook("이펙티브 자바");
        
        System.out.println("\n");
        
        // 2. 도서 수정
        System.out.println(">>> 2. 도서 수정 호출");
        bookController.updateBook("토비의 스프링");
        
        System.out.println("\n");
        
        // 3. 도서 조회
        System.out.println(">>> 3. 도서 조회 호출");
        bookController.selectBook("객체지향의 사실과 오해");
        
        System.out.println("\n========== 전체 AOP 테스트 종료 ==========\n");
    }
}