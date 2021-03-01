package Y2021.service;

import java.util.HashMap;
import java.util.Map;

import Y2021.models.Street;

public class StreetService {
    private Map<String,Street> streetMap ;
    private static StreetService streetService;
    private StreetService(){
        streetMap = new HashMap<>();
    }
    public static StreetService getInstance(){
        if(streetService == null)
            streetService = new StreetService();
        return streetService;
    }
    public void addStreetMapping(String name,Street street){
        streetMap.put(name, street);
    }

    public Map<String, Street> getStreetMap() {
        return streetMap;
    }

    
}
