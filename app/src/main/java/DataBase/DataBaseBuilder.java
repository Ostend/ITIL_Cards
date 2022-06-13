package DataBase;


import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import DAO.CardsDAO;
import Entities.Card;

@Database(entities = {Card.class}, version=3, exportSchema = false)
public abstract class DataBaseBuilder extends RoomDatabase {
    public abstract CardsDAO getCardsDAO();

    private static volatile DataBaseBuilder INSTANCE;

    static DataBaseBuilder getDatabase(final Context context) {
        synchronized (DataBaseBuilder.class) {
            if (INSTANCE == null) {
                INSTANCE = Room.databaseBuilder(context.getApplicationContext(), DataBaseBuilder.class, "Cards.db")
                                .fallbackToDestructiveMigration()
                                .build();
            }
        }
        return INSTANCE;
    }


}
