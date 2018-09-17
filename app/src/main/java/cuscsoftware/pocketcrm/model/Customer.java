package cuscsoftware.pocketcrm.model;

/**
 * Created by Lam Thanh Huy on 2017/06/08.
 */

public class Customer {
    private String name;
    private String phoneNumber;
    private byte[] photo;

    public Customer(String name, String phoneNumber, byte[] photo) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.photo = photo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public byte[] getPhoto() {
        return photo;
    }

    public void setPhoto(byte[] photo) {
        this.photo = photo;
    }
}
