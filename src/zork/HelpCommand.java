package zork;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class HelpCommand implements Command{

    @Override
    public void exec() {
      String everything = "";  
      BufferedReader br = null;
       try {
            br = new BufferedReader(new FileReader("help.txt"));
            try {
                StringBuilder sb = new StringBuilder();
                String line = br.readLine();
                while (line != null) {
                    sb.append(line);
                    sb.append(System.lineSeparator());
                    line = br.readLine();
                }
                everything = sb.toString();
            } catch (IOException ex) {
              Logger.getLogger(StoryCommand.class.getName()).log(Level.SEVERE, null, ex);
          } finally {
                try {
                    br.close();
                } catch (IOException ex) {
                    Logger.getLogger(StoryCommand.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
       } catch (FileNotFoundException ex) {
            Logger.getLogger(StoryCommand.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                br.close();
            } catch (IOException ex) {
                Logger.getLogger(StoryCommand.class.getName()).log(Level.SEVERE, null, ex);
            }
       }  
        System.out.println(everything);
    }

}
