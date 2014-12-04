/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package turntactoe;

import javax.swing.JButton;
import javax.swing.JList;
import turntactoe.ui.Game;
import turntactoe.ui.Interface;

/**
 *
 * @author iLiminate
 */
public class TurnTacToe {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        new Interface().setVisible(true);
    }
    
    /**
     * @param rotations How many times to rotate the pieces on the board around the center.
    **/
    
    public static void turnTable(int rotations){
        int value1 = 1;
        JButton[] rButtons = {Game.btnOne,Game.btnTwo,Game.btnThree,Game.btnFour,Game.btnFive,Game.btnSix,Game.btnSeven,Game.btnEight, Game.btnNine};
        JButton[] buttons = {Game.btnOne,Game.btnTwo,Game.btnThree,Game.btnFour,Game.btnSix,Game.btnSeven,Game.btnEight, Game.btnNine};
        String[] values = {"","","","","","","","",""};
        
        for (int i=0;i<8;i++){
            values[i] = buttons[(value1+i<8)? value1+i : i ].getText();
            System.out.println(buttons[i].getName() + ": " + values[i]);
        }
        System.out.println("____");
        for (int e=0;e<9;e++){
            rButtons[e].setText((e+1<values.length) ? values[e+1]: values[e] );
           // rButtons[e].setEnabled(!(values[e].contains("X") || values[e].contains("O")));
        }
        
    }
    /**
    *@return Returns true if there is a win.(fix this so it does it per player?)
    **/   
    public static boolean checkWin(){
    String[] btnValue = {Game.btnOne.getText(),Game.btnTwo.getText(),Game.btnThree.getText(),Game.btnFour.getText(),Game.btnFive.getText(),Game.btnSix.getText(),Game.btnSeven.getText(),Game.btnEight.getText(),Game.btnNine.getText()};
    
    if( btnValue[0].matches(btnValue[1]) && btnValue[1].matches(btnValue[2])){if(!btnValue[2].isEmpty()){return true;}}
    if( btnValue[0].matches(btnValue[3]) && btnValue[3].matches(btnValue[6])){if(!btnValue[6].isEmpty()){return true;}}
    if( btnValue[0].matches(btnValue[4]) && btnValue[4].matches(btnValue[8])){if(!btnValue[8].isEmpty()){return true;}}
    if( btnValue[1].matches(btnValue[4]) && btnValue[4].matches(btnValue[7])){if(!btnValue[7].isEmpty()){return true;}}
    if( btnValue[2].matches(btnValue[5]) && btnValue[5].matches(btnValue[8])){if(!btnValue[8].isEmpty()){return true;}}
    if( btnValue[2].matches(btnValue[4]) && btnValue[4].matches(btnValue[6])){if(!btnValue[6].isEmpty()){return true;}}
    if( btnValue[3].matches(btnValue[4]) && btnValue[4].matches(btnValue[5])){if(!btnValue[5].isEmpty()){return true;}}
    if( btnValue[6].matches(btnValue[7]) && btnValue[7].matches(btnValue[8])){if(!btnValue[8].isEmpty()){return true;}}
    
    return false;
    }
    
    public static void resetBoard(){
        JButton[] buttons = {Game.btnOne,Game.btnTwo,Game.btnThree,Game.btnFour,Game.btnFive,Game.btnSix,Game.btnSeven,Game.btnEight, Game.btnNine};
        for(JButton button:buttons) {
            button.setText("");
            button.setEnabled(true);
        }
        Game.curPlayer.setText("2");
    }
}
