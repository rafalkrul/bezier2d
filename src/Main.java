import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;


class Bezier extends JPanel implements ActionListener {
    //stopien krzywej Beziera
    int n=4;
    public int[][] pkt=new int[n][2];

    int silnia(int i)
    //silnia potrzebna do wzoru
    {
        if (i==0) return 1;
        else return  i*silnia(i-1);
    }
    public void rysuj(Graphics g){
        //funkcja rysuj ma za zadnie narysować dużej ilości punktów, aby wyglądały jak linia
        Graphics2D g2d = (Graphics2D) g;


        //wzór matematyczny
        for(float t=0; t<1; t+=0.00005f)
        {
            int wynik_x=0;
            int wynik_y=0;
            for (int i=0; i<pkt.length; i++)
            {
                wynik_x+=((silnia(pkt.length-1))/(silnia(i)* silnia(pkt.length-1-i)))* Math.pow(1-t,pkt.length-1-i)* Math.pow(t,i)*pkt[i][0];
                wynik_y+=((silnia(pkt.length-1))/(silnia(i)*silnia(pkt.length-1-i)))*Math.pow(1-t,pkt.length-1-i)*Math.pow(t,i)*pkt[i][1];



            }
            g2d.drawLine(wynik_x,wynik_y,wynik_x,wynik_y);
        }
    }
    private void Inicjuj(Graphics g) {
        //Tworze punkty, pkt kontrolne
        Graphics2D g2d = (Graphics2D) g;
        g2d.setPaint(new Color(14, 16, 19));
        g2d.fillRect(0, 0, 100000, 100000);
        g2d.setPaint(new Color(51, 255, 153));


        pkt[0][0]=103; pkt[0][1]=364;
        pkt[1][0]=103; pkt[1][1]=379;
        pkt[2][0]=108; pkt[2][1]=87;
        pkt[3][0]=94; pkt[3][1]=82;
        rysuj(g);



        pkt[0][0]=94; pkt[0][1]=82;
        pkt[1][0]=80; pkt[1][1]=77;
        pkt[2][0]=215; pkt[2][1]=89;
        pkt[3][0]=242; pkt[3][1]=132;
        rysuj(g);


        pkt[0][0]=242; pkt[0][1]=132;
        pkt[1][0]=250; pkt[1][1]=145;
        pkt[2][0]=124; pkt[2][1]=234;
        pkt[3][0]=113; pkt[3][1]=224;
        rysuj(g);

        pkt[0][0]=113; pkt[0][1]=224;
        pkt[1][0]=98; pkt[1][1]=240;
        pkt[2][0]=312; pkt[2][1]=462;
        pkt[3][0]=301; pkt[3][1]=452;
        rysuj(g);


        g2d.setPaint(new Color(51, 255, 153));

        pkt[0][0]=265; pkt[0][1]=81;
        pkt[1][0]=265; pkt[1][1]=66;
        pkt[2][0]=266; pkt[2][1]=406;
        pkt[3][0]=276; pkt[3][1]=394;
        rysuj(g);


        pkt[0][0]=276; pkt[0][1]=394;
        pkt[1][0]=321; pkt[1][1]=364;
        pkt[2][0]=418; pkt[2][1]=228;
        pkt[3][0]=433; pkt[3][1]=227;
        rysuj(g);


        pkt[0][0]=433; pkt[0][1]=227;
        pkt[1][0]=456; pkt[1][1]=226;
        pkt[2][0]=601; pkt[2][1]=390;
        pkt[3][0]=600; pkt[3][1]=405;
        rysuj(g);



        pkt[0][0]=600; pkt[0][1]=405;
        pkt[1][0]=599; pkt[1][1]=420;
        pkt[2][0]=590; pkt[2][1]=61;
        pkt[3][0]=589; pkt[3][1]=76;
        rysuj(g);

    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);Inicjuj(g); }
    @Override
    public void actionPerformed(ActionEvent e) { repaint(); }
}
// Klasa main wywołuje program
public class Main extends JFrame {

    public Main() {
        add(new Bezier());

        setTitle("Inicjał RW");
        setSize(1000, 800);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {

        Main frame = new Main();
        frame.setVisible(true);
    }
}
