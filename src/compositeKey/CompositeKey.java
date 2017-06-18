package compositeKey;

import java.io.Serializable;

/**
 * Created by admin on 2017/6/17.
 */
public class CompositeKey implements Serializable {

    private String userName;
    private String address;
    public String getUserName() {
        return userName;
    }
    public void setUserName(String userName) {
        this.userName = userName;
    }
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
}
