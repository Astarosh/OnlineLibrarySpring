/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lib.service;

import java.util.ArrayList;
import java.util.List;
import lib.bean.SearchType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Component;

/**
 *
 * @author Ast
 */
@Component
public class SearchTypeService {

    @Autowired
    MessageSource messageSource;

    private List<SearchType> searchList; // хранит все виды поисков (по автору, по названию, по ISBN)

    public SearchTypeService() {
    }

    public List<SearchType> populateList() {
        searchList = new ArrayList<>();
        SearchType searchType = new SearchType();
        searchType.setSearchType(SearchType.SearchTypes.AUTHOR);
        searchType.setSearchField(messageSource.getMessage("author_name", null, LocaleContextHolder.getLocaleContext().getLocale()));
        searchList.add(searchType);
        SearchType searchType2 = new SearchType();
        searchType2.setSearchType(SearchType.SearchTypes.NAME);
        searchType2.setSearchField(messageSource.getMessage("book_name", null, LocaleContextHolder.getLocaleContext().getLocale()));
        searchList.add(searchType2);
        SearchType searchType3 = new SearchType();
        searchType3.setSearchType(SearchType.SearchTypes.ISBN);
        searchType3.setSearchField("ISBN");
        searchList.add(searchType3);
        return searchList;
    }

    public MessageSource getMessageSource() {
        return messageSource;
    }

    public void setMessageSource(MessageSource messageSource) {
        this.messageSource = messageSource;
    }

    public List<SearchType> getSearchList() {
        return searchList;
    }

    public void setSearchList(List<SearchType> searchList) {
        this.searchList = searchList;
    }

}
