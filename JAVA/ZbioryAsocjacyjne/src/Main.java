import structures.*;

public class Main {
    public static void main(String[] args) {
        SetOnArray letters = new SetOnArray(9);
        String lettersArray[] = {"a", "b", "c", "d", "e", "f", "g", "h"};

        for (int i = 0; i < lettersArray.length; i++) {
            letters.put(new Pair(lettersArray[i], i + 1));
        }

        System.out.println("Letters set after putting some elements: ");

        for (Pair x :
                letters.pairsArray) {
            System.out.println(x);
        }

        letters.edit(new Pair("b", 42));
        System.out.println("\tNum of elems: " + letters.number());
        letters.edit(new Pair("i", 9));
        //letters.edit(new Pair("j", 10)); //exception handled for full set

        System.out.println("Letters set after editing elements \"b\" and \"i\"");

        for (Pair x :
                letters.pairsArray) {
            System.out.println(x);
        }

        System.out.println("Tests of other methods:");
        System.out.println("\t\"b\" lookup: " + letters.find("b"));
        System.out.println("\t\"a\" value lookup: " + letters.read("a"));
        //System.out.println("\"j\" lookup: " + letters.find("j")); //exception handled for the key which is not in the set
        System.out.println("\tNum of elems: " + letters.number());
        System.out.println("\tCleaning the set!");
        letters.clean();
        System.out.println("\tNum of elems: " + letters.number());

        // set on dynamic array

        System.out.println("\n\n\n------------- DynamicArray examples -------------\n\n\n");

        SetOnDynamicArray lettersDynamic = new SetOnDynamicArray();

        for (int i = 0; i < lettersArray.length; i++) {
            lettersDynamic.put(new Pair(lettersArray[i], i + 1));
        }

        lettersDynamic.put(new Pair("Igor", 1308));
        lettersDynamic.put(new Pair("Kuba", 0));
        lettersDynamic.put(new Pair("Karol", 900));
        System.out.println("LettersDynamic set after putting one more elems out of old range:");

        for (Pair p :
                lettersDynamic.pairsArray) {
            System.out.println(p);
        }

        System.out.println("\tTests of other methods");
        System.out.println("\tCurrent len = " + lettersDynamic.number());
        System.out.println("\t\"Igor\" lookup: " + lettersDynamic.find("Igor"));
        System.out.println("\t\"Igor\"s value lookup: " + lettersDynamic.read("Igor"));
        lettersDynamic.clean();
        System.out.println("\tCurrent len = " + lettersDynamic.number());
    }
}
