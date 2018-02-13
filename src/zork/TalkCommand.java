package zork;

import java.util.Scanner;
import static zork.InputParser.SecondWord;
import static zork.StoryParser.roomcount;
import static zork.StoryParser.ZorkNPCs;
import static zork.StoryParser.Zorkrooms;
import static zork.StoryParser.roomDeclaration;


public class TalkCommand implements Command {

    public void WinOrLose(){
      System.out.println(ZorkNPCs.get(roomcount).getGuiderDescription());
      Scanner scanner = new Scanner(System.in);
      String TheKiller = scanner.nextLine().toUpperCase();
      
      if(TheKiller.equals(StoryParser.Killer.toUpperCase())){
          System.out.println("Good job detective.You find the killer.Mr Black said that you are the best");
          System.exit(0);
      }
      else{
          System.out.println("You are wrong." + StoryParser.Killer + " is the killer");
          System.exit(0);
      }
    }

    @Override
    public void exec() {

        String GuiderName;
        GuiderName=ZorkNPCs.get(roomcount).getNameNPC();
        if(!ZorkNPCs.get(roomcount).getNameNPC().equals("nobody")){     
       
            if(GuiderName.toUpperCase().equals(StoryParser.Guider.toUpperCase())){
                WinOrLose();
            }
            if(Players.itemHadgiven){
                System.out.println(ZorkNPCs.get(roomcount).getGuiderDescription()); 
                Players.moves++;
                Players.score+=10;
                Players.itemHadgiven=false;
            }
            else {
                Players.moves++;
            
                System.out.println("Give me my precious");
            }
        }
        else
            System.out.println("There is not NPC here!!");
        
        System.out.print("> ");
    }
}
