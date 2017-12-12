/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lib.controllers;

import java.util.Locale;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.WebMvcProperties.LocaleResolver;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

/**
 *
 * @author Ast
 */
@Controller
public class LocaleController {

    @Autowired
    private SessionLocaleResolver sessionLocaleResolver;

    @RequestMapping("/ru")
    public String changeLocaleToRu() {
        sessionLocaleResolver.setDefaultLocale(new Locale("ru"));
        return "redirect:/";
    }

    @RequestMapping("/en")
    public String changeLocaleToEn() {
        sessionLocaleResolver.setDefaultLocale(Locale.US);
        return "redirect:/";
    }
}
