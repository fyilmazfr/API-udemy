package Pojo;

public class PojoHerokuappRequestBody {
    //1
    private String firstname;
    private String lastname;
    private int totalprice;
    private boolean depositpaid;
    private PojoHerOkuappBookingdates bookingdates; // bunu pojo yapmistik ordan alcaz
    private String additionalneeds;

    //2


    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public int getTotalprice() {
        return totalprice;
    }

    public void setTotalprice(int totalprice) {
        this.totalprice = totalprice;
    }

    public boolean isDepositpaid() {
        return depositpaid;
    }

    public void setDepositpaid(boolean depositpaid) {
        this.depositpaid = depositpaid;
    }

    public PojoHerOkuappBookingdates getBookingdates() {
        return bookingdates;
    }

    public void setBookingdates(PojoHerOkuappBookingdates bookingdates) {
        this.bookingdates = bookingdates;
    }

    public String getAdditionalneeds() {
        return additionalneeds;
    }

    public void setAdditionalneeds(String additionalneeds) {
        this.additionalneeds = additionalneeds;
    }
    //3

    public PojoHerokuappRequestBody(String firstname, String lastname, int totalprice, boolean depositpaid, PojoHerOkuappBookingdates bookingdates, String additionalneeds) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.totalprice = totalprice;
        this.depositpaid = depositpaid;
        this.bookingdates = bookingdates;
        this.additionalneeds = additionalneeds;
    }

    //4

    public PojoHerokuappRequestBody() {
    }

    //5

    @Override
    public String toString() {
        return "PojoHerokuappRequestBody{" +
                "firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", totalprice=" + totalprice +
                ", depositpaid=" + depositpaid +
                ", bookingdates=" + bookingdates +
                ", additionalneeds='" + additionalneeds + '\'' +
                '}';
    }
}
