package UI;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.itil_cards.R;

import DataBase.Repository;
import Entities.Card;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Repository repo = new Repository(getApplication());

        Card card = new Card("Service",
                "A means of enabling value co-creation by facilitating outcomes that customers want to achieve without the customers having to manage specific costs and risks.",
                "Key Definitions", 2);
        Card card1 = new Card("Service Management",
                "A set of specialized organizational capabilities for enabling value for customers in the form of services.",
                  "Key Definitions", 2);
        Card card2 = new Card("Customer",
                "A person who defines the requirements for a service and takes responsibility for the outcome of service production.",
                "Key Definitions", 2);
        Card card3 = new Card("User", "A person who uses services.",
                "Key Definitions", 2);
        Card card4 = new Card("Sponsor",
                "A person who authorized budget for service consumption.",
                "Key Definitions", 2);
//        repo.insertCard(card2);
//        repo.insertCard(card3);
//        repo.insertCard(card4);
//        Card deleteC = repo.getCardByID(5);
//        repo.deleteCard(deleteC);
    }


    public void learnButton(View view) {
        Intent i = new Intent(MainActivity.this, FlashCards.class);
        startActivity(i);
    }
}