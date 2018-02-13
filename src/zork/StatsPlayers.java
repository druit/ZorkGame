package zork;


class StatsPlayers implements Command {

    public StatsPlayers() {
    }

    @Override
    public void exec() {
    
        switch (InputParser.FirstWord) {
            case "whoami":
                System.out.println("Your name is: " + Players.username);
                break;
            case "score":
                System.out.println("Your score is: " + Players.score);
                break;
            case "stats":
                System.out.println("Your name is: " + Players.username);
                System.out.println("Your score is: " + Players.score);
                System.out.println("Your moves is: " + Players.moves);
                System.out.println("Your HP is: " + Players.hp);
                break;
            case "moves":
                System.out.println("Your moves is: " + Players.moves);
                break;
            case "life":
            case "hp":
                System.out.println("Your HP is: " + Players.hp);
                break;
        }
        
        System.out.print("> ");
    }
    
}
