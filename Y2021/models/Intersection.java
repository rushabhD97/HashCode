package Y2021.models;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Intersection {
    int id;
    List<Street> incomingStreets;
    List<Street> outgoingStreets;

    Intersection(){
        this(-1);
    }
    public Intersection(int id){
        this.id=id;
        incomingStreets = new ArrayList<>();
        outgoingStreets = new ArrayList<>();
    }
    public void addIncomingStreet(Street street){
        incomingStreets.add(street);
    }
    public void addOutgoingStreet(Street street){
        outgoingStreets.add(street);
    }

    public String schedule(){
        StringBuilder stringBuilder = new StringBuilder();
        incomingStreets.sort(new Comparator<Street>(){
            public int compare(Street a,Street b){
                return -a.carsBeforeD + b.carsBeforeD;
            }
        });
        if(incomingStreets.isEmpty() || incomingStreets.get(0).carsBeforeD == 0)
            return null;
        int count=0;
        for(Street street:incomingStreets){
            if(street.carsBeforeD==0)
                break;
            stringBuilder.append(street.getName()+" 1\n");
            count++;
        }
        return count==0?null:(this.id+"\n"+count+"\n"+stringBuilder.toString());
    }

}
