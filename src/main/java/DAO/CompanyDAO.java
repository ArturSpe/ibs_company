package DAO;

import DTO.Company;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CompanyDAO extends ArrayList<Company> {

    public List<Company> getCompanyByDate (Date date){

        List<Company> companyList = new ArrayList<>();
        for (Company company: this){
            if (company.getFounded().before(date)){
                companyList.add(company);
            }
        }
        return companyList;
    }

}
