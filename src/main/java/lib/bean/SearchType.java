/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lib.bean;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Component;

/**
 *
 * @author Ast
 */
@Component
public class SearchType {

    private List<SearchType> searchList; // хранит все виды поисков (по автору, по названию, по ISBN)
    private SearchTypes searchType;
    private String searchField;

    public enum SearchTypes {
        AUTHOR,
        NAME,
        LETTER,
        SEARCH,
        GENRE,
        ISBN;

        public static SearchTypes getAUTHOR() {
            return AUTHOR;
        }

        public static SearchTypes getNAME() {
            return NAME;
        }

        public static SearchTypes getLETTER() {
            return LETTER;
        }

        public static SearchTypes getSEARCH() {
            return SEARCH;
        }

        public static SearchTypes getGENRE() {
            return GENRE;
        }

        public static SearchTypes getISBN() {
            return ISBN;
        }
    }

    public SearchType() {
    }

    public String getSearchField() {
        return searchField;
    }

    public SearchTypes getSearchType() {
        return searchType;
    }

    public void setSearchType(SearchTypes searchType) {
        this.searchType = searchType;
    }

    public void setSearchField(String searchField) {
        this.searchField = searchField;
    }

    public List<SearchType> getSearchList() {
        return searchList;
    }

    public void setSearchList(List<SearchType> searchList) {
        this.searchList = searchList;
    }

    @Override
    public String toString() {
        return "SearchType{" + "searchField=" + searchField + '}';
    }
}
