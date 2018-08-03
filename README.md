# GettingStartedWithMT

This project experiments with testing software by combining mutation testing and metamorphic testing. 

Metamorphic testing establishes metamorphic relations (MRs) between outputs of a program; therefore, it is useful in testing software whose output is unknown.

Mutation testing inserts faults, or mutants, into the code and then checks to see whether or not the provided tests detect the faults. 

In this project, four algorithms are being tested: Insertion Sort, Bubble Sort, Binary Search, and Shortest Path. Open source implementations were found for all four algorithms, with slight modifications and several methods added in. Then, three MRs were brainstormed for each algorithm. These were then coded into metamorphic tests using JUnit. 

Once all of the JUnit tests passed, PITClipse (a PIT testing Eclipse plugin...PIT is mutation testing software) was run on the tests. The initial line coverage was 61%, and the initial mutation coverage was 49%. This goes to show how poor the test coverage was even with a fully passing JUnit run.

By continuing to  edit the code and add in metamorphic and regular tests, the final line coverage increased to 99%, while the mutation coverage increased to 88%.
