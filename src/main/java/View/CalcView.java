package View;
import java.awt.*;
import java.awt.event.ActionListener;
import javax.swing.*;


public class CalcView extends JFrame {

    private JTextField primulPolinom = new JTextField(7);
    private JTextField alDoileaPolinom = new JTextField(7);
    private JTextField solutiePolinom = new JTextField(7);

    private JLabel firstPoly = new JLabel("Primul Polinom");
    private JLabel secondPoly = new JLabel("Al doilea Polinom");
    private JLabel result = new JLabel("Rezultat");


    private JButton butonSuma = new JButton("Suma");
    private JButton butonScadere= new JButton("Scadere");
    private JButton butonInmultire = new JButton("Inmultire");
    private JButton butonImpartire = new JButton("Impartire");
    private JButton butonDerivare =new JButton("Derivare");
    private JButton butonIntegrare =new JButton("Integrare");


    public CalcView(){

        solutiePolinom.setEditable(false);
        JPanel polyPanel= new JPanel();



        polyPanel.setBackground(new Color(254,253,240));
        polyPanel.setLayout(null);


        firstPoly.setBounds(100,5,200,20);
        firstPoly.setFont(new Font("Impact",Font.BOLD,26));
        firstPoly.setForeground(new Color(136,77,167));

        primulPolinom.setBounds(20,45,350,40);
        primulPolinom.setForeground(Color.BLACK);
        primulPolinom.setFont(new Font("Times New Roman",Font.BOLD,20));

        secondPoly.setBounds(100, 95, 200 , 20);
        secondPoly.setFont(new Font("Impact",Font.BOLD,26));
        secondPoly.setForeground(new Color(136,77,167));

        alDoileaPolinom.setBounds(20,130,350,40);
        alDoileaPolinom.setForeground(Color.BLACK);
        alDoileaPolinom.setFont(new Font("Times New Roman",Font.BOLD,20));

        result.setBounds(140,170,200,40);
        result.setFont(new Font("Impact",Font.BOLD,26));
        result.setForeground(new Color(136,77,167));

        solutiePolinom.setBounds(20,210,350,40);
        solutiePolinom.setFont(new Font("Times New Roman",Font.BOLD,20));
        solutiePolinom.setBackground(Color.WHITE);

        butonSuma.setBounds(400,20,200,40);
        butonSuma.setFont(new Font("Impact",Font.BOLD,26));
        butonSuma.setBackground(Color.ORANGE);
        butonSuma.setForeground(new Color(136,77,167));

        butonScadere.setBounds(400,60,200,40);
        butonScadere.setFont(new Font("Impact", Font.BOLD,26));
        butonScadere.setBackground(Color.ORANGE);
        butonScadere.setForeground(new Color(136,77,167));

        butonInmultire.setBounds(400,100, 200,40);
        butonInmultire.setFont(new Font("Impact",Font.BOLD,26));
        butonInmultire.setBackground(Color.ORANGE);
        butonInmultire.setForeground(new Color(136,77,167));

        butonImpartire.setBounds(400,140,200,40);
        butonImpartire.setFont(new Font("Impact",Font.BOLD,26));
        butonImpartire.setBackground(Color.ORANGE);
        butonImpartire.setForeground(new Color(136,77,167));

        butonDerivare.setBounds(400,180,200,40);
        butonDerivare.setFont(new Font("Impact",Font.BOLD,26 ));
        butonDerivare.setBackground(Color.ORANGE);
        butonDerivare.setForeground(new Color(136,77,167));

        butonIntegrare.setBounds(400,220,200,40);
        butonIntegrare.setFont(new Font("Impact",Font.BOLD,26));
        butonIntegrare.setBackground(Color.ORANGE);
        butonIntegrare.setForeground(new Color(136,77,167));

        polyPanel.add(firstPoly);
        polyPanel.add(secondPoly);
        polyPanel.add(primulPolinom);
        polyPanel.add(alDoileaPolinom);
        polyPanel.add(butonSuma);
        polyPanel.add(butonScadere);
        polyPanel.add(butonInmultire);
        polyPanel.add(butonImpartire);
        polyPanel.add(butonDerivare);
        polyPanel.add(butonIntegrare);
        polyPanel.add(result);
        polyPanel.add(solutiePolinom);

        polyPanel.setPreferredSize(new Dimension(660,330));
        this.setContentPane(polyPanel);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        this.setTitle("Calculator Polinomial");
        this.pack();




    }

    public String getFirstPolynom(){
        return primulPolinom.getText();
    }

    public String getSecondPolynom(){
        return alDoileaPolinom.getText();
    }

    public int getCalcSolution(){
        return Integer.parseInt(solutiePolinom.getText());
    }
    public void setCalcSolution(String solutie){
        solutiePolinom.setText(solutie);
    }
    public void sumaListener(ActionListener e){
        butonSuma.addActionListener(e);
    }
    public void scadereListener(ActionListener e){
        butonScadere.addActionListener(e);
    }
    public void inmultireListener(ActionListener e){
        butonInmultire.addActionListener(e);
    }
    public void impartireListener(ActionListener e){
        butonImpartire.addActionListener(e);
    }
    public void derivareListener(ActionListener e){
        butonDerivare.addActionListener(e);
    }
    public void integrareListener(ActionListener e){
        butonIntegrare.addActionListener(e);
    }

    public void displayErrorMessage(String errorMessage){

        JOptionPane.showMessageDialog(this,errorMessage);
    }


}
