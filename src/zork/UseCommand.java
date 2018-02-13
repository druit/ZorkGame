package zork;

import static zork.InputParser.FirstWord;
import static zork.InputParser.SecondWord;
import static zork.Players.Items;
import static zork.StoryParser.CurrentRoom;
import static zork.StoryParser.ZorkItems;
import static zork.StoryParser.Zorkrooms;
import static zork.StoryParser.roomcount;


public class UseCommand implements Command{

    @Override
    public void exec() {
        int ItemPlace=0;
        boolean AreWhereWeWantToGo=false;
        boolean errorcheck=false;
       boolean youcanuse=false;
       int VerbWay=0;
       for (int i=0;i<ZorkItems.size();i++){
           if(ZorkItems.get(i).getVerb().equals(FirstWord)&&ZorkItems.get(i).getNoun().equals(SecondWord)&&ZorkItems.get(i).getRoomUseActionItem().equals(Zorkrooms.get(roomcount).getEast())){
               VerbWay=i;
               break;
           }
           else if(ZorkItems.get(i).getVerb().equals(FirstWord)&&ZorkItems.get(i).getNoun().equals(SecondWord)&&ZorkItems.get(i).getRoomUseActionItem().equals(Zorkrooms.get(roomcount).getWest())){
               VerbWay=i;
               break;
           }
           else if(ZorkItems.get(i).getVerb().equals(FirstWord)&&ZorkItems.get(i).getNoun().equals(SecondWord)&&ZorkItems.get(i).getRoomUseActionItem().equals(Zorkrooms.get(roomcount).getNorth())){
               VerbWay=i;
               break;
           }
           else if(ZorkItems.get(i).getVerb().equals(FirstWord)&&ZorkItems.get(i).getNoun().equals(SecondWord)&&ZorkItems.get(i).getRoomUseActionItem().equals(Zorkrooms.get(roomcount).getSouth())){
               VerbWay=i;
               break;
           }
           else if(ZorkItems.get(i).getVerb().equals(FirstWord)&&ZorkItems.get(i).getNoun().equals(SecondWord)&&ZorkItems.get(i).getTrueorFalse().equals("true"))
           {
               VerbWay=i;
               break;
           }
           else 
               youcanuse=false;
           
               
               
       }
      

       for(int i=0;i<Items.size();i++){
            if(ZorkItems.get(VerbWay).getItemForAction().contains(Items.get(i))) {
                youcanuse=true;
                ItemPlace=i;
                break;
                }
       }
       
      
       if(youcanuse==true){

           if(!ZorkItems.get(VerbWay).getVerb().equals("nu")&&!ZorkItems.get(VerbWay).getItemForAction().equals("used")){
               if(Zorkrooms.get(roomcount).getNorth().equals(ZorkItems.get(VerbWay).getRoomUseActionItem())&&FirstWord.equals(ZorkItems.get(VerbWay).getVerb()))
                   AreWhereWeWantToGo=true;
               else if(Zorkrooms.get(roomcount).getWest().equals(ZorkItems.get(VerbWay).getRoomUseActionItem())&&FirstWord.equals(ZorkItems.get(VerbWay).getVerb()))
                       AreWhereWeWantToGo=true;
               else if(Zorkrooms.get(roomcount).getSouth().equals(ZorkItems.get(VerbWay).getRoomUseActionItem())&&FirstWord.equals(ZorkItems.get(VerbWay).getVerb()))
                            AreWhereWeWantToGo=true;
               else if(Zorkrooms.get(roomcount).getEast().equals(ZorkItems.get(VerbWay).getRoomUseActionItem())&&FirstWord.equals(ZorkItems.get(VerbWay).getVerb()))
                    AreWhereWeWantToGo=true;
               else if(ZorkItems.get(VerbWay).getRoomUseActionItem().equals("nowhere")||ZorkItems.get(VerbWay).getTrueorFalse().equals("true")){
                   AreWhereWeWantToGo=true;
                   if(ZorkItems.get(VerbWay).getVerb().equals("eat")||ZorkItems.get(VerbWay).getVerb().equals("drink"))
                       StoryParser.YouCanHeal=true;
       
                       }
               else {
                   if(!ZorkItems.get(VerbWay).getVerb().equals(FirstWord)){
                       errorcheck=true;
                   }
                   AreWhereWeWantToGo=false;
               }
               

               
               if(AreWhereWeWantToGo==true){
                            ZorkItems.get(VerbWay).setTrueorFalse("true");
                            Players.moves++;
                            Players.score+=4;
                            Players.Items.remove(ItemPlace);
                            ZorkItems.get(VerbWay).setItemForAction("used");
                            ZorkItems.get(VerbWay).setVerb("used");
                            ZorkItems.get(VerbWay).setNoun("used");
                            
                System.out.println(ZorkItems.get(VerbWay).getAfterAction());
               }else{
                   if(errorcheck==true){
                                       System.out.println("You already use/fix it");
                   }
                   else{
                   System.out.println("You must go to the correct room for using this item.");             
                   }
               }
           }
        }else{
           if(ZorkItems.get(VerbWay).getItemForAction().equals("used"))
               System.out.println("You already use/fix it");
           else
           System.out.println("You can't use this command, you need something");
            
           
           Players.moves++;
           Players.score+=-1;
       }        
        System.out.print("> ");
   }
}