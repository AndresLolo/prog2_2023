import Entities.*;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import uy.edu.um.prog2.adt.BinaryHeap.BinaryHeap;
import uy.edu.um.prog2.adt.BinaryTree.Tree;
import uy.edu.um.prog2.adt.MyLinkedList.*;
import uy.edu.um.prog2.adt.queue.*;

import uy.edu.um.prog2.adt.Hash.*;

import java.io.FileReader;
import java.io.IOException;
import java.io.BufferedReader;


public class CVSreader {
    static MyList<Tweet> tweets = new LinkedList<>();
    static MyHash hashtag = new HashImpl<>(100000);
    static MyHash<Long, User> usuarios = new HashImpl<>(26242);
    static int canttweets = 0;
    static MyList <String> Contenido = new LinkedList<>();
    public static MyList<User> usuarioslista = new LinkedList<>();
    public static MyList<Pilotos> pilotos = new LinkedList<>();

    public static void cargardatos() {
        try (CSVParser parser = new CSVParser(new FileReader("DATA/f1_dataset_test.csv"), CSVFormat.DEFAULT)) {
            parser.iterator().next();
            int lugar = 0;
            for (CSVRecord record : parser) {

                String contenidoTweet = record.get(10);
                String fecha = record.get(9);
                long idtweet = idUnico(fecha);
                String fechaCreado = record.get(4);
                long idUser = idUnico(fechaCreado);
                String nombre = record.get(1);
                String source = record.get(12);
                int favoritos;
                try {
                    if (record.get(7).contains(".")) {
                        double doubleValue = Double.parseDouble(record.get(7));
                        favoritos = (int) Math.round(doubleValue);
                    } else {
                        favoritos = Integer.parseInt(record.get(7));
                    }
                } catch (NumberFormatException e) {
                    continue;
                }

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
                Tweet newtweet = new Tweet(idtweet, contenidoTweet,source , fecha, isretweet, favoritos,listahashtag);
                tweets.add(newtweet);
                canttweets++;

                //usuarios
                if (!usuarios.contains(idUser)) {
                    User usuarioTemp = new User(idUser, nombre, verificado, 0, lugar);
                    usuarios.put(usuarioTemp.getId(), usuarioTemp);
                    usuarioslista.add(usuarioTemp);
                    usuarios.get(idUser).puttweet(newtweet);
                    lugar++;

                }else{
                    usuarios.get(idUser).puttweet(newtweet);
                }


            }

            System.out.println("Tweets"+tweets.size());
            System.out.println("Usuarios"+usuarioslista.size());
            System.out.println("Hashtags"+hashtag.size());

        } catch (IOException e) {
            e.printStackTrace();
        }
        //lector del archivo de pilotos
        try (BufferedReader br = new BufferedReader(new FileReader("DATA/drivers.txt"))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String nombre = linea;
                Pilotos piloto = new Pilotos(nombre,0);
                pilotos.add(piloto);

            }
            System.out.println("Pilotos"+pilotos.size());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //hacer las fechas id unico
    public static Long idUnico(String fecha) {

        long hash = fecha.hashCode();
        long hashPositivo = Math.abs(hash);
        return  hashPositivo;

    }

    //Funcion 1 -  funciona muy lento
    public static void pilotosMasMencionados(String mes, String anio) throws QueueVacia {
        Tree binaryTreeList = new Tree();
        for (int i = 0; i <canttweets ; i++) {
            if (tweets.get(i).getFecha().contains(mes) && tweets.get(i).getFecha().contains(anio)){
                for (int j = 0; j <pilotos.size() ; j++) {
                    if (tweets.get(i).getContent().contains(pilotos.get(j).getName())){
                        pilotos.get(j).setCantidad(pilotos.get(j).getCantidad()+1);
                    }
                }
            }
        }
        for (int i = 0; i <pilotos.size() ; i++) {
            binaryTreeList.insert(pilotos.get(i).getCantidad(),pilotos.get(i));
        }
        LinkedList list = binaryTreeList.postorder();
        for (int i=0;i<10;i++){
            Pilotos pilotosordenados = (Pilotos) list.get(i);
            int cantidad=pilotosordenados.getCantidad();
            String nombre=pilotosordenados.getName();
            System.out.println("Nombre: "+nombre+" Cantidad de menciones: "+cantidad);
        }

    }

    //Funcion 2- 5 segundos
    public static void usuariosConMasTweets() throws QueueVacia {
        Tree binaryTreeList = new Tree();
        for (int i = 0; i <usuarioslista.size() ; i++) {
            User usuario = usuarioslista.get(i);
            binaryTreeList.insert(usuario.getCantidadTweets(),usuario);

        }
        LinkedList list = binaryTreeList.postorder();
        for (int i=0;i<15;i++){
            User usuariosordenados = (User) list.get(i);
            int cantidad=usuariosordenados.getCantidadTweets();
            String nombre=usuariosordenados.getName();
            String verificado;
            if (usuariosordenados.isVerificado()){
                verificado="Si";
            }
            else{
                verificado="No";
            }
            System.out.println("Nombre: "+nombre+" Cantidad de tweets: "+cantidad+" //Verificado: "+verificado);
        }
    }
    //Funcion 3 - 10 segundos - hay que bajar el tiempo
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
    //Funcion 4- 14 segundos- hay que bajar el tiempo
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
    //Funcion 5- lo mismo que la 2
    public static void cuentasFavoritas() throws QueueVacia {
        Tree binaryTreeList = new Tree();
        for (int i = 0; i <usuarioslista.size(); i++) {
            User usuario = usuarioslista.get(i);
            int prioridad=usuario.getFavorito();
            binaryTreeList.insert(prioridad,usuario);
        }
        LinkedList list = binaryTreeList.postorder();
        for (int i = 0; i < 7; i++) {
            User usuariosordenados = (User) list.get(i);
            String nombre=usuariosordenados.getName();
            int favoritos = usuariosordenados.getFavorito();

            int top=i+1;
            System.out.println("Top. "+top+" "+nombre+" tiene "+ favoritos +" likes");
        }
    }

    //Funcion 6- 4 segundos- hay que bajarle el tiempo
    public static int contarDistintos(String palabra) {
        int contador = 0;
        for (int i = 0; i < canttweets; i++) {
            if (Contenido.get(i).contains(palabra)) {
                contador++;
            }
        }
        return contador;
    }


}