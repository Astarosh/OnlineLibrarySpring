package lib.service;

import java.util.ArrayList;
import java.util.List;
import lib.bean.Letter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Component;

@Component
public class LetterService {

    private Letter letter;
    private List<Letter> letterList;
    @Autowired
    MessageSource messageSource;

    public List<Letter> populateList() {
        letterList = new ArrayList<>();
        String letterStr = messageSource.getMessage("all_alphabetic_letters", null, LocaleContextHolder.getLocaleContext().getLocale());
        char[] lett = letterStr.toCharArray();
        for (int i = 0; i < lett.length; i++) {
            letter = new Letter();
            letter.setLetterStr(String.valueOf(lett[i]));
            letterList.add(letter);
        }
        return letterList;
    }

    public Letter getLetter() {
        return letter;
    }

    public void setLetter(Letter letter) {
        this.letter = letter;
    }

    public List<Letter> getLetterList() {
        return letterList;
    }

    public void setLetterList(List<Letter> letterList) {
        this.letterList = letterList;
    }
}
