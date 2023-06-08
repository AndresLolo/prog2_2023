
import Entities.Tweet;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import uy.edu.um.prog2.adt.MyLinkedList.*;

import java.io.FileReader;
import java.io.IOException;

public class CVSreader {
        static MyList<Tweet> tweets = new LinkedList<>();
        public static void cargardatos(){
            try (CSVParser parser = new CSVParser(new FileReader("Obliogatorio/src/f1_dataset_test.csv"), CSVFormat.DEFAULT)) {
                for (CSVRecord record : parser) {
                    long id = 0;
                    String contenidoTweet = record.get(10);
                    String numero = record.get(0);
                    String user = record.get(1);
                    if (numero.equals("")) {
                    } else {
                        id = Long.parseLong(numero);
                    }
                    String col14 = record.get(13);
                    boolean valor;
                    if (col14.contains("True")) {
                        valor = true;
                    } else {
                        valor = false;
                    }
                    Tweet newtweet = new Tweet(id, contenidoTweet, user, valor);
                    tweets.add(newtweet);
                }

            } catch (IOException e) {
                e.printStackTrace();
            }

        }
        public static int encontrartweet(String frase){
            int cantidad = 0;
            for(int i = 0; i < tweets.size(); i++){
                if (tweets.get(i).getContent().contains(frase)){
                    cantidad++;
                }
            }
            return cantidad;
        }

        public static void main(String[] args) {



            }
            }




