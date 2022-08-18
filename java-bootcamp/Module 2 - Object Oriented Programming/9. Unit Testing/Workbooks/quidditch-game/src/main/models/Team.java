package src.main.models;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Team {

    private static final String POSITION_CHASER = "chaser";
    private static final String POSITION_SEEKER = "seeker";
    private static final String POSITION_KEEPER = "keeper";

    private String house;
    private String keeper;
    private String seeker;
    private String[] chasers;

    public Team(String house, String keeper, String seeker, String[] chasers) {
        if (house == null || keeper == null || seeker == null) {
            throw new IllegalArgumentException("field values cannot be null");
        }

        if (house.isBlank() || keeper.isBlank() || seeker.isBlank()) {
            throw new IllegalArgumentException("field values cannot be blank");
        }

        if (hasNull(chasers) || hasBlank(chasers)) {
            throw new IllegalArgumentException("Array chasers cannot be null/blank");
        }

        if (chasers.length != 3) {
            throw new IllegalArgumentException("Chasers length has to be equal to 3");
        }

        this.house = house;
        this.keeper = keeper;
        this.seeker = seeker;
        this.chasers = Arrays.copyOf(chasers, chasers.length);

    }

    public Team(Team source) {
        this.house = source.house;
        this.keeper = source.keeper;
        this.seeker = source.seeker;
        this.chasers = Arrays.copyOf(source.chasers, source.chasers.length);
    }

    public String getHouse() {
        return house;
    }

    public String getKeeper() {
        return keeper;
    }

    public String getSeeker() {
        return seeker;
    }

    public String[] getChaser() {
        return Arrays.copyOf(chasers, chasers.length);
    }

    /*
     * FREQUENTLY ASKED QUESTIONS:
     * 
     * Question: the constants are final, so why can't we make them public? It's not
     * possible for the caller to update them.
     * Answer: Even if the constant is final, I prefer to expose a method instead of
     * the variable. But if you want to expose the variable, that's also correct.
     * 
     */

    public static String getPositionChaser() {
        return POSITION_CHASER;
    }

    public static String getPositionSeeker() {
        return POSITION_SEEKER;
    }

    public static String getPositionKeeper() {
        return POSITION_KEEPER;
    }

    public void setHouse(String house) {
        checkParam(house);
        this.house = house;
    }

    public void setKeeper(String keeper) {
        checkParam(keeper);
        this.keeper = keeper;
    }

    public void setSeeker(String seeker) {
        checkParam(seeker);
        this.seeker = seeker;
    }

    public void setChasers(String[] chase) {
        this.chasers = Arrays.copyOf(chase, chase.length);
    }

    public void checkParam(String param) {
        if (param == null || param.isBlank()) {
            throw new IllegalArgumentException(param + " cannot be null or blank");
        }
    }

    public static boolean hasNull(String[] chasers) {
        return Arrays.stream(chasers)
                .anyMatch(chaser -> chaser == null);
    }

    public static boolean hasBlank(String[] chasers) {
        return Arrays.stream(chasers)
                .anyMatch(chaser -> chaser.isBlank());
    }

    public String toString() {
        return "House: " + this.house + "\n" +
                "Keeper: " + this.keeper + "\n" +
                "Seeker: " + this.seeker + "\n" +
                "Chasers: " + Arrays.toString(this.chasers) + "\n";
    }

}
