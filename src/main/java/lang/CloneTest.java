package lang;

import com.alibaba.fastjson.JSON;

/**
 * @author zhangxinpeng
 * @date 2021/6/18
 */
public class CloneTest implements Cloneable {
    public static void main(String[] args) throws CloneNotSupportedException {
        User user = new User("Tad", 30);
        user.setAddress(new Address("山东省"));
        Object user1 = user.clone();
        user.setName("xxx");
        user.getAddress().setProvince("北京市");
        System.out.println(JSON.toJSONString(user));
        System.out.println(JSON.toJSONString(user1));
        CloneTest cloneTest = new CloneTest();
        cloneTest.clone();
    }
}

class User extends Object implements Cloneable {
    private String name;
    private int age;

    private Address address;

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @Override
    protected Object clone() {
        try {
            User u = (User)super.clone();
            u.setAddress((Address) address.clone());
            return u;
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return null;
    }
}

class Address implements Cloneable {
    private String province;

    public Address(String province) {
        this.province = province;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    @Override
    protected Object clone() {
        try {
            return super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return null;
    }
}
