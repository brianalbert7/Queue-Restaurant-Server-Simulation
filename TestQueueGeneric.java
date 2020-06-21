package project03queuessum18;
/**
 * Date Written    10/3/2014 - made tester generic
 * Date Modified   10/12/2014 - changed to use Queues
 * Run this program using the following:
 *      RunTestQueueWithCar.java
 *      RunTestQueueWithInteger.java
 * @author Stephen T. Brower<stephen.brower@raritanval.edu>
 * @param <E> This Generic class expects an additional class on its use
 */
public class TestQueueGeneric<E>
{
    public void test(E[] testDataAdd)
    {
        // creates a Queue
        Queue<E> myGenericQueue = new Queue<E>( );

        // holds an item removed
        E itemRemoved;

        int checkItem = 0;

        // show initial Queue size
        displayQueueSize("Display Queue Size on startup",myGenericQueue, checkItem);

        // add some stuff to the Queue
        System.out.println("\n===========\n<<Start adds:");
        for (E item : testDataAdd)
        {
            System.out.print("Adding: " + item);
            myGenericQueue.add(item);
            checkItem++;
            System.out.print(" \tadded...now size is " + myGenericQueue.size());
            if (checkItem == myGenericQueue.size())
                System.out.println(" -good");
            else
                System.out.println(" no, expected " + checkItem + "\t\t<=== issue");
        }
        System.out.println("Stopped adding>>\n===========");

        // show Queue size after adds
        displayQueueSize("\nDisplay Queue size after adds",myGenericQueue,checkItem);

        // set index for checking to the beginning of the testDataAdd array
        checkItem = 0;

        System.out.print("\nAbout to remove 1 item...");

        // remove 1 item
        try
        {
            itemRemoved = myGenericQueue.remove();
            // display 1 item
            System.out.print("...removed: <" + itemRemoved
                        + "> exp:{" + testDataAdd[checkItem]
                        + "} \tsize: " + myGenericQueue.size());
            if (itemRemoved.equals(testDataAdd[checkItem]))
                System.out.println(" -good");
            else
                System.out.println(" exp:"+testDataAdd[checkItem]+"\t\t<=== issue");
            checkItem++;

        }
        catch (EmptyQueue e)
        {
            System.out.println("Can't remove from Queue - empty");
        }

        // show Queue size after 1 remove
        displayQueueSize("Display Queue size after 1 remove",myGenericQueue,
                (testDataAdd.length-checkItem) );


        // remove all
        System.out.println("\n===========\n<<Start removing:");
        while (myGenericQueue.size() > 0)
        {
            System.out.print("About to remove...");
            // remove 1 item
            try
            {
                itemRemoved = myGenericQueue.remove();
                // display 1 item
                System.out.print("...removed: <" + itemRemoved
                            + "> exp:{" + testDataAdd[checkItem]
                            + "} \tsize: " + myGenericQueue.size());
                if (itemRemoved.equals(testDataAdd[checkItem]))
                    System.out.println(" -good");
                else
                    System.out.println(" exp:"+testDataAdd[checkItem]+"\t\t<=== issue");
                checkItem++;
            }
            catch (EmptyQueue e)
            {
                System.out.println("Can't remove from Queue - empty");
            }

        }
        System.out.println("Stopped removing>>\n===========");

        // show Queue size after removing  all
        displayQueueSize("Display Queue size after remove all",myGenericQueue,
                (testDataAdd.length-checkItem) );


        System.out.print("\nattempt to remove 1 item from an empty Queue:\nremove?");
        try
        {
            itemRemoved = myGenericQueue.remove();
            // display 1 item
            System.out.println("...removed: <" + itemRemoved
                        + "> expected EmptyQueue Exception" +
                    " \tsize: " + myGenericQueue.size()+"\t\t<==issue");
        }
        catch (EmptyQueue e)
        {
            System.out.println("Can't remove  - EmptyQueue exception  -good");
        }

        // show Queue size after 1 pop
        displayQueueSize("Display Queue size after 1 remove",myGenericQueue,0);

    }




    /**
        the displayBag method displays the Queue size
        @param heading a String to display before the Queue size
        @param aBag the Queue to display the size from
        @param expected value for the expected size of the queue
    */
    private void displayQueueSize(String heading, Queue<E> aQueue, int expected)
    {
        System.out.println("\n" + heading);
        System.out.print("Size: " + aQueue.size());
        if (expected == aQueue.size())
            System.out.println(" -good");
        else
            System.out.println(" exp: " + expected+"\t\t<=== issue");


    }
}