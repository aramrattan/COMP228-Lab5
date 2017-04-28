import java.util.ArrayList;
import java.util.concurrent.RecursiveAction;

public class Stream extends RecursiveAction {

    final int CPUCOUNT = Runtime.getRuntime().availableProcessors();
    final long intiNum; 
    final long MINTASKSIZE;
    long start;
    long end;
    long forSplit;
 
    Stream(long numToFactor, long MINTASKSIZE,long TASKSIZE, long startPoint, long endPoint) {
       this.intiNum = numToFactor; 
    	this.MINTASKSIZE = MINTASKSIZE; 
    	this.forSplit = TASKSIZE;
        this.start = startPoint;
        this.end = endPoint;
    }
    
    protected void compute() {
        if (end - start +1 <= MINTASKSIZE) {
      
            //System.out.println("Run already! "+":" + (end - start + 1) + ":" + start +":" + end);
            for(long i = start; i <= end; i++) {
                new Calc().factor(MINTASKSIZE, i);

        	

               
            }
        } else {


        	long middle = (start + end)/ 2;
            invokeAll(new Stream(intiNum,MINTASKSIZE,forSplit, start,middle),
                    new Stream(intiNum,MINTASKSIZE,forSplit, middle+1, end));
            

        }

    }
}