package com.quyeying.charity.report.dto;

/**
 * charity_sale
 * com.quyeying.charity.report.dto
 * Created with IntelliJ IDEA.
 * User: Watson
 * Date: 2014/6/21
 * Time: 14:57
 */
public class TotalReportDto {

    private String pkid;

    private String bscode;

    private String amount;

    private String name;

    private String sex;

    private String age;

    private String tel;


    public String getPkid() {
        return pkid;
    }

    public void setPkid(String pkid) {
        this.pkid = pkid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getBscode() {
        return bscode;
    }

    public void setBscode(String bscode) {
        this.bscode = bscode;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

}
