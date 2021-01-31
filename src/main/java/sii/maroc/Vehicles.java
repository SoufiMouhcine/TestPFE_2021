package sii.maroc;

import static org.hamcrest.CoreMatchers.nullValue;

import java.util.PrimitiveIterator.OfDouble;

public class Vehicles {
	
	private String moteur;
	enum typeVehiculeEnum {
			CAR,TRUCK,MOTORCYCLE
	};
	

	public Vehicles(String moteur) {
		super();
		this.moteur = moteur;
	}
	
	public int consomationMoteur(String moteur) {
		int consomation=0;
		String moteurType[] = this.moteur.split(",");
		for (String m: moteurType) {
			if(m.contains(moteur)) {
				String consomationSplit[] = m.split(":");
				String cnsomationPerCent[] = consomationSplit[1].split("%");
				consomation=Integer.parseInt(cnsomationPerCent[0]);
				
			}
		}
		return consomation;
		
	}
	
	public int distance(String distance) {
		String distanceSplit[]=distance.split(" KM");
		int distanceInteger=Integer.parseInt(distanceSplit[0]);
		return distanceInteger;
		
	}
	

	public String move(String typeVehicles,String moteur,String doors,String distance) {
		String result = null;
		typeVehiculeEnum typeVehicule = null;
		if (typeVehicles.equals("CAR"))
			typeVehicule = typeVehiculeEnum.CAR;
		else if (typeVehicles.equals("TRUCK")) typeVehicule = typeVehiculeEnum.TRUCK;
		else typeVehicule = typeVehiculeEnum.MOTORCYCLE;

		switch (typeVehicule) {
		case CAR:
			if (doors.equals("1 2 3 4")) {
				result = "DOORS OK, MOVING. The CAR will consume "+distance(distance)*consomationMoteur(moteur)/100+".00 L";
			}
			else if(doors.equals("1 3 4")) {
				result="DOORS KO, BLOCKED \n"+
                        "  _\n"+
                        " | \\\n"+
                        " |_|";
			}
			else if (doors.equals("1 2 4")) {
				result="DOORS KO, BLOCKED \n"+
                        "  _\n"+
                        " | |\n"+
                        " /_|";
			}
			break;
		case TRUCK:
			if (doors.equals("1 2")) {
				result = "DOORS OK, MOVING. The TRUCK will consume "+distance(distance)*consomationMoteur(moteur)/100+".00 L";
			}
			break;
		case MOTORCYCLE:
			if (doors.equals("")) {
				result = "DOORS OK, MOVING. The MOTORCYCLE will consume "+distance(distance)*consomationMoteur(moteur)/100+".00 L";
			}
			break;
		}
		return result;
		
	}
	
	
}
