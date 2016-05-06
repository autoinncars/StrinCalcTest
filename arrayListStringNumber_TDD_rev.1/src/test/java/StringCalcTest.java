import junit.framework.TestCase;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Created by Administrator on 5/4/16.
 */
public class StringCalcTest {
    StringCalc stringCalc = new StringCalc();

    @Test
    public void returnsZeroForEmptyString() throws Exception {
        stringCalc.dealWithDelimiter("");
        stringCalc.splitString();
        stringCalc.parseFromStringToInteger();
        int actual = stringCalc.returnSum();

        assertEquals(0, actual);
    }

    @Test
    public void returnsOneForStringOne() throws Exception {
        stringCalc.dealWithDelimiter("1");
        stringCalc.splitString();
        stringCalc.parseFromStringToInteger();
        int actual = stringCalc.returnSum();

        assertEquals(1, actual);
    }

    @Test
    public void returnsTwoForStringTwo() {
        stringCalc.dealWithDelimiter("2");
        stringCalc.splitString();
        stringCalc.parseFromStringToInteger();
        int actual = stringCalc.returnSum();

        assertEquals(2, actual);
    }

    @Test
    public void returnsSumOfOneAndTwo() throws Exception {
        stringCalc.dealWithDelimiter("1,2");
        stringCalc.splitString();
        stringCalc.parseFromStringToInteger();
        int actual = stringCalc.returnSum();

        assertEquals(3, actual);
    }

    @Test
    public void returnsSumOfTreeNumbers() throws Exception {
        stringCalc.dealWithDelimiter("1,2,3");
        stringCalc.splitString();
        stringCalc.parseFromStringToInteger();
        int actual = stringCalc.returnSum();

        assertEquals(6, actual);
    }

    @Test
    public void returnsSumOf4Numbers() {
        stringCalc.dealWithDelimiter("1,2,3,4");
        stringCalc.splitString();
        stringCalc.parseFromStringToInteger();
        int actual = stringCalc.returnSum();

        assertEquals(10, actual);
    }

    @Test
    public void returnsSumOf4NumbersSeparatedByNewLine() {
        stringCalc.dealWithDelimiter("1\n2\n3\n4");
        stringCalc.splitString();
        stringCalc.parseFromStringToInteger();
        int actual = stringCalc.returnSum();

        assertEquals(10, actual);
    }

    @Test
    public void returnsSumOfTreeNumbersSeparatedByDifferentDelimeter() throws Exception {
        stringCalc.dealWithDelimiter("//;\n;1;2");
        stringCalc.splitString();
        stringCalc.parseFromStringToInteger();
        int actual = stringCalc.returnSum();

        assertEquals(3, actual);
    }

    @Test
    public void negativeNumberWillThrowExceptionNegativesNotAllowed() throws Exception {
        stringCalc.dealWithDelimiter("-1,-2,3");
        stringCalc.splitString();
        stringCalc.parseFromStringToInteger();
        stringCalc.catchException();
        int actual = stringCalc.returnSum();

        assertEquals(3, actual);
    }

    @Test
    public void DelimitersCanBeOfAnyLength() throws Exception {
        stringCalc.dealWithDelimiter("//***\n1***2***3");
        stringCalc.splitString();
        stringCalc.parseFromStringToInteger();
        int actual = stringCalc.returnSum();

        assertEquals(6, actual);
    }

    @Test
    public void AllowMultipleDelimiters() throws Exception {
        stringCalc.dealWithDelimiter("//*%\n1*2%3");
        stringCalc.splitString();
        stringCalc.parseFromStringToInteger();
        int actual = stringCalc.returnSum();

        assertEquals(6, actual);
    }

    @Test
    public void handleMultipleDelimitersWithLengthLongerThanOneChar() throws Exception {
        stringCalc.dealWithDelimiter("////*******%%%%%%%%%%\n1*2%%%%%%%%%%%3");
        stringCalc.splitString();
        stringCalc.parseFromStringToInteger();
        int actual = stringCalc.returnSum();

        assertEquals(6, actual);
    }
}
