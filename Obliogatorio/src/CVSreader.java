
import Entities.*;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import uy.edu.um.prog2.adt.MyLinkedList.*;
import uy.edu.um.prog2.adt.queue.*;

import uy.edu.um.prog2.adt.Hash.*;

import java.io.FileReader;
import java.io.IOException;


public class CVSreader {
    static MyList<Tweet> tweets = new LinkedList<>();
    static MyHash hashtag = new HashImpl<>(100000);
    static MyHash<Long, User> usuarios = new HashImpl<>(100000);
    static int canttweets = 0;
    static MyList <String> Contenido = new LinkedList<>();
    public static MyList<User> usuarioslista = new LinkedList<>();

    public static void cargardatos() {
        try (CSVParser parser = new CSVParser(new FileReader("Obliogatorio/src/f1_dataset_test.csv"), CSVFormat.DEFAULT)) {
            parser.iterator().next();
            for (CSVRecord record : parser) {

                String contenidoTweet = record.get(10);
                String fecha = record.get(9);
                long idtweet = idUnico(fecha);
                String fechaCreado = record.get(4);
                long idUser = idUnico(fechaCreado);
                String nombre = record.get(1);
                String source = record.get(12);

                boolean isretweet;
                try {
                    isretweet = Boolean.parseBoolean(record.get(13));
                } catch (NumberFormatException e) {
                    continue;
                }
                boolean verificado;
                try {
                    verificado = Boolean.parseBoolean(record.get(8));
                } catch (NumberFormatException e) {
                    continue;
                }

                //Hashtags
                String[] hashtag1 = record.get(11).replace("[", "").replace("]", "").replace("'", "").replace(" ", "").split(",");
                MyList<HashTag> listahashtag = new LinkedList<>();
                for (String hashtag3 : hashtag1) {
                    listahashtag.add(new HashTag(hashtag3, hashtag3));
                    hashtag.put(hashtag3, new HashTag(hashtag3, hashtag3));
                }
                //contenido
                Contenido.add(contenidoTweet);

                //tweets
                Tweet newtweet = new Tweet(idtweet, contenidoTweet,source , fecha, isretweet, listahashtag);
                tweets.add(newtweet);
                canttweets++;

                //usuarios
                if (!usuarios.contains(idUser)) {
                    User usuarioTemp = new User(idUser, nombre, verificado);
                    usuarios.put(usuarioTemp.getId(), usuarioTemp);
                    usuarioTemp.puttweet(newtweet);
                    usuarioslista.add(usuarioTemp);
                }
                else {
                    usuarios.get(idUser).puttweet(newtweet);
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

    //Funcion 6- 10 segundos
    public static int contarDistintos(String palabra) {
        int contador = 0;
        for (int i = 0; i < canttweets; i++) {
            if (Contenido.get(i).contains(palabra)) {
                contador++;
            }
        }
        return contador;
    }

    //Hashtag más usado para un día dado, sin tener en cuenta #f1. El día será ingresado en el formato YYYY-MM-DD.
    //Funcion 4- 30 segundos
    public static String hashMasUsado(String fecha){
        int contador = 0;
        String hashtag = "";
        for (int i = 0; i < canttweets; i++) {
            if (tweets.get(i).getFecha().contains(fecha)) {
                for (int j = 0; j < tweets.get(i).getHashTags().size(); j++) {
                    if (tweets.get(i).getHashTags().get(j).getText().contains("f1") || tweets.get(i).getHashTags().get(j).getText().contains("F1")) {
                        continue;
                    }
                    if (tweets.get(i).getHashTags().get(j).getText().contains(hashtag)) {
                        contador++;
                    }
                    if (contador > 0) {
                        hashtag = tweets.get(i).getHashTags().get(j).getText();
                    }
                }
            }
        }
        return hashtag+" "+contador;
    }

    //Cantidad de hashtags distintos para un día dado. me tiene que dar un numero de cuantos hashtags distintos hay en un dia
    //Funcion 3 - 25 segundos
    public static int cantHashtag(String fecha) {
        int contador = 0;
        MyList<String> listahashtag = new LinkedList<>();
        for (int i = 0; i < canttweets; i++) {
            if (tweets.get(i).getFecha().contains(fecha)) {
                for (int j = 0; j < tweets.get(i).getHashTags().size(); j++) {
                    if (!listahashtag.contains(tweets.get(i).getHashTags().get(j).getText())) {
                        listahashtag.add(tweets.get(i).getHashTags().get(j).getText());
                        contador++;
                    }
                }

            }
        }
        return contador;
    }

    //Funcion 2- 5 segundos
    public static void usuariosConMasTweets() throws QueueVacia {
        MyPrioridadQueue<User> usuariosMasTweets = new LinkedList<>();
        for (int i = 0; i <usuarioslista.size() ; i++) {
            User usuario = usuarioslista.get(i);
            int prioridad=usuario.getCantidadTweets();
            usuariosMasTweets.enqueueConPrioridad(usuario,prioridad);

        }
        for (int i=0;i<15;i++){
            User usuarionuevo=usuariosMasTweets.dequeue();
            int cantidad=usuarionuevo.getCantidadTweets();
            String nombre=usuarionuevo.getName();
            String verificado;
            if (usuarionuevo.isVerificado()){
                verificado="Si";
            }
            else{
                verificado="No";
            }
            System.out.println("Nombre: "+nombre+" //Cantidad de tweets: "+cantidad+" //Verificado: "+verificado);
        }
    }


}








