package POO.demo.services.models;

public class Adresse {

    private String street;
    private String city;
    private String county;
    private String state;
    private int zip;

    public Adresse(String street, String city, String county, String state, int zip) {
        this.street = street;
        this.city = city;
        this.county = county;
        this.state = state;
        this.zip = zip;
    }

    @Override
    public String toString() {
        return String.format("%s - %d %s [%s] %s",
                this.street,
                this.zip,
                this.city,
                this.state,
                this.county);
    }

    // GETTERS AND SETTERS

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCounty() {
        return county;
    }

    public void setCounty(String county) {
        this.county = county;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public int getZip() {
        return zip;
    }

    public void setZip(int zip) {
        this.zip = zip;
    }
}
