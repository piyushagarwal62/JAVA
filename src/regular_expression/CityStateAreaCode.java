package regular_expression;

public class CityStateAreaCode {
    private String cityName;
    private String stateCode;
    private String areaCode;

    public CityStateAreaCode(String cityName, String stateCode, String areaCode) {
        this.cityName = cityName;
        this.stateCode = stateCode;
        this.areaCode = areaCode;
    }

    public String getCityName() {
        return cityName;
    }

    public String getStateCode() {
        return stateCode;
    }

    public String getAreaCode() {
        return areaCode;
    }

    @Override
    public String toString() {
        return "PhoneAreaCode{" +
                "cityName='" + cityName + '\'' +
                ", stateCode='" + stateCode + '\'' +
                ", areaCode='" + areaCode + '\'' +
                '}';
    }
}