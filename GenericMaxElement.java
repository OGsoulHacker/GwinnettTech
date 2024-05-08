package hello;
/* Generic Maximum Element in an Array
    > Implement the following method that returns the maximum element in an array
        public static <E extends Comparable<E>> E max(E[] list)
*/
public class GenericMaxElement {
    public static void main(String[] args) {
        System.out.println( max( new Double[]{1.1,2.2,3.3} ));
    }
    public static <E extends Comparable<E>> E max(E[] list){
        if (list.length == 0)
            return null;
        E max = list[0];
        for (int i = 1; i < list.length; i++) {
            if(list[i] == null ){
                continue;
            }
            if( max == null || !(max.compareTo( list[i] ) > 0 ))
                max = list[i];
        }
        return max;
    }
}
