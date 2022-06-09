package UI;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.itil_cards.R;

import DataBase.Repository;
import Entities.Card;
import Entities.SavedTerm;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Repository repo = new Repository(getApplication());



    }



    public void learnButton(View view) {
        Intent i = new Intent(MainActivity.this, FlashCards.class);
        i.putExtra("lesson", 1);
        startActivity(i);
    }

    public void keyTermsOnClick(View view) {
        Intent i = new Intent(MainActivity.this, FlashCards.class);
        i.putExtra("lesson", 2);
        startActivity(i);
    }

    public void principlesOnClick(View view) {
        Intent i = new Intent(MainActivity.this, FlashCards.class);
        i.putExtra("lesson", 3);
        startActivity(i);
    }

    public void dimensionsOnClick(View view) {
        Intent i = new Intent(MainActivity.this, FlashCards.class);
        i.putExtra("lesson", 4);
        startActivity(i);
    }

    public void svsOnClick(View view) {
        Intent i = new Intent(MainActivity.this, FlashCards.class);
        i.putExtra("lesson", 5);
        startActivity(i);
    }

    public void practicesOnClick(View view) {
        Intent i = new Intent(MainActivity.this, FlashCards.class);
        i.putExtra("lesson", 6);
        startActivity(i);
    }

    public void savedTermsOnClick(View view) {
        Intent i = new Intent(MainActivity.this, FlashCards.class);
        if(SavedTerm.getSavedTerms().size() == 0){
            Toast.makeText(this, "No Saved Terms", Toast.LENGTH_SHORT).show();
        }else {
            i.putExtra("lesson", 10);
            startActivity(i);
        }
    }
}