public class CheckOrder {
	boolean corrOrd = false;
    String order;
    String[] correctOrder = {"rzuc pila", "destudo", "bronic orla", "walcz", "bronic dowodce", "zmien pozycje:"};
    public CheckOrder(String order){
        this.order = order;
    }
    public boolean correctOrd(){  
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
	        for(int i = 0; i < correctOrder.length; i++) {
	            corrOrd=correctOrder[i].equals(order);
	            if(corrOrd == true) {
	            	break;
	            }
	        }
	        if(corrOrd == true) {
	        	doOrder(order);
	        }
        }

        return corrOrd;
    }
    public void position(int id, int x, int y) {
    	if((x - Jednostki.legion.get(id).x) + (y - Jednostki.legion.get(id).y) <= Jednostki.legion.get(id).zasieg && Map.mapa[x][y] != '|' && Map.mapa[x][y] != '_') {
	    	Map.mapa[x][y] = Map.mapa[Jednostki.legion.get(id).x][Jednostki.legion.get(id).y];
	    	Map.mapa[Jednostki.legion.get(id).x][Jednostki.legion.get(id).y] = ' ';
	    	Map.jednostki.legion.get(id).x = x;
	    	Map.jednostki.legion.get(id).y = y;
    	}else {
    		corrOrd = false;
    	}
    }
    public void doOrder(String order) {
    	
    	if(order.equals("rzuc pila")) {
    		if(ManagerLegion.pila == 0) {
    			
    		}
    		if(ManagerLegion.pila == 1) {
    			
    		}
    		ManagerLegion.pila = (ManagerLegion.pila+1)%2;
    	}
    	if(order.equals("destudo")) {
    		if(ManagerLegion.destudo == 0) {
	    		for(int i = 0; i <= Jednostki.legion.size(); i++) {
	    			Jednostki.legion.get(i).sila += 200;
	    		}
    		}
    		if(ManagerLegion.destudo == 1) {
    			for(int i = 0; i <= Jednostki.legion.size(); i++) {
	    			Jednostki.legion.get(i).sila -= 200;
    			}
    		}
    		ManagerLegion.destudo = (ManagerLegion.destudo+1)%2;
    	}
    	if(order.equals("bronic orla")) {
    		if(ManagerLegion.orzel == 0) {
	    		for(int i = 0; i <= Jednostki.legion.size(); i++) {
	    			Jednostki.legion.get(i).sila += 100;
	    			Jednostki.legion.get(i).morale += 100;
	    		}
    		}
    		if(ManagerLegion.orzel == 1) {
    			for(int i = 0; i <= Jednostki.legion.size(); i++) {
	    			Jednostki.legion.get(i).sila -= 100;
	    			Jednostki.legion.get(i).morale -= 100;
	    		}
    		}
    		ManagerLegion.orzel = (ManagerLegion.orzel+1)%2;
    	}
    	if(order.equals("walcz")) {
    		if(ManagerLegion.walcz == 0) {
    			
    		}
    		if(ManagerLegion.walcz == 1) {
    			
    		}
    		ManagerLegion.walcz = (ManagerLegion.walcz+1)%2;
    		System.out.println(ManagerLegion.walcz);
    	}
		if(order.equals("bronic dowodce")) {
			if(ManagerLegion.dowodca == 0) {
				for(int i = 0; i <= Jednostki.legion.size(); i++) {
	    			Jednostki.legion.get(i).morale -= 50;
	    			if(Jednostki.legion.get(i).morale < 0) {
	    				Jednostki.legion.get(i).morale = 0;
	    			}
	    		}
			}
			if(ManagerLegion.dowodca == 1) {
				for(int i = 0; i <= Jednostki.legion.size(); i++) {
	    			Jednostki.legion.get(i).morale += 50;
	    		}
			}
			ManagerLegion.dowodca = (ManagerLegion.dowodca+1)%2;
		}
    }
}