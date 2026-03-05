/**
 * Represents one row from the Pokémon dataset.
 *
 * This class was renamed from `Data` to `Pokemon` and now reflects the
 * domain of the project. It holds information extracted from the CSV
 * such as Pokédex number, name, type, and attack stat.  Additional
 * attributes can be added as needed for further analysis.
 */
public class Pokemon {

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
    public Pokemon(int number, String name, String type, int attack) {
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