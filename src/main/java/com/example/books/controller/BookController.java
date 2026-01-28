package com.example.books.controller;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/books")

public class BookController {
    @PostMapping("/add")
    public String addBook(@RequestParam String title){

        return "도서 등록:" + title ;
    }

    @PutMapping("/update")
    public String updateBook(@RequestParam String title){

        return "도서 수정:" +title;
    }

    @GetMapping("/select")
    public String selectBook(@RequestParam String title){

        return"도서 조회:"+ title;
    }

}
