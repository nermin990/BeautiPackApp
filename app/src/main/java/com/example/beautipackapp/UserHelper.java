package com.example.beautipackapp;

public class UserHelper {

    String ime, korisnickoIme, email, lozinka, potvrdiLozinku;

    public UserHelper() {
    }

    public UserHelper(String ime, String korisnickoIme, String email, String lozinka, String potvrdiLozinku) {
        this.ime = ime;
        this.korisnickoIme = korisnickoIme;
        this.email = email;
        this.lozinka = lozinka;
        this.potvrdiLozinku = potvrdiLozinku;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getKorisnickoIme() {
        return korisnickoIme;
    }

    public void setKorisnickoIme(String korisnickoIme) {
        this.korisnickoIme = korisnickoIme;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLozinka() {
        return lozinka;
    }

    public void setLozinka(String lozinka) {
        this.lozinka = lozinka;
    }

    public String getPotvrdiLozinku() {
        return potvrdiLozinku;
    }

    public void setPotvrdiLozinku(String potvrdiLozinku) {
        this.potvrdiLozinku = potvrdiLozinku;
    }
}
