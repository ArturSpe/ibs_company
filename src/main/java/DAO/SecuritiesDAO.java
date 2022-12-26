package DAO;

import DTO.Securities;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.*;

public class SecuritiesDAO extends ArrayList<Securities> {


    public boolean addSecurities(Securities securities){
        return this.add(securities);
    }

    public List<Securities> overdueSecurities(){

        List<Securities> list = new ArrayList<>();

        for(Securities securities : this){
            if ((securities.getDate().before(Date.from(LocalDate.now().atStartOfDay().atZone(ZoneId.systemDefault()).toInstant())))) {
                list.add(securities);
            }
        }
        return list;
    }

    public Set<Securities> byCurrency(String currency){

        Set<Securities> securitiesSet = new HashSet<>();
        for (Securities securities : this){
            for (String s : securities.getCurrency()){
                if(s.equals(currency)){
                    securitiesSet.add(securities);
                }
            }
        }
        return securitiesSet;
    }
}
