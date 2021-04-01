package by.ushenkoDmitry.codewars.predictiveContactList;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PredictiveContactList {

    private static final Map<Integer, String> numpersMap = new HashMap<>();

    static {
        numpersMap.put(2, "abc");
        numpersMap.put(3, "def");
        numpersMap.put(4, "ghi");
        numpersMap.put(5, "jkl");
        numpersMap.put(6, "mno");
        numpersMap.put(7, "pqrs");
        numpersMap.put(8, "tuv");
        numpersMap.put(9, "wxyz");
    }

    public static List<String> predict(List<String> contacts, String keystrokes) {
        List<String> checkedContacts = new ArrayList<>();
        contacts.forEach(contact -> {
            if (contact.length() >= keystrokes.length()) {
                for (int i = 0; i < contact.length(); i++) {
                    if (i < keystrokes.length()) {
                        int num = Integer.parseInt(keystrokes.charAt(i) + "");
                        if (!numpersMap.get(num).contains(contact.toLowerCase().charAt(i) + "")) {
                            return;
                        }
                    }
                }
                checkedContacts.add(contact);
            }
        });
        return checkedContacts;
    }

}