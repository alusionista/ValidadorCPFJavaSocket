# Validador de CPF

Este projeto consiste em uma aplicação cliente-servidor em Java que valida se um CPF é válido.

A aplicação cliente (`Cliente.java`) estabelece uma conexão com o servidor através do socket e permite que o usuário insira um CPF a ser validado. Em seguida, envia o CPF para o servidor e recebe a resposta indicando se o CPF é válido ou inválido. O resultado é exibido no console.

A aplicação servidor (`Servidor.java`) aguarda a conexão do cliente e recebe o CPF enviado pelo cliente. Em seguida, realiza a validação do CPF e retorna o resultado para o cliente. O servidor imprime no console o CPF recebido e o resultado da validação.

## Como utilizar

1. Certifique-se de ter o Java Development Kit (JDK) instalado em sua máquina.
2. Faça o download dos arquivos `Cliente.java` e `Servidor.java`.
3. Abra um terminal e navegue até o diretório onde os arquivos foram baixados.
4. Compile os arquivos Java digitando o seguinte comando no terminal:

   ```shell
   javac Cliente.java Servidor.java
   ```

5. Inicie o servidor executando o seguinte comando no terminal:

   ```shell
   java Servidor
   ```

   O servidor iniciará e ficará aguardando conexões.

6. Em outro terminal, inicie o cliente executando o seguinte comando no terminal:

   ```shell
   java Cliente
   ```

   O cliente será iniciado e solicitará que você insira o CPF a ser validado.

7. Digite o CPF e pressione Enter.
8. O resultado da validação será exibido no console do cliente e do servidor.

## Observações

- Certifique-se de que o servidor esteja em execução antes de iniciar o cliente, caso contrário, o cliente não conseguirá se conectar.
- O servidor estará escutando na porta `45000`. Verifique se essa porta está disponível no seu sistema.
- O servidor aceitará apenas uma conexão por vez. Após cada conexão, ele será finalizado e precisará ser reiniciado para aceitar uma nova conexão.

## Limitações

- Este validador de CPF segue as regras básicas de validação do CPF, mas não verifica se o número do CPF é realmente um número válido emitido pela Receita Federal.
- O formato de entrada do CPF deve ser composto apenas por dígitos numéricos. Quaisquer caracteres não numéricos serão removidos antes da validação.
- O programa não faz validação adicional, como verificar se o CPF é um número sequencial ou possui um padrão conhecido.
- A conexão entre o cliente e o servidor é estabelecida usando o endereço IP `127.0.0.1` e a porta `45000`. Se desejar, você pode alterar esses valores nos códigos-fonte do cliente e do servidor.

Sinta-se à vontade para adaptar e aprimorar esse projeto de acordo com suas necessidades!