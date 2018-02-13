package zork;

import java.util.Timer;
import java.util.TimerTask;
import static zork.StoryParser.roomcount;


public class TimerClass {
        Timer myTimer = new Timer();
        TimerTask task = new TimerTask() {

            @Override
            public void run() {
                int damage=25;
                   if(Players.hp-damage>=0){
                   Players.hp-=damage;
                   }else if (Players.hp-damage<0){
                       Players.hp-=Players.hp;
                   }                   
                   
                   
                    if(Players.hp==0){
                         System.out.println("\nRIP");
                         System.exit(0);
                    }else if(Players.hp<=damage)
                         System.out.println("\n~Your Hp is too low : " + Players.hp);
                     else
                         System.out.println("\n~Your Hp is " + Players.hp);
                     System.out.print("> ");
            }
        };
        
        public void start(){
            myTimer.scheduleAtFixedRate(task,60000,60000);
        }
        
    
    
}
