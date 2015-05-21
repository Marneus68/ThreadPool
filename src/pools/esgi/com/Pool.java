package pools.esgi.com;

import circular.esgi.com.CIrcularFifo;
import circular.esgi.com.Node;
import interfaces.pools.esgi.com.IPool;

import java.util.ArrayList;

/**
 * Created by madalien on 21/05/15.
 */
public class Pool implements IPool {

    private int numberOfWorkers;
    private ArrayList<Worker> workers;
    private CIrcularFifo threadPool;
    private Object monitor;

    public Pool(int poolSize){
        super();

        monitor = new Object();
        numberOfWorkers = poolSize;
        threadPool = new CIrcularFifo();

        workers = new ArrayList<Worker>(numberOfWorkers);
        for (int i=0; i<numberOfWorkers; i++){
            Worker w = new Worker(this);
            workers.add(w);
            w.start();
        }
    }

    @Override
    public void addJob(Runnable job) {
        synchronized (monitor) {
            threadPool.insert(new Node(job));
            monitor.notify();
        }
    }

    @Override
    public Runnable nextJob() {
        synchronized (monitor) {
            try{
                if(0 == threadPool.getSize()){
                    monitor.wait();
                }
            }
            catch(InterruptedException e){
                System.out.println("failed to get the next job in thread pool");
                e.printStackTrace();
                return null;
            }
            return threadPool.get().job;
        }
    }

}

