/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lib.controllers;

import java.io.IOException;
import javax.validation.Valid;
import lib.bean.BookExtension;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 *
 * @author Ast
 */
@Controller
public class UploadFileController {

    //Save the uploaded file to this folder
    @PostMapping("/upload") // //new annotation since 4.3
    public String singleFileUpload(@Valid BookExtension bookExtensionResult, BindingResult result,
            ModelMap model,
            RedirectAttributes redirectAttributes) throws IOException {
        if (bookExtensionResult.getFile().getBytes().length == 0) {
            redirectAttributes.addFlashAttribute("message", "Please select a file to upload");
            return "redirect:/uploadStatus";
        }

        // Get the file and save it somewhere
        byte[] bytes = bookExtensionResult.getFile().getBytes();
        bookExtensionResult.getBook().setImage(bytes);
        if (bytes.length > 100000) {
            redirectAttributes.addFlashAttribute("message", "Failed to upload, too big ");
        } else {
            redirectAttributes.addFlashAttribute("message",
                    "You successfully uploaded '" + bookExtensionResult.getFile().getBytes().length + bookExtensionResult.getBook().getName()+ "'");
        }
        model.addAttribute("bookExtension", bookExtensionResult);
        return "views/editBook";
    }

    @GetMapping("/uploadStatus")
    public String uploadStatus() {
        return "views/uploadStatus";
    }
}
