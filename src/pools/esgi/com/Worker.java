package pools.esgi.com;

import interfaces.pools.esgi.com.IPool;

/**
 * Created by madalien on 21/05/15.
 */
public class Worker extends Thread{

    private IPool _pool;

    public Worker(IPool pool){
        super();
        _pool = pool;
    }

    @Override
    public void run(){
        while(true){
            _pool.nextJob().run();
        }
    }


}
