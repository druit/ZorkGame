package zork;

import Output.Display;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;


public class LoadCommand implements Command {

    @Override
    public void exec() {
        File f = new File(Players.username+"_save.txt");
        try {
            FileInputStream in = new FileInputStream(f);
            ObjectInputStream ob = new ObjectInputStream(in);
            Players.id = (int) ob.readObject();
            Players.score = (int) ob.readObject();
            Players.hp = (int) ob.readObject();
            Players.moves = (int) ob.readObject();
            Players.Items = (ArrayList<String>) ob.readObject();
            StoryParser.CurrentRoom = (Room) ob.readObject();
            StoryParser.roomcount = (int) ob.readObject();
            StoryParser.ZorkItems = (ArrayList<Items>) ob.readObject();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(SaveCommand.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(SaveCommand.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(LoadCommand.class.getName()).log(Level.SEVERE, null, ex);
        }
        Display.FirstDisplay(StoryParser.CurrentRoom.getName());
    }
      
}
