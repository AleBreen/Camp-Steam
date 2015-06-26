public class DataAnalysis{

    public static void main(String [] args){
        ActorDatabase database = new ActorDatabase();

        /*
         *
         * NTER YOUR CODE HERE
         * database.get(i) // returns the actor at the i-th position
         * actor.set(3, actor) // sets the actor at position 3 to actor
         * database.set(i,database.get(i+1)) // sets the actor at the i-th position to the actor at the (i+1) position
         *
         */
	int j=0;

	while(j<database.length()-1){
	int i = 0;
		while(i<database.length()-1){
			Actor a1= database.get(i);
			Actor a2= database.get(i+1);
			long a1Movies= a1.getNumberOfMovies()*a1.getHighestGrossing;
			long a2Movies= a2.getNumberOfMovies()*a2.getHighestGrossing;
			if(a1Movies<a2Movies) {
				Actor temp=database.get(i);
				database.set(i,database.get(i+1));
				database.set(i+1,temp);
			}
			i=i+1;
		}
		j=j+1;
	} 

        database.print();
    }
}
