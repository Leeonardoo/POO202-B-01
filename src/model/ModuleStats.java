package model;

public class ModuleStats {
    private int totalActivations;

    public int getTotalActivations() {
        return totalActivations;
    }

    public void setTotalActivations(int totalActivations) {
        if (totalActivations < 0) {
            throw new IllegalArgumentException("O total de ativações não pode ser menor que zero!");
        }

        this.totalActivations = totalActivations;
    }
}