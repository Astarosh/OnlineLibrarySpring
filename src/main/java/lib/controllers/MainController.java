/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lib.controllers;

import java.util.List;
import java.util.Map;
import lib.entity.Book;
import lib.service.BookQuantityService;
import lib.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {

    @Autowired
    private BookService bookService;

    @Autowired
    BookQuantityService bookQuantityService;

    @RequestMapping("/")
    public String hello(ModelMap model
    ) {
        int pageNumber = bookQuantityService.getBookQuanity().getPageNumber();
        int booksPerPage = bookQuantityService.getBookQuanity().getBooksPerPage();
        int totalBooksCount = bookService.fillAllBooksNumber();
        List<Book> bookList = bookService.fillAllBooksLimit(pageNumber-1, booksPerPage);
        model.put("bookList", bookList);
        model.put("bookListLength", totalBooksCount);
        return "views/index";
    }
}
