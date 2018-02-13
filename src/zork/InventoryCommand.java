package zork;


public class InventoryCommand implements Command {

    @Override
    public void exec() {
        if(!Players.Items.isEmpty()){
         System.out.print("Your inventory : " );
            for (String Item : Players.Items) {
            System.out.print("["+Item+"]"+" ");
             }
        }
        else
            System.out.println("Your inventory is empty");
        
        
        System.out.print("\n> ");
    }
    

}
