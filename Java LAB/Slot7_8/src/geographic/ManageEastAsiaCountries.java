/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package geographic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Nhật Huy
 */
public class ManageEastAsiaCountries {

    private List<Country> countries;

    public ManageEastAsiaCountries() {
        countries = new ArrayList<>();
    }

    public void enterCountryInformation() {
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < 11; i++) {
            System.out.println("Enter information for Country " + (i + 1));
            System.out.print("Enter code of country: ");
            String countryCode = scanner.nextLine();
            System.out.print("Enter name of country: ");
            String countryName = scanner.nextLine();
            System.out.print("Enter total Area: ");
            float totalArea = Float.parseFloat(scanner.nextLine());
            System.out.print("Enter terrain of country: ");
            String countryTerrain = scanner.nextLine();

            EastAsiaCountries country = new EastAsiaCountries(countryCode, countryName, totalArea, countryTerrain);
            countries.add(country);
            System.out.println("-----------------------------");
        }
    }

    public void displayCountryInformation() {
        System.out.println("ID\t\tName\t\tTotal Area\tTerrain");
        countries.forEach((Country country) -> {
            System.out.printf("%-16s%-16s%-16.1f%s%n", ((EastAsiaCountries) country).getCountryCode(), ((EastAsiaCountries) country).getCountryName(), ((EastAsiaCountries) country).getTotalArea(), ((EastAsiaCountries) country).getCountryTerrain());
        });
    }

    public void searchCountryByName() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the name you want to search for: ");
        String searchName = sc.nextLine();

        boolean found = false;
        System.out.println("ID\t\tName\t\tTotal Area\tTerrain");
        for (Country country : countries) {
            if (country.getCountryName().equals(searchName)) {
                System.out.printf("%-16s%-16s%-16.1f%s%n", ((EastAsiaCountries) country).getCountryCode(), ((EastAsiaCountries) country).getCountryName(), ((EastAsiaCountries) country).getTotalArea(), ((EastAsiaCountries) country).getCountryTerrain());
                found = true;
            }
        }
        if (!found) {
            System.out.println("Country not found!");
        }
        System.out.println(); // Add a blank line for better readability
    }

    public void displayCountriesAscending() {
        Collections.sort(countries, (Country c1, Country c2) -> c1.getCountryName().compareTo(c2.getCountryName()));

        System.out.println("ID\t\tName\t\tTotal Area\tTerrain");
        countries.forEach((country) -> {
            System.out.printf("%-16s%-16s%-16.1f%s%n", ((EastAsiaCountries) country).getCountryCode(), ((EastAsiaCountries) country).getCountryName(), ((EastAsiaCountries) country).getTotalArea(), ((EastAsiaCountries) country).getCountryTerrain());
        });
        System.out.println(); // Add a blank line for better readability
    }

    public List<Country> getCountries() {
        return countries;
    }

    public void setCountries(List<Country> countries) {
        this.countries = countries;
    }

}
