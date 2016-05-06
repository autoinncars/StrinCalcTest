import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Administrator on 5/4/16.
 */
public class StringCalc {
    int sum = 0;
    Throwable exc;
    String delimiter;
    int countNegativeNumbers = 0;
    String illegalArgumentExceptionParametar = "";
    List<String> stringNumbers = new ArrayList<String>();
    List<Integer> number = new ArrayList<Integer>();


    public int returnSum() {
        for (Integer num : number) {
            sum = sum + num;
        }
        return sum;
    }

    public String dealWithDelimiter(String s) {
        delimiter = s.replaceAll("[ \n // ; * % ]", ",");
        return delimiter;
    }

    public List<String> splitString() {
        stringNumbers = Arrays.asList(delimiter.split(","));
        return stringNumbers;
    }

    public List<Integer> parseFromStringToInteger() {
        for (String str : stringNumbers) {
            if ("".equals(str)) {
                number.add(0);
            } else {
                number.add(Integer.valueOf(str));
            }
        }
        return number;
    }

    public Throwable catchException() {
        for (Integer num : number) {
            if (num < 0) {
                try {
                    illegalArgumentExceptionParametar =
                            illegalArgumentExceptionParametar + stringNumbers.get(countNegativeNumbers);
                    throw new IllegalArgumentException(illegalArgumentExceptionParametar);
                } catch (IllegalArgumentException e) {
                    exc = e;
                    number.set(countNegativeNumbers, 0);
                    countNegativeNumbers++;
                }
            }
        }
        if (exc != null) {
            exc.printStackTrace();
        }
        return exc;
    }
}

