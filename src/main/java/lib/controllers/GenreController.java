/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lib.controllers;

import java.util.List;
import java.util.Objects;
import lib.entity.Book;
import lib.entity.Genre;
import lib.service.BookQuantityService;
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
public class GenreController {

    @Autowired
    private BookService bookService;

    @Autowired
    BookQuantityService bookQuantityService;

    @RequestMapping("/genre/{genreId}")
    public String genre(@PathVariable Long genreId, ModelMap model) {
        List<Genre> list;
        list = (List<Genre>) model.get("genreList");
        Long maxGenreId = 1L;
        Genre genreById = new Genre();
        for (Genre genre : list) {
            if (genre.getId() == genreId) {
                genreById.setId(genreId);
                genreById.setName(genre.getName());
            }
            if (genre.getId() > maxGenreId) {
                maxGenreId = genre.getId();
            }
        }
        model.put("genreId", genreById.getId());
        if (genreId == -1) {
            int pageNumber = bookQuantityService.getBookQuanity().getPageNumber();
            int booksPerPage = bookQuantityService.getBookQuanity().getBooksPerPage();
            List<Book> bookList = bookService.fillAllBooksLimit(pageNumber-1, booksPerPage);
            model.put("booksPerPage", booksPerPage);
            model.put("pageNumber", pageNumber);
            model.put("bookList", bookList);
            model.put("bookListLength", bookService.fillAllBooksNumber());
            return "views/result";
        } else if (genreId < maxGenreId + 1) {
            int pageNumber = bookQuantityService.getBookQuanity().getPageNumber();
            int booksPerPage = bookQuantityService.getBookQuanity().getBooksPerPage();
            List<Book> bookList = bookService.fillBookByGenreLimit(genreById, pageNumber-1, booksPerPage);
            model.put("booksPerPage", booksPerPage);
            model.put("pageNumber", pageNumber);
            model.put("bookList", bookList);
            model.put("bookListLength", bookService.fillAllBookByGenre(genreById));
            return "views/result";
        } else {
            return "redirect:/";
        }
    }
}
