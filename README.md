# Congress
An exercise which uses priority queues to solve the following assignment: 

U.S. Congress Apportion. The members of the U.S.
Congress represent the states. There are more seats than
states, in fact, there are 435 and 50 states, so many states receive
more than one seat in Congress. This is how it should
be: California has 33,930,798 residents while Wyoming has
only 495,304, so California ought to receive many more
seats. On the other hand, even though California has almost
70 times as many residents, it would be absurd if it had 70
times as many seats as Wyoming.

Huntington–Hill. Here’s how it’s done, using the Huntington–Hill
method from 1911: First, each state receives a
seat. (In fact, Article 1, Section 2 of the U.S. Constitution requires
that.) Then, as long as there are seats left, we repeat
the following: Give the next seat to the largest state, and
decrease the state’s population by a certain constant. The
exact procedure, including the formula for the constant, can
be found among the links below.

Requirements
Your algorithm must run in time proportional to (m +
n)log m for m states and n seats. (Otherwise the large input
files will indeed take too much time.)

Input Files:
The files 1990-in.txt and 2000-in.txt contain the real-world data for
the 1990 and 2000 U.S. censuses. The corresponding output files are the actual seats computed in the 106th and 108th
congresses. The other files I made up. Files called small-*-in.txt are small instances that are useful for debugging, they
are meant to make your life easier. The files called huge-*-in.txt are fictional population data for planets, the largest of
these distributes the 1 million seats in the galactic senate among 200,000 planets.

Congress.java uses some of the algs4 libraries from Princeton's Algorithms I course, while CongressPQ.java does the same job without them.
