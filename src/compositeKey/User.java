package compositeKey;

/**
 * Created by admin on 2017/6/17.
 */
public class User {


    private int age;
    private CompositeKey keys;

    public CompositeKey getKeys() {
        return keys;
    }

    public void setKeys(CompositeKey keys) {
        this.keys = keys;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }



}
