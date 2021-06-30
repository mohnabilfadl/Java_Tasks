package Opreations;


import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

public class CountryDAO {

    public List<Country> readAllCountries(String fileName) {
        File f = new File(fileName);
        List<Country> countries = new ArrayList<>();
        try {
            List<String> lines = Files.readAllLines(f.toPath());
            for (int i = 1; i < lines.size(); i++) {
                countries.add(createCountry(lines.get(i)));
            }

            return countries;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }


    }

    public Country createCountry(String line) {
        String[] fields = line.split(",");
        return new Country(Integer.parseInt(fields[0]), fields[1]);
    }

}
