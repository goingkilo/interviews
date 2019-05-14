package geektrust.traffic2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class RouteCalculator {

    private static class VehiclePriority {
        static  List<String> order = new ArrayList<String>(){{
            add("Car");
            add("Bike");
            add("TukTuk");
        }};

        public static int getPriority(String name){
            if( order.contains(name)){
                return order.indexOf(name);
            }
            return -1;
        }

    }

    private Comparator<ResultObject> sorter = new Comparator<ResultObject>(){
        @Override
        public int compare(ResultObject o1, ResultObject o2) {
            // compare time taken
            int difference = Float.valueOf(o1.timeTaken).compareTo(Float.valueOf(o2.timeTaken));

            if ( difference != 0) {
                return difference;
            }

            // if time taken is same, use vehicle priority.
           return VehiclePriority.getPriority(o1.vehicleName) - VehiclePriority.getPriority(o2.vehicleName);

        }
    };


    public ResultObject calculate(Vehicle[] vehicles, Orbit[] routes , Weather w, float trafficSpeed){

        List<ResultObject> results = new ArrayList<>();

        for( Vehicle v : vehicles) {
            for (Orbit o : routes) {
                try {
                    ResultObject ro = timeTaken(v, o, w, trafficSpeed);
                    results.add(ro);
                }
                catch(Exception e){
                    //
                }
            }
        }
        Collections.sort(results, sorter);

        if( results.size() > 0) {
            return results.get(0);
        }
        return null;

    }

    ResultObject timeTaken( Vehicle v, Orbit o, Weather w, float trafficSpeed){
        float t=  v.getTimeToTravel(w, o.getMegaMiles(), o.getCraters(),trafficSpeed);
        return new ResultObject(v.getName(), o.getName(),t);
    }


    class ResultObject {
        String vehicleName;
        String routeName;
        float timeTaken;

        public ResultObject(String  v, String o, float timeTaken) {
            this.vehicleName = v;
            this.routeName = o;
            this.timeTaken = timeTaken;
        }
    }


}
