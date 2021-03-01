package Y2021.models;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class Street {
    private Integer b,e;
    private String name;
    private Integer l;
    private Map<Integer,Integer> remainingMap;
	public int carsBeforeD;
    public Street(){
        this(-1,-1,null,-1);
    }

    public Street(Integer b, Integer e, String name, Integer l) {
        this.b = b;
        this.e = e;
        this.name = name;
        this.l = l;
        this.remainingMap = new TreeMap<>();
    }
    

    public Integer getBeginIntersection() {
        return b;
    }

    public void setBeginIntersection(Integer b) {
        this.b = b;
    }

    public Integer getEndIntersection() {
        return e;
    }

    public void setEndIntersection(Integer e) {
        this.e = e;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getLength() {
        return l;
    }

    public void setLength(Integer l) {
        this.l = l;
    }

    public Map<Integer, Integer> getRemainingMap() {
        return remainingMap;
    }

    public void setRemainingMap(Map<Integer, Integer> remainingMap) {
        this.remainingMap = remainingMap;
    }


    
}
