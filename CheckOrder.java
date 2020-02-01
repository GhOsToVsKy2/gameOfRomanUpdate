public class CheckOrder {
    String order;
    String[] correctOrder = {"rzuc pila", "destudo", "bronic orla", "walcz", "bronic dowodce", "zmien pozycje:"};
    public CheckOrder(String order){
        this.order = order;
    }
    public boolean correctOrd(){
        boolean corrOrd = false;
        String[] Ord = order.split(":");
        if(Ord[0].equals("zmien pozycje")) {
        	corrOrd = true;
        	String[] position = Ord[1].split(" ");
        	try {
	        	position(Integer.parseInt(position[1]), Integer.parseInt(position[2]), Integer.parseInt(position[3]));
        	}catch(Exception e) {
        		e.printStackTrace();
        	}
        }else {
	        for(int i = 0; i < correctOrder.length; i++)
	            corrOrd=correctOrder[i].equals(order);
        }

        return corrOrd;
    }
    public void position(int id, int x, int y) {
    	Map.mapa[x][y] = Map.mapa[Jednostki.legion.get(id).x][Jednostki.legion.get(id).y];
    	Map.mapa[Jednostki.legion.get(id).x][Jednostki.legion.get(id).y] = ' ';
    	Map.jednostki.legion.get(id).x = x;
    	Map.jednostki.legion.get(id).y = y;
    }
}