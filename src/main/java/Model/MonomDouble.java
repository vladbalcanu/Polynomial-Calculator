package Model;

public class MonomDouble extends Monom{
    private double coeficient;

    public MonomDouble(int exponent, double coeficient) {
        super(exponent);
        this.coeficient = coeficient;
    }

    public MonomDouble(double coeficient) {
        this.coeficient = coeficient;
    }
    public MonomDouble(){
    }

    public double getCoeficient() {
        return coeficient;
    }

    public void setCoeficient(double coeficient) {
        this.coeficient = coeficient;
    }
}
