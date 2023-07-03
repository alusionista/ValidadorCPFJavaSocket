import java.io.*;
import java.net.Socket;

public class Cliente {
    public static Socket socket;
    private static DataInputStream entrada;
    private static DataOutputStream saida;

    public static void main(String[] args) {
        try {
            socket = new Socket("127.0.0.1", 45000);
            entrada = new DataInputStream(socket.getInputStream());
            saida = new DataOutputStream(socket.getOutputStream());

            var reader = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("__________Validador de CPF__________");
            System.out.print("Insira o CPF a ser validado: ");
            var valor = reader.readLine();

            saida.writeUTF(valor);

            var resultado = entrada.readUTF();
            System.out.println(resultado);

            socket.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
