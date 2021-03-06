/** 
 *  @author Josh Hug
 */

/* Methods can ALSO have formal type parameters.
 * We specifiy such paramters RIGHT BEFORE the return type of the method. 
 * Such a method is called a generic method. */

public class VesselHelper {
    
    /** Destroy the contents of v, and return what was
      * once there. */
    public static <Jabberwocky> Jabberwocky remove(Vessel<Jabberwocky> v) {
        Jabberwocky returnValue = v.peek();
        v.put(null);
        return returnValue;
    }

    public static <Plarp extends Comparable<Plarp>> Plarp max(Vessel<Plarp> v1, Vessel<Plarp> v2) {
        Plarp v1val = v1.peek();
        Plarp v2val = v2.peek();
        if (v1val.compareTo(v2val) > 0) {
            return v1val;
        }
        return v2val;
    }

    /* ratio is trickier */

    /* Approach below will not work unless you pass EXACTLY a Vessel<Number>.
     * For example, we could not pass in a Vessel<Integer>, because a 
     * a Vessel<Integer> is-not-a Vessel<Number>. */
    /*public static double ratio(Vessel<Number> v1, Vessel<Number> v2) {
        double d1 = v1.peek().doubleValue();
        double d2 = v2.peek().doubleValue();
        return d1 / d2;
    }    */


    /** The preferred approach. */
    public static double ratio(Vessel<? extends Number> x, Vessel<? extends Number> y) {
        Number xVal = x.peek(); // assignment allowed since ? is-a Number, 
        Number yVal = y.peek(); // even though we don't know what ? is.
        return xVal.doubleValue() / yVal.doubleValue();
    }

    /*
    This approach also works, but is a little more verbose than the version above.

    Either approach is fine on project 1.

    public static <T1 extends Number, T2 extends Number> 
    double ratio(Vessel<T1> x, Vessel<T2> y) {
        T1 xVal = x.peek();
        T2 yVal = y.peek();
        return xVal.doubleValue() / yVal.doubleValue();
    }
    */

} 