package zork;

import static zork.StoryParser.roomcount;
import static zork.StoryParser.CurrentRoom;
import static zork.StoryParser.ZorkItems;
import static zork.StoryParser.ZorkNPCs;
import static zork.StoryParser.Zorkrooms;
import static zork.StoryParser.roomDeclaration;

public class LookCommand implements Command {

        @Override
    public void exec() {
        boolean checkInventory=false;
        boolean checkInventory2=false;
        System.out.println("You are at " + CurrentRoom.getName() );
            for (String Item : Players.Items) {
                if (Item.equals(ZorkItems.get(roomcount).getItemName())) {
                    checkInventory=true;
                    break;
                }
            }
            for (String Item : Players.Items) {
                if (Item.equals(ZorkItems.get(roomcount).getItemForAction())) {
                    checkInventory2=true;
                    break;
                }
            }
        if(!ZorkItems.get(roomcount).getItemName().contains("noitem")&&!ZorkItems.get(roomcount).getItemName().equals("used")&& !checkInventory==true)
        System.out.println("And you see " + ZorkItems.get(roomcount).getItemName());
        if(!ZorkItems.get(roomcount).getItemForAction().contains("noitem")&&!ZorkItems.get(roomcount).getItemForAction().equals("used")&& !checkInventory2==true)
            System.out.println("And this item: " + ZorkItems.get(roomcount).getItemForAction());
        if(!ZorkNPCs.get(roomcount).getNameNPC().equals("nobody"))
        System.out.println("Look!!! there is someone in your way oh he is " +ZorkNPCs.get(roomcount).getNameNPC());
        
                    Players.moves++;
            System.out.print("> ");
    }
}
