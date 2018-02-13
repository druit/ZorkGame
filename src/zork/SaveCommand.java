package zork;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;


public class SaveCommand implements Command{

    @Override
    public void exec() {
        File f = new File(Players.username+"_save.txt");
        try {
            FileOutputStream out = new FileOutputStream(f);
            ObjectOutputStream ob = new ObjectOutputStream(out);
            ob.writeObject(Players.id);
            ob.writeObject(Players.score);
            ob.writeObject(Players.hp);
            ob.writeObject(Players.moves);
            ob.writeObject(Players.Items);
            ob.writeObject(StoryParser.CurrentRoom);
            ob.writeObject(StoryParser.roomcount);
            ob.writeObject(StoryParser.ZorkItems);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(SaveCommand.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(SaveCommand.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
