package com.qiangliu8.domain;

public class MyStudent {
    private Integer MyId;
    private String MyName;
    private String MyEmail;
    private Integer MyAge;

    public Integer getMyId() {
        return MyId;
    }

    public void setMyId(Integer myId) {
        MyId = myId;
    }

    public String getMyName() {
        return MyName;
    }

    public void setMyName(String myName) {
        MyName = myName;
    }

    public String getMyEmail() {
        return MyEmail;
    }

    public void setMyEmail(String myEmail) {
        MyEmail = myEmail;
    }

    public Integer getMyAge() {
        return MyAge;
    }

    public void setMyAge(Integer myAge) {
        MyAge = myAge;
    }

    public MyStudent() {
    }

    public MyStudent(Integer myId, String myName, String myEmail, Integer myAge) {
        MyId = myId;
        MyName = myName;
        MyEmail = myEmail;
        MyAge = myAge;
    }

    @Override
    public String toString() {
        return "MyStudent{" +
                "MyId=" + MyId +
                ", MyName='" + MyName + '\'' +
                ", MyEmail='" + MyEmail + '\'' +
                ", MyAge=" + MyAge +
                '}';
    }
}
