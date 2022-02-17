package Model;

public class MonomInt extends Monom {
    private int coeficient;

    public MonomInt(int exponent, int coeficient) {
        super(exponent);
        this.coeficient = coeficient;
    }

    public MonomInt(int coeficient) {
        this.coeficient = coeficient;
    }
    public MonomInt(){}

    public int getCoeficient() {
        return coeficient;
    }

    public void setCoeficient(int coeficient) {
        this.coeficient = coeficient;
    }
}
