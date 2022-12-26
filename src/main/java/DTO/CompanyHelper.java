package DTO;

import DAO.CompanyDAO;
import DTO.Company;

import java.util.List;

public class CompanyHelper {

    CompanyDAO companies;

    public CompanyDAO getCompanies() {
        return companies;
    }

    public void setCompanies(CompanyDAO companies) {
        this.companies = companies;
    }

}
