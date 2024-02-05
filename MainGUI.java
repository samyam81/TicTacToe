package TicTacToe;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;


public class MainGUI implements ActionListener{
    public static void main(String[] args) {
        new MainGUI();
    }

    JFrame frame=new JFrame();
    JLabel textfield=new JLabel();
    JButton[] board=new JButton[9];
    JPanel bpanel=new JPanel();
    JPanel tpanel=new JPanel();
    boolean player1;
    
    // JLabel heading=new JLabel();

    Font myFont=new Font("Monospaced",Font.BOLD,30);
    
    MainGUI(){

        frame =new JFrame("Tic-Tac-Toe");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setBackground(new Color(20,20,20));
        frame.setSize(420,550);

        // heading= new JLabel("  Tic-Tac-Toe");
        // heading.setBounds(5,5,200,30);
        // heading.setFont(myFont);

        textfield.setBackground(Color.black);
        textfield.setForeground(new Color(255,215,0)); 
        textfield.setFont(myFont);
        textfield.setText("   Tic-Tac-Toe");
        textfield.setOpaque(true);

        tpanel.setLayout(new BorderLayout());
        tpanel.setBounds(0,50,550,50);

        bpanel.setLayout(new GridLayout(3,3));
        bpanel.setBackground(Color.pink);
        

        for (int i = 0; i < 9; i++) {
            board[i]=new JButton();
            bpanel.add(board[i]);
            board[i].setFont(myFont);
            board[i].setFocusable(false);
            board[i].addActionListener(this);
        }

        tpanel.add(textfield);
        // frame.add(heading);
        frame.add(tpanel,BorderLayout.NORTH);
        frame.add(bpanel);
        frame.setVisible(true);

        firstTurn();
    }
    private void firstTurn() {
        Random rand=new Random();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
          
            e.printStackTrace();
        }
        if (rand.nextInt(2)==0) {
            player1=true;
            textfield.setText("X turn");
        }
        else{
            player1=false;
            textfield.setText("0 turn");
        }
    }
    

    @Override
    public  void actionPerformed(ActionEvent e){
        for (int i = 0; i < 9; i++) {
            if (e.getSource()==board[i]) {
                    if (player1) {
                        if (board[i].getText()=="") {
                            board[i].setForeground(Color.GRAY);
                            board[i].setText("X");
                            player1=false;
                            textfield.setText("0 turn");
                            check();
                        }
                    }  else {
                        if (board[i].getText()=="") {
                            board[i].setForeground(Color.cyan);
                            board[i].setText("0");
                            player1=true;
                            textfield.setText("X turn");
                            check();
                        }
                    }
            }
        }
        
    }
    private void check() {


            if ((board[0].getText()=="X")
            &&
            (board[1].getText()=="X")
            &&
            (board[2].getText()=="X")){
                Xwins(0,1,2);
            }
            
              else if ((board[0].getText()=="0")
            &&
            (board[1].getText()=="0")
            &&
            (board[2].getText()=="0")){
                Owins(0,1,2);
            }

            else if ((board[3].getText()=="X")
            &&
            (board[4].getText()=="X")
            &&
            (board[5].getText()=="X")){
                Xwins(3,4,5);
            }

               else if ((board[3].getText()=="0")
            &&
            (board[4].getText()=="0")
            &&
            (board[5].getText()=="0")){
                Owins(3,4,5);
            }

            else if ((board[6].getText()=="X")
            &&
            (board[7].getText()=="X")
            &&
            (board[8].getText()=="X")){
                Xwins(6,7,8);
            }

             else if ((board[6].getText()=="0")
            &&
            (board[7].getText()=="0")
            &&
            (board[8].getText()=="0")){
                Owins(6,7,8);
            }

            else if ((board[0].getText()=="X")
            &&
            (board[3].getText()=="X")
            &&
            (board[6].getText()=="X")){
                Xwins(0,3,6);
            }

              else if ((board[0].getText()=="0")
            &&
            (board[3].getText()=="0")
            &&
            (board[6].getText()=="0")){
                Owins(0,3,6);
            }

            else if ((board[1].getText()=="X")
            &&
            (board[4].getText()=="X")
            &&
            (board[7].getText()=="X")){
                Xwins(1,4,7);
            }

              else if ((board[1].getText()=="0")
            &&
            (board[4].getText()=="0")
            &&
            (board[7].getText()=="0")){
                Owins(1,4,7);
            }


            else if ((board[2].getText()=="X")
            &&
            (board[5].getText()=="X")
            &&
            (board[8].getText()=="X")){
                Xwins(2,5,8);
            }

              else if ((board[2].getText()=="0")
            &&
            (board[5].getText()=="0")
            &&
            (board[8].getText()=="0")){
                Owins(2,5,8);
            }

            else if ((board[0].getText()=="X")
            &&
            (board[4].getText()=="X")
            &&
            (board[8].getText()=="X")){
                Xwins(0,4,8);
            }

             else if ((board[0].getText()=="0")
            &&
            (board[4].getText()=="0")
            &&
            (board[8].getText()=="0")){
                Owins(0,4,8);
            }
            
            else if ((board[2].getText()=="X")
            &&
            (board[4].getText()=="X")
            &&
            (board[6].getText()=="X")){
                Xwins(2,4,6);
            }

              else if ((board[2].getText()=="0")
            &&
            (board[4].getText()=="0")
            &&
            (board[6].getText()=="0")){
                Owins(2,4,6);
            }        
    }
    private void Owins(int i, int j, int k) {
     
        board[i].setBackground(Color.magenta);
        board[j].setBackground(Color.magenta);
        board[k].setBackground(Color.magenta);

        for (int k2 = 0; k2 < 9; k2++) {
            board[k2].setEnabled(false);
        }
        textfield.setText("   0-Wins");
      
    }
    private void Xwins(int i, int j, int k) {
      board[i].setBackground(Color.PINK);
       board[j].setBackground(Color.PINK);
        board[k].setBackground(Color.PINK);

        for (int k2 = 0; k2 < 9; k2++) {
            board[k2].setEnabled(false);
        }
        textfield.setText("  X-Wins");
    }
    
}