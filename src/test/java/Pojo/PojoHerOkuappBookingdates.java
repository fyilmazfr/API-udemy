package Pojo;

import baseUrl.BaseUrlHerOkuApp;

public class PojoHerOkuappBookingdates  {

    // 1) Tum variable’lari "private" olarak olusturalim
    private String checkin;
    private String checkout;

  //2) Tum variable’lar icin getter( ) and setter( ) metodlari olusturalim

    public String getCheckin() {
        return checkin;
    }

    public void setCheckin(String checkin) {
        this.checkin = checkin;
    }

    public String getCheckout() {
        return checkout;
    }

    public void setCheckout(String checkout) {
        this.checkout = checkout;
    }


    //3) Tum parametreleri iceren bir constructor olusturalim


    public PojoHerOkuappBookingdates(String checkin, String checkout) {
        this.checkin = checkin;
        this.checkout = checkout;
    }
   //4
    public PojoHerOkuappBookingdates() {
    }

    //5
    @Override
    public String toString() {
        return "PojoHerOkuappBookingdates{" +
                "checkin='" + checkin + '\'' +
                ", checkout='" + checkout + '\'' +
                '}';
    }
}