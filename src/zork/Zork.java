package zork;


import Output.Display;
import Output.Login;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
import zork.StoryParser;
import static zork.StoryParser.ZorkItems;
import static zork.StoryParser.Zorkrooms;
import static zork.InputParser.FirstWord;
import static zork.InputParser.SecondWord;
import static zork.StoryParser.Zorkrooms;
import static zork.StoryParser.roomDeclaration;

public class Zork {

    public static void main(String[] args) throws Exception {
      
      int i = Login.Welcome(1);
      
        StoryParser s = new StoryParser();
        
        HashMap<String, Command> map = new HashMap<>();
        
        Command go = new GoCommand();
        Command look = new LookCommand();
        Command gossip = new TalkCommand();
        Command take = new TakeCommand();
        Command inventory = new InventoryCommand();
        Command stats = new StatsPlayers();
        Command use = new UseCommand();
        Command answer = new AnswerCommand();
        Command pick = new PickCommand();
        Command save = new SaveCommand();
        Command load = new LoadCommand();
        Command whatneed = new WhatNeedCommand();
        Command heal = new HealCommand();
        Command help = new HelpCommand();
        Command story = new StoryCommand();
       
        
       
        map.put("go south", go);
        map.put("go west", go);
        map.put("go north", go);
        map.put("go east", go);
        map.put("look", look);
        map.put("talk", gossip);
        map.put("inventory", inventory);
        map.put("whoami",stats);
        map.put("moves", stats);
        map.put("hp",stats);
        map.put("score",stats);
        map.put("life",stats);
        map.put("save",save);
        map.put("load", load);
        map.put("stats",stats);
        map.put("what need",whatneed);
        map.put("heal",heal);
        map.put("help", help);
        map.put("story", story);
      
        
        
        for (Items temp : ZorkItems) {
            String temp2 = temp.getItemName();
            map.put("use "+temp2, answer);
        }
        
        for (Items ZorkItem : ZorkItems) {
            String Verb = ZorkItem.getVerb();
            String Noun = ZorkItem.getNoun();
            map.put(Verb+" "+Noun,use);
          
        }
        for (Items temp : ZorkItems) {
            String temp2 = temp.getItemName();
            map.put("take "+temp2, take);
        }
                for (Items temp : ZorkItems) {
            String temp2 = temp.getItemForAction();
            map.put("pick "+temp2, pick);
            
        }
        
        if(i==2){
            load.exec();
        }else{
            Display.FirstDisplay(StoryParser.CurrentRoom.getName());
        }        
                
        Scanner scanner = new Scanner(System.in);
        String Text = scanner.nextLine();
        InputParser inputParser = new InputParser();
        inputParser.SplitInput(Text);
        

        TimerClass timer = new TimerClass();
        timer.start();
        
        while (!Text.equals("quit")) {
            if (map.containsKey(Text)) {
                map.get(Text).exec(); 
            }
            else{
                System.out.println("Error");
                System.out.print("> ");
            }

            Text = scanner.nextLine();
            inputParser.SplitInput(Text);
        }
        System.out.println("Thank you for playing");
        System.exit(0);
    }
}
