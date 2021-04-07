import java.util.*;
public class Main{
    static ArrayList<Integer> playerposs =  new ArrayList<Integer>();
    static ArrayList<Integer> cpuposs =  new ArrayList<Integer>();
    public static void main(String args[]){

        char [] [] gameBoard = {{' ','|',' ','|',' '},
                                {'-','+','-','+','-'},
                                {' ','|',' ','|',' '},
                                {'-','+','-','+','-'},
                                {' ','|',' ','|',' '}};
   
        
        Scanner sc = new Scanner(System.in);
        Random rand = new Random();
        while(true){
            System.out.println("Enter placement");
            int pos = sc.nextInt();
            while(playerposs.contains(pos) || cpuposs.contains(pos)){
                System.out.println("Position taken FFFFFFFFFFFFFFFFFFFFFF");
                pos = sc.nextInt();
            }
            Place(gameBoard, pos, "player");

            int poscomp = rand.nextInt(9)+1;
            while(playerposs.contains(poscomp) || cpuposs.contains(poscomp)){
                poscomp = rand.nextInt(9)+1;
            }

            Place(gameBoard, poscomp, "cpu");
        
            printgame(gameBoard);
            String result = winner();
            System.out.println(result);
        }
        
    }
    public static void printgame(char [] [] gamebo){
        for(char [] row : gamebo){
            for(char c : row){
                System.out.print(c);
            }
            System.out.println();
        }
    }
    public static void Place(char [][] gameBoard, int pos, String user){

        char symbol;
        if(user.equals("player")){
            symbol = 'X';
            playerposs.add(pos);
        }
        else{
            symbol = 'O';
            cpuposs.add(pos);
        }

        switch(pos){
            case 1:
                gameBoard[0] [0] = symbol;
                break;
                case 2:
                gameBoard[0] [2] = symbol;
                break;
                case 3:
                gameBoard[0] [4] = symbol;
                break;
                case 4:
                gameBoard[2] [0] = symbol;
                break;
                case 5:
                gameBoard[2] [2] = symbol;
                break;
                case 6:
                gameBoard[2] [4] = symbol;
                break;
                case 7:
                gameBoard[4] [0] = symbol;
                break;
                case 8:
                gameBoard[4] [2] = symbol;
                break;
                case 9:
                gameBoard[4] [4] = symbol;
                break;
                default:
                break;

        }
    }
    public static String winner(){
        List toprow = Arrays.asList(1,2,3);
        List midrow = Arrays.asList(4,5,6);
        List botrow = Arrays.asList(7,8,9);
        List leftcol = Arrays.asList(1,4,7);
        List midcol = Arrays.asList(2,5,8);
        List rightcol = Arrays.asList(3,6,9);
        List cross1= Arrays.asList(1,5,9);
        List cross2 = Arrays.asList(7,5,3);

        List<List> win = new ArrayList<List>();
        win.add(toprow);
        win.add(midrow);
        win.add(botrow);
        win.add(leftcol);
        win.add(midcol);
        win.add(rightcol);
        win.add(cross1);
        win.add(cross2);

        for(List l : win){
            if(playerposs.containsAll(l)){
                return "You won!";
            }
            else if(cpuposs.containsAll(l)){
                return "Computer wins";
            }
            else if(playerposs.size() + cpuposs.size() == 9){
                return "TIE";
            }
        }
        return "";
    }
}
