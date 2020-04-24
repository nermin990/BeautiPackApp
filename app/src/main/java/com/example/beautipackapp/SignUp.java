package com.example.beautipackapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class SignUp extends AppCompatActivity {

    FirebaseDatabase rootNode;
    DatabaseReference reference;

    EditText ime, korisnickoIme, eMail, lozinka, potvrdiLozinku;
    Button registrujSe, registrujSeKaoVlasnik;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_sign_up);

        ime = findViewById(R.id.punoIme);
        korisnickoIme = findViewById(R.id.vaseKorisnickoIme);
        eMail = findViewById(R.id.eMail);
        lozinka = findViewById(R.id.vasaLozinka);
        potvrdiLozinku = findViewById(R.id.potvrdiLozinku);
        registrujSe = findViewById(R.id.registrujSe);
        registrujSeKaoVlasnik = findViewById(R.id.registrujSeKaoVlasnik);

        registrujSe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rootNode = FirebaseDatabase.getInstance();
                reference = rootNode.getReference("Users");

                String name = ime.getEditableText().toString();
                String username = korisnickoIme.getEditableText().toString();
                String email = eMail.getEditableText().toString();
                String password = lozinka.getEditableText().toString();
                String confirmPassword = potvrdiLozinku.getEditableText().toString();

                UserHelper helper = new UserHelper(name, username, email, password, confirmPassword);

                reference.child(username).setValue(helper);

            }
        });
    }

    private Boolean validateName(){
        String val = ime.getEditableText().toString();

        if(val.isEmpty()){
            ime.setError("Morate uneti ime.");
            return false;
        }else{
            ime.setError(null);
            return true;
        }
    }

    private Boolean validateUsername(){
        String val = korisnickoIme.getEditableText().toString();
        String noWhiteSpace = "\\A\\w{4,20}\\z";
        //"\\A\\w{4,20}\\z"

        if(val.isEmpty()){
            korisnickoIme.setError("Morate uneti Korisnicko ime");
            return false;
        }else if(val.length()>=15) {
            korisnickoIme.setError("Korisnicko ime je predugacko");
            return false;
        }else if(val.length()<6){
            korisnickoIme.setError("Korisnicko ime mora imati najmanje 6 karaktera");
            return false;
        }else if(!val.matches(noWhiteSpace)){
            korisnickoIme.setError("Ne smete koristiti prazna mesta");
            return false;
        }else{
            korisnickoIme.setError(null);
            return true;
        }
    }

    private Boolean validateEmail(){
        String val = eMail.getEditableText().toString();
        String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";

        if(val.isEmpty()){
            eMail.setError("Morate uneti email adresu");
            return false;
        }else if(!val.matches(emailPattern)){
            eMail.setError("Neispravna email adresa");
            return false;
        }else{
            eMail.setError(null);
            return true;
        }
    }

    private Boolean validatePassword(){
        String val = lozinka.getEditableText().toString();
        String valPassword = "^(?=\\A\\w{4,20}\\z).{4,}$";

        if(val.isEmpty()){
            lozinka.setError("Morate uneti lozinku");
            return false;
        }else if(!val.matches(valPassword)){
            lozinka.setError("Lozinka je i suvise slaba");
            return false;
        }else{
            lozinka.setError(null);
            return true;
        }
    }
    //"^(?=.*[a-zA-Z])(?=.*[@#$%^&+=])(?=\\A\\w{4,20}\\z).{4,}$";
    private Boolean validateConfirmPassword(){
        String val = potvrdiLozinku.getEditableText().toString();
        String valPassword = "^(?=\\A\\w{4,20}\\z).{4,}$";

        if(val.isEmpty()){
            potvrdiLozinku.setError("Morate uneti istu lozinku");
            return false;
        }else if(!val.matches(valPassword)){
            potvrdiLozinku.setError("Lozinka je i suvise slaba");
            return false;
        }else{
            potvrdiLozinku.setError(null);
            return true;
        }
    }

    public void registerUser(View view){

        if(!validateName()| !validateUsername() | !validateEmail() | !validatePassword() | !validateConfirmPassword()){
            return;
        }
        String name = ime.getEditableText().toString();
        String username = korisnickoIme.getEditableText().toString();
        String email = eMail.getEditableText().toString();
        String phoneNo = lozinka.getEditableText().toString();
        String password = potvrdiLozinku.getEditableText().toString();
    }
}
