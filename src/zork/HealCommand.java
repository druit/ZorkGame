package zork;


public class HealCommand implements Command {

    @Override
    public void exec() {
        int LIFE=100;
        if (StoryParser.YouCanHeal==true){
            int HP= Players.hp+10;
            if(HP<=LIFE){
                Players.hp+=10;
                Players.score+=6;
                StoryParser.YouCanHeal=false;     
            }
            else 
                System.out.println("Your Hp is too high,Use it later");
        }else
        {
            System.out.println("You can't heal yourself, need food");
        }
        
        Players.moves++;

        System.out.print("> ");
    }
    
}
