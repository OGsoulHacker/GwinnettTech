package hello;
import java.util.Arrays;
import java.util.HashSet;
import java.util.PriorityQueue;


/*Perform set operations on priority queues
 ==========================================
    > Create 2 priority queues
        * {"George", "Jim", "John", "Blake", "Kevin", "Michael"}
        * {"Katie", "Kevin", "Michelle", "Ryan"}
    > Find their:
        * Union
        * Intersection
        * Difference
*/
//============================================================================================================
public class SetOperationsPriorityQueues {
        public static void main(String[] args) {
            // Create two priority queues
            PriorityQueue<String> queue1 = new PriorityQueue<>(Arrays.asList(
                    "George", "Jim", "John", "Blake", "Kevin", "Michael"));

            PriorityQueue<String> queue2 = new PriorityQueue<>(Arrays.asList(
                    "George", "Katie", "Kevin", "Michelle", "Ryan"));

            // Display the two sets for union, difference, and intersection
            System.out.println("Set 1: " + queue1);
            System.out.println("Set 2: " + queue2);
            System.out.println("Union: " + findUnion(queue1, queue2));
            System.out.println("Difference: " + findDifference(queue1, queue2));
            System.out.println("Intersection: " + findIntersection(queue1, queue2));

            // Initialize hashSet
            HashSet<String> hashSet = new HashSet<>();
        }

        // Method for calculating union
        public static <E> PriorityQueue<E> findUnion(PriorityQueue<E> queue1, PriorityQueue<E> queue2) {
            PriorityQueue<E> union = new PriorityQueue<>(queue1);
            union.addAll(queue2);
            return union;
        }

        //Method for calculating difference
        public static <E> PriorityQueue<E> findDifference(PriorityQueue<E> queue1, PriorityQueue<E> queue2) {
            PriorityQueue<E> difference = new PriorityQueue<>(queue1);
            difference.removeAll(queue2);
            //close but not quite.
            //The difference queue also needs to include the elements that are in queue2
            // but NOT in queue1. To do this,
            // 1) make a 4th queue that contains the intersection of both queue1 and queue2.
            // 2) Add all of queue2's elements to the difference queue.
            // 3) Use the intersection queue instead of queue2 as the parameter in difference.removeAll()
            return difference;
        }

        //Method for calculating intersection
        public static <E> PriorityQueue<E> findIntersection(PriorityQueue<E> queue1, PriorityQueue<E> queue2) {
            PriorityQueue<E> intersection = new PriorityQueue<>(queue1);
            intersection.retainAll(queue2);
            return intersection;
        }
    }