package DTO;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class Securities {

    private String name;
    private String code;
    private Date date;
    private List<String> currency;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @JsonFormat(pattern="dd.MM.yyyy")
    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public List<String> getCurrency() {
        return currency;
    }

    public void setCurrency(List<String> currency) {
        this.currency = currency;
    }

    @Override
    public String toString(){
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yy");
        return "Название: "+ name + " Код: " + code + " Дата истечения: " + format.format(date);
    }

    @Override
    public int hashCode (){
        return this.code.hashCode();
    }

    @Override
    public boolean equals(Object ob)
    {
        if (ob == this) {
            return true;
        }
        if (ob == null || ob.getClass() != getClass()) {
            return false;
        }
        Securities s = (Securities) ob;
        return this.code.equals(s.code);
    }
}
