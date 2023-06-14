package practice;

import java.util.*;

public class PhoneBook {

    Map<String, String> mapPhoneBook = new TreeMap<>();

    public void addContact(String phone, String name) {

        if (phone.matches("[\\d]{11}") && name.matches("[А-Яа-я]+")) {
            if (mapPhoneBook.containsKey(phone)) {
                mapPhoneBook.replace(phone, mapPhoneBook.get(phone), name);
            } else {
                mapPhoneBook.put(phone, name);
            }
        }
    }


    public String getContactByPhone(String phone) {
        if (mapPhoneBook.containsKey(phone)) {
            return mapPhoneBook.get(phone) + " - " + phone;
        } else {
            return "";
        }
    }


    public Set<String> getContactByName(String name) {

        Set<String> setPhoneBook = new TreeSet<>();
        String namePlusTel = "";
        if (mapPhoneBook.containsValue(name)) {
            namePlusTel = namePlusTel.concat(name) + " - ";
            for (String tel : mapPhoneBook.keySet()) {
                if (mapPhoneBook.get(tel).equals(name)) {
                    namePlusTel = namePlusTel.concat(tel) + ", ";
                }
            }
            setPhoneBook.add(namePlusTel.substring(0, namePlusTel.length() - 2));
            return setPhoneBook;
        } else {
            return new TreeSet<>();
        }
    }

    public Set<String> getAllContacts() {

        Map<String, TreeSet<String>> nameToPhones = new HashMap<>();
        for (String key : mapPhoneBook.keySet()) {
            String name = mapPhoneBook.get(key);
            if (!nameToPhones.containsKey(name)) {
                nameToPhones.put(name, new TreeSet<>());
            }
            nameToPhones.get(name).add(key);
        }

        Set<String> result = new HashSet<>();
        for (String key : nameToPhones.keySet()) {
            String resultString = key + " - " + nameToPhones.get(key);
            result.add(resultString.replaceAll("[\\[\\]]",""));
        }

        return result;

    }
}

