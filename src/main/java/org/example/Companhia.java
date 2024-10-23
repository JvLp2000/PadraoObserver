package org.example;

import java.util.Observable;

public class Companhia extends Observable {

    private String nome;
    private String statusAtual;

    public Companhia(String nome) {
        this.nome = nome;
    }

    public void mudarStatus(String novoStatus) {
        this.statusAtual = novoStatus;
        setChanged(); // Indica que houve uma mudança no estado da companhia
        notifyObservers("Status da companhia atualizado para: " + novoStatus); // Notifica os observadores
    }

    public void adicionarNovaTarefa(String tarefa) {
        setChanged();
        notifyObservers("Nova tarefa atribuída: " + tarefa); // Notifica sobre novas tarefas
    }

    @Override
    public String toString() {
        return "Companhia{" +
                "nome='" + nome + '\'' +
                ", statusAtual='" + statusAtual + '\'' +
                '}';
    }
}
