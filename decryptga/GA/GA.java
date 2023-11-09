package GA;

import java.io.*;
import java.util.*;

import GA.popContainer;


//encrypt, decrypt, and fitness were taken from the
public class GA {

    String text;
    int popLength;

    public GA ( ) {

        //The filepath for both files
        // "decryptga/GA/Data1.txt"
        // "decryptga/GA/Data2.txt"

    //  int popLength = (int) readKeyLength("decryptga/GA/Data1.txt");

    popLength = readKeyLength("decryptga/GA/Data1.txt");
    String inputTextStream =  readTextFile("decryptga/GA/Data1.txt");
   

    doGA(10, popLength, inputTextStream);
    //System.out.println(fitness(thetext, inputTextStream));
    
    
    }

    // this will implement the complete GA Algorithm
    public void doGA(int popSize, int popLength, String inputText){

        // initialize the population 

        //String[] keyPopulationContainer = new String[popSize];

        // evaluate all individuals instering the key with the fitness score into custom object popContainer and putting the objects into an array
        popContainer[] keyAndScoreContainer = new popContainer[popLength];

        for (int i = 0; i < popSize; i++) {

            String key = generateCharArr(popLength); // fill every element of rand gen String of letters - this is our initial pop of "keys"
            double fitnessScore = Evaluation.fitness(key, inputText);
        
            popContainer keyAndScoreHolder = new popContainer(key, fitnessScore);

            keyAndScoreContainer[i] = keyAndScoreHolder;

            System.out.println(keyAndScoreHolder.toString());

        }

        // start loop

        int limit = 10;
        int generationNum = 0;

            // set a condition for generation loop to keep cycling
            for (int j = 0 ; j <= limit; j++){

            // increase generation number

                generationNum ++;


            

            // do selection algorithm

            // mutate mated population

            // evaluate new individuals


                }



    }

    // this method will take in an element and apply a mutation to it
    public String mutateElement(String element){

        // Convert string into a char array in order to apply changes easier
        element = "Hello, World!";
        char[] elementArray = element.toCharArray();


        // we will utilize reciprocal exchange and swap two cities

        String tempHolder;
        int randomIndex = (int)Math.floor(Math.random() * (popLength - 0 + 1) + 0);


        //tempHolder = elementArray[randomIndex];


        
        // convert back into a string to be returned
        String mutatedElement = new String(elementArray);
        return mutatedElement;
    }


    // this will build a string of the given size of random lowercase roman alphabet chars
    public static String generateCharArr(int arrSize) {
        String rand = new String();
        for (int i = 0; i <= arrSize-1; i++) {
            Random r = new Random();
            char c = (char) (r.nextInt(26) + 'a');
            rand = rand + c;

        }
        return rand;
    }

    // read the textfile, returns the key length
    public int readKeyLength(String filePath) {

        int key = 0;

        StringBuilder line = new StringBuilder();

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            // Read the first line from the file
            line.append(reader.readLine());
        } catch (IOException e) {
            // Handle file reading errors
            System.err.println("Error reading the file: " + e.getMessage());
        }

        // Store the imported line in the 'text' variable
        this.text = line.toString();

        try {
            key = Integer.parseInt(text);
            
        } catch (NumberFormatException e) {
            System.out.println("Invalid input. Cannot convert the string to an integer.");
        }
    
        return key; 
}

    // read the textfile, returns the key length
    public String readTextFile(String filePath) {
    StringBuilder content = new StringBuilder();

    try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
        // Skip the first line (containing the integer)
        reader.readLine();

        String line;
        while ((line = reader.readLine()) != null) {
            // Remove non-alphabetic characters and append the rest to the content
            content.append(line.replaceAll("[^a-zA-Z]", ""));
        }
    } catch (IOException e) {
        e.printStackTrace(); // Handle the exception according to your requirements
    }

    return content.toString();
}


      public static void main ( String[] args ) { GA s = new GA(); }

} // Turtle
