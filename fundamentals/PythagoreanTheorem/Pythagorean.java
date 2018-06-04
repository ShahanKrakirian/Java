import java.lang.Math;
public class Pythagorean {
    public String calculateHypotenuse(int legA, int legB){ 
        double sumsquares = (legA * legA) + (legB * legB);
        double hypot = Math.sqrt(sumsquares);
        return hypot;
    }
}