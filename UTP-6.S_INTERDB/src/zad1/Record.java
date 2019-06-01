package zad1;

import java.util.Locale;

class Record {
    private Locale countryCode;
    private String countryName;
    private String dateFrom; //YYYY-MM-DD
    private String dateTo; //YYYY-MM-DD
    private String location;
    private String price;
    private String currency;

    Record(Locale countryCode, String countryName, String dateFrom, String dateTo, String location, String price, String currency) {
        this.countryCode = countryCode;
        this.countryName = countryName;
        this.dateFrom = dateFrom;
        this.dateTo = dateTo;
        this.location = location;
        this.price = price;
        this.currency = currency;
    }

    Locale getCountryCode() {
        return countryCode;
    }

    String getCountryName() {
        return countryName;
    }

    String getDateFrom() {
        return dateFrom;
    }

    String getDateTo() {
        return dateTo;
    }

    String getLocation() {
        return location;
    }

    String getPrice() {
        return price;
    }

    String getCurrency() {
        return currency;
    }

}