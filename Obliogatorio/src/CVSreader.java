
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import java.io.FileReader;
import java.io.IOException;
public class CVSreader {

        public static void main(String[] args) {
            try (CSVParser parser = new CSVParser(new FileReader("/Users/alolo/Library/CloudStorage/OneDrive-UniversidaddeMontevideo/obligatorio2023/f1_dataset_test.csv"), CSVFormat.DEFAULT)) {
                for (CSVRecord record : parser) {
                    String col1 = record.get(0);
                    String col2 = record.get(1);
                    String col3 = record.get(2);
                    String col4 = record.get(3);
                    String col5 = record.get(4);
                    String col6 = record.get(5);
                    String col7 = record.get(6);
                    String col8 = record.get(7);
                    String col9 = record.get(8);
                    String col10 = record.get(9);
                    String col11 = record.get(10);
                    String col12 = record.get(11);
                    String col13 = record.get(12);
                    String col14 = record.get(13);
                    // Procesar las columnas según sea necesario
                    if (col3.equals("Uruguay")) {
                        System.out.println("Columna 1: " + col1);
                        System.out.println("Columna 2: " + col2);
                        System.out.println("Columna 3: " + col3);
                        System.out.println("Columna 4: " + col4);
                        System.out.println("Columna 5: " + col5);
                        System.out.println("Columna 6: " + col6);
                        System.out.println("Columna 7: " + col7);
                        System.out.println("Columna 8: " + col8);
                        System.out.println("Columna 9: " + col9);
                        System.out.println("Columna 10: " + col10);
                        System.out.println("Columna 11: " + col11);
                        System.out.println("Columna 12: " + col12);
                        System.out.println("Columna 13: " + col13);
                        System.out.println("Columna 14: " + col14);
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            }
        }


