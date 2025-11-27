package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class CalculadoraController {

    @FXML
    private TextField tela; 

    private double num1 = 0; // Armazena o primeiro número da operação
    private String operador = ""; // Guarda o operador selecionado (+, -, *, /)
    private boolean limpar = false; // Indica se a tela deve ser limpa ao digitar o próximo número

    @FXML
    private void onNumero(ActionEvent event) {
        Button botao = (Button) event.getSource(); // Obtém o botão clicado
        String valor = botao.getText(); // Pega o texto do botão (número)

        // Se o flag "limpar" estiver ativado, limpa a tela antes de escrever
        if (limpar) {
            tela.setText("");
            limpar = false;
        }

        // Adiciona o número digitado ao texto atual da tela
        tela.setText(tela.getText() + valor);
    }

    @FXML
    private void onOperador(ActionEvent event) {
        Button botao = (Button) event.getSource(); // Obtém o botão clicado
        operador = botao.getText(); // Guarda o operador selecionado (+, -, /, x, *)
        
        // Armazena o número atual da tela como primeiro operando
        num1 = Double.parseDouble(tela.getText());

        // Ativa o flag para limpar a tela ao digitar o próximo número
        limpar = true;
    }

    @FXML
    private void onIgual(ActionEvent event) {
        // Lê o segundo número da tela
        double num2 = Double.parseDouble(tela.getText());
        double resultado = 0;

        // Realiza a operação conforme o operador escolhido
        switch (operador) {
            case "+": resultado = num1 + num2; break;
            case "-": resultado = num1 - num2; break;
            case "x": 
            case "*": resultado = num1 * num2; break;
            case "/": 
                // Evita divisão por zero
                if (num2 == 0) {
                    tela.setText("Erro");
                    return;
                }
                resultado = num1 / num2; 
                break;
        }

        // Exibe o resultado na tela
        tela.setText(String.valueOf(resultado));

        // Ativa o flag para limpar a tela na próxima digitação
        limpar = true;
    }
}
