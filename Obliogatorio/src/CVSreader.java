
import Entities.*;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import uy.edu.um.prog2.adt.MyLinkedList.*;
import uy.edu.um.prog2.adt.BinaryTree.*;
import uy.edu.um.prog2.adt.Hash.*;

import java.io.FileReader;
import java.io.IOException;


public class CVSreader {
        static MyList<Tweet> tweets = new LinkedList<>();
        static MyHash hashtag= new HashImpl<>(100000);

        public static void cargardatos() {
            try (CSVParser parser = new CSVParser(new FileReader("Obliogatorio/src/f1_dataset_test.csv"), CSVFormat.DEFAULT)) {
                for (CSVRecord record : parser) {
                    long id = 0;
                    String contenidoTweet = record.get(10);
                    String numero = record.get(0);
                    String user = record.get(1);
                    String fecha = record.get(9);
                    if (numero.equals("")) {
                    } else {
                        id = Long.parseLong(numero);
                    }
                    String col14 = record.get(13);
                    boolean valor;
                    if (col14.equals("True")) {
                        valor = true;
                    } else {
                        valor = false;
                    }
                    String[] hashtag1 = record.get(11).replace("[", "").replace("]", "").replace("'", "").replace(" ", "").split(",");
                    MyList<HashTag> listahashtag = new LinkedList<>();
                    for(String hashtag3 : hashtag1){
                        listahashtag.add(new HashTag(fecha, hashtag3));
                        hashtag.put(hashtag3, new HashTag(fecha, hashtag3));
                    }

                    Tweet newtweet = new Tweet(id, contenidoTweet, user, fecha, valor, listahashtag);
                    tweets.add(newtweet);

                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        public static int cantidadTweets(String palabra){
            int cantidad = 0;
            for (int i = 0; i < tweets.size(); i++) {
                Tweet tweet = tweets.get(i);
                if (tweet.getContent().contains(palabra)) {
                    cantidad++;
                }
            }
            return cantidad;
        }

        //listar los diez pilotos con mas menciones en los tweets en un anio y mes especifico
        public static LinkedList PilotosMencionados(String anio, String mes) {
            int Max = 0;
            int Sergio = 0;
            int Charles = 0;
            int Carlos = 0;
            int Lewis = 0;
            int George = 0;
            int Fernando = 0;
            int Lance = 0;
            int Lando = 0;
            int Oscar = 0;
            int Pierre = 0;
            int Esteban = 0;
            int Nyck = 0;
            int Yuki = 0;
            int Alexander = 0;
            int Logan = 0;
            int Guanyu = 0;
            int Valtteri = 0;
            int Nico = 0;
            int Kevin = 0;

            Tree pilotos = new Tree();

            for (int i = 0; i < tweets.size(); i++) {
                if (tweets.get(i).getFecha().contains(anio) && tweets.get(i).getFecha().contains(mes)) {
                    String content = tweets.get(i).getContent();
                    if (content.contains("Max Verstappen")) {
                        Max++;
                    }

                    if (content.contains("Charles Leclerc")) {
                        Charles++;
                    }
                    if (content.contains("Carlos Sainz")) {
                        Carlos++;
                    }
                    if (content.contains("Lewis Hamilton")) {
                        Lewis++;
                    }
                    if (content.contains("George Russell")) {
                        George++;
                    }
                    if (content.contains("Fernando Alonso")) {
                        Fernando++;
                    }
                    if (content.contains("Lance Stroll")) {
                        Lance++;
                    }
                    if (content.contains("Lando Norris")) {
                        Lando++;
                    }
                    if (content.contains("Oscar Piastri")) {
                        Oscar++;
                    }
                    if (content.contains("Pierre Gasly")) {
                        Pierre++;
                    }
                    if (content.contains("Esteban Ocon")) {
                        Esteban++;
                    }
                    if (content.contains("Nyck de Vries")) {
                        Nyck++;
                    }
                    if (content.contains("Yuki Tsunoda")) {
                        Yuki++;
                    }
                    if (content.contains("Alexander Albon")) {
                        Alexander++;
                    }
                    if (content.contains("Logan Sargeant")) {
                        Logan++;
                    }
                    if (content.contains("Guanyu Zhou")) {
                        Guanyu++;
                    }
                    if (content.contains("Valtteri Bottas")) {
                        Valtteri++;
                    }
                    if (content.contains("Nico Hulkenberg")) {
                        Nico++;
                    }
                    if (content.contains("Kevin Magnussen")) {
                        Kevin++;
                    }
                }


                ;
            }
            pilotos.insert(Max, "Max Verstappen:"+Max);
            pilotos.insert(Sergio, "Sergio Perez:"+Sergio);
            pilotos.insert(Charles, "Charles Leclerc:"+Charles);
            pilotos.insert(Carlos, "Carlos Sainz:"+Carlos);
            pilotos.insert(Lewis, "Lewis Hamilton:"+Lewis);
            pilotos.insert(George, "George Russell:"+George);
            pilotos.insert(Fernando, "Fernando Alonso:"+Fernando);
            pilotos.insert(Lance, "Lance Stroll:"+Lance);
            pilotos.insert(Lando, "Lando Norris:"+Lando);
            pilotos.insert(Oscar, "Oscar Piastri:"+Oscar);
            pilotos.insert(Pierre, "Pierre Gasly:"+Pierre);
            pilotos.insert(Esteban, "Esteban Ocon:"+Esteban);
            pilotos.insert(Nyck, "Nyck de Vries:"+Nyck);
            pilotos.insert(Yuki, "Yuki Tsunoda:"+Yuki);
            pilotos.insert(Alexander, "Alexander Albon:"+Alexander);
            pilotos.insert(Logan, "Logan Sargeant:"+Logan);
            pilotos.insert(Guanyu, "Guanyu Zhou:"+Guanyu);
            pilotos.insert(Valtteri, "Valtteri Bottas:"+Valtteri);
            pilotos.insert(Nico, "Nico Hulkenberg:"+Nico);
            pilotos.insert(Kevin, "Kevin Magnussen:"+Kevin);
            //quiero que me de los primeros 10 datos de esta lista

            LinkedList list = pilotos.postorder();



            return list;
        }
        //Cantidad de hashtags distintos para un día dado. El día será ingresado en el formato YYYY-MM-DD. por favor hace que si se repitan hastags iguales no los cuente, utilizando la lista hashtag la cual es una hash sabiendo que en su key esta la fecha y en su value el hashtag
        public static int cantidadHashtags(String fecha) {
            int contador = 0;
            for (int i = 0; i < tweets.size(); i++) {
                if (tweets.get(i).getFecha().contains(fecha)) {
                    for (int j = 0; j < tweets.get(i).getHashTags().size(); j++) {
                        if (hashtag.get(tweets.get(i).getHashTags().get(j).getText()) != null) {
                            contador++;
                            hashtag.remove(tweets.get(i).getHashTags().get(j).getText());
                        }
                    }
                }
            }
            return contador;
        }

    //Hashtag más usado para un día dado, sin tener en cuenta #f1. El día será ingresado en el formato YYYY-MM-DD.

}




