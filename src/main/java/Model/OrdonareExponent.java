package Model;

import java.util.Comparator;

public class OrdonareExponent implements Comparator<Monom> {
    @Override
    public int compare(Monom o1, Monom o2) {
        if(o1.getExponent() > o2.getExponent())
            return -1;
        else
            if(o1.getExponent() < o2.getExponent())
            return 1;
        return 0;
    }
}
