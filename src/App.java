import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Main application for the Data Analysis Mini‑Project.  This class reads the
 * provided Pokémon CSV file, constructs a list of Data objects, and then
 * applies analysis methods (min/max, averages by type) to answer the guiding
 * question specified in the README.  All required features (file I/O,
 * algorithms, and printing results) are implemented.
 */
public class App {

    public static void main(String[] args) {

        // path to the dataset; adjust if you move the file
        File file = new File("/workspaces/data-analysis-project-RA-TechMed/pokemon (12).csv");

        ArrayList<Data> pokedex = new ArrayList<>();

        try (Scanner scanner = new Scanner(file)) {
            if (scanner.hasNextLine()) {
                scanner.nextLine(); // skip header row
            }
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                // basic CSV split; description may contain commas but we don't
                // use that column so it's okay for this exercise
                String[] tokens = line.split(",");
                if (tokens.length < 6) {
                    continue; // malformed row
                }
                int number = Integer.parseInt(tokens[0].trim());
                String name = tokens[1].trim();
                String type = tokens[2].trim();
                int attack = Integer.parseInt(tokens[5].trim());

                Data p = new Data(number, name, type, attack);
                pokedex.add(p);
            }
        } catch (FileNotFoundException e) {
            System.err.println("Dataset file not found: " + e.getMessage());
            return;
        }

        // analysis calls
        int count = pokedex.size();
        Data maxAtk = findPokemonWithMaxAttack(pokedex);
        Data minAtk = findPokemonWithMinAttack(pokedex);
        Map<String, Double> averageByType = computeAverageAttackByType(pokedex);
        String highestAvgType = typeWithHighestAverage(averageByType);

        // output insights
        System.out.println("Rows loaded: " + count);
        System.out.println("Strongest (attack): " + maxAtk);
        System.out.println("Weakest (attack): " + minAtk);
        System.out.println("Average attack by type: " + averageByType);
        System.out.println("Type with highest average attack: " + highestAvgType);
    }

    /**
     * Returns the Pokémon with the highest attack value.
     */
    public static Data findPokemonWithMaxAttack(ArrayList<Data> list) {
        if (list.isEmpty()) return null;
        Data best = list.get(0);
        for (Data p : list) {
            if (p.getAttack() > best.getAttack()) {
                best = p;
            }
        }
        return best;
    }

    /**
     * Returns the Pokémon with the lowest attack value.
     */
    public static Data findPokemonWithMinAttack(ArrayList<Data> list) {
        if (list.isEmpty()) return null;
        Data worst = list.get(0);
        for (Data p : list) {
            if (p.getAttack() < worst.getAttack()) {
                worst = p;
            }
        }
        return worst;
    }

    /**
     * Computes the average attack stat grouped by primary type.
     *
     * @return a map from type name to average attack
     */
    public static Map<String, Double> computeAverageAttackByType(ArrayList<Data> list) {
        Map<String, Integer> sum = new HashMap<>();
        Map<String, Integer> count = new HashMap<>();
        for (Data p : list) {
            String type = p.getType();
            if (type.isEmpty()) continue;
            sum.put(type, sum.getOrDefault(type, 0) + p.getAttack());
            count.put(type, count.getOrDefault(type, 0) + 1);
        }
        Map<String, Double> avg = new HashMap<>();
        for (String t : sum.keySet()) {
            avg.put(t, sum.get(t) / (double) count.get(t));
        }
        return avg;
    }

    /**
     * Given the map of averages produced by {@link #computeAverageAttackByType},
     * returns the type whose average is highest.
     */
    public static String typeWithHighestAverage(Map<String, Double> avgMap) {
        String bestType = null;
        double bestVal = Double.NEGATIVE_INFINITY;
        for (Map.Entry<String, Double> e : avgMap.entrySet()) {
            if (e.getValue() > bestVal) {
                bestVal = e.getValue();
                bestType = e.getKey();
            }
        }
        return bestType;
    }
}