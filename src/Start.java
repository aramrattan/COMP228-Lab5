import java.awt.List;
import java.util.ArrayList;
import java.util.concurrent.ForkJoinPool;

public class Start {
    public static void main(String[] args) {
    	final long BIGNUMBER = 25478965412345312L;
    	final long TASKSIZE = (long) Math.floor(Math.sqrt((double)BIGNUMBER));
    	int streamNum=2;
    	ArrayList times = new ArrayList();
    while(streamNum<=16)
    {
        Long beginT = System.nanoTime();
        
        ForkJoinPool fjp = new ForkJoinPool();
        Stream task = new Stream(BIGNUMBER, (TASKSIZE/streamNum) +1, TASKSIZE,1, TASKSIZE);
        fjp.invoke(task);
    
        
       Long endT = System.nanoTime();
        Long timebetweenStartEnd = endT - beginT;
        times.add(timebetweenStartEnd/1E9);
        streamNum*=2;
    }
    
    	for (int i=0; i<times.size(); i++)
    	{
    		int tasknum = i+1;
    		System.out.println("Task " + tasknum + " : " + times.get(i));
    	}
    }

}