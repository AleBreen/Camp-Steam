public class Tester{

    public static void main(String [] args){

        String inputBoard = "600008002812700003075026040400130020000084000007502400008053079090060200030200814";
        Board board = new Board(inputBoard);

        Player player = new Player(board);
        int row, col, val;
       
        System.out.println(board.toString());

        while(!board.finished()){
            player.computeMove();
            row = player.getRowMove();
            col = player.getColMove();
            val = player.getValMove();
            board.setTileAt(row,col,val);
        }
        
        System.out.println(board.toString());

    }
}
