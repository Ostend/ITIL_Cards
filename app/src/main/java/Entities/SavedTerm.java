package Entities;

import java.util.ArrayList;
import java.util.List;

public class SavedTerm {
    private static List<Card> savedTerm = new ArrayList<>();

    public static List<Card> getSavedTerms() {
        return savedTerm;
    }

    public static void addSavedTerm(Card card){
        savedTerm.add(card);
    }

    public static void deleteSavedTermItem(Card card){
        savedTerm.remove(card);
    }
}
