package project03queuessum18;

/**
 *
 * @author Brian Albert
 */
public class SimulationUsingQueueOfCustomersMultiple {
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
        final double PROBABILITY_OF_ARRIVAL = 300.0 / (60*60);
        final int MAX_TIME_TO_CHECKOUT = 5*60;      // maximum time to process "customer"
        int numCustomersArrived = 0;                // counter for number of customers that arrived

        Server[] regularServer = new Server[10];        // each server has their own Queue of customers
        Server expressServer = new Server();        //Server Declaration
        
        //initialize the array of servers
        for (int i = 0; i < regularServer.length; i++) {
            regularServer[i] = new Server();
        }
        
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
                if (newCustomer.getInitialWorkToDo() <= 60)
                {
                    expressServer.addCustomer(newCustomer);
                    // display customer's arrival
                    System.out.println("Express Server: At time " + currentSecond + " a customer arrived. " +
                        "work will be "+newCustomer.getInitialWorkToDo());
                }
                else
                {
                    int shortest = 0;
                    boolean found = false;
                    int chosenServer = 0;
                    boolean useShort = false;
                    
                    for (int i = 0; i < regularServer.length; i++) {
                        if (found == false){
                            if (regularServer[i].isFree()){
                                regularServer[i].addCustomer(newCustomer);
                                chosenServer = i;
                                found = true;
                            }
                            else if (regularServer[i].customerWorkToDoRemaining() < regularServer[shortest].customerWorkToDoRemaining())
                                shortest = i;
                            
                            if (i == (regularServer.length))
                            {
                                found = true;
                                useShort = true;
                            }
                        }
                    }
                    
                    if (useShort == true){
                        regularServer[shortest].addCustomer(newCustomer);
                        chosenServer = shortest;
                    }
                    
                    // display customer's arrival
                    System.out.println("Regular Server(" + chosenServer + ") : At time " + currentSecond + " a customer arrived. " +
                        "work will be "+newCustomer.getInitialWorkToDo());
                }
            }
            
            // for this second, is a server free and someone waiting?
            if (expressServer.isFree() && expressServer.queueSize() > 0)
            {
                expressServer.serveCustomer();             // mark the 'server' as busy

                // accumulate waiting time---note: the time this customer waited is: currentSecond - customerBeingServedArrivalTime
                totalWaitingTime+=currentSecond - expressServer.currentCustomerArrivalTime();

                // display working info
                System.out.println("Express Server: At " + currentSecond +
                        " started working on customer who arrived at "+
                        expressServer.currentCustomerArrivalTime() + 
                        " -- work remainng is " + expressServer.customerWorkToDoRemaining());
            }

            // for this second, is a server free and someone waiting?
            for (int i = 0; i < regularServer.length; i++){
                if (regularServer[i].isFree() && regularServer[i].queueSize() > 0)
                {
                    regularServer[i].serveCustomer();             // mark the 'server' as busy

                    // accumulate waiting time---note: the time this customer waited is: currentSecond - customerBeingServedArrivalTime
                    totalWaitingTime+=currentSecond - regularServer[i].currentCustomerArrivalTime();

                    // display working info
                    System.out.println("Regular Server(" + i + ") : At " + currentSecond +
                            " started working on customer who arrived at "+
                            regularServer[i].currentCustomerArrivalTime() + 
                            " -- work remainng is " + regularServer[i].customerWorkToDoRemaining());
                }
            }
            
            // for this second, if a server is working on a customer then decrease work to do by 1 second
            if (expressServer.isNotFree())
            {
                // decrement work to do by 1 second
                expressServer.doWork();

                // are we done with customer?
                if (expressServer.isFree()) 
                {
                    System.out.println("Express Server: At " + currentSecond + " server free!");
                }
            }

            // for this second, if a server is working on a customer then decrease work to do by 1 second
            for (int i = 0; i < regularServer.length; i++){
                if (regularServer[i].isNotFree())
                {
                    // decrement work to do by 1 second
                    regularServer[i].doWork();

                    // are we done with customer?
                    if (regularServer[i].isFree()) 
                    {
                        System.out.println("Regular Server(" + i + ") : At " + currentSecond + " server free!");
                    }
                }
            }

            // for this second, if it is the last second, announce last second of simulation
            if (currentSecond == (MAX_TIME_FOR_SIMULATION - 1))
            {
                System.out.println("At " + currentSecond + " \t\t\t\t\t\t\tWe are closed");
                
                for (int i = 0; i < regularServer.length; i++){
                    // Display the number of customers stuck on line (still in Queue)
                    System.out.println("\t\t\t\t\t\t\t\tRegular Server(" + i + ") : number of customers stuck on line: " + regularServer[i].queueSize());
                }
                System.out.println("\t\t\t\t\t\t\t\tExpress Server: number of customers stuck on line: " + expressServer.queueSize());
            }
        } // for loop end

        System.out.println("\nAt " + currentSecond + " Simulation ended");


        // display statistics from simulation

        // display number of customers that arrived
        System.out.println("\n" + numCustomersArrived + " customers arrived");

        // Display the counter for the number of customers served by regular server
        int totalRegularServed = 0;
        for (int i = 0; i < regularServer.length; i++){
            System.out.println("Number of customers served by Regular Server(" + i + ") : " + regularServer[i].getCustomersServed());
            totalRegularServed += regularServer[i].getCustomersServed();
        }
        // Display the counter for the number of customers served by express server
        System.out.println("Number of customers served by Express Server: " + expressServer.getCustomersServed());

        // Display the total wait time that ALL customers served had waiting on line
        System.out.println("Total Wait Time of customers Served: " + totalWaitingTime);

        // Display the average wait time that the customers served had to wait on line
        System.out.printf("Average Wait Time of ALL customers Served: %,.1f\n",((double)totalWaitingTime/(totalRegularServed + expressServer.getCustomersServed())));

        // Display the number of customers stuck on line (still in Queue)
        for (int i = 0; i < regularServer.length; i++)
            System.out.println("Regular Server(" + i + ") : number of customers stuck on line: " + regularServer[i].queueSize());
        // Display the number of customers stuck on line (still in Queue)
        System.out.println("Express Server: number of customers stuck on line: " + expressServer.queueSize());
    }
}
