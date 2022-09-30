import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class BubbleSort {

    public static void printArray(int[] array) {
        for (int a : array) {
            System.out.print(a + " ");
        }
        System.out.println();
    }

    public static int[] createRandomArray(int arrayLength) {
        int[] array = new int[arrayLength];
        Random random = new Random();
        for (int i = 0; i < arrayLength; i++) {
            array[i] = random.nextInt(100);
        }
        return array;
    }

    public static void writeArrayToFile(int[] array, String fileName){
        try  {
        FileWriter fileWriter = new FileWriter(fileName);
        for (int a : array) {
            fileWriter.write(a + "\n");
            fileWriter.flush();
        }
        fileWriter.close();
        
    }
        catch(IOException e){
            System.out.println("Encountered an error while writing to file");
            e.printStackTrace();
        }
    }

    public static int[] readArrayFromFile(String fileName) throws FileNotFoundException{
        File file = new File(fileName);
        Scanner scanner = new Scanner(file);
        ArrayList arrayList = new ArrayList<>();
        while (scanner.hasNextLine()){
            String str = scanner.nextLine();
            int a = Integer.parseInt(str);
            arrayList.add(a);
        }
        scanner.close();

        int[] array = new int[arrayList.size()];
        for (int i = 0; i < arrayList.size(); i++){
            array[i] = (int) arrayList.get(i);
        }
        return array;
    }

    public static void bubbleSort(int[] array) {
        for (int i = array.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                } 
            }
        }
    }

    public static void main(String[] args) throws Exception {

        int arrayLength = 5;
        int[] array = createRandomArray(arrayLength);
        String fileName = "integers.txt";

        printArray(array);
        writeArrayToFile(array, fileName);

        array = readArrayFromFile(fileName);
        bubbleSort(array);

        writeArrayToFile(array, "sorted.txt");
    }
}
