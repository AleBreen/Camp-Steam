import java.lang.Math;
import java.util.Scanner;

public class Player{

    Board board;
    int rowMove;
    int colMove;
    int valMove;

    public Player(Board board){
        this.board = board;
    }

    public int getRowMove(){
        return this.rowMove;
    }

    public int getColMove(){
        return this.colMove;
    }

    public int getValMove(){
        return this.valMove;
    }

    private void checkRow(int row,int col){
        int i=0;
        int valueR;
        while(i<9){
            valueR=board.getTileAt(row,i).getValue();
            board.getTileAt(row,col).crossOut(valueR);
            i=i+1;
        }
    }

    private void checkCol(int row,int col){
        int j=0;
        int valueC;
        while(j<9){
                 valueC=board.getTileAt(j,col).getValue();
                 board.getTileAt(row,col).crossOut(valueC);
                 j=j+1;
                         }
          
        
        
    }

    private void checkBox(int row,int col){
        int i=0;
        int j=0;
        if(row<3 && col<3){
        j=0;
        i=0;
            while(i<3){
                while(j<3){
                board.getTileAt(row,col).crossOut(board.getTileAt(i,j).getValue());    
                j=j+1;
                
                }
            i=i+1;
            j=0;
            }    
        }
        if(col<6 && col>2 && row<3){
            j=0;
            i=0;
                while(i<3){
                    while(j<3){
                      board.getTileAt(row,col).crossOut(board.getTileAt(i,j+3).getValue());    
               
                      j=j+1;
                         
                   }
                   i=i+1;
                   j=0;
        }
        }
        if(col<9 && col>5 && row<3){
             j=0;
            i=0;
                while(i<3){
                    while(j<3){
                      board.getTileAt(row,col).crossOut(board.getTileAt(i,j+6).getValue());    
                      j=j+1;
                         
                   }
                   i=i+1;
                   j=0;
        }
        
        }
        if(row<6 && row>2 && col<3){
              j=0;
            i=0;
                while(i<3){
                    while(j<3){
                      board.getTileAt(row,col).crossOut(board.getTileAt(i+3,j).getValue());    
 
                        j=j+1;
                         
                   }
                   i=i+1;
                   j=0;
        }
       
        }
        if(row<9 && row>5 && col<3){
               j=0;
            i=0;
                while(i<3){
                    while(j<3){
                       board.getTileAt(row,col).crossOut(board.getTileAt(i+6,j).getValue());    
 
                         j=j+1;
                         
                   }
                   i=i+1;
                   j=0;
        }
      
        }
        if(row<6 && row>2 && col<6 && col>2){
               j=0;
            i=0;
                while(i<3){
                    while(j<3){
                      board.getTileAt(row,col).crossOut(board.getTileAt(i+3,j+3).getValue());    
 
                         j=j+1;
                         
                   }
                   i=i+1;
                   j=0;
        }
      
        }
        if(row<9 && row>5 && col<6 && col>2){
               j=0;
            i=0;
                while(i<3){
                    while(j<3){
                      board.getTileAt(row,col).crossOut(board.getTileAt(i+6,j+3).getValue());    
 
                         j=j+1;
                         
                   }
                   i=i+1;
                   j=0;
        }
      
        }
        if(row<9 && row>5 && col<9 && col>5){
               j=0;
            i=0;
                while(i<3){
                    while(j<3){
                      board.getTileAt(row,col).crossOut(board.getTileAt(i+6,j+6).getValue());    
 
                         j=j+1;
                         
                   }
                   i=i+1;
                   j=0;
        }
      
        }
        if(col<9 && col>5 && row<6 && row>2){
               j=0;
            i=0;
                while(i<3){
                    while(j<3){
                      board.getTileAt(row,col).crossOut(board.getTileAt(i+3,j+6).getValue());    
 
                         j=j+1;
                         
                   }
                   i=i+1;
                   j=0;
        }
      
        }
    }

    public void computeMove(){
            int j=0;
            int i=0;
            int c=0;
                while(c<9){
                   int r=0;
                    while(r<9){    
                        Tile t = board.getTileAt(r,c);
                      checkRow(r,c);
                      checkCol(r,c);
                      checkBox(r,c);
                      int[]moves=t.getAvailableMoves();

                   int numAvailable=t.getAvailableMoves().length;
                       if(numAvailable==1){
                       rowMove=r;
                       colMove=c;
                       valMove=moves[0];
                       }
         
                         r=r+1;
                       }
                         
                   c=c+1;
                   }
                   
    }

    public boolean getMoveFromUser(){
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        if(input.equals("x")){
            return true;
        }
        else{
            rowMove= Integer.parseInt(input);
            colMove= scan.nextInt();
            valMove= scan.nextInt();
            return false;
        }
    }
}
