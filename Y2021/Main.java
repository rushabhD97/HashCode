package Y2021;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import Y2021.models.Car;
import Y2021.models.Intersection;
import Y2021.models.Path;
import Y2021.models.Street;
import Y2021.service.StreetService;
import Y2021.utils.FastReader;

public class Main {

    public static void main(String[] args) {
        Main main = new Main();
        for(int i=0;i<6;i++){
            char filename=(char)('a'+i);
            try {
                PrintStream o = new PrintStream(new File("D:\\Competitive Programming\\HashCode\\Y2021\\output\\"+filename+".txt"));
                System.setOut(o);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            main.run(filename);
        }
    }
    void run(char filename){
        FastReader fr = new FastReader(filename);
        Integer D = fr.nextInt();
        Integer I = fr.nextInt();
        Integer S = fr.nextInt();
        Integer V = fr.nextInt();
        Integer F = fr.nextInt();

        List<Car> cars = new ArrayList<>();
        List<Intersection> intersections = new ArrayList<>();

        for(int i=0;i<I;i++){
            intersections.add(new Intersection(i));
        }
        StreetService streetService = StreetService.getInstance();
        for(int i=0;i<S;i++) {
            Street street = new Street(
                fr.nextInt(),
                fr.nextInt(),
                fr.next(),
                fr.nextInt()
            );
            intersections.get(street.getBeginIntersection()).addOutgoingStreet(street);
            intersections.get(street.getEndIntersection()).addIncomingStreet(street);
            streetService.addStreetMapping(street.getName(), street);
        }
        for(int i=0;i<V;i++){
            Path path = new Path(
                fr.nextInt()
            );

            for(int j=0;j<path.getStreetsCount();j++){
                path.addStreet(streetService.getStreetMap().get(fr.next()),D);
            }
            cars.add(new Car(i,path));

        }
        int intersectionCount =0;
        StringBuilder intersectionString = new StringBuilder();
        for(int i=0;i<I;i++){
            String intersectionSchedule = intersections.get(i).schedule();
            if(intersectionSchedule == null)
                continue;
            intersectionCount++;
            intersectionString.append(intersectionSchedule);
        }
        System.out.println(intersectionCount+"\n"+intersectionString);

    }
}