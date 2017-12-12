/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lib.controllers;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import static java.lang.System.in;
import java.nio.file.Files;
import javax.servlet.http.HttpServletResponse;
import lib.DAO.BookImageDAO;
import org.apache.tomcat.util.codec.binary.Base64;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author Ast
 */
@Controller
public class ImageController {

    @Autowired
    BookImageDAO bookImageDAO;

    @RequestMapping(value = "image/{bookId}")
    @ResponseBody
    public String getImage(@PathVariable(value = "bookId") Long bookId, ModelMap model) throws IOException {
        byte[] image;
        image = bookImageDAO.fillBookById(bookId).get(0).getImage();
        byte[] encodeBase64 = Base64.encodeBase64(image);
        String base64Encoded = new String(encodeBase64, "UTF-8");
        return base64Encoded;
    }

}
