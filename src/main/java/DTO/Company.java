package DTO;

import DAO.SecuritiesDAO;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.sql.Date;
import java.text.SimpleDateFormat;

public class Company {

    private long id;
    private String name;
    private String address;
    private String phoneNumber;
    private String inn;
    @JsonFormat(pattern = "yyyy.MM.dd")
    private java.util.Date founded;
    private SecuritiesDAO securities;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getInn() {
        return inn;
    }

    public void setInn(String inn) {
        this.inn = inn;
    }

    public java.util.Date getFounded() {
        return founded;
    }

    public void setFounded(Date founded) {
        this.founded = founded;
    }

    public SecuritiesDAO getSecurities() {
        return securities;
    }

    public void setSecurities(SecuritiesDAO securities) {
        this.securities = securities;
    }

    @Override
    public String toString(){
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yy");
        return name + " Дата основания: " + format.format(founded);
    }
}