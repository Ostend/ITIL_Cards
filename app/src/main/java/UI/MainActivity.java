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

//        repo.insertCard(new Card("6 steps of optimization: ",
//                "1.Understand and agree on the context in which the proposed optimization exists. 2.Assess the current state of the proposed optimization. 3.Agree what the future state and priorities of the organization should be. 4.Ensure optimization has the appropriate level of stakeholder engagement. 5.Execute the improvements iteratively. 6.Continually monitor the impact of the optimization.  ",
//                "Guiding Principles", 3));


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
}