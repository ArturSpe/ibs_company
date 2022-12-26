import DAO.CompanyDAO;
import DAO.SecuritiesDAO;
import DTO.Company;
import DTO.CompanyHelper;
import DTO.Securities;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class App {

    File file;
    ObjectMapper objectMapper;
    CompanyDAO companyDAO;


    public App (String path) throws IOException {
        file = new File(path);
        objectMapper = new ObjectMapper();
        CompanyHelper securitiesList = objectMapper.readValue(file, CompanyHelper.class);
        companyDAO = securitiesList.getCompanies();
    }

    public void printCompanies(){
        companyDAO.forEach(System.out::println);
    }


    public void printOverdueSec(){
        int i = 0;
        Set<String> stringSet = new HashSet<>();

        for (Company company:companyDAO){
            Map<String, List<Securities>> listMap = new HashMap<>();
            List<Securities> securitiesList = company.getSecurities().overdueSecurities();
            if (securitiesList.size() != 0){
                listMap.put(company.getName(), securitiesList);
                stringSet.add(company.getName());
            }
            for (Map.Entry<String, List<Securities>> entry: listMap.entrySet()){
                System.out.println("Компания с просроченными бумагами: " + entry.getKey() + " Ее бумаги: ");
                entry.getValue().forEach(System.out::println);
                System.out.println("___________________");
            }
        }
        System.out.println("Всего таких бумаг: " + stringSet.size());
    }

    public void printCompanyByDate(String date) throws ParseException {

        SimpleDateFormat format;
        date = date.replaceAll("\\D", ".");
        if (date.length() == 10){
            format = new SimpleDateFormat("dd.MM.yyyy");
        }else {
            format = new SimpleDateFormat("dd.MM.yy");
        }
        companyDAO.getCompanyByDate(format.parse(date)).forEach(System.out::println);
    }

    public void printSecuritiesByCurrency(String currency){

        Set<Securities> securitiesSet = new HashSet<>();
        currency = currency.toUpperCase();
        for (Company company : companyDAO){
            securitiesSet.addAll(company.getSecurities().byCurrency(currency));
        }
        securitiesSet.forEach(System.out::println);
    }

}
