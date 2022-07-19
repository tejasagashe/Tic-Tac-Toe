import java.util.*;
import java.io.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;



public class TicTacToe implements ActionListener{


    Random random=new Random();
    JFrame frame=new JFrame();  // creating frame
    JPanel title =new JPanel(); 
    JPanel button=new JPanel();
    JLabel textField=new JLabel ();
    JButton[] buttons=new JButton[9];
    boolean player1_turn;
  
    TicTacToe(){
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600,600);   
        frame.getContentPane().setBackground(new Color(50,50,50));
        frame.setLayout(new BorderLayout());
        frame.setVisible(true);

        textField.setBackground(new Color(25,25,25));
        textField.setForeground(new Color(25,255,0));
        textField.setFont(new Font("Ink Free",Font.BOLD,25));
        textField.setHorizontalAlignment(JLabel.CENTER);
        textField.setText(("Tic-Tac-Toe"));
        textField.setOpaque(true);

        title.setLayout(new BorderLayout());
        title.setBounds(0,0,800,100);
        title.add(textField);
        frame.add(title,BorderLayout.NORTH); 
        frame.setResizable(false);

        button.setLayout(new GridLayout(3,3,5,5)); // setting rows and columns
        button.setBackground(new Color(255, 255, 255 )); // setting background color
        frame.add(button);
        for(int i=0;i<9;i++){  // Adding 9 buttons in the frame
            buttons[i]=new JButton();
            button.add(buttons[i]);
            buttons[i].setBackground(new Color(39, 55, 70 ));
            buttons[i].setFont(new Font("MV Boli",Font.BOLD,120));
            buttons[i].setFocusable(false);
            buttons[i].addActionListener(this);
        }
        
        firstTurn();


    }
    public void actionPerformed(ActionEvent e){ // In this we performing action like if x chooses its pos then it show the o turn and also checking if three of them are in line or not

        for(int i=0;i<9;i++){
            if(e.getSource()==buttons[i]){
                if(player1_turn){
                    if(buttons[i].getText()==""){
                      buttons[i].setForeground(new Color(255,0,0));
                      buttons[i].setText("X");
                      player1_turn=false;
                      textField.setText("O Turn");
                      check();
                    }
                }
                else{
                    if(buttons[i].getText()==""){
                        buttons[i].setForeground(new Color(255,255,255));
                        buttons[i].setText("O");
                        player1_turn=true;
                        textField.setText("X Turn");
                        check();
                      }
                }
            }
        }
    }

    public void firstTurn(){  //This function is used for player turns

        try {
            Thread.sleep(1000);
        } catch (Exception e) {
           
            e.printStackTrace();
        }
       

        if(random.nextInt(2)==0){
            player1_turn=true;
            textField.setText("X Turn");
        }
        else{
            player1_turn=false;
            textField.setText("O Turn");
        }
    }

    public void check(){ // This function is to check if 3 buttons matches of X or O then it calls xwins or owins function

        if((buttons[0].getText()=="X") &&
         (buttons[1].getText()=="X") &&
         (buttons[2].getText()=="X")){
            xwins(0,1,2);
        }

       else if((buttons[3].getText()=="X") &&
        (buttons[4].getText()=="X") &&
        (buttons[5].getText()=="X")){
           xwins(3,4,5);
       }

      else if((buttons[6].getText()=="X") &&
       (buttons[7].getText()=="X") &&
       (buttons[8].getText()=="X")){
          xwins(6,7,8);
      }

     else if((buttons[0].getText()=="X") &&
      (buttons[4].getText()=="X") &&
      (buttons[8].getText()=="X")){
         xwins(0,4,8);
     }

    else if((buttons[2].getText()=="X") &&
     (buttons[4].getText()=="X") &&
     (buttons[6].getText()=="X")){
        xwins(2,4,6);
    }

   else if((buttons[1].getText()=="X") &&
    (buttons[4].getText()=="X") &&
    (buttons[7].getText()=="X")){
       xwins(1,4,7);
   }

  else if((buttons[0].getText()=="X") &&
   (buttons[3].getText()=="X") &&
   (buttons[6].getText()=="X")){
      xwins(0,3,6);
  }

 else if((buttons[2].getText()=="X") &&
  (buttons[5].getText()=="X") &&
  (buttons[8].getText()=="X")){
     xwins(2,5,8);
 }

     else if((buttons[0].getText()=="O") &&
         (buttons[1].getText()=="O") &&
         (buttons[2].getText()=="O")){
            owins(0,1,2);
        }

       else if((buttons[3].getText()=="O") &&
        (buttons[4].getText()=="O") &&
        (buttons[5].getText()=="O")){
           owins(3,4,5);
       }

      else if((buttons[6].getText()=="O") &&
       (buttons[7].getText()=="O") &&
       (buttons[8].getText()=="O")){
          owins(6,7,8);
      }

     else if((buttons[0].getText()=="O") &&
      (buttons[4].getText()=="O") &&
      (buttons[8].getText()=="O")){
         owins(0,4,8);
     }

    else if((buttons[2].getText()=="O") &&
     (buttons[4].getText()=="O") &&
     (buttons[6].getText()=="O")){
        owins(2,4,6);
    }

   else if((buttons[1].getText()=="O") &&
    (buttons[4].getText()=="O") &&
    (buttons[7].getText()=="O")){
       owins(1,4,7);
   }

  else if((buttons[0].getText()=="O") &&
   (buttons[3].getText()=="O") &&
   (buttons[6].getText()=="O")){
      owins(0,3,6);
  }

 else if((buttons[2].getText()=="O") &&
  (buttons[5].getText()=="O") &&
  (buttons[8].getText()=="O")){
     owins(2,5,8);
 }
 else {
 for (int i=0;i<9;i++){  // This foor loop checks the draw condition
    if(buttons[i].getText()=="X" || buttons[i].getText()=="O"){
        if(i==8)
        textField.setText("Draw");
    }
    else{
        break;
    }
 }
    }
}

    public void xwins(int a,int b,int c){

        buttons[a].setBackground(Color.GREEN);
        buttons[b].setBackground(Color.GREEN);
        buttons[c].setBackground(Color.GREEN);
        
        for(int i=0;i<9;i++){            //This for loop is used to make all buttons false after x wins
            buttons[i].setEnabled(false);
        }
        textField.setText("X Wins");
    }

    public void owins(int a,int b,int c){

        buttons[a].setBackground(Color.GREEN);
        buttons[b].setBackground(Color.GREEN);
        buttons[c].setBackground(Color.GREEN);

        for(int i=0;i<9;i++){           //This for loop is used to make all buttons false after o wins
            buttons[i].setEnabled(false);
        }
        textField.setText("O Wins");
    }

}