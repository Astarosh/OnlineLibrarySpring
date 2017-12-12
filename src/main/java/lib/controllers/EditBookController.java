/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lib.controllers;

import lib.bean.BookExtension;
import lib.entity.Book;
import lib.service.BookExtensionService;
import lib.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author Ast
 */
@Controller
public class EditBookController {

    @Autowired
    BookService bookService;

    @Autowired
    BookExtensionService bookExtensionService;

    @RequestMapping("/book/{bookId}")
    public String bookEdit(@PathVariable Long bookId, ModelMap model) {
        Book book = bookService.getBookById(bookId).get(0);
        BookExtension bookExtension = bookExtensionService.createBookExtension();
        bookExtension.setBook(book);
        model.addAttribute("bookExtension", bookExtension);
        return "views/editBook";
    }
}
