/******************************************************************************
* An IntLinkedBag is a collection of int numbers.
*
* @note
*   (1) Beyond Int.MAX_VALUE elements, countOccurrences,
*   size, and grab are wrong.
*   <p>
*   (2) Because of the slow linear algorithms of this class, large bags will have
*   poor performance.
*
******************************************************************************/
public class IntLinkedBag implements Cloneable
{
   // Invariant of the IntLinkedBag class:
   //   1. The elements in the bag are stored on a linked list.
   //   2. The head reference of the list is in the instance variable
   //      head.
   //   3. The total number of elements in the list is in the instance
   //      variable manyNodes.
   private IntNode head;
   private int manyNodes;


   /**
   * Initialize an empty bag.
   * @param - none
   * @postcondition
   *   This bag is empty.
   **/
   public IntLinkedBag( )
   {
      head = null;
      manyNodes = 0;
   }


   /**
   * Generate a copy of the given bag.
   * @param - original
   *     Bag to be copied. Subsequent changes to the copy
   *     will not affect this original, nor vice versa.
   **/
   public IntLinkedBag(IntLinkedBag original)
   {
      this.head = null;
      this.manyNodes = 0;
      this.addAll( original );
   }


   /**
   * Determine the number of elements in this bag.
   * @param - none
   * @return
   *   the number of elements in this bag
   **/
   public int size( )
   {
      return manyNodes;
   }



   /**
   * Add a new element to this bag.
   * @param element
   *   the new element that is being added
   * @postcondition
   *   A new copy of the element has been added to this bag.
   * @exception OutOfMemoryError
   *   Indicates insufficient memory a new IntNode.
   **/
   public void add(int element)
   {
      head = new IntNode(element, head);
      manyNodes++;
   }


   /**
   * Add the contents of another bag to this bag.
   * @param addend
   *   a bag whose contents will be added to this bag
   * @precondition
   *   The parameter, addend, is not null.
   * @postcondition
   *   The elements from addend have been added to this bag.
   **/
   public void addAll(IntLinkedBag addend)
   {
      for (IntNode cursor = addend.head; cursor != null; cursor = cursor.getLink())
      {
         add( cursor.getData() );
      }
   }


   /**
   * Add new elements to this bag. If the new elements would take this
   * bag beyond its current capacity, then the capacity is increased
   * before adding the new elements.
   * @param elements
   *   (a variable-arity argument)
   *   one or more new elements that are being inserted
   * @postcondition
   *   A new copy of the element has been added to this bag.
   **/
   public void addMany(int... elements)
   {
      for (int i : elements)
      {
         add( i );
      }
   }


   /**
   * Remove one copy of a specified element from this bag.
   * @param target
   *   the element to remove from the bag
   * @postcondition
   *   If target was found in the bag, then one copy of
   *   target has been removed and the method returns true.
   *   Otherwise the bag remains unchanged and the method returns false.
   **/
   public boolean remove(int target)
   {
      boolean answer = false;
      for (IntNode cursor = this.head; cursor != null; cursor = cursor.getLink())
      {
         if ( target == cursor.getData() )
         {
            cursor.setData( head.getData() ); // copy the head node's data into this node
            head = head.getLink();            // remove the head node
            manyNodes--;
            answer = true;
            break;
         }
      }
      return answer;
   }



   /**
   * Accessor method to count the number of occurrences of a particular element
   * in this bag.
   * @param target
   *   the element that needs to be counted
   * @return
   *   the number of times that target occurs in this bag
   **/
   public int countOccurrences(int target)
   {
      int answer = 0;
      IntNode cursor = head;
      while (cursor != null)
      {
         if ( target == cursor.getData() )
         {
            answer++;
         }
         cursor = cursor.getLink( );
      }
      return answer;
   }


   /**
   * Create a new bag that contains all the elements from this bag and another bag.
   * @param b
   *   the other of two bags
   * @precondition
   *   Neither b is not null.
   * @return
   *   the union of this bag and b
   **/
   public IntLinkedBag union(IntLinkedBag b)
   {
      // use the copy constructor
      IntLinkedBag answer = new IntLinkedBag(this);

      // use addAll()
      answer.addAll(b);

      return answer;
   }

}

