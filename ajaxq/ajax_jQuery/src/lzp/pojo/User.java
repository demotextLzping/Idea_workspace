package lzp.pojo;


import com.oracle.webservices.internal.api.databinding.DatabindingMode;

import java.util.Date;

/**
 * @author： LZPing
 * @date： 2022-11-18 10:53
 * @Description
 */
public class User {
    private String name;
    private Integer age;
    private String gender;
    private Date birthdate;

    public User() {
    }

    public User(String name, Integer age, String gender, Date birthdate) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.birthdate = birthdate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Date getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }
}
