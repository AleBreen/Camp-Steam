public class Actor{

    String name;
    int numberOfMovies;
    long highestGrossing, average, lifetimeTotal, adjustedLifetimeTotal, adjustedAverage;

    public Actor(String name, int numberOfMovies, long highestGrossing, long average, long lifetimeTotal, long adjustedLifetimeTotal, long adjustedAverage){
        this.name = name;
        this.numberOfMovies = numberOfMovies;
        this.highestGrossing = highestGrossing;
        this.average = average;
        this.lifetimeTotal = lifetimeTotal;
        this.adjustedLifetimeTotal = adjustedLifetimeTotal;
        this.adjustedAverage = adjustedAverage;
    }

    public String getName(){
        return this.name;
    }

    public int getNumberOfMovies(){
        return numberOfMovies;
    }       

    public long getHighestGrossing(){
        return highestGrossing;
    }

    public long getAverage(){
        return average;
    }

    public long getLifetimeTotal(){
        return lifetimeTotal;
    }   

    public long getAdjustedLifetimeTotal(){
        return adjustedLifetimeTotal;
    }

    public long getAdjustedAverage(){
        return adjustedAverage;
    }       
}
