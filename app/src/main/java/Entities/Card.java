package Entities;


import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "card")
public class Card {

    @PrimaryKey(autoGenerate = true)
    public int card_id;

    private String term;

    private String answer;

    private String lesson_name;

    private int lesson_id;

    public Card( String term, String answer, String lesson_name, int lesson_id) {
        this.term = term;
        this.answer = answer;
        this.lesson_name = lesson_name;
        this.lesson_id = lesson_id;
    }



    public int getCard_id() {
        return card_id;
    }

    public void setCard_id(int card_id) {
        this.card_id = card_id;
    }

    public String getTerm() {
        return term;
    }

    public void setTerm(String term) {
        this.term = term;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public String getLesson_name() {
        return lesson_name;
    }

    public void setLesson_name(String lesson_name) {
        this.lesson_name = lesson_name;
    }

    public int getLesson_id() {
        return lesson_id;
    }

    public void setLesson_id(int lesson_id) {
        this.lesson_id = lesson_id;
    }
}
