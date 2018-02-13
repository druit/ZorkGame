package Output;


import static zork.StoryParser.Zorkrooms;
import static zork.StoryParser.roomDeclaration;


public class Display {
    public static void Display(String TheRoom){
        boolean ThereIsRoom=false;
       
        if(TheRoom.equals("nothing")){
            ThereIsRoom=true;
        }
        if (ThereIsRoom==false ){
            System.out.println("You are to the " + TheRoom);   
       } else {
            
            System.out.println("You can't go that way.");
 
        }
        
        System.out.print("> ");
    }
    public static void FirstDisplay(String name){
        System.out.println("You are to the " + name);
        System.out.print("> ");
    }

}
