import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
public class CVSreader {

        public static void main(String[] args) {
            String csvFile = "/Users/alolo/Library/CloudStorage/OneDrive-UniversidaddeMontevideo/obligatorio2023/f1_dataset_test.csv";
            String line;
            String csvSplitBy = ",";

            try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
                while ((line = br.readLine()) != null) {
                    String[] data = line.split(csvSplitBy);

                    // Aquí puedes procesar los datos como desees
                    // Por ejemplo, imprimirlos en la consola
                    for (String value : data) {
                        System.out.print(value + " ");
                    }
                    System.out.println();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

