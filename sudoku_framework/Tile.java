public class Tile{

    private int value;
    private State state;
    private int [] availableMoves;

    public Tile(){
        this.availableMoves =  new int [] {1,2,3,4,5,6,7,8,9};
        this.value = 0;
        this.state = State.EMPTY;
    }

    public Tile(int value, State state){
        this.value = value;
        if (value == 0){
            this.availableMoves =  new int [] {1,2,3,4,5,6,7,8,9};
        }
        else{
            this.availableMoves = new int [] {value};
        }
        this.state = state;
    }

    public int [] getAvailableMoves(){
        return this.availableMoves;
    }

    public void crossOut(int n){
         
        boolean crossOut = false;
        for(int i = 0; i < this.availableMoves.length; ++i){
            if (availableMoves[i] == n){
                crossOut = true;
                break;
            }
        }
        if (!crossOut){
            return;
        }

        int [] revisedAvailableMoves = new int[this.availableMoves.length-1];
        int counter = 0;
        for(int i = 0; i < this.availableMoves.length; ++i){
            if(this.availableMoves[i] != n){
                revisedAvailableMoves[counter] = this.availableMoves[i];
                ++counter;
            }
        }

        this.availableMoves = revisedAvailableMoves;
    }

    public int getValue(){
       return this.value; 
    }

    public void setValue(int value){
        this.value = value;
    }       

    public State getState(){
        return this.state;
    }

    public void setState(State state){
        this.state = state;
    }

}
