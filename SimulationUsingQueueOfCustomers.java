package project03queuessum18;
/**
 * Created by Michael Main and mucked up by Stephen Brower
 * pillaged from Sample Simulation using a Queue of Integer
 * and changed to a Queue of Customer
 * @author Stephen T. Brower<stephen.brower@raritanval.edu>
 *
 * Modified by: STB 7/23/2018 - brought in Server class from a variation
 *              Brian Albert
 *
 */
public class SimulationUsingQueueOfCustomers
{
    /**
     * main method
     * @param args  the command line arguments
     */
    public static void main(String[] args)
    {
        // settings/declarations
        int currentSecond;                          // for a specific second in simulation
        final int MAX_TIME_FOR_SIMULATION = 90*60;  // 90 minutes
        
                                                    // probability of arrival for a second
                                                    // based on 20 customers an hour
        final double PROBABILITY_OF_ARRIVAL = 20.0 / (60*60);
        final int MAX_TIME_TO_CHECKOUT = 5*60;      // maximum time to process "customer"
        int numCustomersArrived = 0;                // counter for number of customers that arrived

        Server regularServer = new Server();        // each server has their own Queue of customers

        int totalWaitingTime = 0;                   // initialize total waiting time

        // loop to simulate elapsing time
        for (currentSecond = 0; currentSecond < MAX_TIME_FOR_SIMULATION; currentSecond++)
        {
            // everything inside this loop is for 1 second of time

            // has someone arrived at this second?
            if (Math.random() < PROBABILITY_OF_ARRIVAL)
            {
                // a customer arrived - count them
                numCustomersArrived++;

                // 'create' this newCustomer with an estimate of time to take
                Customer newCustomer = new Customer(currentSecond,( (int) (Math.random()*MAX_TIME_TO_CHECKOUT)) );
                // stick this new customer on Server's customerArrivalQueue queue
                regularServer.addCustomer(newCustomer);

                // display customer's arrival
                System.out.println("At time " + currentSecond + " a customer arrived. " +
                        "work will be "+newCustomer.getInitialWorkToDo());
            }

            // for this second, is a server free and someone waiting?
            if (regularServer.isFree() && regularServer.queueSize() > 0)
            {
                regularServer.serveCustomer();             // mark the 'server' as busy

                // accumulate waiting time---note: the time this customer waited is: currentSecond - customerBeingServedArrivalTime
                totalWaitingTime+=currentSecond - regularServer.currentCustomerArrivalTime();

                // display working info
                System.out.println("At " + currentSecond +
                        " started working on customer who arrived at "+
                        regularServer.currentCustomerArrivalTime() + 
                        " -- work remainng is " + regularServer.customerWorkToDoRemaining());
            }

            // for this second, if a server is working on a customer then decrease work to do by 1 second
            if (regularServer.isNotFree())
            {
                // decrement work to do by 1 second
                regularServer.doWork();

                // are we done with customer?
                if (regularServer.isFree()) 
                {
                    System.out.println("At " + currentSecond + " server free!");
                }
            }

            // for this second, if it is the last second, announce last second of simulation
            if (currentSecond == (MAX_TIME_FOR_SIMULATION - 1))
            {
                System.out.println("At " + currentSecond + " \t\t\t\t\t\t\tWe are closed");
                // Display the number of customers stuck on line (still in Queue)
                System.out.println("\t\t\t\t\t\t\t\tnumber of customers stuck on line: " + regularServer.queueSize());
            }
        } // for loop end

        System.out.println("\nAt " + currentSecond + " Simulation ended");


        // display statistics from simulation

        // display number of customers that arrived
        System.out.println("\n" + numCustomersArrived + " customers arrived");

        // Display the counter for the number of customers served
        System.out.println("Number of customers served: " + regularServer.getCustomersServed());


        // Display the total wait time that ALL customers served had waiting on line
        System.out.println("Total Wait Time of customers Served: " + totalWaitingTime);

        // Display the average wait time that the customers served had to wait on line
        System.out.printf("Average Wait Time of customers Served: %,.1f\n",((double)totalWaitingTime/regularServer.getCustomersServed()));

        // Display the number of customers stuck on line (still in Queue)
        System.out.println("number of customers stuck on line: " + regularServer.queueSize());
    }
}
