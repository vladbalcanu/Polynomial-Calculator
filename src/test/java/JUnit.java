import Model.CalcModel;
import Model.MonomInt;
import junit.framework.TestCase;

public class JUnit extends TestCase {
    private CalcModel testModel = new CalcModel();

    public void testSum(){
        testModel.getPol1().getPol().add(new MonomInt(3,2));
        testModel.getPol1().getPol().add(new MonomInt(2,3));
        testModel.getPol1().getPol().add(new MonomInt(1,-1));
        testModel.getPol1().getPol().add(new MonomInt(0,5));
        testModel.getPol2().getPol().add(new MonomInt(2,1));
        testModel.getPol2().getPol().add(new MonomInt(1,-1));
        testModel.getPol2().getPol().add(new MonomInt(0,1));

        String rez="+2*x^3+4*x^2-2*x^1+6*x^0";
        testModel.adunarePolinoame(testModel.getPol1(),testModel.getPol2(),testModel.getPol3());
        testModel.getPol1().getPol().removeAll(testModel.getPol1().getPol());
        testModel.getPol2().getPol().removeAll(testModel.getPol2().getPol());
        String suma=testModel.transformarePolinomToString(testModel.getPol3());
        testModel.getPol3().getPol().removeAll(testModel.getPol3().getPol());

        assertEquals(rez,suma);

    }
    public void testDif(){
        testModel.getPol1().getPol().add(new MonomInt(3,2));
        testModel.getPol1().getPol().add(new MonomInt(2,3));
        testModel.getPol1().getPol().add(new MonomInt(1,-1));
        testModel.getPol1().getPol().add(new MonomInt(0,5));
        testModel.getPol2().getPol().add(new MonomInt(2,1));
        testModel.getPol2().getPol().add(new MonomInt(1,-1));
        testModel.getPol2().getPol().add(new MonomInt(0,1));

        String rez="+2*x^3+2*x^2+4*x^0";
        testModel.scaderePolinoame(testModel.getPol1(),testModel.getPol2(),testModel.getPol3());
        testModel.getPol1().getPol().removeAll(testModel.getPol1().getPol());
        testModel.getPol2().getPol().removeAll(testModel.getPol2().getPol());
        String dif= testModel.transformarePolinomToString(testModel.getPol3());
        testModel.getPol3().getPol().removeAll(testModel.getPol3().getPol());
        assertEquals(rez,dif);

    }
    public void testMul(){
        testModel.getPol1().getPol().add(new MonomInt(3,2));
        testModel.getPol1().getPol().add(new MonomInt(2,3));
        testModel.getPol1().getPol().add(new MonomInt(1,-1));
        testModel.getPol1().getPol().add(new MonomInt(0,5));
        testModel.getPol2().getPol().add(new MonomInt(2,1));
        testModel.getPol2().getPol().add(new MonomInt(1,-1));
        testModel.getPol2().getPol().add(new MonomInt(0,1));

        String rez="+2*x^5+1*x^4-2*x^3+9*x^2-6*x^1+5*x^0";
        testModel.inmultirePolinom(testModel.getPol1(),testModel.getPol2(),testModel.getPol3());
        testModel.getPol1().getPol().removeAll(testModel.getPol1().getPol());
        testModel.getPol2().getPol().removeAll(testModel.getPol2().getPol());
        String mul= testModel.transformarePolinomToString(testModel.getPol3());
        testModel.getPol3().getPol().removeAll(testModel.getPol3().getPol());
        assertEquals(rez,mul);

    }

    public void testDiv(){
        testModel.getPol1().getPol().add(new MonomInt(3,2));
        testModel.getPol1().getPol().add(new MonomInt(2,3));
        testModel.getPol1().getPol().add(new MonomInt(1,-1));
        testModel.getPol1().getPol().add(new MonomInt(0,5));
        testModel.getPol2().getPol().add(new MonomInt(2,1));
        testModel.getPol2().getPol().add(new MonomInt(1,-1));
        testModel.getPol2().getPol().add(new MonomInt(0,1));

        String rez="+2*x^1+5*x^0+2*x^1";

        testModel.impartirePolinoame(testModel.getPol1(), testModel.getPol2(), testModel.getPol3());
        testModel.getPol1().getPol().removeAll(testModel.getPol1().getPol());
        testModel.getPol2().getPol().removeAll(testModel.getPol2().getPol());
        String div= testModel.transformarePolinomToString(testModel.getPol3());
        testModel.getPol3().getPol().removeAll(testModel.getPol3().getPol());
        assertEquals(rez,div);
    }

    public void testDeriv(){
        testModel.getPol1().getPol().add(new MonomInt(3,2));
        testModel.getPol1().getPol().add(new MonomInt(2,3));
        testModel.getPol1().getPol().add(new MonomInt(1,-1));
        testModel.getPol1().getPol().add(new MonomInt(0,5));
        String rez="+6*x^2+6*x^1-1*x^0";

        testModel.derivarePolinom(testModel.getPol1(), testModel.getPol3());
        testModel.getPol1().getPol().removeAll(testModel.getPol1().getPol());
        String deriv= testModel.transformarePolinomToString(testModel.getPol3());
        testModel.getPol3().getPol().removeAll(testModel.getPol3().getPol());
        assertEquals(rez,deriv);

    }

    public void testInteg(){
        testModel.getPol1().getPol().add(new MonomInt(3,2));
        testModel.getPol1().getPol().add(new MonomInt(2,3));
        testModel.getPol1().getPol().add(new MonomInt(1,-1));
        testModel.getPol1().getPol().add(new MonomInt(0,5));
        String rez="+0.5*x^4+1*x^3-0.5*x^2+5*x^1";

        testModel.integrarePolinom(testModel.getPol1(), testModel.getPol3());
        testModel.getPol1().getPol().removeAll(testModel.getPol1().getPol());
        String integ= testModel.transformarePolinomToString(testModel.getPol3());
        testModel.getPol3().getPol().removeAll(testModel.getPol3().getPol());
        assertEquals(rez,integ);
    }
}
