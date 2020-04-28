package regular_expression;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author piyush.agarwal
 * Demonstrate of Named Capture Group
 *
 */
public class NamedCapturingGroupDemo {
    private final static String regex =
            "\\b(?<city>[A-Za-z\\s]+),\\s(?<state>[A-Z]{2,2}):\\s(?<areaCode>[0-9]{3,3})\\b";

    
    public static void main(String[] args) {
        String input = "This is the list: Baytown, TX: 281, Chapel Hill, NC: 284, " +
                "Fort Myers, FL: 239";
        new NamedCapturingGroupDemo().showAreaCodes(input);
    }

    private final static Pattern pattern = Pattern.compile(regex);

    public void showAreaCodes(String textData) {
        List<CityStateAreaCode> areaCodeList = getAreaCodeList(textData);
        System.out.println(areaCodeList);
    }

    public List<CityStateAreaCode> getAreaCodeList(String textData) {
        List<CityStateAreaCode> areaCodeList = new ArrayList<>();
        Matcher matcher = pattern.matcher(textData);

        while (matcher.find()) {
            if (matcher.groupCount() == 3) {
                areaCodeList.add(
                        new CityStateAreaCode(matcher.group("city"), matcher.group("state"),
                                matcher.group("areaCode")));
            }
        }
        return areaCodeList;
    }

}
