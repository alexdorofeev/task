package test;

/**
 * Created by Dorofeev on 4/8/2016.
 */
public class Filter {
    private long time = System.currentTimeMillis();
    private long limitTime;
    private int limiN;
    private int count = 0;

    public Filter(int n, long limitTime){
        this.limitTime = limitTime;
        this.limiN = n;
    }
    public boolean isSignalAllowed() {
        if (((System.currentTimeMillis() - time) > limitTime)) {
            time = System.currentTimeMillis();
            count = 0;
        }
        if(count < limiN){
            count++;
            return true;
        }
        return false;
    }
}
