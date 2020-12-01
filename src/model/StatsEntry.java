package model;

import java.io.Serializable;

public class StatsEntry implements Serializable{
    private int totalExecutions, totalRightAnswers, totalWrongAnswers;
    private byte enigmaId;

    public StatsEntry(byte enigmaId, int totalExecutions, int totalRightAnswers, int totalWrongAnswers) {
        this.setEnigmaId(enigmaId);
        this.setTotalExecutions(totalExecutions);
        this.setTotalRightAnswers(totalRightAnswers);
        this.setTotalWrongAnswers(totalWrongAnswers);
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

    public byte getEnigmaId() {
        return enigmaId;
    }

    public void setEnigmaId(byte enigmaId) {
        this.enigmaId = enigmaId;
    }
}