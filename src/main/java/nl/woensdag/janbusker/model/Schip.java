package nl.woensdag.janbusker.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Schip {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String naam;
    private int lengte;
    private boolean gezonken;

    public String getNaam() {
        return naam;
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }

    public int getLengte() {
        return lengte;
    }

    public void setLengte(int lengte) {
        this.lengte = lengte;
    }

    public boolean isGezonken() {
        return gezonken;
    }

    public void setGezonken(boolean gezonken) {
        this.gezonken = gezonken;
    }
}
