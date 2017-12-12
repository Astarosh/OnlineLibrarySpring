/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lib.bean;

import lib.entity.Book;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author Ast
 */
@Component
public class BookExtension extends Book {

    private SearchType searchType;
    private Book book;
    private String searchTypeString;
    private String searchString;
    private boolean imageEdited;
    private boolean contentEdited;
    private MultipartFile file;

    public MultipartFile getFile() {
        return file;
    }

    public void setFile(MultipartFile file) {
        this.file = file;
    }


    public String getSearchString() {
        return searchString;
    }

    public void setSearchString(String searchString) {
        this.searchString = searchString;
    }

    public boolean isImageEdited() {
        return imageEdited;
    }

    public void setImageEdited(boolean imageEdited) {
        this.imageEdited = imageEdited;
    }

    public boolean isContentEdited() {
        return contentEdited;
    }

    public void setContentEdited(boolean contentEdited) {
        this.contentEdited = contentEdited;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public SearchType getSearchType() {
        return searchType;
    }

    public void setSearchType(SearchType searchType) {
        this.searchType = searchType;
    }

    public String getSearchTypeString() {
        return searchTypeString;
    }

    public void setSearchTypeString(String searchTypeString) {
        this.searchTypeString = searchTypeString;
    }
}
