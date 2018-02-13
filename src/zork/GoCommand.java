/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package zork;

import Output.Display;
import static zork.StoryParser.ZorkItems;
import static zork.StoryParser.roomcount;
import static zork.StoryParser.Zorkrooms;


public class GoCommand implements Command{

    @Override
    public void exec() {
      boolean nowhere;
      boolean Getroomcoun=false;
      String RoomName = "";
      nowhere = ZorkItems.get(roomcount).getRoomUseActionItem().equals("nowhere");
 
         if(nowhere==false){
            switch (InputParser.SecondWord) {
                case "east":

                    if(ZorkItems.get(roomcount).getTrueorFalse().equals("true")||!Zorkrooms.get(roomcount).getEast().equals(ZorkItems.get(roomcount).getRoomUseActionItem()))
                    {
                       
                        RoomName = StoryParser.CurrentRoom.getEast();
                        Getroomcoun=true;
                    }
                    else if(ZorkItems.get(roomcount).getTrueorFalse().equals("false")){
                        System.out.println(ZorkItems.get(roomcount).getBeforeAction());
                        System.out.print("> ");
                    }           break;
                case "west":
                    if(ZorkItems.get(roomcount).getTrueorFalse().equals("true")||!Zorkrooms.get(roomcount).getWest().equals(ZorkItems.get(roomcount).getRoomUseActionItem()))
                    {
                        RoomName = StoryParser.CurrentRoom.getWest();
                        Getroomcoun=true;
                    }
                    else if(ZorkItems.get(roomcount).getTrueorFalse().equals("false")){
                        System.out.println(ZorkItems.get(roomcount).getBeforeAction());
                        System.out.print("> ");
                    }           break;
                case "north":
                    if(ZorkItems.get(roomcount).getTrueorFalse().equals("true")||!Zorkrooms.get(roomcount).getNorth().equals(ZorkItems.get(roomcount).getRoomUseActionItem()))
                    { RoomName = StoryParser.CurrentRoom.getNorth();
                    Getroomcoun=true;
                    }
                    else if(ZorkItems.get(roomcount).getTrueorFalse().equals("false")){
                        System.out.println(ZorkItems.get(roomcount).getBeforeAction());
                        System.out.print("> ");
                    }           break;
                case "south":
                    if(ZorkItems.get(roomcount).getTrueorFalse().equals("true")||!Zorkrooms.get(roomcount).getSouth().equals(ZorkItems.get(roomcount).getRoomUseActionItem()))
                    { RoomName = StoryParser.CurrentRoom.getSouth();
                        Getroomcoun=true;
                    }
          else if(ZorkItems.get(roomcount).getTrueorFalse().equals("false")){
            System.out.println(ZorkItems.get(roomcount).getBeforeAction());
            System.out.print("> ");
           }        break;
            }
         }else{
            switch (InputParser.SecondWord) {
                case "east":
                    RoomName = StoryParser.CurrentRoom.getEast();
                    break;
                case "west":
                    RoomName = StoryParser.CurrentRoom.getWest();
                    break;
                case "north":
                    RoomName = StoryParser.CurrentRoom.getNorth();
                    break;
                case "south":
                    RoomName = StoryParser.CurrentRoom.getSouth();             
                    break;
            }
         }

      
      if(Getroomcoun==true||nowhere==true){
      for(Room room : StoryParser.Zorkrooms){
        if(room.getName().equals(RoomName)){
             for(int i =0 ; i< Zorkrooms.size();i++){
                 if(room.getName().equals(Zorkrooms.get(i).getName())){
                     roomcount=i;
                                 Players.moves++;
                 }
             }
          StoryParser.CurrentRoom = room;

          break;
            }
        }

      Display.Display(RoomName);
      }
      
    }
}


