package it.academy.AGMExpress.utilities;

import org.apache.commons.lang3.RandomStringUtils;

public class TargaGenerator {
    public static String generateTargaItaliana() {
        String lettere = RandomStringUtils.randomAlphabetic(2).toUpperCase();
        String cifre = RandomStringUtils.randomNumeric(2);
        String lettereFinali = RandomStringUtils.randomAlphabetic(2).toUpperCase();
        return lettere + "-" + cifre + "-" + lettereFinali;
    }
}
