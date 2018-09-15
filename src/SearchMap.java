import java.io.*;
import java.util.HashMap;
import java.util.Scanner;

public class SearchMap {

    private static void ReadAndParseFile(String FileName,HashMap<String,Vertex> nodes){
        StringBuilder sb = new StringBuilder();
        try {
            Scanner sc = new Scanner(new File(FileName));

            String origin = sc.nextLine();
            nodes.put(origin,new Vertex(origin));

            while(sc.hasNextLine()){
                String curr = sc.nextLine();
                String[] data = curr.split(" ");

                String currOrigin = data[0];
                String currDestination = data[1];
                double currAmount = Double.parseDouble(data[2]);

                if(nodes.containsKey(currOrigin)){
                    Vertex currVertex = nodes.get(currOrigin);
                    currVertex.getEdges().put(
                            currDestination,
                            currAmount
                    );

                }else{
                    Vertex currVertex = new Vertex(currOrigin);
                    currVertex.getEdges().put(
                            currDestination,
                            currAmount
                    );
                }
            }
            sc.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private static void WriteToFile(String Filename, String data){

    }

    public static void main(String [] args){
        String inputFile = "";
        String outputFile = "";

        HashMap<String,Vertex> map = new HashMap<>();
        if(args.length !=2){
            System.out.println("Error: Please enter correct command line inputs");
            System.exit(0);
        }
        inputFile = args[0];
        outputFile = args[1];

        ReadAndParseFile(inputFile,map);


    }




}
