package UI;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.provider.ContactsContract;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.itil_cards.R;

import java.nio.channels.ReadPendingException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Random;
import java.util.logging.Logger;

import DataBase.Repository;
import Entities.Card;
import Entities.SavedTerm;

public class FlashCards extends AppCompatActivity {
    //todo add ability to flip the cards so user sees answer and has to guess term
    //todo add text label to activity to dynamically change with title of the category of terms


    //if term, cardStatus = 0, if answer cardStatus = 1
    private int correctNum = 1;
    private int pos = 0;
    private int cardStatus = 0;
    private List<Card> allCards = new ArrayList<>();
    private HashMap<Card, Integer> wrongAnswers = new HashMap<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flash_cards);
        Repository repo = new Repository(getApplication());


        Log.d("allCards", String.valueOf(allCards.size()));

        //Set the flash card with the term:
        int lesson = getIntent().getIntExtra("lesson", 0);
                if(lesson == 1) {
                    allCards = repo.getmAllCards();
                }else if(lesson == 10){
                    allCards.addAll(SavedTerm.getSavedTerms());
                    ((ImageButton) findViewById(R.id.cutSavedTerm)).setVisibility(View.VISIBLE);
                }else {
                    allCards = repo.getCardsByLesson(lesson);
                }



        Collections.shuffle(allCards, new Random());
       ((TextView) findViewById(R.id.cardText)).setText(allCards.get(pos).getTerm());
       //todo use resource string
        ((TextView) findViewById(R.id.numberText)).setText(correctNum + "/" + allCards.size());

    }

    public void wrongButton(View view) {
        //todo if answer wrong more than twice, add duplicate card into flashcards
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                allCards.add(allCards.remove(pos));
                if( wrongAnswers.containsKey(allCards.get(allCards.size() - 1)) ){
                    wrongAnswers.replace(allCards.get(allCards.size() - 1), (wrongAnswers.get(allCards.get(allCards.size() - 1)) + 1));
                }else {
                    wrongAnswers.put(allCards.get(allCards.size() - 1), 1);
                }
                ((TextView) findViewById(R.id.cardText)).setText(allCards.get(pos).getTerm());
                cardStatus = 0;
            }
        }, 600);


    }

    public void repeatButton(View view) {
        //pos = pos + 1;
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                allCards.add(allCards.remove(pos));
                ((TextView) findViewById(R.id.cardText)).setText(allCards.get(pos).getTerm());
                cardStatus = 0;
            }
        }, 600);
    }

    public void checkButton(View view) {
        //pos = pos + 1;
        correctNum = correctNum + 1;
        Log.d("savedTerm", String.valueOf(SavedTerm.getSavedTerms().size()));
        allCards.remove(pos);
        Log.d("savedTerm", String.valueOf(SavedTerm.getSavedTerms().size()));


        if(allCards.size() <= pos){
            ((TextView) findViewById(R.id.cardText)).setText("No more terms");
            ((TextView) findViewById(R.id.numberText)).setText( correctNum-1 + "/" + allCards.size());
            TextView cardV = findViewById(R.id.cardText);
            cardV.setOnClickListener(null);
            ((ImageButton) findViewById(R.id.checkButton)).setVisibility(View.INVISIBLE);
            ((ImageButton) findViewById(R.id.repeatButton)).setVisibility(View.INVISIBLE);
            ((ImageButton) findViewById(R.id.wrongButton)).setVisibility(View.INVISIBLE);
            ((ImageButton) findViewById(R.id.saveTerm)).setVisibility(View.INVISIBLE);
            ((ImageButton) findViewById(R.id.cutSavedTerm)).setVisibility(View.INVISIBLE);
            return;
        }else{((TextView) findViewById(R.id.cardText)).setText(allCards.get(pos).getTerm());
            ((TextView) findViewById(R.id.numberText)).setText( correctNum + "/" + allCards.size());
            cardStatus = 0;
            }

    }

    public void cardViewClick(View view) {
        if (cardStatus == 0) {
            cardStatus = 1;
            ((TextView) findViewById(R.id.cardText)).setText(allCards.get(pos).getAnswer());
        }else{
            cardStatus = 0;
            ((TextView) findViewById(R.id.cardText)).setText(allCards.get(pos).getTerm());
        }
        return;
    }

    public void saveTerm(View view) {
        //TODO If already exists in list, TOAST and do not add to list
        Repository repo = new Repository(getApplication());
        //todo find saved term with same id

        Toast.makeText(this, "Term saved", Toast.LENGTH_SHORT).show();
        SavedTerm.addSavedTerm(repo.getCardByID(allCards.get(pos).getCard_id()));

//        if(SavedTerm.returnSavedTerm(allCards.get(pos).getCard_id())){
//            Toast.makeText(this, "Already saved", Toast.LENGTH_SHORT).show();
//        }else {
//            Toast.makeText(this, "Term saved", Toast.LENGTH_SHORT).show();
//            SavedTerm.addSavedTerm(repo.getCardByID(allCards.get(pos).getCard_id()));
//        }
    }

    public void homeOnClick(View view) {
        Intent i = new Intent(FlashCards.this, MainActivity.class);
        startActivity(i);
    }

    public void cutSavedTermOnClick(View view) {
        //todo reflect immediately the term is cut/ take out of view
        SavedTerm.deleteSavedTermByIndex(SavedTerm.getSavedTerms().indexOf(allCards.get(pos)));
        Toast.makeText(this, "Term unsaved", Toast.LENGTH_SHORT).show();
    }
}