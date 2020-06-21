package project03queuessum18;

/**
 * This customer class is to be used for a Queue of Customer
 * @author Stephen T. Brower<stephen.brower@raritanval.edu>
 */
public class Customer
{
    private int arrivalTime;
    private int initialWorkToDo;
    private int workToDoRemaining;

    /**
     * Constructor
     * @param timeArrived the time the customer arrived
     * @param amountOfWorkToDoInSeconds the number of seconds it will take to
     * "serve" the customer -- this will also be used to initialize
     * the workToDoRemaining field
     */
    public Customer(int timeArrived, int amountOfWorkToDoInSeconds)
    {
        arrivalTime = timeArrived;
        initialWorkToDo = amountOfWorkToDoInSeconds;
        workToDoRemaining = amountOfWorkToDoInSeconds;
    }

    /**
     * the getArrivalTime method will return the value in the arrivalTime field
     * @return value in the arrivalTime field
     */
    public int getArrivalTime()
    {
        return arrivalTime;
    }

    /**
     * the getInitialWorkToDo method will return the value in the initialWorkToDo field
     * @return value in the initialWorkToDo field
     */
    public int getInitialWorkToDo()
    {
        return initialWorkToDo;
    }

    /**
     * The getWorkToDoRemaining method will return the value in the workToDoRemaining field
     * @return value in the workToDoRemaining field
     */
    public int getWorkToDoRemaining()
    {
        return workToDoRemaining;
    }

    /**
     * the doWork method decrements the remaining work to do by 1
     */
    public void doWork()
    {
        workToDoRemaining--;
    }

    /**
     * this overrides the toString method in Object
     * to make a String that represents this Customer object
     * @return String that represents this Customer object
     */
    @Override
    public String toString()
    {
        return "Customer arr: "+ arrivalTime+
                " initialWorkToDo: "+initialWorkToDo+
                " workToDoRemaining: "+workToDoRemaining;
    }
}
