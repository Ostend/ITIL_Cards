package DataBase;

import android.app.Application;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import DAO.CardsDAO;
import Entities.Card;

public class Repository {
    private CardsDAO mCardsDAO;
    private List<Card> mAllCards;
    private Card card;


    private static int NUMBER_OF_THREADS = 4;
    static final ExecutorService databaseExecutor = Executors.newFixedThreadPool(NUMBER_OF_THREADS);

    public Repository(Application application){
        DataBaseBuilder db = DataBaseBuilder.getDatabase(application);
        mCardsDAO = db.getCardsDAO();
    }

    public void insertCard(Card card){
        databaseExecutor.execute(()->{
            mCardsDAO.insert(card);
        });
        try{
            Thread.sleep(1000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }

    public void deleteCard(Card card){
        databaseExecutor.execute(()->{
            mCardsDAO.delete(card);
        });
        try{
            Thread.sleep(1000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }

    public Card getCardByID(int id){
        databaseExecutor.execute(()->{
            card =  mCardsDAO.returnCardbyID(id);
        });
        try{
            Thread.sleep(1000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }

        return card;
    }

    public List<Card> getmAllCards(){
        databaseExecutor.execute(()->{
            mAllCards = mCardsDAO.getAllCards();
        });
        try{
            Thread.sleep(1000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        return mAllCards;
    }

    public List<Card> getCardsByLesson(int lessonId){
        databaseExecutor.execute(()->{
            mAllCards = mCardsDAO.getCardsByLesson(lessonId);
        });
        try{
            Thread.sleep(1000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        return mAllCards;
    }



}
