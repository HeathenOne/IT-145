//Dylan Carter
public class Monkey extends RescueAnimal {
   // Instance variables specific to Monkey
   private String species;
   private double tailLength;
   private double height;
   private double bodyLength;

   public final static String [] VALID_SPECIES = {
    "Capuchin",
    "Guenon",
    "Macaque",
    "Marmoset",
    "Squirrel Monkey",
    "Tamarin"
    };

    //Constructor
    public Monkey(
        String name, String species, String gender, String age, String weight,
        double height, double bodyLength, double tailLength, String acquisitionDate, String
        acquisitionCountry, String trainingStatus, boolean reserved, String inServiceCountry)
    {
        setName(name);
        setSpecies(species);
        setGender(gender);
        setAge(age);
        setWeight(weight);
        setHeight(height);
        setBodyLength(bodyLength);
        setTailLength(tailLength);
        setAcquisitionDate(acquisitionDate);
        setAcquisitionLocation(acquisitionCountry);
        setTrainingStatus(trainingStatus);
        setReserved(reserved);
        setInServiceCountry(inServiceCountry);
    }

    //Getter for species
    public String getSpecies() {
        return species;
        }

    //Setter for species
     public void setSpecies(String species) {
        for (String validSpecies : VALID_SPECIES) {
            if (validSpecies.equalsIgnoreCase(species)) {
                this.species = species;
                return;
            }
        }
        throw new IllegalArgumentException("Invalid species: " + species);
    }

    //Getter for tailLength
    public double getTailLength() {
        return tailLength;
        }

    //Setter for tailLength
    public void setTailLength(double tailLength) {
        this.tailLength = tailLength;
        }

    //Getter for height
    public double getHeight() {
        return height;
        }

    //Setter for height
    public void setHeight(double height) {
        this.height = height;
        }

    //Getter for bodyLength
    public double getBodyLength() {
        return bodyLength;
        }

    //Setter for bodyLength
    public void setBodyLength(double bodyLength) {
        this.bodyLength = bodyLength;
        }

    //Format for Driver class
    public String getFormattedDetails() {
        String formattedDetails = String.format("Name: %s, Status: %s, Acquisition Country: %s, Reserved: %s",
            getName(), getTrainingStatus(), getAcquisitionLocation(), (getReserved() ? "True" : "False"));
        return formattedDetails;
    }
}

