package Controller;


import View.CalcView;
import Model.CalcModel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalcController {
    private CalcView theView ;
    private CalcModel theModel;
    public CalcController(CalcView theView, CalcModel theModel) {
        this.theView = theView;
        this.theModel = theModel;
        this.theView.sumaListener(new SumListener());
        this.theView.scadereListener(new DifListener());
        this.theView.derivareListener(new DerivListener());
        this.theView.integrareListener(new IntegListener());
        this.theView.inmultireListener(new MulListener());
        this.theView.impartireListener(new DivListener());
    }
    class SumListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String firstPolynom ; String secondPolynom;
            try{
                firstPolynom= theView.getFirstPolynom();
                secondPolynom=theView.getSecondPolynom();
                theModel.transformStringIntoPolinom(theModel.getPol1(),firstPolynom);
                theModel.transformStringIntoPolinom(theModel.getPol2(),secondPolynom);
                theModel.adunarePolinoame(theModel.getPol1(), theModel.getPol2() , theModel.getPol3());
                theView.setCalcSolution(theModel.transformarePolinomToString(theModel.getPol3()));
            }
            catch(NumberFormatException ex){
                theView.displayErrorMessage("you need to enter 2 Polynoms");
            }
        }
    }
    class DifListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String firstPolynom ; String secondPolynom;
            try{
                firstPolynom= theView.getFirstPolynom();
                secondPolynom=theView.getSecondPolynom();
                theModel.transformStringIntoPolinom(theModel.getPol1(),firstPolynom);
                theModel.transformStringIntoPolinom(theModel.getPol2(),secondPolynom);
                theModel.scaderePolinoame(theModel.getPol1(), theModel.getPol2() , theModel.getPol3());
                theView.setCalcSolution(theModel.transformarePolinomToString(theModel.getPol3()));
            }
            catch(NumberFormatException ex){
                theView.displayErrorMessage("you need to enter a Polynom in the first textbox");
            }
        }
    }
    class DerivListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String firstPolynom ;
            try{
                firstPolynom= theView.getFirstPolynom();
                theModel.transformStringIntoPolinom(theModel.getPol1(),firstPolynom);
                theModel.derivarePolinom(theModel.getPol1(), theModel.getPol3());
                theView.setCalcSolution(theModel.transformarePolinomToString(theModel.getPol3()));
            }
            catch(NumberFormatException ex){
                theView.displayErrorMessage("you need to enter a Polynom in the first textbox");
            }
        }
    }
    class IntegListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String firstPolynom ;
            try{
                firstPolynom= theView.getFirstPolynom();
                theModel.transformStringIntoPolinom(theModel.getPol1(),firstPolynom);
                theModel.integrarePolinom(theModel.getPol1(), theModel.getPol3());
                theView.setCalcSolution(theModel.transformarePolinomToString(theModel.getPol3()));
            }
            catch(NumberFormatException ex){
                theView.displayErrorMessage("you need to enter a Polynom in the first textbox");
            }
        }
    }
    class MulListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String firstPolynom ;String secondPolynom;
            try{
                firstPolynom= theView.getFirstPolynom();
                secondPolynom= theView.getSecondPolynom();
                theModel.transformStringIntoPolinom(theModel.getPol1(),firstPolynom);
                theModel.transformStringIntoPolinom(theModel.getPol2(),secondPolynom);
                theModel.inmultirePolinom(theModel.getPol1(), theModel.getPol2(),theModel.getPol3());
                theView.setCalcSolution(theModel.transformarePolinomToString(theModel.getPol3()));
            }
            catch(NumberFormatException ex){
                theView.displayErrorMessage("you need to enter a Polynom in the first textbox");
            }
        }
    }
    class DivListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String firstPolynom ;String secondPolynom;
            try{
                firstPolynom= theView.getFirstPolynom();
                secondPolynom= theView.getSecondPolynom();
                theModel.transformStringIntoPolinom(theModel.getPol1(),firstPolynom);
                theModel.transformStringIntoPolinom(theModel.getPol2(),secondPolynom);
                theModel.impartirePolinoame(theModel.getPol1(),theModel.getPol2(),theModel.getPol3());
                theView.setCalcSolution(theModel.transformarePolinomToString(theModel.getPol3()));
            }
            catch(NumberFormatException ex){
                theView.displayErrorMessage("you need to enter a Polynom in the first textbox");
            }
        }
    }
}
