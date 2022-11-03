package ua.gov.mkip.itHelp.model.enums;

public enum TypeOfProblem {
    INTENET("відсутній інтернет чи неможу підключитися до Wi-fi"),
    PC("пролема з компьтером"),
    MAIL("не можу зайти в електрону пошту"),
    ASKOD("система електроного документообігу АСКОД"),
    SIGNATURE("виникла проблема з ЕЦП"),
    PRINTER("не друкує приінтер");

    private final String displayValue;

    TypeOfProblem(String displayValue) {
        this.displayValue = displayValue;
    }

    public String getDisplayValue() {
        return displayValue;
    }
}
