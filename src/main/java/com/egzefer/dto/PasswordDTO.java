package com.egzefer.dto;

import com.egzefer.Requirement;
import com.egzefer.Strength;

/**
 * DTO that contains the information regarding the checked password
 * 
 * @author evandro
 *
 */
public class PasswordDTO {

    private String password;

    private Integer score;

    private Strength strength;

    private Requirement lengthReq;

    private Requirement uppercaseReq;

    private Requirement lowercaseReq;

    private Requirement numbersReq;

    private Requirement symbolsReq;

    private Requirement midNumSymReq;

    private Requirement totalRequirementsRequirementsReq;

    private Requirement lettersOnlyReq;

    private Requirement numbersOnlyReq;

    private Requirement repeatCharsReq;

    private Requirement consecUppercaseReq;

    private Requirement consecLowercaseReq;

    private Requirement consecNumbersReq;

    private Requirement seqLettersReq;

    private Requirement seqNumbersReq;

    private Requirement seqSymbolsReq;

    public String getPassword() {

        return password;
    }

    public void setPassword(String password) {

        this.password = password;
    }

    public Integer getScore() {

        return score;
    }

    public void setScore(Integer score) {

        this.score = score;
    }

    public Strength getStrength() {

        return strength;
    }

    public void setStrength(Strength strength) {

        this.strength = strength;
    }

    public Requirement getLengthReq() {

        return lengthReq;
    }

    public void setLengthReq(Requirement lengthReq) {

        this.lengthReq = lengthReq;
    }

    public Requirement getUppercaseReq() {

        return uppercaseReq;
    }

    public void setUppercaseReq(Requirement uppercaseReq) {

        this.uppercaseReq = uppercaseReq;
    }

    public Requirement getLowercaseReq() {

        return lowercaseReq;
    }

    public void setLowercaseReq(Requirement lowercaseReq) {

        this.lowercaseReq = lowercaseReq;
    }

    public Requirement getNumbersReq() {

        return numbersReq;
    }

    public void setNumbersReq(Requirement numbersReq) {

        this.numbersReq = numbersReq;
    }

    public Requirement getSymbolsReq() {

        return symbolsReq;
    }

    public void setSymbolsReq(Requirement symbolsReq) {

        this.symbolsReq = symbolsReq;
    }

    public Requirement getMidNumSymReq() {

        return midNumSymReq;
    }

    public void setMidNumSymReq(Requirement midNumSymReq) {

        this.midNumSymReq = midNumSymReq;
    }

    public Requirement getTotalRequirementsReq() {

        return totalRequirementsRequirementsReq;
    }

    public void setTotalRequirementsReq(Requirement totalRequirementsReq) {

        this.totalRequirementsRequirementsReq = totalRequirementsReq;
    }

    public Requirement getLettersOnlyReq() {

        return lettersOnlyReq;
    }

    public void setLettersOnlyReq(Requirement lettersOnlyReq) {

        this.lettersOnlyReq = lettersOnlyReq;
    }

    public Requirement getNumbersOnlyReq() {

        return numbersOnlyReq;
    }

    public void setNumbersOnlyReq(Requirement numbersOnlyReq) {

        this.numbersOnlyReq = numbersOnlyReq;
    }

    public Requirement getRepeatCharsReq() {

        return repeatCharsReq;
    }

    public void setRepeatCharsReq(Requirement repeatCharsReq) {

        this.repeatCharsReq = repeatCharsReq;
    }

    public Requirement getConsecUppercaseReq() {

        return consecUppercaseReq;
    }

    public void setConsecUppercaseReq(Requirement consecUppercaseReq) {

        this.consecUppercaseReq = consecUppercaseReq;
    }

    public Requirement getConsecLowercaseReq() {

        return consecLowercaseReq;
    }

    public void setConsecLowercaseReq(Requirement consecLowercaseReq) {

        this.consecLowercaseReq = consecLowercaseReq;
    }

    public Requirement getConsecNumbersReq() {

        return consecNumbersReq;
    }

    public void setConsecNumbersReq(Requirement consecNumbersReq) {

        this.consecNumbersReq = consecNumbersReq;
    }

    public Requirement getSeqLettersReq() {

        return seqLettersReq;
    }

    public void setSeqLettersReq(Requirement seqLettersReq) {

        this.seqLettersReq = seqLettersReq;
    }

    public Requirement getSeqNumbersReq() {

        return seqNumbersReq;
    }

    public void setSeqNumbersReq(Requirement seqNumbersReq) {

        this.seqNumbersReq = seqNumbersReq;
    }

    public Requirement getSeqSymbolsReq() {

        return seqSymbolsReq;
    }

    public void setSeqSymbolsReq(Requirement seqSymbolsReq) {

        this.seqSymbolsReq = seqSymbolsReq;
    }

}
