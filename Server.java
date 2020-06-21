package project03queuessum18;

/**
 *
 * @author Stephen T. Brower<stephen.brower@raritanval.edu>
 */
public class Server 
{
    private boolean free;
    private int customersServed;
    private Queue<Customer> customerArrivalQueue;
    private Customer currentCustomer;
    
    /**
     * no-arg Constructor
     * initializes the server as free and initializes the Queue of Customer
     */
    public Server()
    {
        free = true;
        customersServed = 0;
        customerArrivalQueue = new Queue<Customer>();
        currentCustomer = null;
    }
    
    /**
     * isFree method returns state of this server being free
     * @return boolean state of this server being free
     */
    public boolean isFree()
    {
        return free;
    }
    
    /**
     * isNotFree method returns state of this server not being free
     * @return boolean state of this server not being free
     */
    public boolean isNotFree()
    {
        return !free;
    }
    
    /**
     * serveCustomer method removes a server from the Queue
     */
    public void serveCustomer()
    {
        if (free)
        {
            free = false;
            customersServed++;
            try
            {
                currentCustomer = customerArrivalQueue.remove();
            }
            catch (EmptyQueue e)
            {
                System.out.println("*** something went wrong ***");
            }
        }
    }
    
    /**
     * getCustomersServed returns the number of customers that the server has
     * started to work on
     * @return the number of customers that the server has started to work on
     */
    public int getCustomersServed()
    {
        return customersServed;
    }
    
    /**
     * freeServer method sets the server as free
     */
    public void freeServer()
    {
        if (!free)
            free=true;
    }
    
    /**
     * addCustomer method adds a new customer to the Queue
     * @param waitingCustomer is the customer to be added to the queue
     */
    public void addCustomer(Customer waitingCustomer)
    {
        customerArrivalQueue.add(waitingCustomer);
    }
    
    /**
     * queueSize returns the size of the Queue which is the number of 
     * customers waiting
     * @return the number of customers waiting
     */
    public int queueSize()
    {
        return customerArrivalQueue.size();
    }
    
    /**
     * currentCustomerArrivalTime returns the time the current customer arrived
     * @return the time the current customer arrived
     */
    public int currentCustomerArrivalTime()
    {
        if (currentCustomer != null)
            return currentCustomer.getArrivalTime();
        else
            return 0;
    }
    
    /**
     * doWork method marks a second of work for the customer and if work is
     * over it frees up the server
     */
    public void doWork()
    {
        if (currentCustomer != null)
        {
            currentCustomer.doWork();
            if (currentCustomer.getWorkToDoRemaining() <= 0)
                freeServer();
        }
    }
    
    /**
     * customerWorkToDoRemaining returns the work that is remaining for the 
     * current customer
     * @return work that is remaining for the current customer
     */
    public int customerWorkToDoRemaining()
    {
        if (currentCustomer != null)
            return currentCustomer.getWorkToDoRemaining();
        else
            return 0;
    }
    
}
