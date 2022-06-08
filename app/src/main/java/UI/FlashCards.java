package UI;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.example.itil_cards.R;

import java.nio.channels.ReadPendingException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import DataBase.Repository;
import Entities.Card;

public class FlashCards extends AppCompatActivity {
    private List<Card> allCards = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flash_cards);
        Repository repo = new Repository(getApplication());
        allCards = repo.getmAllCards();
        Log.d("allCards", String.valueOf(allCards.size()));

        //Set the flash card with the term:
       ((TextView) findViewById(R.id.cardText)).setText(allCards.get(0).getTerm());
    }

    public void wrongButton(View view) {
    }

    public void repeatButton(View view) {
    }

    public void checkButton(View view) {
    }

    public void cardViewClick(View view) {
    }
}