public class Konnica extends Jednostki{
    public Konnica(int id, int x, int y, int strona){
    	sila = 200;
    	liczebnosc = 300;
        wyszkolenie = 1;
        morale = 25;
        wyposazenie = 5;
        zasieg = 10;
        this.id = id;
        this.x = x;
        this.y = y;
        this.strona = strona;
    }
}