import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import static java.lang.Character.getNumericValue;

public class Servidor {

    private static Socket socket;
    private static ServerSocket server;
    private static DataInputStream entrada;
    private static DataOutputStream saida;

    public static void main(String[] args) {
        try {

            server = new ServerSocket(45000);
            System.out.println("SERVIDOR ON");
            socket = server.accept();

            entrada = new DataInputStream(socket.getInputStream());
            saida = new DataOutputStream(socket.getOutputStream());


            String cpf = entrada.readUTF();
            System.out.println("Valor recebido: " + cpf);

            var resultado = "";

            if (validaCpf(cpf)) {
                resultado = "Este CPF é válido";
                System.out.println("CPF válido!");
            } else {
                resultado = "Este CPF é inválido";
                System.out.println("CPF inválido!");
            }

            saida.writeUTF(resultado);

            socket.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static boolean validaCpf(String cpf) {
        cpf = cpf.replaceAll("\\D", "");
        if (cpf.length() != 11) return false;

        int soma = 0;
        for (int i = 0; i < 9; i++) soma += getNumericValue(cpf.charAt(i)) * (10 - i);
        int resto = soma % 11;
        int penultimoDigito = (resto < 2) ? 0 : 11 - resto;
        if (getNumericValue(cpf.charAt(9)) != penultimoDigito) return false;

        soma = 0;
        for (int i = 0; i < 10; i++) soma += getNumericValue(cpf.charAt(i)) * (11 - i);
        resto = soma % 11;
        int ultimoDigito = (resto < 2) ? 0 : 11 - resto;
        return getNumericValue(cpf.charAt(10)) == ultimoDigito;
    }

}
