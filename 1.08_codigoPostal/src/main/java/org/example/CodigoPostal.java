package org.example;

import java.util.Objects;

public class CodigoPostal {
    private String cp;
    private String country;
    private String countryAbb;
    private Lugar[] places;

    public String getCp() {
        return cp;
    }

    public void setCp(String cp) {
        this.cp = cp;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCountryAbb() {
        return countryAbb;
    }

    public void setCountryAbb(String countryAbb) {
        this.countryAbb = countryAbb;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CodigoPostal that = (CodigoPostal) o;
        return Objects.equals(cp, that.cp) && Objects.equals(country, that.country);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cp, country);
    }
}
