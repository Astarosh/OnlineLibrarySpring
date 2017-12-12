/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lib.controllers;

import java.util.List;
import lib.bean.BookExtension;
import lib.bean.BookQuantity;
import lib.bean.Letter;
import lib.bean.SearchType;
import lib.bean.User;
import lib.entity.Genre;
import lib.service.BookExtensionService;
import lib.service.BookQuantityService;
import lib.service.GenreService;
import lib.service.LetterService;
import lib.service.SearchTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

/**
 *
 * @author Ast
 */
@ControllerAdvice
public class GlobalControllerAdvice {

    @Autowired
    private LetterService letterService;

    @Autowired
    private User user;

    @Autowired
    private GenreService genreService;

    @Autowired
    private SearchTypeService searchTypeService;

    @Autowired
    private BookExtensionService bookExtensionService;

    @Autowired
    private BookQuantityService bookQuantityService;

    @ModelAttribute("bookExtension")
    public BookExtension createBookExtension() {
        return bookExtensionService.createBookExtension();
    }

    @ModelAttribute("bookQuantity")
    public BookQuantity createBookQuantity() {
        return bookQuantityService.getBookQuanity();
    }

    @ModelAttribute("searchTypesList")
    public List<SearchType> populateSearchList() {
        return searchTypeService.populateList();
    }

    @ModelAttribute("genreList")
    public List<Genre> populateGenreList() {
        return genreService.getGenre();
    }

    @ModelAttribute("user")
    public User populateUser() {
        if (user.getUsername() == null) {
            user.setUsername("guest");
        }
        return user;
    }

    @ModelAttribute("letterList")
    public List<Letter> populateLetterList() {
        return letterService.populateList();
    }
}
