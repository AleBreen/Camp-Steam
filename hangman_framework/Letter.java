public class Letter{

    private boolean guessed;
    private final String value;

    public Letter(String value){
        this.value = value;
        this.guessed = false;
    }

    public boolean isGuessed(){
        return guessed;
    }

    public void setGuessed(boolean guessed){
        this.guessed = guessed;
    }

    public String getValue(){
        return this.value;
    }


}
