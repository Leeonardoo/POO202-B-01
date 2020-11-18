package model;

public class StatsEntry {
    private int enigmaId, totalActivations, totalExecutions, totalRightAnswers, totalWrongAnswers;

    public int getTotalActivations() {
        return totalActivations;
    }

    public void setTotalActivations(int totalActivations) {
        if (totalActivations < 0) {
            throw new IllegalArgumentException("O número de ativações não pode ser menor que 0!");
        }
        this.totalActivations = totalActivations;
    }

    public int getTotalExecutions() {
        return totalExecutions;
    }

    public void setTotalExecutions(int totalExecutions) {
        if (totalExecutions < 0) {
            throw new IllegalArgumentException("O número de execuções não pode ser menor que 0!");
        }
        this.totalExecutions = totalExecutions;
    }

    public int getTotalRightAnswers() {
        return totalRightAnswers;
    }

    public void setTotalRightAnswers(int totalRightAnswers) {
        if (totalRightAnswers < 0) {
            throw new IllegalArgumentException("O número de respostas certas não pode ser menor que 0!");
        }
        this.totalRightAnswers = totalRightAnswers;
    }

    public int getTotalWrongAnswers() {
        return totalWrongAnswers;
    }

    public void setTotalWrongAnswers(int totalWrongAnswers) {
        this.totalWrongAnswers = totalWrongAnswers;
    }

    public int getEnigmaId() {
        return enigmaId;
    }

    public void setEnigmaId(int enigmaId) {
        this.enigmaId = enigmaId;
    }
}