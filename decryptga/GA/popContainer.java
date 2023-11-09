package GA;

public class popContainer{
    
    private String key;
    private double fitScore;

    // Constructor
    public popContainer(String key, double fitScore) {
        this.key = key;
        this.fitScore = fitScore;
    }

    // Getter and setter methods for the string value
    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    // Getter and setter methods for the double value
    public double getfitScore() {
        return fitScore;
    }

    public void setfitScore(double fitScore) {
        this.fitScore = fitScore;
    }

    // toString method to represent the object as a string
    @Override
    public String toString() {
        return "Data {" +
                "Key = '" + key + '\'' +
                ", Fitness = " + fitScore +
                '}';
    }


}