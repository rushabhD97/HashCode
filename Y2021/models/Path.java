package Y2021.models;

import java.util.ArrayList;
import java.util.List;

public class Path {
    private Integer p;
    private List<Street> streets;
    private int time;
    public Path(){
        this(0);
    }
    public Path(int p){
        this.p = p;
        streets = new ArrayList<>(p);
        time=0;
    }

    public Integer getStreetsCount() {
        return p;
    }

    public List<Street> getStreetsName() {
        return streets;
    }

    public void addStreet(Street street,int D) {
        this.streets.add(street);
        street.getRemainingMap().put(time, street.getRemainingMap().getOrDefault(time, 0)+1);
        if(time<D)
            street.carsBeforeD++;
        time+=street.getLength();

    }



}
