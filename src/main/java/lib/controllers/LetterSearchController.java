/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lib.controllers;

import java.util.List;
import lib.entity.Book;
import lib.service.BookQuantityService;
import lib.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author Ast
 */
@Controller
public class LetterSearchController {

    @Autowired
    private BookService bookService;

    @Autowired
    BookQuantityService bookQuantityService;

    @RequestMapping("/letter/{letterStr}")
    public String letter(@PathVariable String letterStr, ModelMap model) {
        if (letterStr.length() == 1) {
            int pageNumber = bookQuantityService.getBookQuanity().getPageNumber();
            int booksPerPage = bookQuantityService.getBookQuanity().getBooksPerPage();
            int totalBooksCount = bookService.fillAllBooksByLetter(letterStr);
            List<Book> bookList = bookService.fillBookByLetterLimit(letterStr, pageNumber - 1, booksPerPage);
            model.put("bookList", bookList);
            model.put("bookListLength", totalBooksCount);
            return "views/result";
        } else {
            return "redirect:/";
        }
    }
}
