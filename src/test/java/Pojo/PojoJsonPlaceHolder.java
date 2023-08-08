package Pojo;

public class PojoJsonPlaceHolder {//pojoda 5 adim vardir
    /*
    {
"title": "Ahmet",
"body": "Merhaba",
"userId": 10,
"id": 70
}
     */

    //1) Tum variable’lari "private" olarak olusturalim
    private String title;
    private String body;
    private int userId;
    private int id;


    // 2) Tum variable’lar icin getter( ) and setter( ) metodlari olusturalim
                    //mouse ,sag tik,generate, getter and setter olustur, hepsini sec ve java bize olusturdu

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    // 3) Tum parametreleri iceren bir constructor olusturalim
                                //mouse ,sag tik,generate, constructor olustur, hepsini sec ve java bize olusturdu


    public PojoJsonPlaceHolder(String title, String body, int userId, int id) {
        this.title = title;
        this.body = body;
        this.userId = userId;
        this.id = id;
    }

    //4) Default constructor (parametresiz) olusturalim
                                    //mouse ,sag tik,generate, constructor olustur,select none ve java bize olusturdu

    public PojoJsonPlaceHolder() {
    }

    //5) toString( ) metodu olusturalim
                                    //mouse ,sag tik,generate, toString olustur ve java bize olusturdu


    @Override
    public String toString() {
        return "PojoJsonPlaceHolder{" +
                "title='" + title + '\'' +
                ", body='" + body + '\'' +
                ", userId=" + userId +
                ", id=" + id +
                '}';
    }
}
