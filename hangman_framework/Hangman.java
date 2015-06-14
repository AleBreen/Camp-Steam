public class Hangman{

    public Hangman(){

    }

    private final static String COLOR_FRAME = "\u001B[44m";
    private final static String COLOR_RESET = "\u001B[0m";
    private final static String COLOR_MAN = "\u001B[40m";

    private final static int FRAME_THICKNESS = 2;
    private final static int start = 5;
    private final static int mid = 30;

    private static String formatSpaces(int length){
        StringBuffer outputBuffer = new StringBuffer(length);
        for(int i = 0; i< length; ++i){
            outputBuffer.append(" ");        
        } 
        return outputBuffer.toString();
    }

    private static String topOfFrame(){
        String frame = "";
        frame += formatSpaces(start) + COLOR_FRAME + formatSpaces(mid+3) + COLOR_RESET + "\n";
        frame += formatSpaces(start) + COLOR_FRAME + formatSpaces(1) + COLOR_RESET + formatSpaces(mid) + COLOR_FRAME + formatSpaces(FRAME_THICKNESS) + COLOR_RESET + "\n";
        frame += formatSpaces(start) + COLOR_FRAME + formatSpaces(1) + COLOR_RESET + formatSpaces(mid) + COLOR_FRAME + formatSpaces(FRAME_THICKNESS) + COLOR_RESET + "\n";
        frame += formatSpaces(start) + COLOR_FRAME + formatSpaces(1) + COLOR_RESET + formatSpaces(mid) + COLOR_FRAME + formatSpaces(FRAME_THICKNESS) + COLOR_RESET + "\n";
        return frame;
    }

    private static String bottomOfFrame(){
        return formatSpaces(start + mid/FRAME_THICKNESS) + COLOR_FRAME + formatSpaces(mid+4) + COLOR_RESET + "\n";
    }

    private static String head(){
        String frame = "";
        frame += formatSpaces(start-1) + COLOR_MAN + formatSpaces(3) + COLOR_RESET + formatSpaces(mid-1) + COLOR_FRAME + formatSpaces(FRAME_THICKNESS) + COLOR_RESET + "\n";
        frame += formatSpaces(start-3) + COLOR_MAN + formatSpaces(FRAME_THICKNESS) + COLOR_RESET + formatSpaces(3) + COLOR_MAN + formatSpaces(FRAME_THICKNESS) + COLOR_RESET + formatSpaces(mid-3) + COLOR_FRAME + formatSpaces(FRAME_THICKNESS) + COLOR_RESET + "\n";
        frame += formatSpaces(start-4) + COLOR_MAN + formatSpaces(1) + COLOR_RESET + formatSpaces(7) + COLOR_MAN + formatSpaces(1) + COLOR_RESET + formatSpaces(mid-4) + COLOR_FRAME + formatSpaces(FRAME_THICKNESS) + COLOR_RESET + "\n";
        frame += formatSpaces(start-3) + COLOR_MAN + formatSpaces(FRAME_THICKNESS) + COLOR_RESET + formatSpaces(3) + COLOR_MAN + formatSpaces(FRAME_THICKNESS) + COLOR_RESET + formatSpaces(mid-3) + COLOR_FRAME + formatSpaces(FRAME_THICKNESS) + COLOR_RESET + "\n";
        frame += formatSpaces(start-1) + COLOR_MAN + formatSpaces(3) + COLOR_RESET + formatSpaces(mid-1) + COLOR_FRAME + formatSpaces(FRAME_THICKNESS) + COLOR_RESET + "\n";
        return frame;
    }

    private static String oneArm(){
        String frame = "";
        frame += COLOR_MAN + formatSpaces(1) + COLOR_RESET + formatSpaces(4) + COLOR_MAN + formatSpaces(1) + COLOR_RESET + formatSpaces(mid) + COLOR_FRAME + formatSpaces(FRAME_THICKNESS) + COLOR_RESET + "\n";
        frame += formatSpaces(1) + COLOR_MAN + formatSpaces(1) + COLOR_RESET + formatSpaces(3) + COLOR_MAN + formatSpaces(1) + COLOR_RESET + formatSpaces(mid) + COLOR_FRAME + formatSpaces(FRAME_THICKNESS) + COLOR_RESET + "\n";
        frame += formatSpaces(FRAME_THICKNESS) + COLOR_MAN + formatSpaces(1) + COLOR_RESET + formatSpaces(FRAME_THICKNESS) + COLOR_MAN + formatSpaces(1) + COLOR_RESET + formatSpaces(mid) + COLOR_FRAME + formatSpaces(FRAME_THICKNESS) + COLOR_RESET + "\n";
        frame += formatSpaces(3) + COLOR_MAN + formatSpaces(3) + COLOR_RESET + formatSpaces(mid) + COLOR_FRAME + formatSpaces(FRAME_THICKNESS) + COLOR_RESET + "\n";
        return frame;
    }

    private static String twoArms(){
        String frame = "";
        frame += COLOR_MAN + formatSpaces(1) + COLOR_RESET + formatSpaces(4) + COLOR_MAN + formatSpaces(1) + COLOR_RESET + formatSpaces(4) + COLOR_MAN + formatSpaces(1) + COLOR_RESET + formatSpaces(mid-5) + COLOR_FRAME + formatSpaces(FRAME_THICKNESS) + COLOR_RESET + "\n";
        frame += formatSpaces(1) + COLOR_MAN + formatSpaces(1) + COLOR_RESET + formatSpaces(3) + COLOR_MAN + formatSpaces(1) + COLOR_RESET + formatSpaces(3) + COLOR_MAN + formatSpaces(1) + COLOR_RESET + formatSpaces(mid-4) + COLOR_FRAME + formatSpaces(FRAME_THICKNESS) + COLOR_RESET + "\n";
        frame += formatSpaces(FRAME_THICKNESS) + COLOR_MAN + formatSpaces(1) + COLOR_RESET + formatSpaces(FRAME_THICKNESS) + COLOR_MAN + formatSpaces(1) + COLOR_RESET + formatSpaces(FRAME_THICKNESS) + COLOR_MAN + formatSpaces(1) + COLOR_RESET + formatSpaces(mid-3) + COLOR_FRAME + formatSpaces(FRAME_THICKNESS) + COLOR_RESET + "\n";
        frame += formatSpaces(3) + COLOR_MAN + formatSpaces(5) + COLOR_RESET + formatSpaces(mid-FRAME_THICKNESS) + COLOR_FRAME + formatSpaces(FRAME_THICKNESS) + COLOR_RESET + "\n";
        return frame;
    }

    private static String oneLeg(){
        String frame = "";
        frame += formatSpaces(3) + COLOR_MAN + formatSpaces(3) + COLOR_RESET + formatSpaces(mid) + COLOR_FRAME + formatSpaces(FRAME_THICKNESS) + COLOR_RESET + "\n";
        frame += formatSpaces(FRAME_THICKNESS) + COLOR_MAN + formatSpaces(1) + COLOR_RESET + formatSpaces(mid+3) + COLOR_FRAME + formatSpaces(FRAME_THICKNESS) + COLOR_RESET + "\n";
        frame += formatSpaces(1) + COLOR_MAN + formatSpaces(1) + COLOR_RESET + formatSpaces(mid+4) + COLOR_FRAME + formatSpaces(FRAME_THICKNESS) + COLOR_RESET + "\n";
        frame += COLOR_MAN + formatSpaces(1) + COLOR_RESET + formatSpaces(mid+5) + COLOR_FRAME + formatSpaces(FRAME_THICKNESS) + COLOR_RESET + "\n";
        return frame;
    }

    private static String twoLegs(){
        String frame = "";
        frame += formatSpaces(3) + COLOR_MAN + formatSpaces(5) + COLOR_RESET + formatSpaces(mid-FRAME_THICKNESS) + COLOR_FRAME + formatSpaces(FRAME_THICKNESS) + COLOR_RESET + "\n";
        frame += formatSpaces(FRAME_THICKNESS) + COLOR_MAN + formatSpaces(1) + COLOR_RESET + formatSpaces(5) + COLOR_MAN + formatSpaces(1) + COLOR_RESET + formatSpaces(mid-3) + COLOR_FRAME + formatSpaces(FRAME_THICKNESS) + COLOR_RESET + "\n";
        frame += formatSpaces(1) + COLOR_MAN + formatSpaces(1) + COLOR_RESET + formatSpaces(7) + COLOR_MAN + formatSpaces(1) + COLOR_RESET + formatSpaces(mid-4) + COLOR_FRAME + formatSpaces(FRAME_THICKNESS) + COLOR_RESET + "\n";
        frame += COLOR_MAN + formatSpaces(1) + COLOR_RESET + formatSpaces(9) +  COLOR_MAN + formatSpaces(1) + COLOR_RESET + formatSpaces(mid-5) + COLOR_FRAME + formatSpaces(FRAME_THICKNESS) + COLOR_RESET + "\n";
        return frame;
    }

    public static String base(){
        String frame = topOfFrame();
        for(int i = 0; i < 22; ++i){
            frame += formatSpaces(start + 1 + mid) + COLOR_FRAME + formatSpaces(FRAME_THICKNESS) + COLOR_RESET + "\n";
        }
        frame += bottomOfFrame();
        return frame;
    }

    public static String strikeOne(){
        String frame = topOfFrame();
        frame += head();

        for(int i =0; i<17; ++i){
            frame += formatSpaces(start + 1 + mid) + COLOR_FRAME + formatSpaces(FRAME_THICKNESS) + COLOR_RESET + "\n";
        }
        frame += bottomOfFrame();
        return frame;
    }

    public static String strikeTwo(){
        String frame = topOfFrame();
        frame += head();
        for(int i = 0; i<9; ++i){
            frame += formatSpaces(start) + COLOR_MAN + formatSpaces(1) + COLOR_RESET + formatSpaces(mid) + COLOR_FRAME + formatSpaces(FRAME_THICKNESS) + COLOR_RESET + "\n";
        }
        for(int i =0; i<8; ++i){
            frame += formatSpaces(start + 1 + mid) + COLOR_FRAME + formatSpaces(FRAME_THICKNESS) + COLOR_RESET + "\n";
        }
        frame += bottomOfFrame();
        return frame;
    }

    public static String strikeThree(){
        String frame  = topOfFrame();
        frame += head();
        frame += oneArm();
        for(int i = 0; i<4; ++i){
            frame += formatSpaces(start) + COLOR_MAN + formatSpaces(1) + COLOR_RESET + formatSpaces(mid) + COLOR_FRAME + formatSpaces(FRAME_THICKNESS) + COLOR_RESET + "\n";
        }
        for(int i =0; i<8; ++i){
            frame += formatSpaces(start + 1 + mid) + COLOR_FRAME + formatSpaces(FRAME_THICKNESS) + COLOR_RESET + "\n";
        }
        frame += bottomOfFrame();
        return frame;    
    }

    public static String strikeFour(){
        String frame  = topOfFrame();
        frame += head();
        frame += twoArms();
        for(int i = 0; i<4; ++i){
            frame += formatSpaces(start) + COLOR_MAN + formatSpaces(1) + COLOR_RESET + formatSpaces(mid) + COLOR_FRAME + formatSpaces(FRAME_THICKNESS) + COLOR_RESET + "\n";
        }
        for(int i =0; i<8; ++i){
            frame += formatSpaces(start + 1 + mid) + COLOR_FRAME + formatSpaces(FRAME_THICKNESS) + COLOR_RESET + "\n";
        }
        frame += bottomOfFrame();
        return frame;    
    }

    public static String strikeFive(){
        String frame = topOfFrame();
        frame += head();
        frame += twoArms();
        for(int i = 0; i<3; ++i){
            frame += formatSpaces(start) + COLOR_MAN + formatSpaces(1) + COLOR_RESET + formatSpaces(mid) + COLOR_FRAME + formatSpaces(FRAME_THICKNESS) + COLOR_RESET + "\n";
        }
        frame += oneLeg();
        for(int i =0; i<3; ++i){
            frame += formatSpaces(start + 1 + mid) + COLOR_FRAME + formatSpaces(FRAME_THICKNESS) + COLOR_RESET + "\n";
        }

        frame += bottomOfFrame();
        return frame;    
    }       

    public static String strikeSix(){
        String frame = topOfFrame();
        frame += head();
        frame += twoArms();
        for(int i = 0; i<3; ++i){
            frame += formatSpaces(start) + COLOR_MAN + formatSpaces(1) + COLOR_RESET + formatSpaces(mid) + COLOR_FRAME + formatSpaces(FRAME_THICKNESS) + COLOR_RESET + "\n";
        }
        frame += twoLegs();
        for(int i =0; i<3; ++i){
            frame += formatSpaces(start + 1 + mid) + COLOR_FRAME + formatSpaces(FRAME_THICKNESS) + COLOR_RESET + "\n";
        }

        frame += bottomOfFrame(); 
        return frame;    
    }       
}
