package Opreations;


public class City {
    public int code;
    private String name, country;
    private double surfaceArea;
    private double population;

    public City(int code, String name, String country, double surfaceArea, double population) {

        this.code = code;
        this.name = name;
        this.country = country;
        this.surfaceArea = surfaceArea;
        this.population = population;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public double getSurfaceArea() {
        return surfaceArea;
    }

    public void setSurfaceArea(double surfaceArea) {
        this.surfaceArea = surfaceArea;
    }

    public double getPopulation() {
        return population;
    }

    public void setPopulation(double population) {
        this.population = population;
    }

    @Override
    public String toString() {
        return "City [code=" + code + ", name=" + name + ", country=" + country + ", surfaceArea=" + surfaceArea
                + ", population=" + population + "]";
    }

    
    }



