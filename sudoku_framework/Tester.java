import java.util.Random;

public class Tester{

    public static void main(String [] args){

        String [] inputBoard = new String[11];



        inputBoard[0] = "600008002812700003075026040400130020000084000007502400008053079090060200030200814";
        inputBoard[1] = "350069070000070203710082090500097000670000089000650004020830056805010000060720041";
        inputBoard[2] = "310408907000050000460000200100006053500281009670300001004000038000010000201509046";
        inputBoard[3] = "500000783008300062400030079040001090700070900080750002048005000956000340071800009";
        inputBoard[4] = "740109826050004001000027000000780009810405073200016000000240000100500040425903087";
        inputBoard[5] = "010020300004005060070000008006900070000100002030048000500006040000800106008000000";
        inputBoard[6] = "010020300003004050060000007005800060000100002080072000400005090000700104007000000";
        inputBoard[7] = "070050800005008020010000009008100050000200001090034000900002030000600107006000000";
        inputBoard[8] = "010020300004001050060000007005200060000800009020019000300005010000700805007000000";
        inputBoard[9] = "010020300004003050060000001005700060000800002070012000400005090000400805007000000";
      //  inputBoard[10] = "200000008007604900068020730070203040009000200040705010085060390003109600600000002";
        int i = 0;
        Random rand = new Random();
        i=rand.nextInt(11);
        Board board = new Board(inputBoard[i]);

        Player player = new Player(board);
        int row, col, val;
       
        System.out.println(board.toString());

        boolean autoPilot = false;

        while(!board.finished()){
            if(autoPilot) {
                player.computeMove();
            } else {
                autoPilot = player.getMoveFromUser();
            }
            row = player.getRowMove();
            col = player.getColMove();
            val = player.getValMove();
            board.setTileAt(row,col,val);
            System.out.println(board.toString());
        }
        
        System.out.println(board.toString());

    }
}
