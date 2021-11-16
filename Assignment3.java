/** @author Andrew Quach
 *  @version 1.0 Due 11/16/2021
 *  @description This program is designed to create multiple different arrays,
 *  @description find the smallest values in said array, create new arrays based on
 *  @description existing arrays, and compare each other's values.
 */

 import java.io.*;
 import java.util.Scanner;

public class Assignment3 
{
    /*assigns values in output file to array*/
    public static void readData(int [] value1, int [] value2, int y) throws IOException {
        Scanner input = new Scanner (new File("arrayvalues.txt"));
        
        y=input.nextInt();
        for (int i=0; i<y; i++){

        
            value1 [i]=input.nextInt();
            value2 [i]=input.nextInt();
         }
    }
    /* add't array */
    public static void printArray(int [] vals, int lim, PrintWriter otpt) throws IOException {
        for (int i=0; i<lim; i++){
            otpt.print(vals[i]+" ");   }
        otpt.println();
    }       
    /* identify smallest value in array */
    public static int least (int [] arr,int num){
        int least=arr[0];
        for (int i=0; i<num; i++){
            if(arr[i]<least) {
                least=arr[i];
            }
        }
        return least;
        } 
    /* assigning and creating new array based off 2 previous array's sums */
    public static void construct(int x, int [] previous1, int [] previous2, int[] sumarr){
        for (int i=0; i<x; i++) {
            sumarr[i] =previous1[i]+previous2[i];
        }
    }
    /* Compares two arrays to see which value is larger and to what array it originated from */
    public static void whatsHigher(int[] scores1, int[] scores2, int y,PrintWriter otpt) throws IOException {
        int larger1=0;
        int larger2=0;
        int equal=0;

        for (int i=0; i<y; i++) {
            /*score one is higher than score two */
            if (scores1[i]>scores2[i]){
                 otpt.println("In position "+i+", the greater value is in array score1: "
                 +scores1[i]+" is greater than "+scores2[i]);
            larger1++;
            }
            /*score two is higher than score one */
             if (scores1[i]<scores2[i]){
                otpt.println("In position "+i+", the greater value is in array score2: "
                +scores2[i]+" is greater than "+scores1[i]); 
            larger2++;
            }
            /*score one is equal to score two */
            if (scores1[i]==scores2[i]){
                 otpt.println("In position "+i+", the two arrays are equal in value: "
                +scores1[i]);
             equal++;
            }   
        } 
                otpt.println();
                otpt.println("Array score1 was larger "+larger1+" time(s)");
                otpt.println("Array score2 was larger "+larger2+" time(s)");
                otpt.println("The two arrays were equal "+equal+" time(s)");
    }
    
        public static void main (String [] args) throws IOException {
            /*grants access to file to be printed to*/
            Scanner input = new Scanner (new File("arrayvalues.txt"));
        /*creates file to be printed to*/
        PrintWriter output = new PrintWriter (new FileWriter("arrayvalues.txt", true));  
        
        int y=input.nextInt();
        int [] scores1 = new int [50];
        int [] scores2 = new int [50];
        
        readData(scores1,scores2,y);
        
        output.println("Scores for Array 1:");
        printArray(scores1,y,output);
        output.println("Score for Array 2:");
        printArray(scores2,y,output);
        output.println();

        int [] sumscore = new int [50];

        output.println("Array Sum Score:");
        printArray(sumscore,y,output);
        output.println();

        output.println("Smallest Value in Sum of Scores: "+least(sumscore,y));
        output.println();

        whatsHigher(scores1,scores2,y,output);
        
        input.close();
        output.close();
        }
}