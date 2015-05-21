package interfaces.pools.esgi.com;

/**
 * Created by madalien on 21/05/15.
 */
public interface IPool {
    public void addJob(Runnable job);
    public Runnable nextJob();
}
