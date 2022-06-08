package UI;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.itil_cards.R;

import java.nio.channels.ReadPendingException;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.logging.Logger;

import DataBase.Repository;
import Entities.Card;

public class FlashCards extends AppCompatActivity {
    //todo add ability to flip the cards so user sees answer and has to guess term
    //todo create side list of all 'wrong' answers
    //if term, cardStatus = 0, if answer cardStatus = 1
    private int correctNum = 1;
    private int pos = 0;
    private int cardStatus = 0;
    private List<Card> allCards = new ArrayList<>();
    private Queue<Card> qCards = new PriorityQueue<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flash_cards);
        Repository repo = new Repository(getApplication());
        allCards = repo.getmAllCards();
        Log.d("allCards", String.valueOf(allCards.size()));

        //Set the flash card with the term:

       ((TextView) findViewById(R.id.cardText)).setText(allCards.get(pos).getTerm());
       //todo use resource string
        ((TextView) findViewById(R.id.numberText)).setText(correctNum + "/" + allCards.size());

    }

    public void wrongButton(View view) {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                allCards.add(allCards.remove(pos));
                ((TextView) findViewById(R.id.cardText)).setText(allCards.get(pos).getTerm());
                cardStatus = 0;
            }
        }, 600);


    }

    public void repeatButton(View view) {
        //pos = pos + 1;
        allCards.add(allCards.remove(pos));
        ((TextView) findViewById(R.id.cardText)).setText(allCards.get(pos).getTerm());
        cardStatus = 0;
    }

    public void checkButton(View view) {
        //pos = pos + 1;
        correctNum = correctNum + 1;
        allCards.remove(pos);
        if(allCards.size() <= pos){
            ((TextView) findViewById(R.id.cardText)).setText("No more terms");
            ((TextView) findViewById(R.id.numberText)).setText( correctNum-1 + "/" + allCards.size());
            ImageButton check = findViewById(R.id.checkButton);
            check.setEnabled(false);
            TextView cardV = findViewById(R.id.cardText);
            cardV.setOnClickListener(null);
            return;
        }else{((TextView) findViewById(R.id.cardText)).setText(allCards.get(pos).getTerm());
            ((TextView) findViewById(R.id.numberText)).setText( correctNum + "/" + allCards.size());
            cardStatus = 0;
            }

        //List.remove(index)

    }

    public void cardViewClick(View view) {
        if (cardStatus == 0) {
            cardStatus = 1;
            ((TextView) findViewById(R.id.cardText)).setText(allCards.get(pos).getAnswer());
            return;
        }else{
            cardStatus = 0;
            ((TextView) findViewById(R.id.cardText)).setText(allCards.get(pos).getTerm());
            return;
        }
    }
}