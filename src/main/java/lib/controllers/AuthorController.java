/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lib.controllers;

import java.util.List;
import java.util.Map;
import lib.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author Ast
 */
@Controller
public class AuthorController {

    @Autowired
    private AuthorService authorService;
//    @ResponseBody
//    @RequestMapping("/stocks")
//    public List<Map<String, Object>> stocks() {
//        return template.queryForList("select * from author");
//    }

    @RequestMapping("/author")
    public String welcome(Map<String, Object> model) {
        model.put("authorName", authorService.getAuthors().get(0).getFio());
        return "views/author";
    }
}
