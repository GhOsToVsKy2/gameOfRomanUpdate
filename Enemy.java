
public class Enemy extends Jednostki{
	static boolean toDo = false;
	public Enemy(int id, int x, int y, int strona){
        sila = 100;
        liczebnosc = 200;
        wyszkolenie = 0;
        morale = 100;
        wyposazenie = 1;
        zasieg = 10;
        this.id = id;
        this.x = x;
        this.y = y;
        this.strona = strona;
    }
	 
	public static void bot(int enemyId) {
		for(int i = 1; i < 11; i++) {
			if(Map.mapa[Jednostki.enemyArmy.get(enemyId).x+i][Jednostki.enemyArmy.get(enemyId).y] == 'P' || Map.mapa[Jednostki.enemyArmy.get(enemyId).x+1][Jednostki.enemyArmy.get(enemyId).y] == 'K' || Map.mapa[Jednostki.enemyArmy.get(enemyId).x+1][Jednostki.enemyArmy.get(enemyId).y] == '_') {
				Map.mapa[Jednostki.enemyArmy.get(enemyId).x][Jednostki.enemyArmy.get(enemyId).y] = ' ';
				Map.mapa[Jednostki.enemyArmy.get(enemyId).x+i-1][Jednostki.enemyArmy.get(enemyId).y] = 'W';
				Jednostki.enemyArmy.get(enemyId).x = Jednostki.enemyArmy.get(enemyId).x+i-1;
				toDo = true;
				break;
			}
		}
		if(toDo == false) {
			Map.mapa[Jednostki.enemyArmy.get(enemyId).x][Jednostki.enemyArmy.get(enemyId).y] = ' ';
			Map.mapa[Jednostki.enemyArmy.get(enemyId).x+10][Jednostki.enemyArmy.get(enemyId).y] = 'W';
			Jednostki.enemyArmy.get(enemyId).x = Jednostki.enemyArmy.get(enemyId).x+10;
			Jednostki.enemyArmy.get(enemyId).y = Jednostki.enemyArmy.get(enemyId).y;
		}
		if(toDo == true) {
			
		}
	}
}
