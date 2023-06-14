
import Entities.*;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import uy.edu.um.prog2.adt.MyLinkedList.*;

import uy.edu.um.prog2.adt.Hash.*;

import java.io.FileReader;
import java.io.IOException;


public class CVSreader {
    static MyList<Tweet> tweets = new LinkedList<>();
    static MyHash hashtag = new HashImpl<>(100000);
    static MyHash<Long, User> usuarios = new HashImpl<>(100000);

    public static void cargardatos() {
        try (CSVParser parser = new CSVParser(new FileReader("Obliogatorio/src/f1_dataset_test.csv"), CSVFormat.DEFAULT)) {
            parser.iterator().next();
            for (CSVRecord record : parser) {

                String contenidoTweet = record.get(10);
                String user = record.get(1);
                String fecha = record.get(9);
                long idtweet = idUnico(fecha);
                String fechaCreado = record.get(4);
                long idUser = idUnico(fechaCreado);
                String nombre = record.get(2);

                boolean isretweet;
                try {
                    isretweet = Boolean.parseBoolean(record.get(13));
                } catch (NumberFormatException e) {
                    continue;
                }
                String[] hashtag1 = record.get(11).replace("[", "").replace("]", "").replace("'", "").replace(" ", "").split(",");
                MyList<HashTag> listahashtag = new LinkedList<>();
                for (String hashtag3 : hashtag1) {
                    listahashtag.add(new HashTag(hashtag3, hashtag3));
                    hashtag.put(hashtag3, new HashTag(hashtag3, hashtag3));
                }

                Tweet newtweet = new Tweet(idtweet, contenidoTweet, user, fecha, isretweet, listahashtag);
                tweets.add(newtweet);
                if (!usuarios.contains(idUser)) {
                    User usuarioTemp = new User(idUser, nombre);
                    usuarios.put(usuarioTemp.getId(), usuarioTemp);
                    usuarioTemp.puttweet(newtweet);

                }


            }
            System.out.println("Tweet"+tweets.size());
            System.out.println("Usuario"+usuarios.size());
            System.out.println("Hashtag"+hashtag.size());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Long idUnico(String fecha) {
        // Aplicar función hash a la cadena para obtener un valor único
        int hash = fecha.hashCode();
        // Convertir el valor único a un valor positivo
        int hashPositivo = Math.abs(hash);
        return (long) hashPositivo;

    }
    public static int contarDistintos(String palabra) {
        int contador = 0;
        for (int i = 0; i < tweets.size(); i++) {
            if (tweets.get(i).getContent().contains(palabra)) {
                contador++;
            }
        }
        return contador;
    }


}








