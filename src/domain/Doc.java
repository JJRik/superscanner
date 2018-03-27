package domain;

public class Doc {
    private String days;
    private String months;
    private String years;
    private String startPage;
    private String lastPage;
    private String type;




    public void setDays(String days) {
        this.days = days;
    }

    public void setMonths(String months) {
        this.months = months;
    }

    public void setYears(String years) {
        this.years = years;
    }

    public void setStartPage(String startPage) {
        this.startPage = startPage;
    }

    public void setLastPage(String lastPage) {
        this.lastPage = lastPage;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Doc(String days, String months, String years, String startPage, String lastPage, String type) {

        this.days = days;
        this.months = months;
        this.years = years;
        this.startPage = startPage;
        this.lastPage = lastPage;
        this.type = type;
    }

    public String getStartPage() {
        return startPage;
    }

    public String getLastPage() {
        return lastPage;
    }

    public String getType() {
        return type;
    }

    @Override
    public String toString() {
        return getDate() + " " + startPage + " " + lastPage + " " + type;
    }

    public String getDate() {
        if (Integer.parseInt(years) > 89) return days + "." + months + "." + "19" + years;
        return days + "." + months + "." + "20" + years;
    }
}
