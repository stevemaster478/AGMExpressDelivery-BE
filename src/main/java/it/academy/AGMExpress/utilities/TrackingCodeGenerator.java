package it.academy.AGMExpress.utilities;

import org.apache.commons.lang3.RandomStringUtils;


public class TrackingCodeGenerator {

    public static String generateTrackingCode() {
        String trackingCode = RandomStringUtils.randomAlphanumeric(10);
        return trackingCode;
    }
}

