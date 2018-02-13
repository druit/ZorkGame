package zork;

import static zork.StoryParser.CurrentRoom;
import static zork.StoryParser.roomcount;


public class WhatNeedCommand implements Command {


    @Override
    public void exec() {
        int WayOfCard=0;
        String first[];
    
        for (int i=0;i<StoryParser.ZorkItems.size();i++){
            
                if(StoryParser.ZorkItems.get(i).getRoomUseItem().equals(StoryParser.CurrentRoom.getName())){
                    WayOfCard=i;
                    break;
                }
 
        }
        if(!StoryParser.ZorkNPCs.get(roomcount).getNameNPC().equals("nobody")){
                if(StoryParser.ZorkItems.get(WayOfCard).getItemName().contains("noitem")){
                first= StoryParser.ZorkItems.get(WayOfCard).getItemName().split("noi");
                System.out.println("You need " + first[0]);    
                }else
                    System.out.println("You need "+StoryParser.ZorkItems.get(WayOfCard).getItemName());
                }
        else
                System.out.println("There is not NPC here!");
        
        Players.moves++;
        System.out.print("> ");
    }
    
}
