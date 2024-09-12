import java.io.IOException;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner leitura = new Scanner(System.in);
        ConsultaCep consultaCep = new ConsultaCep();

        System.out.println("Digite um número de CEP para consulta:");
        var cep = leitura.nextLine();

        if (!consultaCep.validaCep(cep)) {
            System.out.println("CEP inválido. O CEP deve conter 8 dígitos.");
            return;
        }

        try {
            Endereco novoEndereco = consultaCep.buscaEndereco(cep);
            System.out.println("Endereço encontrado:");
            System.out.println("CEP: " + novoEndereco.cep());
            System.out.println("Logradouro: " + novoEndereco.logradouro());
            System.out.println("Complemento: " + novoEndereco.complemento());
            System.out.println("Localidade: " + novoEndereco.localidade());
            System.out.println("UF: " + novoEndereco.uf());


            GeradorDeArquivo gerador = new GeradorDeArquivo();
            gerador.salvaJson(novoEndereco);
        } catch (RuntimeException | IOException e) {
            System.out.println(e.getMessage());
            System.out.println("Finalizado a aplicação");
        }
    }

}
