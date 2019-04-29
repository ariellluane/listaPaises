package Model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Paises implements Serializable {


    public Paises(long id, String name, String latitude, String longitude, String alphacod1, String alphacod2, String capital,
               String region, String subregion, String population, String demonym,
                  String area, String gini, String nativename, String numericcode) {

        this.id = id;
        this.name = name;
        this.latitude = latitude;
        this.longitude = longitude;
        this.alpha2Code = alphacod1;
        this.alpha3Code = alphacod2;
        this.capital = capital;
        this.region = region;
        this.subregion = subregion;
        this.population = population;
        this.demonym = demonym;
        this.area = area;
        this.gini = gini;
        this.nativename = nativename;
        this.numericCode = numericcode;
    }

    @Override
    public String toString() {
        return "Paises{" +
                " name='" + name + '\'' +
                " latitude='" + latitude + '\'' +
                " longitude='" + longitude + '\'' +
                " alphacod1='" + alpha2Code + '\'' +
                " alphacod2='" + alpha3Code + '\'' +
                " capital='" + capital + '\'' +
                " region='" + region + '\'' +
                " subregion='" + subregion + '\'' +
                " population='" + population + '\'' +
                " demonym='" + demonym + '\'' +
                " area='" + area + '\'' +
                " gini='" + gini + '\'' +
                " nativename='" + nativename + '\'' +
                " numericcode='" + numericCode + '\'' +
                '}';
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getLatitude() {
        return latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public String getAlpha2Code() {
        return alpha2Code;
    }

    public String getAlpha3Code() {
        return alpha3Code;
    }

    public String getCapital() {
        return capital;
    }

    public String getRegion() {
        return region;
    }

    public String getSubregion() {
        return subregion;
    }

    public String getPopulation() {
        return population;
    }

    public String getDemonym() {
        return demonym;
    }

    public String getArea() {
        return area;
    }

    public String getGini() {
        return gini;
    }

    public String getNativename() {
        return nativename;
    }

    public String getNumericcode(){
        return numericCode;
    }


    @SerializedName("id")
    public long id;

    @SerializedName("name")
    public String name;

    @SerializedName("latitude")
    public String latitude;

    @SerializedName("longitude")
    public String longitude;


    @SerializedName("alpha2Code")
    public String alpha2Code;

    @SerializedName("alpha3Code")
    public String alpha3Code;

    @SerializedName("capital")
    public String capital;

    @SerializedName("region")
    public String region;

    @SerializedName("subregion")
    public String subregion;

    @SerializedName("population")
    public String population;

    @SerializedName("demonym")
    public String demonym;

    @SerializedName("area")
    public String area;

    @SerializedName("gini")
    public String gini;

    @SerializedName("nativename")
    public String nativename;

    @SerializedName("numericCode")
    public String numericCode;



}
