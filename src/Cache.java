public class Cache {
    
    private String[] keys;
    private int[] values;
    private int[] frequency;
    private int actualFrequency;
    
    public Cache(int limit) {
        this.keys = new String[limit];
        this.values = new int[limit];
        this.frequency = new int[limit];
        this.actualFrequency = 0;
    }

    public String[] getKeys() {
        return this.keys;
    }

    public int[] getValues() {
        return this.values;
    }

    public int[] getFrequency() {
        return this.frequency;
    }

    public int getActualFrequency() {
        return this.actualFrequency;
    }

    public void setKeys(String[] keys) {
        this.keys = keys;
    }

    public void setValues(int[] values) {
        this.values = values;
    }

    public void setFrequencyList(int[] frequency) {
        this.frequency = frequency;
    }

    public void setActualFrequency(int actualFrequency) {
        this.actualFrequency = actualFrequency;
    }

    public void increaseActualFrequency() {
        this.actualFrequency++;
    }

}
