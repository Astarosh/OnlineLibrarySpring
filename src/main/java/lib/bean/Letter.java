/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lib.bean;

import org.springframework.stereotype.Component;

/**
 *
 * @author Ast
 */
@Component
public class Letter {

    @Override
    public String toString() {
        return "Letter{" + "letter=" + letterStr + '}';
    }
    private String letterStr;
    public Letter(){
    }

    public String getLetterStr() {
        return letterStr;
    }

    public void setLetterStr(String letterStr) {
        this.letterStr = letterStr;
    }
}
