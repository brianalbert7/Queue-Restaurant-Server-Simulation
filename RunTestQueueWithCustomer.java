package project03queuessum18;
/**
 * Programmed by   Stephen Brower
 * Inspired by     Michael Main
 * Date Written    10/3/2014 - written to use generic tester to test generic linked list
 *                              needs TestLinkedBagGeneric.java
 *
 * Date Modified   10/12/2014 - changed to use Queue
 *                 3/16/2017 - changed inputs, updated output
 *                  4/12/2018 - change from Car to Customer
 * For Sample Output, see below
*/

public class RunTestQueueWithCustomer
{
    public static void main(String[] args)
    {
        runMe();
    }

    public static void runMe()
    {

        TestQueueGeneric<Customer> testQueueCustomer = new TestQueueGeneric<Customer>();

        Customer[] arrayOfCustomersToAdd = {
                    new Customer(1,86),
                    new Customer(10,7),
                    new Customer(21,530),
                    new Customer(33,9),
                    new Customer(57,134),
                    new Customer(93,88) };

        testQueueCustomer.test ( arrayOfCustomersToAdd );
    }

}

/*
Expected output:
run:

Display Queue Size on startup
Size: 0 -good

===========
<<Start adds:
Adding: Customer arr: 1 initialWorkToDo: 86 workToDoRemaining: 86 	added...now size is 1 -good
Adding: Customer arr: 10 initialWorkToDo: 7 workToDoRemaining: 7 	added...now size is 2 -good
Adding: Customer arr: 21 initialWorkToDo: 530 workToDoRemaining: 530 	added...now size is 3 -good
Adding: Customer arr: 33 initialWorkToDo: 9 workToDoRemaining: 9 	added...now size is 4 -good
Adding: Customer arr: 57 initialWorkToDo: 134 workToDoRemaining: 134 	added...now size is 5 -good
Adding: Customer arr: 93 initialWorkToDo: 88 workToDoRemaining: 88 	added...now size is 6 -good
Stopped adding>>
===========


Display Queue size after adds
Size: 6 -good

About to remove 1 item......removed: <Customer arr: 1 initialWorkToDo: 86 workToDoRemaining: 86> exp:{Customer arr: 1 initialWorkToDo: 86 workToDoRemaining: 86} 	size: 5 -good

Display Queue size after 1 remove
Size: 5 -good

===========
<<Start removing:
About to remove......removed: <Customer arr: 10 initialWorkToDo: 7 workToDoRemaining: 7> exp:{Customer arr: 10 initialWorkToDo: 7 workToDoRemaining: 7} 	size: 4 -good
About to remove......removed: <Customer arr: 21 initialWorkToDo: 530 workToDoRemaining: 530> exp:{Customer arr: 21 initialWorkToDo: 530 workToDoRemaining: 530} 	size: 3 -good
About to remove......removed: <Customer arr: 33 initialWorkToDo: 9 workToDoRemaining: 9> exp:{Customer arr: 33 initialWorkToDo: 9 workToDoRemaining: 9} 	size: 2 -good
About to remove......removed: <Customer arr: 57 initialWorkToDo: 134 workToDoRemaining: 134> exp:{Customer arr: 57 initialWorkToDo: 134 workToDoRemaining: 134} 	size: 1 -good
About to remove......removed: <Customer arr: 93 initialWorkToDo: 88 workToDoRemaining: 88> exp:{Customer arr: 93 initialWorkToDo: 88 workToDoRemaining: 88} 	size: 0 -good
Stopped removing>>
===========

Display Queue size after remove all
Size: 0 -good

attempt to remove 1 item from an empty Queue:
remove?Can't remove  - EmptyQueue exception  -good

Display Queue size after 1 remove
Size: 0 -good
BUILD SUCCESSFUL (total time: 0 seconds)

*/

