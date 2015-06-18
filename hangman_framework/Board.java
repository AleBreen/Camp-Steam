public class Board{

    private Letter [] word;
    private Letter [] remainingLetters; 
    private final String [] alphabet = {"A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z"};

    private int lives;
    private int wordLength;
    private final static String COLOR_WORD = "\u001B[40m";
    private final static String COLOR_RESET = "\u001B[0m";
    private final static String COLOR_BLANK = "\u001B[107m";
    private final static String COLOR_REMAINING = "\u001B[100m";

    public Board(String inputWord){
        inputWord = inputWord.toUpperCase();
        this.wordLength = inputWord.length();
        this.word = new Letter[inputWord.length()];
        this.remainingLetters = new Letter[alphabet.length];

        for(int i = 0; i< inputWord.length(); ++i){
            this.word[i] = new Letter(inputWord.substring(i,i+1));
        }

        for(int i = 0; i < alphabet.length; ++i){
            this.remainingLetters[i] = new Letter(alphabet[i]);
        }

        this.lives = 6;
    }

    private boolean allLettersFilled(){
        for(Letter letter : word){
            if(!letter.isGuessed()){
                return false;
            }
        }
        return true;
    }

    public int getLives(){
        return this.lives;
    }

    public void updateNumberOfLives(boolean correct){
        if(correct == false){
            lives = lives -1;
        }

        /**
         * ENTER CODE FOR UPDATING NUMBER OF LIVES REMAINING
         */
    }

    public boolean setMove(String move){
        move = move.toUpperCase();
        boolean correct = false;
        for(int i = 0; i < this.remainingLetters.length; ++i){
            if(move.equals(this.remainingLetters[i].getValue())){
                this.remainingLetters[i].setGuessed(true);
            }
        }

        for(int i = 0; i < this.word.length; ++i){
            if(move.equals(word[i].getValue())){
                word[i].setGuessed(true);
                correct = true;
            }
        }


        updateNumberOfLives(correct);


        return correct;
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
        output += getWordProgress();

        return output;
    }

    public String getIncorrectGuesses(){ //getRemainingLetters(){
        String letters = "";
        boolean correct;
        for(Letter letter: this.remainingLetters){
            if(letter.isGuessed()){
                correct = false;
                for(Letter w: this.word){
                    if (w.getValue().equals(letter.getValue())){
                        correct = true;
                    }
                }
                if (!correct){
                    letters += COLOR_WORD + formatSpaces(1) + letter.getValue() + formatSpaces(1) + COLOR_RESET;
                }
            }
        }
        letters +="\n";
        return letters;
    }

    public String getWordProgress(){

        final int box_len = 7;
        final int between_len = 4;
        final String fullBoxSpaces = formatSpaces(box_len);
        final String halfBoxSpaces = formatSpaces(box_len/2);
        final String betweenBoxSpaces = formatSpaces(between_len);

        String wordInProgress = "";
        String paddingVertical = "";
        String paddingHorizontal = "";
        paddingVertical += COLOR_WORD + formatSpaces(this.wordLength*box_len) + COLOR_RESET + "\n";
        paddingHorizontal += COLOR_WORD + formatSpaces(box_len/2);
        wordInProgress +=paddingVertical;

        for(Letter letter: word){
            if(letter.isGuessed()){
                wordInProgress += paddingHorizontal + letter.getValue() + paddingHorizontal + COLOR_RESET;
            }
            else{
                wordInProgress += COLOR_WORD + formatSpaces(2) + COLOR_BLANK + formatSpaces(3) + COLOR_WORD + formatSpaces(2) + COLOR_RESET;
            }
        }
        wordInProgress += "\n";
        wordInProgress += paddingVertical;
        return wordInProgress;
    }

}
