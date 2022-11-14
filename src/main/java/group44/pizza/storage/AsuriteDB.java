package group44.pizza.storage;

import java.util.ArrayList;
import java.util.Arrays;

public class AsuriteDB {
    public static ArrayList<String> validIds = new ArrayList<String>(Arrays.asList(
            "wchung25",
            "urmum26",
            "tirvin",
            "dhruvinmecrazy",
            "supasexyboi"
    ));

    public static boolean isValidAsuId(String asuId) {
        for (String s : validIds) {
            if (s.equals(asuId)) return true;
        }
        return false;
    }
}
