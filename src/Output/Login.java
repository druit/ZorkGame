package Output;



import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;
import zork.Players;


public class Login {
        
        public static boolean existUsername(String word) throws FileNotFoundException {
           boolean count = false;
           Scanner scanner = new Scanner(new File("players.txt"));
           while (scanner.hasNextLine()) {
           String nextToken = scanner.next();
            if (nextToken.contains(word)){
             count = true;
             break;
            }
           }
          return count;
        }
        
        public static int Welcome(int size) throws FileNotFoundException, IOException{
            Scanner pass_scanner = new Scanner(System.in);
            String spass = " ";
            System.out.print("###########################################################################################################"
                + "\nWelcome in our game.You can type help or story to learn more about zork story and game commands after login."
                    + "\n" 
                       + "If you want to continue type your Username(if you haven't player type register): ");
            Scanner key = new Scanner(System.in);
            String sname = key.nextLine();
            
            int lines = 0;
            if(sname.equals("register")){
                try{ 
                    try (BufferedReader readerlines = new BufferedReader(new FileReader("players.txt"))) {
                        while (readerlines.readLine() != null) lines++;
                    } 
                   FileWriter fStream = new FileWriter("players.txt", true);
                   System.out.println("Give me a username:");
                   Scanner usernameScanner = new Scanner(System.in);
                   String username = usernameScanner.nextLine();
                   while(existUsername(username)){
                       System.out.println("Username already taken.Give me a username:");
                       username = usernameScanner.nextLine();
                   }
                   System.out.println("Give me a password:");
                   Scanner passwordScanner = new Scanner(System.in);
                   String password = passwordScanner.nextLine();
                   lines = lines + 1;
                   fStream.append("\n" + lines + "," + username + "," + password + "," + "100,0,0");
                   fStream.close();     
                   sname = username;
                   spass = password;
                   } catch (IOException e) {
                     System.out.println("I can't open txt file"); 
                   } 
            }
            
            FileReader file = new FileReader("players.txt");
            BufferedReader reader = new BufferedReader(file);
            String line = reader.readLine();
            List<Integer> id = new ArrayList<>();
            ArrayList<String> unames = new ArrayList<String>() {};
            ArrayList<String> pass = new ArrayList<String>() {};
            List<Integer> hp = new ArrayList<Integer>();
            List<Integer> score = new ArrayList<Integer>();
            List<Integer> moves = new ArrayList<Integer>();
            
            boolean true_name = false;
            boolean login_success=false;
            int login_line = 0;
            
             while(line != null)
            {
                StringTokenizer tokenizer = new StringTokenizer(line,",");
                
                id.add(Integer.parseInt(tokenizer.nextToken()));
                unames.add(tokenizer.nextToken());
                pass.add(tokenizer.nextToken());
                hp.add(Integer.parseInt(tokenizer.nextToken()));
                score.add(Integer.parseInt(tokenizer.nextToken()));
                moves.add(Integer.parseInt(tokenizer.nextToken()));
                
                line = reader.readLine();
            } 
            
            do{
                if(unames.contains(sname)){
                    for (int i=0;i<unames.size();i++) {
                        if (unames.get(i).equals(sname)) {
                            login_line = i;
                            true_name = true;
                            break;
                        }
                    }
                }else{
                    System.out.println("Invalid Username\n");
                    System.out.println("Give username:");
                    sname = key.nextLine();
                }
                    
            }while(true_name == false);
            if(spass.equals(" ")){
            System.out.print("what is your password: \t");
            spass = pass_scanner.nextLine();
            }
            do{
                if(unames.get(login_line).equals(sname) && pass.get(login_line).equals(spass)){
                   login_success = true;
                   System.out.println("Login Complete\n\n");
                }else if (unames.get(login_line) != sname || pass.get(login_line) != spass) {
                    System.out.print("\nIvalid Password!!!\nWhat is your password: ");
                    spass = pass_scanner.nextLine();
                }
             }while(login_success == false);

            Players player = new Players(id.get(login_line),unames.get(login_line),pass.get(login_line),hp.get(login_line),score.get(login_line),moves.get(login_line));
            
            String game="1";
            do{
                if(new File(Players.getUsername()+"_save.txt").exists()){
                    System.out.print("has save\n");
                    System.out.println("Want to resume the game or start new game?\nPress 1 to start new game or 2 to load the saved game" );
                    Scanner sgame = new Scanner(System.in);
                    game = sgame.nextLine();
                    System.out.println();
                }
            }while(!(game.equals("1") || game.equals("2")));
            int temp = Integer.parseInt(game);
            
            return(temp);
      }
        
      public static void ProfileUser(int id,String username,String password,int hp,int score,int moves){
                 System.out.println("The name of player [" + id + "] is: " +
                username +
                "\n With score: " + score +
                "\n HP : " +hp + "\n Moves: " +
                moves);
      }
}