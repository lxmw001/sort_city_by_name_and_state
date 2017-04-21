package lg.sort;


import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by luis on 4/20/17.
 */
public class SortCities {

    private String[] cityNames = {"ALLENTOWN", "YORK", "SIOUX FALLS", "MCALLEN", "COLUMBIA", "WICHITA", "ITHACA", "LUBBOCK",
            "SANTACRUZ", "DAYTONABEACH", "VALDOSTA", "SAN JOSE", "COLUMBIA", "NEWHAVEN", "NASHVILLE", "ANNARBOR", "WASHINGTON", "SPOKANE", "HOUSTON"};
    private String[] stateNames = {"PA", "PA", "SD", "TX", "SC", "KS", "NY", "TX",
            "CA", "FL", "GA", "CA", "MO", "CT", "TN", "MI", "DC", "WA", "TX"};

    public static void main(String[] args) {
        SortCities runner = new SortCities();

        List<City> cities = runner.createCities();

        Collections.sort(cities, new Comparator<City>() {
            @Override
            public int compare(City city1, City city2) {
                return city1.getName().compareTo(city2.getName());
            }
        });

        System.out.println("********Cities sorted only by name*****");

        for (City c : cities) {
            System.out.println(c);
        }

        Collections.sort(cities, new Comparator<City>() {
            @Override
            public int compare(City city1, City city2) {
                int sortByState = city1.getState().compareTo(city2.getState());

                return sortByState !=0 ? sortByState : city1.getName().compareTo(city2.getName());
            }
        });

        System.out.println("********Cities sorted by state and the by name*****");
        for (City c : cities) {
            System.out.println(c);
        }

    }

    public List<City> createCities() {
        List<City> cities = new ArrayList<>();

        int numCities = cityNames.length;
        for(int i = 0; i < numCities; i++) {
            City c = new City(cityNames[i], stateNames[i]);
            cities.add(c);
        }

        return cities;
    }

}
