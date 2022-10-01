import java.io.*;
import java.util.*;

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

    public static void writeArrayToFile(int[] array, String fileName) {
        try {
            FileWriter fileWriter = new FileWriter(fileName);
            for (int a : array) {
                fileWriter.write(a + "\n");
                fileWriter.flush();
            }
            fileWriter.close();

        } catch (IOException e) {
            System.out.println("Encountered an error while writing to file");
            e.printStackTrace();
        }
    }

    public static int[] readArrayFromFile(String fileName) throws FileNotFoundException {
        File file = new File(fileName);
        Scanner scanner = new Scanner(file);
        ArrayList arrayList = new ArrayList<>();
        while (scanner.hasNextLine()) {
            String str = scanner.nextLine();
            int a = Integer.parseInt(str);
            arrayList.add(a);
        }
        scanner.close();

        int[] array = new int[arrayList.size()];
        for (int i = 0; i < arrayList.size(); i++) {
            array[i] = (int) arrayList.get(i);
        }
        return array;
    }

    public static String bubbleSort(int[] array) {
        for (int i = array.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
        return Arrays.toString(array);
    }

    public static void main(String[] args) throws Exception {
        System.out.println("Welcome to Bubble Sort");
        while (true) {
            System.out.println("1) Sort random array\n2) Type array to sort\n3) Exit");
            Scanner scanner = new Scanner(System.in);
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    int arrayLength;
                    System.out.println("Enter array length");
                    arrayLength = scanner.nextInt();
                    int[] array = createRandomArray(arrayLength);
                    String fileName = "integers.txt";
                    System.out.print("Random Array:  ");
                    printArray(array);
                    writeArrayToFile(array, fileName);
                    array = readArrayFromFile(fileName);
                    String sortedArray = bubbleSort(array);
                    System.out.println("Sorted Array:  " + sortedArray);
                    writeArrayToFile(array, "sorted.txt");
                    System.out.println("Sorted array written to file.");
                    break;
                case 2:
                    System.out.println("Enter array length");
                    arrayLength = scanner.nextInt();
                    array = new int[arrayLength];
                    System.out.print("Enter array elements one at a time and press enter:  ");
                    for (int i = 0; i < arrayLength; i++) {
                        array[i] = scanner.nextInt();
                    }
                    bubbleSort(array);
                    printArray(array);
                    break;
                case 3:
                    System.out.print("Goodbye");
                    System.exit(0);
                    break;

            }
        }
    }
}
