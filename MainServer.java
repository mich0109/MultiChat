import java.io.IOException;
import java.net.ServerSocket;
import java.util.ArrayList;
import java.net.Socket;

public class MainServer {
    public static void main(String[] args) {
        final int port = 5500;
        try {
            ServerSocket serverSocket = new ServerSocket(port);
            ArrayList<Thread> listaThreadConnessioni = new ArrayList<Thread>();
            ListaClient listaClient = new Listaclient();
            System.out.println("Server aperto");
            System.out.println("In attesa di connessioni...");
            while(true) {
                Socket nuovoClient = serverSocket.accept();
                listaClient.addClient(nuovoClient);
                Thread connessioneThread = new Thread(new ThreadConnessione(nuovoClient, listaClient));
                listaThreadConnessioni.add(ConnessioneThread);
                listaThreadConnessioni.get(listaThreadConnessioni.size()-1).start();
            }
        } catch (IOException e) { System.out.println("Errore di connessione"); }
    }
}
