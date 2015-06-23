public class ActorDatabase{

    Actor [] actors;
    public ActorDatabase(){
        actors = new Actor[12];
        actors[0] = new Actor("Hilary Duff", 40,138614544, 40228713, 402287133, 523670500, 52367100);
        actors[1] = new Actor("Tom Cruise", 41, 234280354, 96918842, 3392159468L, 5455996200L, 155885600);
        actors[2] = new Actor("Will Smith", 36, 306169268, 127924164, 2814331600L, 3935435800L, 178883400);
        actors[3] = new Actor("Jennifer Lawrence", 28, 408010692, 133947419, 1875263861, 1864968300, 133212000);
        actors[4] = new Actor("Seth Rogen", 69, 215434591, 92542483, 1850849667, 2036750000, 101837500);
        actors[5] = new Actor("Eddie Murphy", 55, 322719944, 100274264, 3810422028L, 6132569400L, 161383400);
        actors[6] = new Actor("Morgan Freeman", 110, 534858444, 74283373, 4234152245L, 5524554300L, 96922000);
        actors[7] = new Actor("Miley Cyrus", 63, 114053579, 80465483, 321861933, 357104500, 89276100);
        actors[8] = new Actor("Jack Black", 115, 218080025, 63316350, 1392959694, 1688217600, 76737200);
        actors[9] = new Actor("Robert Downey, Jr.", 82, 623357910, 67879611, 3529739790L, 4136145200L, 79541300);
        actors[10] = new Actor("Orlando Bloom", 38, 423315812, 165637143, 2815831431L, 3513325700L, 206666200);
        actors[11] = new Actor("Samuel L. Jackson", 161, 449447357, 70467543, 4580390287L, 5717131200L, 879559000);
    }

    public void print(){
        System.out.println("NAME:\t\t\t # of Movies:\t Highest Grossing:\t Average: \tLifetime Total:\t Adjusted Lifetime Total:\t Adjusted Average:\t");
        for(Actor actor : actors){
            if(actor.getName().length() > 14){

                System.out.print(actor.getName() + "\t\t" + actor.getNumberOfMovies() + "\t\t" + actor.getHighestGrossing() + "\t" + actor.getAverage() + "\t" + actor.getLifetimeTotal() + "\t\t" + actor.getAdjustedLifetimeTotal() + "\t\t" + actor.getAdjustedAverage() + "\t\n");
            }
            else{
                System.out.print(actor.getName() + "\t\t\t" + actor.getNumberOfMovies() + "\t\t" + actor.getHighestGrossing() + "\t" + actor.getAverage() + "\t" + actor.getLifetimeTotal() + "\t\t" + actor.getAdjustedLifetimeTotal() + "\t\t" + actor.getAdjustedAverage() + "\t\n");
            }
        }
    }

    public Actor get(int num){
        return actors[num];
    }

    public void set(int num, Actor actor){
        actors[num] = actor;
    }       

    public int length(){
        return actors.length;
    }
}
