package Model;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CalcModel {

    private Polinom pol1 = new Polinom(); // Primul Polinom introdus
    private Polinom pol2 = new Polinom(); // Al doilea Polinom introdus
    private Polinom pol3 = new Polinom(); // Polinomul pentru rezultat

    public Polinom getPol1() {
        return pol1;
    }

    public void setPol1(Polinom pol1) {
        this.pol1 = pol1;
    }

    public Polinom getPol2() {
        return pol2;
    }

    public void setPol2(Polinom pol2) {
        this.pol2 = pol2;
    }

    public Polinom getPol3() {
        return pol3;
    }

    public void setPol3(Polinom pol3) {
        this.pol3 = pol3;
    }
// --------  METODA DE SORTARE ---------- //

    public void sortPolinom(Polinom poly) {
        OrdonareExponent o = new OrdonareExponent();
        Collections.sort(poly.getPol(), o);
    }

    // --------  METODA DE TRANSFORMARE A STRINGULUI DIN TEXTFIELD IN POLINOM ---------- //
    public void transformStringIntoPolinom(Polinom poly,String polyString){
        Pattern pt = Pattern.compile("([+-]?[^-+]+[*]+)");
        Matcher mt = pt.matcher(polyString);

        while(mt.find()) {
            int coeficient = 0;
            int exponent = 0;
            if (mt.group().matches("[+-]?\\d+[*]+")) {
                coeficient = Integer.parseInt(mt.group().replaceAll("[*]", ""));
                poly.getPol().add(new MonomInt(exponent, coeficient));
            }
            sortPolinom(poly);
        }

        Pattern pt1= Pattern.compile("x+\\D+\\d+");
        Matcher mt1 = pt1.matcher(polyString);
        int i =0;

        while(mt1.find()){

            int exponent=0;
            if (mt1.group().matches("x+\\D+\\d+")) {
                exponent = Integer.parseInt(mt1.group().replaceAll("x+\\D", ""));
                poly.getPol().get(i).setExponent(exponent);
                i++;
            }
        }
        sortPolinom(poly);
    }
    // --------  METODA DE TRANSFORMARE A POLINOMULUI IN STRING ---------- //
    public String transformarePolinomToString(Polinom poly) {
        String polinomul = "";
        for (Monom e : poly.getPol()) {
            if (e instanceof MonomInt) {
                if (((MonomInt) e).getCoeficient() > 0)
                    polinomul = polinomul + "+" + String.valueOf(((MonomInt) e).getCoeficient()) + "*x^" + String.valueOf(e.getExponent());
                else if(((MonomInt) e).getCoeficient() < 0) {
                    polinomul = polinomul + String.valueOf(((MonomInt) e).getCoeficient()) + "*x^" + String.valueOf(e.getExponent());
                }
            } else if (e instanceof MonomDouble) {
                if (((MonomDouble) e).getCoeficient() > 0)
                    polinomul = polinomul + "+" + String.valueOf(((MonomDouble) e).getCoeficient()) + "*x^" + String.valueOf(e.getExponent());
                else if(((MonomDouble) e).getCoeficient() < 0) {
                    polinomul = polinomul + String.valueOf(((MonomDouble) e).getCoeficient()) + "*x^" + String.valueOf(e.getExponent());
                }
            }
        }
        poly.getPol().removeAll(poly.getPol());
        return polinomul;
    }
    // --------  METODA DE ADUNARE A POLINOAMELOR---------- //
    public void adunarePolinoame(Polinom poly1, Polinom poly2, Polinom poly3) {
        for (Monom e : poly1.getPol()) {
            boolean q = false;
            for (Monom e1 : poly2.getPol()) {
                if (e.getExponent() == e1.getExponent()) {
                    q = true;
                    poly3.getPol().add(new MonomInt(e.getExponent(), ((MonomInt) e).getCoeficient() + ((MonomInt) e1).getCoeficient()));
                    break;
                }
            }
            if (!q) {
                poly3.getPol().add(e);
            }
        }
        for (Monom e : poly2.getPol()) {
            boolean q = false;
            for (Monom e1 : poly3.getPol()) {
                if (e.getExponent() == e1.getExponent()) {
                    q = true;
                    break;
                }
            }
            if (!q) {
                poly3.getPol().add(e);
            }
        }
        sortPolinom(poly3);
        poly1.getPol().removeAll(poly1.getPol());
        poly2.getPol().removeAll(poly2.getPol());
    }
    // --------  METODA DE SCADERE A POLINOAMELOR ---------- //
    public void scaderePolinoame(Polinom poly1, Polinom poly2, Polinom poly3) {
        for (Monom e : poly1.getPol()) {
            boolean q = false;
            for (Monom e1 : poly2.getPol()) {
                if (e.getExponent() == e1.getExponent()) {
                    q = true;
                    poly3.getPol().add(new MonomInt(e.getExponent(), ((MonomInt) e).getCoeficient() - ((MonomInt) e1).getCoeficient()));
                    break;
                }
            }
            if (!q) {
                poly3.getPol().add(e);
            }
        }
        for (Monom e : poly2.getPol()) {
            boolean q = false;
            for (Monom e1 : poly3.getPol()) {
                if (e.getExponent() == e1.getExponent()) {
                    q = true;
                }
            }
            if (!q) {
                poly3.getPol().add(new MonomInt(e.getExponent(),-((MonomInt)e).getCoeficient()));
            }
        }
        sortPolinom(poly3);
        poly1.getPol().removeAll(poly1.getPol());
        poly2.getPol().removeAll(poly2.getPol());
    }
    // --------  METODA DE DERIVARE A PRIMULUI POLINOM ---------- //
    public void derivarePolinom(Polinom poly1, Polinom poly3) {
        for (Monom e : poly1.getPol()) {
            if (e.getExponent() != 0) {
                poly3.getPol().add(new MonomInt(e.getExponent() - 1, ((MonomInt) e).getCoeficient() * e.getExponent()));
            }
        }
        sortPolinom(poly3);
        poly1.getPol().removeAll(poly1.getPol());
    }
    // --------  METODA DE INTEGRARE A PRIMULUI POLINOM ---------- //
    public void integrarePolinom(Polinom poly1, Polinom poly3) {
        for (Monom e : poly1.getPol()) {
            if (((MonomInt) e).getCoeficient() % (e.getExponent() + 1) != 0) {
                pol3.getPol().add(new MonomDouble(e.getExponent() + 1, (((MonomInt) e).getCoeficient() * 1.0) / (e.getExponent() + 1)));
            } else {
                pol3.getPol().add(new MonomInt(e.getExponent() + 1, ((MonomInt) e).getCoeficient() / (e.getExponent() + 1)));
            }
        }
        sortPolinom(poly3);
        poly1.getPol().removeAll(poly1.getPol());
    }
    // --------  METODA DE INMULTIRE A POLINOAMELOR ---------- //
    public void inmultirePolinom(Polinom poly1, Polinom poly2, Polinom poly3) {
        for (Monom e : poly1.getPol()) {
            for (Monom e1 : poly2.getPol()) {
                if (poly3.getPol().isEmpty()) {
                    poly3.getPol().add(new MonomInt(e.getExponent() + e1.getExponent(), ((MonomInt) e).getCoeficient() * ((MonomInt) e1).getCoeficient()));
                } else {
                    boolean bool = false;
                    for (Monom e2 : poly3.getPol()) {
                        if (e2.getExponent() == e.getExponent() + e1.getExponent()) {
                            ((MonomInt) e2).setCoeficient(((MonomInt) e2).getCoeficient() + ((MonomInt) e).getCoeficient() * ((MonomInt) e1).getCoeficient());
                            bool = true;
                            break;
                        }
                    }
                    if (!bool) {
                        poly3.getPol().add(new MonomInt(e.getExponent() + e1.getExponent(), ((MonomInt) e).getCoeficient() * ((MonomInt) e1).getCoeficient()));
                    }
                }
            }
        }
        sortPolinom(poly3);
        poly1.getPol().removeAll(poly1.getPol());
        poly2.getPol().removeAll(poly2.getPol());
    }
    // --------  METODA DE IMPARTIRE A POLINOAMELOR ---------- //
    public void impartirePolinoame(Polinom poly1, Polinom poly2, Polinom poly3) {
        Polinom pol4 = new Polinom();
        for (Monom e : poly1.getPol()) {
            pol4.getPol().add(new MonomDouble(e.getExponent(), ((MonomInt) e).getCoeficient()));
        }
        for (int i =0 ;i <pol4.getPol().size();i++) {
            if (pol4.getPol().get(i).getExponent() >= poly2.getPol().get(0).getExponent()) {
                if (((MonomDouble)pol4.getPol().get(i)).getCoeficient() != 0) {
                    double coeficient = ((MonomDouble) pol4.getPol().get(i)).getCoeficient() / ((MonomInt) poly2.getPol().get(0)).getCoeficient();
                    int exponent = pol4.getPol().get(i).getExponent() - poly2.getPol().get(0).getExponent();
                    if (coeficient == (int) coeficient) {
                        poly3.getPol().add(new MonomInt(exponent, (int) coeficient));
                    } else {
                        poly3.getPol().add(new MonomDouble(exponent, coeficient));
                    }
                    for(Monom e:poly2.getPol()) {
                        int exp=exponent+e.getExponent();
                        double coef=coeficient * ((MonomInt) e).getCoeficient();
                        boolean q=false;
                        for(Monom e3:pol4.getPol()){
                            if(e3.getExponent()==exp){
                                q=true;
                                ((MonomDouble)e3).setCoeficient(((MonomDouble)e3).getCoeficient()-coef);
                                break;
                            }
                        }
                        if(!q){
                            pol4.getPol().add(new MonomDouble(exp,-coef));
                            sortPolinom(pol4);
                        }
                    }
                }
            } else {
                if (((MonomDouble) pol4.getPol().get(i)).getCoeficient() != 0) {
                    double coeficient = ((MonomDouble) pol4.getPol().get(i)).getCoeficient() ;
                    int exponent = pol4.getPol().get(i).getExponent();
                    if (coeficient == (int) coeficient) {
                        poly3.getPol().add(new MonomInt(exponent, (int) coeficient));
                    } else {
                        poly3.getPol().add(new MonomDouble(exponent, coeficient));
                    }
                }
            }
        }
        poly1.getPol().removeAll(poly1.getPol());
        poly2.getPol().removeAll(poly2.getPol());
        pol4.getPol().removeAll(pol4.getPol());
    }
}