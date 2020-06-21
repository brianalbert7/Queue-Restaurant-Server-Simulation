package project03queuessum18;

/**
 *
 * @author Brian Albert
 */
public class Node<E> 
{
    private E data;
    private Node<E> next;
    
    /**
     * 
     * @param initialData value for the initial data
     * @param initialNext value for the initial next
     */
    public Node(E initialData, Node<E> initialNext){
        data = initialData;
        next = initialNext;
    }
    
    /**
     * getData method returns the data
     * @return The value in the data field
     */
    public E getData(){
        return data;
    }
    
    /**
     * getNext method returns the next
     * @return The value in the next field
     */
    public Node<E> getNext(){
        return next;
    }
    
    /**
     * The setData method accepts an argument which is stored in the data field.
     * @param newData value for data field
     */
    public void setData(E newData){
        data = newData;
    }
    
    /**
     * The setNext method accepts an argument which is stored in the next field.
     * @param newNext value for next field
     */
    public void setNext(Node<E> newNext){
        next = newNext;
    }
}
