package zork;


class AnswerCommand implements Command {


    @Override
    public void exec() {
         for(Items item:StoryParser.ZorkItems){
          if(item.getItemName().contains(InputParser.SecondWord)){
              if(item.getRoomUseItem().equals(StoryParser.CurrentRoom.getName())){
                  Players.itemHadgiven = true;
                  Players.moves++;
                  Players.score+=Players.score;
                  break;
              }
          }
      }  
    }
    
}
