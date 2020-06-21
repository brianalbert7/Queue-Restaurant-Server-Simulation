package project03queuessum18;

/**
 *
 * @author Brian Albert
 */
public class Queue<E> 
{
    private Node<E> front;
    private Node<E> rear;
    private int numElements;
    
    /**
     * No-arg constructor
     */
    public Queue(){
        front = null;
        rear = null;
        numElements = 0;
    }
    
    /**
     * add method accepts an argument to be added to the rear of the queue
     * @param element value to be added to the queue
     */
    public void add(E element){
        if (rear == null)
        {
            front = new Node<E>(element, null);
            rear = front;
        }
        else
        {
            rear.setNext(new Node<E>(element,null));
            rear = rear.getNext();
        }
        numElements++;
    }
    
    /**
     * remove method removes a value from the front of the queue
     * @return The value in the value field
     * @throws EmptyQueue when front is null
     */
    public E remove() throws EmptyQueue {
        E value;
        if (front == null)
            throw new EmptyQueue();
        else
        {
            value = front.getData();
            if (front != rear)
                front = front.getNext();
            else
            {
                front = null;
                rear = null;
            }
            numElements--;
        }
        return value;
    }
    
    /**
     * size method returns the number of elements in the queue
     * @return The value in the numElements field
     */
    public int size(){
        return numElements;
    }
}
