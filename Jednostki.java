import java.util.HashMap;
public class Jednostki {
    int id;
    int sila;
    int liczebnosc;
    int wyszkolenie;
    int morale;
    int wyposazenie;
    int strona;
    int zasieg;
    int x;
    int y;
    static public HashMap<Integer, Jednostki> legion = new HashMap<>();
    static public HashMap<Integer, Jednostki> enemyArmy = new HashMap<>();
    
    public Jednostki(){

    }
}