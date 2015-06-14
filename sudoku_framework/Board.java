public class Board{

    private final static int [] BOUNDARIES = {2,5,8};

    private final static String COLOR_FILLED = "\u001B[100m";
    private final static String COLOR_PERMANENT = "\u001B[40m";
    private final static String COLOR_EMPTY = "\u001B[107m";
    private final static String COLOR_RESET = "\u001B[0m";

    private Tile [][] board;
    public final static int NUM_ROWS = 9;
    public final static int NUM_COLS = 9;

    public Board(String inputBoard){

        board = new Tile[NUM_ROWS][NUM_COLS];
        int counter = 0;
        int val;
        State state;

        for (int i = 0; i < this.NUM_ROWS; ++i){
            for (int j = 0; j < this.NUM_COLS; ++j){
                val = Integer.parseInt(inputBoard.substring(counter, counter+1));
                if (val == 0){
                    state = State.EMPTY;
                }
                else{  
                    state = State.PERMANENT;
                }
                board[i][j] = new Tile(val, state);
                ++counter;
            }
        }
    }

    private String formatSpaces(int length){
        StringBuffer outputBuffer = new StringBuffer(length);
        for(int i = 0; i< length; ++i){
            outputBuffer.append(" ");        
        } 
        return outputBuffer.toString();
    }

    public String toString(){
        String output = "";
        String stateSeq;
        State state;
        final int box_len = 7;
        final int between_len = 4;
        final String fullBoxSpaces = formatSpaces(box_len);
        final String halfBoxSpaces = formatSpaces(box_len/2);
        final String betweenBoxSpaces = formatSpaces(between_len);

        for(int i = 0; i < this.NUM_ROWS; ++i){
            stateSeq = "";

            for(int j = 0; j < NUM_COLS; ++j){
                state = board[i][j].getState();
                switch(state){
                    case EMPTY:     
                        stateSeq += COLOR_EMPTY + fullBoxSpaces + COLOR_RESET;
                        break;
                    case PERMANENT: 
                        stateSeq += COLOR_PERMANENT + fullBoxSpaces + COLOR_RESET;
                        break;
                    case FILLED:    
                        stateSeq += COLOR_FILLED + fullBoxSpaces + COLOR_RESET;
                }

                for(int k : BOUNDARIES){
                    if (j == k){ 
                        stateSeq += betweenBoxSpaces;
                    }
                }
                stateSeq += formatSpaces(2);
            }

            output += stateSeq;
            output += "\n";
            
            for(int j = 0; j < this.NUM_COLS; ++j){
                state = board[i][j].getState();
                switch(state){
                    case EMPTY:     
                        output += COLOR_EMPTY +  fullBoxSpaces + COLOR_RESET;
                        break;
                    case PERMANENT: 
                        output += COLOR_PERMANENT + halfBoxSpaces + board[i][j].getValue() + halfBoxSpaces + COLOR_RESET;
                        break;
                    case FILLED:    
                        output += COLOR_FILLED + halfBoxSpaces + board[i][j].getValue() + halfBoxSpaces +  COLOR_RESET;
                }

                output += formatSpaces(2);

                for(int k : BOUNDARIES){
                    if (j == k){ 
                        output += betweenBoxSpaces;
                    }
                }

            }
            
            output += "\n";
            output += stateSeq;
            output += "\n\n";

            for(int k : BOUNDARIES){
                if (i == k){ 
                    output += "\n";
                }
            }
        } 
        return output;
    }

    public void setTileAt(int row, int col, int value){
       if(board[row][col].getState() == State.PERMANENT){
            System.out.println("Cannot set permanent tile");
       } 
       else{
           board[row][col].setValue(value);
           board[row][col].setState(State.FILLED);
       }
    }

    public Tile getTileAt(int row, int col){
        return this.board[row][col];
    }

    public void crossOutAt(int row, int col, int val){
        this.board[row][col].crossOut(val);
    }

    protected int getBoxFromRowCol(int row, int col){
        if(row < this.NUM_ROWS/3 && col < this.NUM_COLS/3){
            return 1;
        }
        else if(row < this.NUM_ROWS/3 && col < 2*this.NUM_COLS/3){
            return 2;
        }
        else if(row < this.NUM_ROWS/3){
            return 3;
        }   
        else if(row < 2*this.NUM_ROWS/3 && col < this.NUM_COLS/3){
            return 4;
        }
        else if(row < 2*this.NUM_ROWS/3 && col < 2*this.NUM_COLS/3){
            return 5;
        }
        else if(row < 2*this.NUM_ROWS/3){
            return 6;
        }
        else if(col < this.NUM_COLS/3){
            return 7;
        }
        else if(col < 2*this.NUM_COLS/3){
            return 8;
        }
        else{
            return 9;
        }
    }

    private boolean allTilesFilled(){
        for(int i = 0; i < this.NUM_ROWS; ++i){
            for(int j = 0; j < this.NUM_COLS; ++j){
                if(this.board[i][j].getValue() == 0){
                    return false;
                }
            }
        }
        return true;
    }

    private boolean checkRowCorrect(int row){
        Tile testTile = new Tile();
        testTile.crossOut(0);
        for(int j = 0; j < this.NUM_COLS; ++j){
              testTile.crossOut(board[row][j].getValue()); 
        }

        if (testTile.getAvailableMoves().length == 0){
            return true;
        }
        return false;
    }

    private boolean checkColCorrect(int col){
        Tile testTile = new Tile();
        testTile.crossOut(0);
        for(int i = 0; i < this.NUM_ROWS; ++i){
              testTile.crossOut(board[i][col].getValue()); 
        }

        if (testTile.getAvailableMoves().length == 0){
            return true;
        }

        return false;
    }

    private boolean checkBoxCorrect(int box){
        Tile testTile = new Tile();
        testTile.crossOut(0);
        for(int i = 0; i < this.NUM_ROWS; ++i){ //this.NUM_ROWS; ++i){
            for(int j = 0; j < this.NUM_COLS; ++j){
                if (getBoxFromRowCol(i,j) != box){
                    continue;
                } 
                testTile.crossOut(this.board[i][j].getValue());
            } 
        }

        if (testTile.getAvailableMoves().length == 0){
            return true;
        }
        return false;
    }

    public boolean finished(){
        if(!allTilesFilled()){
            return false;
        }

        for(int i = 0; i < this.NUM_ROWS; ++i){
            if (!checkRowCorrect(i)){
                return false;
            }

            if (!checkColCorrect(i)){
                return false;
            }

            if (!checkBoxCorrect(i+1)){
                return false;
            }

        }
        return true;
    }
}
