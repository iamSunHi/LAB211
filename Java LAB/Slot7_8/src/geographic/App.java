/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package geographic;

/**
 *
 * @author Nhật Huy
 */
public class App extends Menu {

    ManageEastAsiaCountries manager = new ManageEastAsiaCountries();
    public static String[] optionsList = {"Input the information of 11 countries in East Asia", "Display the information of country you've just input", "Search the information of country by user-entered name", "Display the information of countries sorted name in ascending order"};

    public App(String title, String[] optionsList) {
        super(title, optionsList);
    }

    public static void main(String[] args) {
        App m = new App("MENU", optionsList);
        m.run();
        System.out.println("\nEnd Program !");
    }

    @Override
    public void execute(int choice) {
        switch (choice) {
            case 1:
                EastAsiaCountries country1 = new EastAsiaCountries("VN", "Viet Nam", 331698.0f, "Nice");
                EastAsiaCountries country2 = new EastAsiaCountries("IDN", "Indonesia", 1860360.0f, "Nice");
                EastAsiaCountries country3 = new EastAsiaCountries("TH", "Thailand", 513120.0f, "Diverse");
                EastAsiaCountries country4 = new EastAsiaCountries("JP", "Japan", 377972.0f, "Mountainous");
                EastAsiaCountries country5 = new EastAsiaCountries("KR", "South Korea", 100210.0f, "Hilly");
                manager.getCountries().add(country1);
                manager.getCountries().add(country2);
                manager.getCountries().add(country3);
                manager.getCountries().add(country4);
                manager.getCountries().add(country5);
//                manager.enterCountryInformation();
                break;
            case 2:
                manager.displayCountryInformation();
                break;
            case 3:
                manager.searchCountryByName();
                break;
            case 4:
                manager.displayCountriesAscending();
                break;
        }
    }
}
