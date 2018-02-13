package zork;


import java.io.BufferedReader;
import  java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;


public class StoryParser {

    public static List<Room> Zorkrooms = new ArrayList<>();
    public static List<Items> ZorkItems = new ArrayList<>();
    public static List<NPC> ZorkNPCs = new ArrayList<>();
    public static String roomDeclaration="";
    public static Room CurrentRoom = new Room();
    public static int roomcount;
    public static String Killer;
     public static String Guider;
    public static boolean YouCanHeal;
    
    public StoryParser() throws Exception{
      FileReader file = new FileReader("story.txt");
      BufferedReader reader = new BufferedReader(file);
      String line = reader.readLine();
      
      FileReader killer = new FileReader("killer.txt");
      BufferedReader reader_killer = new BufferedReader(killer);
      String killer_line = reader_killer.readLine();
      StringTokenizer tokenizerofKiller = new StringTokenizer(killer_line,"/");
      
      FileReader guider = new FileReader("guider.txt");
      BufferedReader reader_guider = new BufferedReader(guider);
      String guider_line = reader_guider.readLine();
      StringTokenizer tokenizerofGuider = new StringTokenizer(guider_line,"/");
      
      Guider = tokenizerofGuider.nextToken();
      Killer = tokenizerofKiller.nextToken();
      while(line != null)
      {
          Room ZorkRoom = new Room();
          Items ZorkItem = new Items();
          NPC ZorkNPC = new NPC();
          
          StringTokenizer tokenizer = new StringTokenizer(line,",");
          
          ZorkRoom.setName(tokenizer.nextToken());
          ZorkRoom.setEast(tokenizer.nextToken());  
          ZorkRoom.setWest(tokenizer.nextToken());
          ZorkRoom.setNorth(tokenizer.nextToken());
          ZorkRoom.setSouth(tokenizer.nextToken());
          ZorkItem.setRoomHasItem(ZorkRoom.getName());
          ZorkItem.setItemName(tokenizer.nextToken());
          ZorkItem.setRoomUseItem(tokenizer.nextToken());
          ZorkItem.setItemForAction(tokenizer.nextToken()); //1
          ZorkItem.setRoomUseActionItem(tokenizer.nextToken());//2
          ZorkItem.setVerb(tokenizer.nextToken());//3
          ZorkItem.setNoun(tokenizer.nextToken());//4
          ZorkItem.setAfterAction(tokenizer.nextToken());//5
          ZorkItem.setBeforeAction(tokenizer.nextToken());//6
          ZorkItem.setTrueorFalse(tokenizer.nextToken());//7
          ZorkNPC.setNameNPC(tokenizer.nextToken());
          ZorkNPC.setGuiderDescription(tokenizer.nextToken());
          
          Zorkrooms.add(ZorkRoom);
          ZorkItems.add(ZorkItem);
          ZorkNPCs.add(ZorkNPC);
          
          
          line = reader.readLine();
      }
      
            //roomDeclaration = Zorkrooms.get(0).getName();
            CurrentRoom=Zorkrooms.get(0);
    }
}
