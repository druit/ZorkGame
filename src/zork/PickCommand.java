package zork;

import java.util.ArrayList;
import static zork.InputParser.SecondWord;
import static zork.Players.Items;
import static zork.StoryParser.ZorkItems;


class PickCommand implements Command {

    public PickCommand() {
    }

    @Override
    public void exec() {
         Items ite;
        int placeofitem=0;
        boolean Alreadytake=false;
        
        ArrayList<String> names = new ArrayList<String>();
        ArrayList<String> hasItems = new ArrayList<String>();
        
        int i;
        for(i=0;i<ZorkItems.size();i++){
             ite = ZorkItems.get(i);
             names.add(ite.getItemForAction());
             hasItems.add(ite.getRoomHasItem());
        }
        
        String item = InputParser.SecondWord;
        String room = StoryParser.CurrentRoom.getName();
        
        boolean contains=false;
        for(i=0;i<ZorkItems.size();i++){
            if(names.get(i).equals(item)&&hasItems.get(i).equals(room)){
               Players.Items.add(item);
               placeofitem=i;
              
               StoryParser.ZorkItems.get(i).setItemForAction(ZorkItems.get(i).getItemForAction()+"noitem");
                
                contains=true;
            }              
        }
        if (contains == false)
            {
            for (String Item : Items) {
                if (Item.equals(SecondWord)) {
                    Alreadytake=true;
                }
            }
            if(Alreadytake==true)
                System.out.println("You already have it");
            else
                System.out.println("this item not included in this room");
            }
            
        else{
                        Players.moves++;
                        Players.score+=5;
                System.out.println("You picked up: "+names.get(placeofitem));      
        }   
        
        System.out.print("> ");
    }
    
}
