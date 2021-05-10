package eu.mrndesign.matned.workerrest.workerrestapplication.utils;

import eu.mrndesign.matned.workerrest.workerrestapplication.exception.WrongDateFormatException;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;

public class Patterns {

    public static final String DATE_PATTERN = "yyyy-MM-dd";
    public static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern(DATE_PATTERN);



    private static final List<String> formatStrings = Arrays.asList("yyyy-MM-dd", "dd-MM-yyyy", "ddMMyyyy","yyyyMMdd", "dd.MM.yyyy");


    public static LocalDate getDateFromString(String dateString)
    {
        for (String formatString : formatStrings)
        {
            try
            {
                return LocalDate.parse(dateString, DateTimeFormatter.ofPattern(formatString));
            }
            catch (Exception ignored) {}
        }
        throw new WrongDateFormatException();
    }

    public static String getDateToString(LocalDate parsed){
        try {
            return parsed.format(DATE_TIME_FORMATTER);
        }catch (NullPointerException ex){
            System.out.println("Null date - unable to format");
        }
        return null;
    }

}
