package Model;

import java.util.ArrayList;

public class Polinom {
    private ArrayList<Monom> pol = new ArrayList<Monom>();

    public Polinom(ArrayList<Monom> pol) {
        this.pol = pol;
    }
    public Polinom() {
    }
    public ArrayList<Monom> getPol() {
        return pol;
    }
    public void setPol(ArrayList<Monom> pol) {
        this.pol = pol;
    }

}
