package co.com.certification.automation.util;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Formats {

    public static String getDateTimeForEvidence(){
        DateTimeFormatter formatDateTime = DateTimeFormatter.ofPattern("yyyy-MM-dd_HH-mm-ss");
        String dateEvidence= LocalDateTime.now().format(formatDateTime);
        return dateEvidence;
    }
}
