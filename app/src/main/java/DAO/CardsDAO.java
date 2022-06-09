package DAO;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;

import Entities.Card;

@Dao
public interface CardsDAO {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insert(Card card);

    @Delete
    void delete(Card card);

    @Query("SELECT * FROM card WHERE card.card_id = :id")
    Card  returnCardbyID(int id);

    @Query("SELECT * FROM card")
    List<Card> getAllCards();

    @Query("SELECT * FROM card WHERE card.lesson_id = :id")
    List<Card> getCardsByLesson(int id);

}
