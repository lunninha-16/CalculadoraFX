package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class CalculadoraController {

    @FXML
    private TextField tela;

    private double num1 = 0;
    private String operador = "";
    private boolean limpar = false;

    @FXML
    private void onNumero(ActionEvent event) {
        Button botao = (Button) event.getSource();
        String valor = botao.getText();

        if (limpar) {
            tela.setText("");
            limpar = false;
        }

        tela.setText(tela.getText() + valor);
    }

    @FXML
    private void onOperador(ActionEvent event) {
        Button botao = (Button) event.getSource();
        operador = botao.getText();
        num1 = Double.parseDouble(tela.getText());
        limpar = true;
    }

    @FXML
    private void onIgual(ActionEvent event) {
        double num2 = Double.parseDouble(tela.getText());
        double resultado = 0;

        switch (operador) {
            case "+": resultado = num1 + num2; break;
            case "-": resultado = num1 - num2; break;
            case "x": 
            case "*": resultado = num1 * num2; break;
            case "/": 
                if (num2 == 0) {
                    tela.setText("Erro");
                    return;
                }
                resultado = num1 / num2; break;
        }

        tela.setText(String.valueOf(resultado));
        limpar = true;
    }
}
