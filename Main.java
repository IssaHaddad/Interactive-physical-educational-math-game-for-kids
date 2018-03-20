import jssc.SerialPort;
import jssc.SerialPortException;
import jssc.SerialPortList;

public class Driver
{
        public static void main (String [] args) throws SerialPortException 
        {
                Sensor sensor = new Sensor ();
                GraphicalUserInterface gui = new GraphicalUserInterface (sensor);
        }
}

import java.awt.*;

import sun.audio.*;

import javax.sound.sampled.*;

import java.awt.event.*;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Random;

import javax.swing.*;

import jssc.SerialPort;
import jssc.SerialPortException;
import jssc.SerialPort;
import jssc.SerialPortException;
public class GraphicalUserInterface implements ActionListener, Observer
{            
        private static final String ContinuousAudioDataStream = null;
        JFrame f1;
    JFrame f2;
    JFrame f3;
    JFrame f4;
    JFrame f5;
    JButton b1,b2,b3,b11,b21,b31,b32,b33,b51;
    JPanel p11,p21,p22,p23,p3,p51,p52,p53;
    JTextField t11,t12,t201,t202,t203,t204,t205,t206,t207,t208,t209,t210,t211,t212,t213,t214,t215,t216,t217,bonus1;
    JTextField t501,t502,t503,t504,t505,t506,t507,t508,t509,t510,t511,t512,t513,t514,t515,t516,t517,bonus2;
    JLabel l11,l12,l13,l14,l15,l16,l201,l202,l203,l204,l205,l206,l207,l208,l209,l210,l211,l212,l213,l214,l215,l216,l217,l218,l219,l220,l221,l222,l223,l224,l225,l226,l227,l230,l231,l232,l233,l234,l31;
    JLabel l501,l502,l503,l504,l505,l506,l507,l508,l509,l510,l511,l512,l513,l514,l515,l516,l517,l518,l519,l520,l521,l522,l523,l524,l525,l526,l527,l530,l531,l532,l533,l534;
    Container c;
    GridLayout layout1,layout2,layout3,layout4,layout5;
    Font font = new Font("Comic Sans MS", Font.BOLD, 18);
    Font font2 = new Font("baghdad", Font.BOLD ,14);
    Font font3 = new Font("baghdad", Font.BOLD, 16);
        Integer numberofquestions;
        Problem problem;
        double g1, g2;
        int [] numbersequence, numberstocatch1, numberstocatch2;
        int answer, bs1, bs2, number1, number2, catch1, catch2, time, timer1, timer2, correctanswersinarow1, correctanswersinarow2, numberofactivationsofrecordtable;
        Subject sensor;

        public GraphicalUserInterface (Subject s)
        {          
                playonce("src/Mario_Kart_Race_Start_-_Gaming_Sound_Effect_HD_.wav");
                numberofactivationsofrecordtable = 0;
                correctanswersinarow1 = 0;
                correctanswersinarow2 = 0;
                timer1 = timer2 = 0;
                int index;
                time = 2500;
                sensor = s;
                sensor.RegisterObserver (this);
                layout1 = new GridLayout(3,1);
            f1 = new JFrame("Java Frame");
            f1.setLayout(layout1);
            b1 = new JButton("New Game");
            f1.add(b1 , BorderLayout.NORTH);
            b1.addActionListener(this);
            b2 = new JButton("Score");
            f1.add(b2, BorderLayout.CENTER);
            b2.addActionListener(this);
            b3 = new JButton("Exit");
            f1.add(b3 , BorderLayout.SOUTH);
            b3.addActionListener(this);
            f1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            f1.setSize(400,300);
            f1.setVisible(true);  
            numberofquestions = 10;
            numberstocatch1 = new int [10];
            numberstocatch2 = new int [10];
            for (index = 0; index < 10; index = index + 1)
            {
                    numberstocatch1 [index] = index;
            }
            for (index = 9; index >= 0; index = index - 1)
            {
                    numberstocatch2 [index] = 9 - index;
            }
            t203= new JTextField();
                t212= new JTextField();
                t215= new JTextField();
                t503= new JTextField();
                t512= new JTextField();
                t515= new JTextField();
                Runnable randomnumbers = new Runnable ()
                {
                    int index = 0;
                        public void run ()
                        {
                                while (true)
                                {
                                        number1 = numberstocatch1 [index];
                                        number2 = numberstocatch2 [index];
                                        t203.setText (((Integer) number1).toString ());
                                        t215.setText (((Integer) number2).toString ());
                                        t503.setText (((Integer) number1).toString ());
                                        t515.setText (((Integer) number2).toString ());
                                        try 
                                        {
                                                        Thread.sleep (time);
                                                } 
                                        catch (InterruptedException ie) 
                                        {
                                                        ie.printStackTrace();
                                                }
                                        index = index + 1;
                                        if (index > 9)
                                        {
                                                index = 0;
                                                ArrayReshufle (numberstocatch1);
                                                ArrayReshufle (numberstocatch2);
                                        }
                                }
                        }
                };
                Thread thread1 = new Thread (randomnumbers);
                thread1.start ();
                Runnable runningtimer = new Runnable ()
                {
                        public void run ()
                        {
                                while (true)
                                {
                                        t212.setText (((Integer) timer1).toString () + " s");
                                        t512.setText (((Integer) timer2).toString () + " s");
                                        timer1 = timer1 + 1;
                                        timer2 = timer2 + 1;
                                        try 
                                        {
                                                        Thread.sleep (1000);
                                                } 
                                        catch (InterruptedException ie) 
                                        {
                                                        ie.printStackTrace ();
                                                }
                                        
                                }
                        }
                };
                Thread thread2 = new Thread (runningtimer);
                thread2.start ();
      
        }
        
        public void ArrayReshufle (int [] array)
        {
                int index, temp, tempindex;
                Random random = new Random ();
            for (index = array.length - 1; index > 0; index = index - 1)
            {
                    tempindex = random.nextInt (index + 1);
                    temp = array [tempindex];
                    array [tempindex] = array [index];
                      array [index] = temp;
            }
        }
        
        public void actionPerformed(ActionEvent ae)
          {
            

            if (ae.getSource()==b1)
            {
                    PlayerGame();
                    f1.setVisible(false);
            }
            if (ae.getSource()==b2)
            {
                    DisplayScore();
                    f1.setVisible(false);
            }
            if (ae.getSource()==b3)
            {
                    playonce("src/Gun_Load_-_Sound_Effect.wav");
                    System.exit(0);
            }
            if (ae.getSource()==b11)
            {
                    f1.setVisible (true);
                    f2.setVisible (false);
            }
            if (ae.getSource()==b21)
            {
                    numberofquestions = 10;
                    correctanswersinarow1 = 0;
                    problem = new Problem ();
                    numbersequence = problem.GenerateSequence ();
                    f4.setVisible(true);
                    f3.setVisible(false);
            }
            if (ae.getSource()==b31)
            {
                    DisplayGameOne();
                    f4.setVisible(false);
            }
            if (ae.getSource()==b51)
            {
                    numberofquestions = 10;
                    correctanswersinarow2 = 0;
                    problem = new Problem ();
                    numbersequence = problem.GenerateSequence ();
                    f4.setVisible(true);
                    f5.setVisible(false);
            }
            if (ae.getSource()==b32)
            {
                    DisplayGameTwo();
                    f4.setVisible(false);
            }
            if (ae.getSource()==b33)
            {
                    f4.setVisible(false);
                    f1.setVisible(true);
            }
            }
        public void DisplayScore()
        {
                playonce("src/Gun_Load_-_Sound_Effect.wav");
                layout2 = new GridLayout();
            f2 =new JFrame("Score Board");
            f2.setLayout(layout2);
            p11 = new JPanel();
            p11.setLayout(new GridLayout(3,3));
            l11 = new JLabel("Player 1",SwingConstants.CENTER);
            l12 = new JLabel("Player 2",SwingConstants.CENTER);
            l13 = new JLabel("Time Spent:",SwingConstants.CENTER);
            l14 = new JLabel("Result:",SwingConstants.CENTER);
            l15 = new JLabel("WINNER!",SwingConstants.CENTER);
            l16 = new JLabel("LOSER!",SwingConstants.CENTER);
            b11 = new JButton("back");
            b11.addActionListener(this);
            t11 = new JTextField("50");
            t12 = new JTextField("20");
            p11.add(b11);
            p11.add(l11);
            p11.add(l12);
            p11.add(l13);
            p11.add(t11);
            p11.add(t12);
            p11.add(l14);
            if((Integer.parseInt(t11.getText()))<(Integer.parseInt(t12.getText())))
            {
                    p11.add(l15);
                    p11.add(l16);
            }
            else
            {
                    p11.add(l16);
                    p11.add(l15);
            }
            f2.add(p11);
            f2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            f2.setSize(300,300);
            f2.setVisible(true);
        }

                public void DisplayGameOne()
        {
                        DisplayScore ();
                        f2.setVisible (false);
                playonce("src/Super_Mario_Bros.wav");
                timer1 = 0;
                layout3 = new GridLayout();
                layout3 = new GridLayout();
                f3 = new JFrame("Game board");
                f3.setLayout(layout3);
                p21= new JPanel();
                p22= new JPanel();
                p23= new JPanel();
                p21.setLayout(new GridLayout(5,2));
                p22.setLayout(new GridLayout(5,5));
                p23.setLayout(new GridLayout(5,2));
                l201=new JLabel("----------------->", SwingConstants.RIGHT);
                l202=new JLabel("<-----------------",SwingConstants.LEFT);
                l203=new JLabel("PLAYER 1", SwingConstants.CENTER);
                l203.setFont(font);
                l204=new JLabel("Q no.",SwingConstants.RIGHT);
                l205=new JLabel("TIME:",SwingConstants.RIGHT);
                l206=new JLabel("");
                l207=new JLabel("First Digit ->",SwingConstants.RIGHT);
                l208=new JLabel("");
                l209=new JLabel("");
                l210=new JLabel("till BONUS",SwingConstants.RIGHT);
                l211=new JLabel("");
                l212=new JLabel("");
                l213=new JLabel("");
                l214=new JLabel("");
                l215=new JLabel("");
                l216=new JLabel("");
                l217=new JLabel("");
                l218=new JLabel("");
                l219=new JLabel("");
                l220=new JLabel("");
                l221=new JLabel("");
                l222=new JLabel("");
                l223=new JLabel("");
                l224=new JLabel("");
                l225=new JLabel("<- Second Digit",SwingConstants.LEFT);
                l226=new JLabel("");
                l227=new JLabel("Your Answer:",SwingConstants.RIGHT);
                l230= new JLabel("");
                t202= new JTextField();
                t202.setFont(font3);
                t203= new JTextField();
                t203.setFont(font3);
                l232= new JLabel("");
                l234= new JLabel("");
                t206= new JTextField();
                t207= new JTextField();
                t207.setFont(font2);
                t208= new JTextField();
                t208.setFont(font2);
                t209= new JTextField();
                t209.setFont(font2);
                t210= new JTextField();
                t210.setFont(font2);
                t211= new JTextField();
                t211.setFont(font2);
                t212= new JTextField();
                l231= new JLabel("");
                t214= new JTextField();
                t214.setFont(font3);
                t215= new JTextField();
                t215.setFont(font3);
                l233= new JLabel("");
                t217= new JTextField();
                t217.setFont(font);
                bonus1 = new JTextField();
                b21=new JButton("Back");
                b21.addActionListener(this);
                p21.add(b21);
                p21.add(l230);
                p21.add(l207);
                p21.add(t202);
                p21.add(l201);
                p21.add(t203);
                p21.add(l208);
                p21.add(l232);
                p21.add(l209);
                p21.add(l234);
                p22.add(l204);
                p22.add(t206);
                p22.add(l210);
                p22.add(bonus1);
                p22.add(l206);
                p22.add(l212);
                p22.add(l213);
                p22.add(l203);
                p22.add(l214);
                p22.add(l215);
                p22.add(t207);
                p22.add(t208);
                p22.add(t209);
                p22.add(t210);
                p22.add(t211);
                p22.add(l216);
                p22.add(l217);
                p22.add(l218);
                p22.add(l219);
                p22.add(l220);
                p22.add(l221);
                p22.add(l205);
                p22.add(t212);
                p22.add(l222);
                p22.add(l223);
                p23.add(l231);
                p23.add(l224);
                p23.add(t214);
                p23.add(l225);
                p23.add(t215);
                p23.add(l202);
                p23.add(l233);
                p23.add(l226);
                p23.add(l227);
                p23.add(t217);
                f3.add(p21);
                f3.add(p22);
                f3.add(p23);
                t202.setEditable (false);
                t203.setEditable (false);
                t206.setEditable (false);
                t207.setEditable (false);
                t208.setEditable (false);
                t209.setEditable (false);
                t210.setEditable (false);
                t211.setEditable (false);
                t212.setEditable (false);
                t214.setEditable (false);
                t215.setEditable (false);
                t217.setEditable (false);
                bonus1.setEditable (false);
                    t206.setText (numberofquestions.toString ());
                    problem = new Problem ();
                    numbersequence = problem.GenerateSequence ();
                    t207.setText (((Integer) numbersequence [0]).toString ());
                    t208.setText (((Integer) numbersequence [1]).toString ());
                    t209.setText (((Integer) numbersequence [2]).toString ());
                    t210.setText (((Integer) numbersequence [3]).toString ());
                    t211.setText ("??");
                    bonus1.setText (((Integer) correctanswersinarow1).toString ());
                    f3.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    f3.setSize(1500,500);
                    f3.setVisible(true);
        }
                
                 void DisplayGameTwo()
                {
                         DisplayScore ();
                                f2.setVisible (false);
                         playonce("src/Super_Mario_Bros.wav");
                         timer2 = 0;
                        layout5 = new GridLayout();
                        f5 = new JFrame("Game board");
                        f5.setLayout(layout5);
                        p51= new JPanel();
                        p52= new JPanel();
                        p53= new JPanel();
                        p51.setLayout(new GridLayout(5,2));
                        p52.setLayout(new GridLayout(5,5));
                        p53.setLayout(new GridLayout(5,2));
                        l501=new JLabel("----------------->", SwingConstants.RIGHT);
                        l502=new JLabel("<-----------------",SwingConstants.LEFT);
                        l503=new JLabel("PLAYER 2", SwingConstants.CENTER);
                        l503.setFont(font);
                        l504=new JLabel("Q no.",SwingConstants.RIGHT);
                        l505=new JLabel("TIME:",SwingConstants.RIGHT);
                        l506=new JLabel("");
                        l507=new JLabel("First Digit ->",SwingConstants.RIGHT);
                        l508=new JLabel("");
                        l509=new JLabel("");
                        l510=new JLabel("till BONUS",SwingConstants.RIGHT);
                        l511=new JLabel("");
                        l512=new JLabel("");
                        l513=new JLabel("");
                        l514=new JLabel("");
                        l515=new JLabel("");
                        l516=new JLabel("");
                        l517=new JLabel("");
                        l518=new JLabel("");
                        l519=new JLabel("");
                        l520=new JLabel("");
                        l521=new JLabel("");
                        l522=new JLabel("");
                        l523=new JLabel("");
                        l524=new JLabel("");
                        l525=new JLabel("<- Second Digit",SwingConstants.LEFT);
                        l526=new JLabel("");
                        l527=new JLabel("Your Answer:",SwingConstants.RIGHT);
                        l530= new JLabel("");
                        t502= new JTextField();
                        t502.setFont(font3);
                        t503= new JTextField();
                        t503.setFont(font3);
                        l532= new JLabel("");
                        l534= new JLabel("");
                        t506= new JTextField();
                        t507= new JTextField();
                        t507.setFont(font2);
                        t508= new JTextField();
                        t508.setFont(font2);
                        t509= new JTextField();
                        t509.setFont(font2);
                        t510= new JTextField();
                        t510.setFont(font2);
                        t511= new JTextField();
                        t511.setFont(font2);
                        t512= new JTextField();
                        l531= new JLabel("");
                        t514= new JTextField();
                        t514.setFont(font3);
                        t515= new JTextField();
                        t515.setFont(font3);
                        l533= new JLabel("");
                        t517= new JTextField();
                        t517.setFont(font);
                        bonus2 = new JTextField();
                        b51=new JButton("Back");
                        b51.addActionListener(this);
                        p51.add(b51);
                        p51.add(l530);
                        p51.add(l507);
                        p51.add(t502);
                        p51.add(l501);
                        p51.add(t503);
                        p51.add(l508);
                        p51.add(l532);
                        p51.add(l509);
                        p51.add(l534);
                        p52.add(l504);
                        p52.add(t506);
                        p52.add(l510);
                        p52.add(bonus2);
                        p52.add(l506);
                        p52.add(l512);
                        p52.add(l513);
                        p52.add(l503);
                        p52.add(l514);
                        p52.add(l515);
                        p52.add(t507);
                        p52.add(t508);
                        p52.add(t509);
                        p52.add(t510);
                        p52.add(t511);
                        p52.add(l516);
                        p52.add(l517);
                        p52.add(l518);
                        p52.add(l519);
                        p52.add(l520);
                        p52.add(l521);
                        p52.add(l505);
                        p52.add(t512);
                        p52.add(l522);
                        p52.add(l523);
                        p53.add(l531);
                        p53.add(l524);
                        p53.add(t514);
                        p53.add(l525);
                        p53.add(t515);
                        p53.add(l502);
                        p53.add(l533);
                        p53.add(l526);
                        p53.add(l527);
                        p53.add(t517);
                        f5.add(p51);
                        f5.add(p52);
                        f5.add(p53);
                        t502.setEditable (false);
                        t503.setEditable (false);
                        t506.setEditable (false);
                        t507.setEditable (false);
                        t508.setEditable (false);
                        t509.setEditable (false);
                        t510.setEditable (false);
                        t511.setEditable (false);
                        t512.setEditable (false);
                        t514.setEditable (false);
                        t515.setEditable (false);
                        t517.setEditable (false);
                        bonus2.setEditable (false);
                            t506.setText (numberofquestions.toString ());
                            problem = new Problem ();
                            numbersequence = problem.GenerateSequence ();
                            t507.setText (((Integer) numbersequence [0]).toString ());
                            t508.setText (((Integer) numbersequence [1]).toString ());
                            t509.setText (((Integer) numbersequence [2]).toString ());
                            t510.setText (((Integer) numbersequence [3]).toString ());
                            t511.setText ("??");
                            bonus2.setText (((Integer) correctanswersinarow2).toString ());
                        f5.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    f5.setSize(1500,500);
                    f5.setVisible(true);
                }
                
                void PlayerGame()
        {
                        playonce("src/Gun_Load_-_Sound_Effect.wav");
                layout4 =new GridLayout();
                f4 = new JFrame("Choose Player");
                f4.setLayout(layout4);
                p3 = new JPanel();
                p3.setLayout(new GridLayout(1,4));
                b31 = new JButton("Player 1");
                b31.addActionListener(this);
                b32 = new JButton("Player 2");
                b32.addActionListener(this);
                b33 = new JButton("Back");
                b33.addActionListener(this);
                l31 = new JLabel("Vs",SwingConstants.CENTER);
                p3.add(b33);
                p3.add(b31);
                p3.add(l31);
                p3.add(b32);
                f4.add(p3);
                f4.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            f4.setSize(300,100);
            f4.setVisible(true);
        }
                void playonce(String filename)
        {
                InputStream in = null;
                        try {
                                in = new FileInputStream(filename);
                        } catch (FileNotFoundException e) {
                                // TODO Auto-generated catch block
                                e.printStackTrace();
                        }
                    AudioStream as = null;
                        try {
                                as = new AudioStream(in);
                        } catch (IOException e) {
                                // TODO Auto-generated catch block
                                e.printStackTrace();
                        }
                    AudioPlayer.player.start(as);
        }
        void playloop(String filename)
        {
                InputStream in = null;
                        try {
                                in = new FileInputStream(filename);
                        } catch (FileNotFoundException e1) {
                                // TODO Auto-generated catch block
                                e1.printStackTrace();
                        }
                    AudioStream as = null;
                        try {
                                as = new AudioStream(in);
                        } catch (IOException e) {
                                // TODO Auto-generated catch block
                                e.printStackTrace();
                        }
                        AudioData data = null;
                        try {
                                data = as.getData();
                        } catch (IOException e) {
                                // TODO Auto-generated catch block
                                e.printStackTrace();
                        }
                        ContinuousAudioDataStream cas = new ContinuousAudioDataStream (data);
                    AudioPlayer.player.start(cas);
        }
        public void Update (int bs1, int bs2, double g1, double g2)
        {
                this.bs1 = bs1;
                this.bs2 = bs2;
                this.g1 = g1;
                this.g2 = g2;
                int temp = 0;
                temp = numberofquestions % 3;
                        bonus1.setText (((Integer) temp).toString ());
                        if (numberofquestions <= 0)
                        {
                                f5.dispose ();
                                t12.setText (((Integer) timer2).toString ());
                                if (numberofactivationsofrecordtable > 0)
                                {
                                        f2.setVisible (true);
                                        numberofactivationsofrecordtable = numberofactivationsofrecordtable + 1;
                                }
                        }
                        if (numberofquestions % 3 == 0)
                        {
                                if (g1 > 1.5)
                            {
                                    catch1 = number1;
                                    t202.setText (((Integer) catch1).toString ());
                                    f3.repaint ();
                            }
                            else if (g2 > 1.5)
                            {
                                    catch2 = number2;
                                    t214.setText (((Integer) catch2).toString ());
                                    f3.repaint ();
                            }
                                correctanswersinarow1 = 0;
                                if (problem.CheckTheAnswer (answer))
                            {
                                        numberofquestions = numberofquestions - 3;
                            }
                        }
                        else
                        {
                                if (bs1 < 500)
                            {
                                    catch1 = number1;
                                    t202.setText (((Integer) catch1).toString ());
                                    f3.repaint ();
                            }
                            else if (bs2 < 650)
                            {
                                    catch2 = number2;
                                    t214.setText (((Integer) catch2).toString ());
                                    f3.repaint ();
                            }
                                if (problem.CheckTheAnswer (answer))
                            {
                                        numberofquestions = numberofquestions - 1;
                            }
                        }
                        if (numberofquestions <= 0)
                        {
                                f3.dispose ();
                                t11.setText (((Integer) timer1).toString ());
                                if (numberofactivationsofrecordtable > 0)
                                {
                                        f2.setVisible (true);
                                        numberofactivationsofrecordtable = numberofactivationsofrecordtable + 1;
                                }
                        }
                        answer = 10 * catch1 + catch2;
                        f3.repaint ();
                        if (problem.CheckTheAnswer (answer))
                        {
                                numberofquestions = numberofquestions - 1;
                                t206.setText (numberofquestions.toString ());
                            t217.setText (((Integer) answer).toString ());
                            time = time - 125;
                            t206.setText (numberofquestions.toString ());
                            numbersequence = problem.GenerateSequence ();
                            t207.setText (((Integer) numbersequence [0]).toString ());
                            t208.setText (((Integer) numbersequence [1]).toString ());
                            t209.setText (((Integer) numbersequence [2]).toString ());
                            t210.setText (((Integer) numbersequence [3]).toString ());
                            t211.setText ("??");
                            catch1 = 0;
                                t202.setText ("");
                                catch2 = 0;
                                t214.setText ("");
                                f3.repaint ();
                                correctanswersinarow1 = correctanswersinarow1 + 1;
                        }
             
                        f3.repaint ();
                        bonus2.setText (((Integer) temp).toString ());
                if (numberofquestions % 3 == 0)
                {
                        if (g1 > 1.5)
                    {
                            catch1 = number1;
                            t502.setText (((Integer) catch1).toString ());
                            f5.repaint ();
                    }
                    else if (g2 > 1.5)
                    {
                            catch2 = number2;
                            t514.setText (((Integer) catch2).toString ());
                            f5.repaint ();
                    }
                        correctanswersinarow2 = 0;
                        if (problem.CheckTheAnswer (answer))
                    {
                                numberofquestions = numberofquestions - 3;
                    }
                }
                else
                {
                        if (bs1 < 500)
                    {
                            catch1 = number1;
                            t502.setText (((Integer) catch1).toString ());
                            f5.repaint ();
                    }
                    else if (bs2 < 650)
                    {
                            catch2 = number2;
                            t514.setText (((Integer) catch2).toString ());
                            f5.repaint ();
                    }
                        if (problem.CheckTheAnswer (answer))
                    {
                                numberofquestions = numberofquestions - 1;
                    }
                }
                
                answer = 10 * catch1 + catch2;
                System.out.println (answer);
                f5.repaint ();
                if (problem.CheckTheAnswer (answer))
                {
                        numberofquestions = numberofquestions - 1;
                        t506.setText (numberofquestions.toString ());
                    t517.setText (((Integer) answer).toString ());
                    time = time - 125;
                    t506.setText (numberofquestions.toString ());
                    numbersequence = problem.GenerateSequence ();
                    t507.setText (((Integer) numbersequence [0]).toString ());
                    t508.setText (((Integer) numbersequence [1]).toString ());
                    t509.setText (((Integer) numbersequence [2]).toString ());
                    t510.setText (((Integer) numbersequence [3]).toString ());
                    t511.setText ("??");
                    catch1 = 0;
                        t502.setText ("");
                        catch2 = 0;
                        t514.setText ("");
                        f5.repaint ();
                        correctanswersinarow1 = correctanswersinarow1 + 1;
                }
                f5.repaint ();
            }
}

import java.util.*;

public class Problem 
{
        private int [] sequence;
        
        public Problem ()
        {
                sequence = new int [5];
        }
        
        public int [] GenerateSequence ()
        {
                int increment, index;
                increment = new Random ().nextInt (20);
                sequence [0] = new Random ().nextInt (20);
                for (index = 1; index < 5; index = index + 1)
                {
                        sequence [index] = sequence [0] + index  * increment;
                }
                return sequence;
        }
        
        public boolean CheckTheAnswer (int answer)
        {
                return (answer == sequence [4]);
        }
}

public interface Observer 
{
        public void Update (int bs1, int bs2, double g1, double g2);
}

public interface Subject 
{
        public void RegisterObserver (Observer o);
        public void RemoveObsever (Observer o);
        public void NotifyObservers () throws InterruptedException;
}

import java.util.ArrayList;

import jssc.SerialPort;
import jssc.SerialPortException;

public class Sensor implements Subject, Runnable
{
        private ArrayList <Observer> observers;
        private double g1, g2;
        private int bendsensor1, bendsensor2;
        private Thread thread;
        
        public Sensor ()
        {
                observers = new ArrayList <Observer> ();
                thread = new Thread (this);
                thread.start ();
        }
        
        static StringBuilder ExtractCommand (int comm []) 
        {
                StringBuilder command = new StringBuilder();
                int i = 0;
                boolean process = true;
                while (true) 
                {
                        if (comm [i] == 13) 
                        {
                                process = false;
                                break;
                        } 
                        else
                        {
                                command.append ((char) comm [i]);
                                i = i + 1;
                        }
                }
                return command;
        }
        
        public void NotifyObservers () throws InterruptedException
        {
                int index;
                for (index = 0; index < observers.size (); index = index + 1)
                {
                        Observer observer = observers.get (index);
                        observer.Update (bendsensor1, bendsensor2, g1, g2);
                }
        }
        
        public void RegisterObserver (Observer o)
        {
                observers.add (o);
        }
        
        public void RemoveObsever (Observer o)
        {
                int index = observers.indexOf (o); 
                if (index >= 0)
                {
                        observers.remove (index);
                }
        }
        
        public void ReadSensors () throws SerialPortException
        {
                SerialPort serialport = new SerialPort ("/dev/tty.usbserial-A700eEa7");
                try 
                {
                        serialport.openPort();
                        serialport.setParams (9600, 8, 1, 0);
                        StringBuffer string = new StringBuffer (100);
                        while (true) 
                        {
                                byte [] buffer = serialport.readBytes (1);
                                if (buffer [0] != 13) 
                                {
                                        string.append ((char) (buffer [0]));
                                } 
                                else if (buffer [0] == 13) 
                                {
                                        try 
                                        {
                                                serialport.readBytes (1);
                                                String tokens [] = string.toString ().split (" ");
                                                bendsensor1 = Integer.parseInt (tokens [0]);
                                                bendsensor2 = Integer.parseInt (tokens [1]);
                                                g1 = Double.parseDouble (tokens [2]);
                                                g2 = Double.parseDouble (tokens [3]);
                                                //System.out.println (bendsensor1);
                                                //System.out.println (bendsensor2);
                                                //System.out.println (g1);
                                                //System.out.println (g2);
                                                NotifyObservers ();
                                                string.setLength (0);
                                        } 
                                        catch (Exception e) 
                                        {
                                                string.setLength (0);
                                        }
                                }
                        }
                } 
                catch (SerialPortException spe) 
                {
                        System.out.println (spe);
                }
                serialport.closePort ();
        }
        
        public void run ()
        {
                try 
                {
                        ReadSensors ();
                } 
                catch (SerialPortException spe) 
                {
                        spe.printStackTrace ();
                }
        }
}


