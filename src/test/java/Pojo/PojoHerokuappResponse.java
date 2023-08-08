package Pojo;

public class PojoHerokuappResponse {
    private int bookingid;
    private PojoHerokuappRequestBody booking;


    //2


    public int getBookingid() {
        return bookingid;
    }

    public void setBookingid(int bookingid) {
        this.bookingid = bookingid;
    }

    public PojoHerokuappRequestBody getBooking() {
        return booking;
    }

    public void setBooking(PojoHerokuappRequestBody booking) {
        this.booking = booking;
    }
    //3

    public PojoHerokuappResponse(int bookingid, PojoHerokuappRequestBody booking) {
        this.bookingid = bookingid;
        this.booking = booking;
    }
    //4

    public PojoHerokuappResponse() {
    }
    //5


    @Override
    public String toString() {
        return "PojoHerokuappResponse{" +
                "bookingid=" + bookingid +
                ", booking=" + booking +
                '}';
    }
}
