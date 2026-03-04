/**
 * Represents one row from your dataset.
 *
 * TODO:
 *  - Rename the class to match your dataset (e.g., Pokemon, StateData, CountryStat)
 *  - Add at least 3 private attributes based on your CSV columns
 *  - Write a constructor that initializes all attributes
 *  - Add getter methods for the attributes you need in your analysis
 *  - Override toString() to display the object's data
 *  - Add Javadoc comments for the class and all methods
 */
/**
 * Represents a single Pokémon from the CSV file.
 * Each object holds the Pokédex number, name, primary type, and base
 * attack stat.  Additional fields could be added if needed.
 */
public class Data {

    private int number;
    private String name;
    private String type;
    private int attack;

    /**
     * Constructs a new data row representing a Pokémon.
     *
     * @param number the Pokédex number
     * @param name   the Pokémon's name
     * @param type   its primary type ("Type 1" column)
     * @param attack the base Attack stat
     */
    public Data(int number, String name, String type, int attack) {
        this.number = number;
        this.name = name;
        this.type = type;
        this.attack = attack;
    }

    /**
     * Returns the Pokédex number.
     */
    public int getNumber() {
        return number;
    }

    /**
     * Returns the name of the Pokémon.
     */
    public String getName() {
        return name;
    }

    /**
     * Returns the primary type string.
     */
    public String getType() {
        return type;
    }

    /**
     * Returns the base Attack stat.
     */
    public int getAttack() {
        return attack;
    }

    @Override
    public String toString() {
        return "#" + number + " " + name + " (" + type + ") attack=" + attack;
    }
}