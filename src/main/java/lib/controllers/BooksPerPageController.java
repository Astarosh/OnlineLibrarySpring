/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lib.controllers;

import javax.validation.Valid;
import lib.bean.BookQuantity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author Ast
 */
@Controller
public class BooksPerPageController {

    @RequestMapping("/booksPerPage")
    public String bookPerPageSelected(@ModelAttribute("bookQuantity") @Valid BookQuantity bookQuantity, BindingResult result,
            Model model) {
        return "redirect:/";
    }
}
