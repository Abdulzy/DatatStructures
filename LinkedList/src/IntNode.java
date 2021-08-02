/******************************************************************************
* An IntNode provides a node for a linked list with
* integer data in each node.
*
******************************************************************************/
public class IntNode
{
   // Invariant of the IntNode class:
   //   1. The node's integer data is in the instance variable data.
   //   2. For the final node of a list, the link part is null.
   //      Otherwise, the link part is a reference to the
   //      next node of the list.
   private int data;
   private IntNode link;


   /**
   * Initialize a node with a specified initial data and link to the next
   * node. Note that the initialLink may be the null reference,
   * which indicates that the new node has nothing after it.
   * @param initialData
   *   the initial data of this new node
   * @param initialLink
   *   a reference to the node after this new node--this reference may be null
   *   to indicate that there is no node after this new node.
   * @postcondition
   *   This node contains the specified data and link to the next node.
   **/
   public IntNode(int initialData, IntNode initialLink)
   {
      data = initialData;
      link = initialLink;
   }


   /**
   * Accessor method to get the data from this node.
   * @param - none
   * @return
   *   the data from this node
   **/
   public int getData( )
   {
      return data;
   }


   /**
   * Accessor method to get a reference to the next node after this node.
   * @param - none
   * @return
   *   a reference to the node after this node (or the null reference if there
   *   is nothing after this node)
   **/
   public IntNode getLink( )
   {
      return link;
   }


   /**
   * Modification method to set the data in this node.
   * @param newData
   *   the new data to place in this node
   * @postcondition
   *   The data of this node has been set to newData.
   **/
   public void setData(int newData)
   {
      data = newData;
   }


   /**
   * Modification method to set the link to the next node after this node.
   * @param newLink
   *   a reference to the node that should appear after this node in the linked
   *   list (or the null reference if there is no node after this node)
   * @postcondition
   *   The link to the node after this node has been set to newLink.
   *   Any other node (that used to be in this link) is no longer connected to
   *   this node.
   **/
   public void setLink(IntNode newLink)
   {
      link = newLink;
   }
}
