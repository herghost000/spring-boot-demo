package com.example.demo.entity;


import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="chouti_user")
public class User {

    //构造一个空构造函数不然启动报错
    public User() {
    }

    /**
     * id
     */
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    /**
     * name
     */
    @Column(name="name")
    private String name;
    /**
     * age
     */
    @Column(name="age")
    private int age;
    /**
     * sex
     */
    @Column(name="sex")
    private String sex;
    /**
     * birthday
     */
    @Column(name="birth_day")
    private Date birthDay;
    /**
     * imageurl
     */
    @Column(name="image_url")
    private String imageUrl;
    /**
     * province
     */
    @Column(name="province")
    private String province;
    /**
     * area
     */
    @Column(name="area")
    private String area;
    /**
     * sign
     */
    @Column(name="sign")
    private String sign;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Date getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(Date birthDay) {
        this.birthDay = birthDay;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (age != user.age) return false;
        if (id != null ? !id.equals(user.id) : user.id != null) return false;
        if (name != null ? !name.equals(user.name) : user.name != null) return false;
        if (sex != null ? !sex.equals(user.sex) : user.sex != null) return false;
        if (birthDay != null ? !birthDay.equals(user.birthDay) : user.birthDay != null) return false;
        if (imageUrl != null ? !imageUrl.equals(user.imageUrl) : user.imageUrl != null) return false;
        if (province != null ? !province.equals(user.province) : user.province != null) return false;
        if (area != null ? !area.equals(user.area) : user.area != null) return false;
        return sign != null ? sign.equals(user.sign) : user.sign == null;

    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + age;
        result = 31 * result + (sex != null ? sex.hashCode() : 0);
        result = 31 * result + (birthDay != null ? birthDay.hashCode() : 0);
        result = 31 * result + (imageUrl != null ? imageUrl.hashCode() : 0);
        result = 31 * result + (province != null ? province.hashCode() : 0);
        result = 31 * result + (area != null ? area.hashCode() : 0);
        result = 31 * result + (sign != null ? sign.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", sex='" + sex + '\'' +
                ", birthDay=" + birthDay +
                ", imageUrl='" + imageUrl + '\'' +
                ", province='" + province + '\'' +
                ", area='" + area + '\'' +
                ", sign='" + sign + '\'' +
                '}';
    }
}
