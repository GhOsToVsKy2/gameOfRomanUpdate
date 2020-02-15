import java.io.IOException;
public class Map {
    static char[][] mapa = new char[50][100];
    int id = 0;
    int enemyId = 0;
    static Jednostki jednostki = new Jednostki();
    public void stratup() {
    	for(int i = 0; i < mapa.length; i++){
            for(int j = 0; j < mapa[i].length; j++){
                mapa[i][j] = 0;
            }
        }
        for(int i = 0; i < 60; i++){
            mapa[48][i+20] = 1;
        }
        mapa[48][19] = 2;
        mapa[48][80] = 2;
        for(int i = 0; i < 60; i++) {
        	mapa[3][i+20] = 3;
        }
    }
    public void jednostki(){
        for(int i = 0; i < mapa.length; i++) {
            for (int j = 0; j < mapa[i].length; j++) {
                if(i == 0 || i == 49 || j == 0 || j == 99){
                    mapa[i][j] = '_';
                }
                if(i > 0 &&( j == 0 || j == 99)){
                    mapa[i][j] = '|';
                }
                if(mapa[i][j] == 1){
                    Piechota_ciezka piechotaCiezka = new Piechota_ciezka(id, i, j, 0);
                    jednostki.legion.put(id, piechotaCiezka);
                    mapa[i][j] = 'P';
                    id++;
                    
                }
                if(mapa[i][j] == 2){
                    Konnica konnica = new Konnica(id, i, j, 0);
                    jednostki.legion.put(id, konnica);
                    mapa[i][j] = 'K';
                    id++;
                }
                else if(mapa[i][j] == 3){
                    mapa[i][j] = 'W';
                    Enemy enemy = new Enemy(enemyId,i,j,1);
                    jednostki.enemyArmy.put(enemyId, enemy);
                    enemyId++;
                }
                else if(mapa[i][j] == 0){
                    mapa[i][j] = ' ';
                }
                System.out.print(mapa[i][j]);
            }
            System.out.println();
        }
        for(int i = 0; i < enemyId; i++) {
        	Enemy.bot(i);
        }
    }
    public void przygotowanie(){

        System.out.println("Na mapie masz rozmieszczenie swoich jednostek (P)(K)");
        System.out.println("Wydaj rozkazy swoim jednostkom");
        jednostki();
    }
    public final static void  clearScreen(){
        try {
            if (System.getProperty("os.name").contains("Windows"))
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            else
                Runtime.getRuntime().exec("clear");
        } catch (IOException | InterruptedException ex) {}
    }
}