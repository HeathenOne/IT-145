//Dylan Carter
import java.util.ArrayList;
import java.util.Scanner;

public class Driver {
    private static ArrayList<Dog> dogList = new ArrayList<Dog>();
    private static ArrayList<Monkey> monkeyList = new ArrayList<Monkey>();

    public static void main(String[] args) {


        initializeDogList();
        initializeMonkeyList();

        Scanner scanner = new Scanner(System.in);
        String menuChoice;

        do {
            displayMenu();
            menuChoice = scanner.nextLine().trim().toLowerCase();

            switch (menuChoice) {
                case "1":
                    intakeNewDog(scanner);
                    break;
                case "2":
                    intakeNewMonkey(scanner);
                    break;
                case "3":
                    reserveAnimal(scanner);
                    break;
                case "4":
                    printAnimals("dog");
                    break;
                case "5":
                    printAnimals("monkey");
                    break;
                case "6":
                    printAnimals("available");
                    break;
                case "q":
                    System.out.println("Exiting application...");
                    break;
                default:
                    System.out.println("Invalid input. Please try again.");
            }
        } while (!menuChoice.equals("q"));

        scanner.close();
    }

    // This method prints the menu options
    public static void displayMenu() {
        System.out.println("\n\n");
        System.out.println("\t\t\t\tRescue Animal System Menu");
        System.out.println("[1] Intake a new dog");
        System.out.println("[2] Intake a new monkey");
        System.out.println("[3] Reserve an animal");
        System.out.println("[4] Print a list of all dogs");
        System.out.println("[5] Print a list of all monkeys");
        System.out.println("[6] Print a list of all animals that are not reserved");
        System.out.println("[q] Quit application");
        System.out.println();
        System.out.println("Enter a menu selection");
    }


    // Adds dogs to a list for testing
    public static void initializeDogList() {
        Dog dog1 = new Dog("Spot", "German Shepherd", "male", "1", "25.6", "05-12-2019", "United States", "intake", false, "United States");
        Dog dog2 = new Dog("Rex", "Great Dane", "male", "3", "35.2", "02-03-2020", "United States", "Phase I", false, "United States");
        Dog dog3 = new Dog("Bella", "Chihuahua", "female", "4", "25.6", "12-12-2019", "Canada", "in service", true, "Canada");

        dogList.add(dog1);
        dogList.add(dog2);
        dogList.add(dog3);
    }


    // Adds monkeys to a list for testing
    //Optional for testing
    public static void initializeMonkeyList() {
        Monkey monkey1 = new Monkey("Charlie", "Capuchin", "male", "Monkey", "5",
                10.5, 60.0, 50.0, "04-20-2021", "Brazil", "intake", false, "Brazil");
        Monkey monkey2 = new Monkey("Milo", "Tamarin", "male", "Monkey", "3",
                8.2, 55.0, 45.0, "07-15-2020", "Peru", "in service", true, "Peru");

        monkeyList.add(monkey1);
        monkeyList.add(monkey2);
    }
    //IntakeNewDog method
    public static void intakeNewDog(Scanner scanner) {
        System.out.println("What is the dog's name?");
        String name = scanner.nextLine();
        for (Dog dog : dogList) {
            if (dog.getName().equalsIgnoreCase(name)) {
                System.out.println("\n\nThis dog is already in our system\n\n");
                return; //returns to menu
            }
        }

        // Add the new dog
        System.out.println("Enter dog's breed:");
        String breed = scanner.nextLine().trim();

        System.out.println("Enter dog's gender:");
        String gender = scanner.nextLine().trim();

        System.out.println("Enter dog's age:");
        String age = scanner.nextLine().trim();

        System.out.println("Enter dog's weight:");
        String weight = scanner.nextLine().trim();

        System.out.println("Enter acquisition date (MM-DD-YYYY):");
        String acquisitionDate = scanner.nextLine().trim();

        System.out.println("Enter acquisition country:");
        String acquisitionCountry = scanner.nextLine().trim();

        System.out.println("Enter training status:");
        String trainingStatus = scanner.nextLine().trim();

        System.out.println("Is the dog reserved? (true/false):");
        boolean reserved = scanner.nextBoolean();
        scanner.nextLine(); // Consume newline left-over

        System.out.println("Enter in-service country:");
        String inServiceCountry = scanner.nextLine().trim();

        Dog newDog = new Dog(name, breed, gender, age, weight, acquisitionDate, acquisitionCountry, trainingStatus, reserved, inServiceCountry);
        dogList.add(newDog);

        System.out.println("\nNew dog added successfully!\n");
    }


    // Complete intakeNewMonkey
    //Instantiate and add the new monkey to the appropriate list
    // For the project submission you must also  validate the input
    // to make sure the monkey doesn't already exist and the species type is allowed
    public static void intakeNewMonkey(Scanner scanner) {
        System.out.println("Enter monkey's name:");
        String name = scanner.nextLine().trim();

        // Check if the monkey is already in the list
        for (Monkey monkey : monkeyList) {
            if (monkey.getName().equalsIgnoreCase(name)) {
                System.out.println("\nThis monkey is already in our system.\n");
                return;
            }
        }

        System.out.println("Enter monkey's species:");
        String species = scanner.nextLine().trim();

        // Validate species input
        boolean validSpecies = false;
        for (String validS : Monkey.VALID_SPECIES) {
            if (validS.equalsIgnoreCase(species)) {
                validSpecies = true;
                break;
            }
        }
        if (!validSpecies) {
            System.out.println("Invalid monkey species. Allowed species are: Capuchin, Guenon, Macaque, Marmoset, Squirrel Monkey, Tamarin");
            return;
        }

        System.out.println("Enter monkey's gender:");
        String gender = scanner.nextLine().trim();

        System.out.println("Enter monkey's age:");
        String age = scanner.nextLine().trim();

        System.out.println("Enter monkey's weight:");
        String weight = scanner.nextLine().trim();

        System.out.println("Enter acquisition date (MM-DD-YYYY):");
        String acquisitionDate = scanner.nextLine().trim();

        System.out.println("Enter acquisition country:");
        String acquisitionCountry = scanner.nextLine().trim();

        System.out.println("Enter training status:");
        String trainingStatus = scanner.nextLine().trim();

        System.out.println("Is the monkey reserved? (true/false):");
        boolean reserved = scanner.nextBoolean();
        scanner.nextLine(); // Consume newline left-over

        System.out.println("Enter in-service country:");
        String inServiceCountry = scanner.nextLine().trim();

        System.out.println("Enter monkey's tail length:");
        double tailLength = scanner.nextDouble();
        scanner.nextLine(); // Consume newline left-over

        System.out.println("Enter monkey's height:");
        double height = scanner.nextDouble();
        scanner.nextLine(); // Consume newline left-over

        System.out.println("Enter monkey's body length:");
        double bodyLength = scanner.nextDouble();
        scanner.nextLine(); // Consume newline left-over

        Monkey newMonkey = new Monkey(name, species, gender, age, weight, height, bodyLength, tailLength, acquisitionDate, acquisitionCountry, trainingStatus, reserved, inServiceCountry);
        monkeyList.add(newMonkey);

        System.out.println("\nNew monkey added successfully!\n");
    }


    // Complete reserveAnimal
    // You will need to find the animal by animal type and in service country
    public static void reserveAnimal(Scanner scanner) {
        System.out.println("Enter animal type (Dog/Monkey):");
        String animalType = scanner.nextLine().trim().toLowerCase();

        System.out.println("Enter in-service country:");
        String inServiceCountry = scanner.nextLine().trim();

        boolean animalFound = false;

        if (animalType.equals("dog")) {
            for (Dog dog : dogList) {
                if (!dog.getReserved() && dog.getInServiceLocation().equalsIgnoreCase(inServiceCountry) && dog.getTrainingStatus().equalsIgnoreCase("in service")) {
                    dog.setReserved(true);
                    System.out.println("\nDog reserved successfully:\n" + dog.toString() + "\n");
                    animalFound = true;
                    break;
                }
            }
        } else if (animalType.equals("monkey")) {
            for (Monkey monkey : monkeyList) {
                if (!monkey.getReserved() && monkey.getInServiceLocation().equalsIgnoreCase(inServiceCountry) && monkey.getTrainingStatus().equalsIgnoreCase("in service")) {
                    monkey.setReserved(true);
                    System.out.println("\nMonkey reserved successfully:\n" + monkey.toString() + "\n");
                    animalFound = true;
                    break;
                }
            }
        } else {
            System.out.println("Invalid animal type.");
        }

        if (!animalFound) {
            System.out.println("No eligible animal found for reservation.");
        }
    }

    public static void printAnimals(String listType) {
        switch (listType.toLowerCase()) {
            case "dog":
                System.out.println("List of dogs:");
                for (Dog dog : dogList) {
                    String details = dog.getFormattedDetails();
                    System.out.println(details);
                }
                break;
            case "monkey":
                System.out.println("List of Monkeys:");
                for (Monkey monkey : monkeyList) {
                    String details = monkey.getFormattedDetails();
                    System.out.println(details);
                }
                break;
            case "available":
                System.out.println("List of available animals:");
                //Dogs
                System.out.println("Dogs:");
                for (Dog dog : dogList) {
                    if (dog.getTrainingStatus().equalsIgnoreCase("in service") && !dog.getReserved()) {
                        String details = dog.getFormattedDetails();
                        System.out.println(details);
                    }
                }
                //Monkeys
                System.out.println("Monkeys:");
                for (Monkey monkey : monkeyList) {
                    if (monkey.getTrainingStatus().equalsIgnoreCase("in service") && !monkey.getReserved()) {
                        String details = monkey.getFormattedDetails();
                        System.out.println(details);
                    }
                }
                break;
            default:
                System.out.println("Invalid listType provided.");
                break;
        }
    }
}
