
import java.io.IOException;
import java.text.ParseException;
import java.util.Scanner;


public class main {

    public static void main (String[] args) throws IOException, ParseException {

        String string;
        App app = new App("src/main/resources/json.txt");

        while (true){
            System.out.println("Введите команду: \n Все компании - all \n Просроченные бумаги - over \n Поиск по дате - date \n Поиск по валюте - curr ");
            string = new Scanner(System.in).nextLine();

            if (string.equals("all")){
                app.printCompanies();
            }
            if (string.equals("over")){
                app.printOverdueSec();
            }
            if (string.equals("date")){
                System.out.println("Введите дату в формате ДД.ММ.ГГГГ или ДД.ММ.ГГ");
                string = new Scanner(System.in).nextLine();
                app.printCompanyByDate(string);
            }
            if (string.equals("curr")){
                System.out.println("Введите валюту");
                string = new Scanner(System.in).nextLine();
                app.printSecuritiesByCurrency(string);
            }
        }

    }

}
