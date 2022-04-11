package ibu.edu;

import java.util.Comparator;

public class sortByName implements Comparator<IPAddress> {
    @Override
    public int compare(IPAddress element1, IPAddress element2) {
        return element1.cityName.compareTo(element2.cityName);
    }
}
