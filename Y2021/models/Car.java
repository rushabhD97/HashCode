package Y2021.models;

public class Car {
    Path path;
    int id;
    public Car(){
        this(-1,null);
    }
    public Car(int id,Path path){
        this.id = id;
        this.path = path;
    }
    public Path getPath() {
        return path;
    }

    public void setPath(Path path) {
        this.path = path;
    }
    

    
}
