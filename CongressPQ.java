


/*
	denk@itu.dk
	with the help of http://www.java2s.com/Tutorials/Java/Java_Collection/0170__Java_Priority_Queues.htm
*/





import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

public class CongressPQ {


    public static void main(String[] args) {

        for (String s: args) {
            System.out.println(s);
        }
        //split the input into an array of strings, then parse it into State objects (except the first 2 lines)
        Scanner input = new Scanner(System.in);
        System.out.println("Please enter path: ");
        String pth = input.nextLine();
        System.out.println("Please enter filename: ");
        String fileName = input.nextLine();

        Path argument = Paths.get(pth, fileName);
        Charset charset = Charset.forName("ISO-8859-1");
        try {
            String[] lines = Files.readAllLines(argument, charset).toArray(new String[0]);
            int numberOfStates = Integer.parseInt(lines[0]);
            int availableSeats = Integer.parseInt(lines[1]);

            PriorityQueue<State> pq = new PriorityQueue<>();

            for(int i=0; i<lines.length; i++) {
                if(lines[i].matches("\\D*")){
                    pq.add(new State(lines[i], Integer.parseInt(lines[i+1])));
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
                System.out.println(state.getName() + " " + state.getSeats());
            }



        } catch (IOException e) {
            System.out.println(e);
        }

    }
}


