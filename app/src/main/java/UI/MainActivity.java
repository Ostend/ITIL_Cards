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
                "A means of enabling value co-creation by facilitating outcomes that customers want to acheive without the customers having to manage specific costs and risks.",
                "Key Definitions", 2);
//        repo.insertCard(card);
//        Card deleteC = repo.getCardByID(2);
//        repo.deleteCard(deleteC);
    }


    public void learnButton(View view) {
        Intent i = new Intent(MainActivity.this, FlashCards.class);
        startActivity(i);
    }
}