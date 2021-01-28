package com.example.fetching3;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Details_Pojo {
    @SerializedName("temperature")
    @Expose
    private String Name;
    @SerializedName("humidity")
    @Expose
    private String Age;
    @SerializedName("timestamps")
    @Expose
    private String Phone;

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getAge() {
        return Age;
    }

    public void setAge(String age) {
        Age = age;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String phone) {
        Phone = phone;
    }
}
