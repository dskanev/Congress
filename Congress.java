import java.nio.charset.StandardCharsets;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;


import com.oracle.tools.packager.IOUtils;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.*;


/*
	denk@itu.dk
	with the help of http://www.java2s.com/Tutorials/Java/Java_Collection/0170__Java_Priority_Queues.htm
*/

public class Congress {
	
	
	public static void main(String[] args) {
		for (String s: args) {
			System.out.println(s);
		}

		//split the input into an array of strings, then parse it into State objects (except the first 2 lines)
		Scanner input = new Scanner(System.in);

		String[] linesOfInput = StdIn.readAll().split("\\n");
		for(String s : linesOfInput){
			System.out.println(s);
		}
        int numberOfStates = Integer.parseInt(linesOfInput[0]);                             
        int availableSeats = Integer.parseInt(linesOfInput[1]);     
         
        PriorityQueue<State> pq = new PriorityQueue<>();
 
        for(int i=0; i<linesOfInput.length; i++) {
            if(linesOfInput[i].matches("\\D*")){
                pq.add(new State(linesOfInput[i], Integer.parseInt(linesOfInput[i+1])));
            }
        }
         
        availableSeats = availableSeats - numberOfStates; 
		
		//get the highest priority State and increment its seats by 1, decrement the available seats and readd the state to the queue
		while(availableSeats > 0) {
			State highestPriority = pq.poll();											
			highestPriority.addSeat();										
			availableSeats = availableSeats - 1;														
			pq.add(highestPriority);														
		}
		
		//print the states and their seats until the queue is empty
		while(!pq.isEmpty()) {
			State state = pq.poll();
			StdOut.println(state.getName() + " " + state.getSeats());			
		}
	}
}