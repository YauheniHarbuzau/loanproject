package by.itstep.loanproject.mapper.uses;

import by.itstep.loanproject.mapper.constants.Constants;
import by.itstep.loanproject.mapper.exeption.DateTimeMapperException;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static by.itstep.loanproject.mapper.constants.Constants.DATE_PATTERN;
import static by.itstep.loanproject.mapper.constants.Constants.DATE_TIME_PATTERN;

/**
 * DateTimeMapper for correct mapping of the date
 *
 * @author Yauheni Harbuzau
 * @see Constants
 * @see DateTimeMapperException
 */
public class DateTimeMapper {

    public static String date(Date date) {
        if (date == null) {
            return null;
        }
        return new SimpleDateFormat(DATE_TIME_PATTERN).format(date);
    }

    public static Date date(String date) {
        if (date == null) {
            return null;
        }
        try {
            return new SimpleDateFormat(date.length() > 10 ? DATE_TIME_PATTERN : DATE_PATTERN).parse(date);
        } catch (ParseException exception) {
            exception.printStackTrace();
        }
        throw new DateTimeMapperException();
    }
}