import Opreations.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;



public class Main {


    public static void main(String[] args) {
       CountryDAO countriesDAO = new  CountryDAO();
       CityDAO citiesDAO = new CityDAO();


        //LAP 1 :-

        List<Country> countryList = countriesDAO.readAllCountries("files/countries.csv");
        List<City> cityList = citiesDAO.readAllCites("files/cities.csv");

        Map<Integer, List<City>> countryCities = new HashMap<>();

        for (City c : cityList) {
            if (!countryCities.containsKey(c.code)) {
                List<City> cities = new ArrayList<>();
                cities.add(c);
                countryCities.put(c.code, cities);
            }
            else {
                countryCities.get(c.code).add(c);
            }
        }

        countryCities.forEach((k, v) -> v.stream().map(City::getPopulation).sorted().collect(Collectors.toList()));

        System.out.println(countryCities);
        
        System.out.println("--------------------------------------------------------------------------------------------------------------------------------------------");
     
        
        //LAP 3 :-   
        
        Map<Integer, List<City>> highPop = cityList.stream()
                .collect(Collectors.groupingBy(City::getCode));
        
        highPop.forEach((k,v) ->
                System.out.println( v.stream().map(City::getPopulation).max(Double::compare)));

     
     
     
    }
}