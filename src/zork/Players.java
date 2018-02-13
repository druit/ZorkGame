package zork;

import java.io.Serializable;
import java.util.ArrayList;

public class Players implements Serializable{
   static boolean youcanuse=false;
   static int id;
   static String username;
   static int score;
   static int hp;
   static int moves;
   static String password;
   static ArrayList<String> Items = new ArrayList<>();
    static boolean itemHadgiven = false;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        Players.id = id;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        Players.hp = hp;
    }

    public static ArrayList<String> getItems() {
        return Items;
    }

    public static void setItems(ArrayList<String> Items) {
        Players.Items = Items;
    }
    
    public Players(int id,String username,String password,int hp,int score,int moves){
       Players.id=id;
       Players.hp=hp;
       Players.score=score;
       Players.password=password;
       Players.username=username;
       Players.moves=moves;
       
    }
    public Players(String username,String password,int hp,int score,int moves){
       Players.id=id;
       Players.hp=hp;
       Players.score=score;
       Players.password=password;
       Players.username=username;
       Players.moves=moves;
    }
    
    public Players(){
       
    }
    public  int getid(){
        return Players.id;
    }
    public String getPassword(){
        return Players.password;
    }
    public void setPassword(String password){
        Players.password=password;
    }
    
    public static String getUsername(){
        return Players.username;
    }
    public void setUsername(String username){
        Players.username=username;
    }
    public int getScore(){
        return Players.score;
    }
    public void setScore(int score){
        Players.score=score;
    }
    public int getMoves(){
        return Players.moves;
    }
    public void setMoves(int moves){
        Players.moves=moves;
    }
    
}
