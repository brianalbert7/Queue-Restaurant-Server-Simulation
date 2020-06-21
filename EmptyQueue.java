package project03queuessum18;

/**
 * EmptyQueue exception for Queue
 * NOTE: Java uses the built-in exception NoSuchElementException for Java's built-in Queue
 *       https://docs.oracle.com/javase/7/docs/api/java/util/NoSuchElementException.html
 * But since we are using our own Queue, we will use our own exception
 * @author Stephen T. Brower<stephen.brower@raritanval.edu>
 */
public class EmptyQueue extends Exception
{
   /**
    *  No-arg constructor
    */
   public EmptyQueue()
   {
      super("Error: Queue is empty. cannot remove from Queue");
   }

}
