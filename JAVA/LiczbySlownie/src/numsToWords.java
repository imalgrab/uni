public class numsToWords
{
    public static final String[] oneDigits = {"zero", "jeden", "dwa", "trzy", "cztery", "pięć", "sześć", "siedem", "osiem", "dziewięć"};
    public static final String[] twoDigits = {"dziesięć", "jedenaście", "dwanaście", "trzynaście", "czternaście", "piętnaście", "szesnaście", "siedemnaście", "osiemnaście", "dziewiętnaście"};
    public static final String[] dozens = {"dwadzieścia", "trzydzieści", "czterdzieści", "pięćdziesiąt", "sześćdziesiąt", "siedemdziesiąt", "osiemdziesiąt", "dziewięćdziesiąt"};
    public static final String[] hundreds = {"sto", "dwieście", "trzysta", "czterysta", "pięćset", "sześćset", "siedemset", "osiemset", "dziewięćset"};
    public static final String[] subjects = {"tysi", "milion", "miliard"};

    public static final String[] subjectThousandEndings = {"ąc", "ące", "ęcy"};
    public static final String[] subjectOtherEndings = {"", "y", "ów"};



    public static final int ONE_DIGITS_MAX_VAL = 9; //constant
    public static final int TWO_DIGITS_MAX_VAL = 19;
    public static final int DOZENS_INDEX_OFFSET = 2;
    public static final int HUNDREDS_INDEX_OFFSET = 1;

    public static String numberToWords(String number)
    {
        return numberToWords(new Integer(number));
    }

    public static String numberToWords(int number)
    {
        if (number == 0)
        {
            return oneDigits[number];
        }

        String prefix = (number < 0) ? "minus " : "";
        String output = "";
        int position = 0;

        number = Math.abs(number);

        while (number != 0)
        {
            int currentHundred = number % 1000;
            output = (currentHundred == 0) ? output : hundredsToWords(currentHundred, position) + " " + aux(currentHundred, position, number) + " " + output;
            //hundredsToWords(currentHundred, position) + " " + aux(currentHundred, position) + " " + output;
            number /= 1000;
            position++;
        }
        return prefix + output;
    }

    public static String dozensToWords(int number, int position)
    {
        number = Math.abs(number % 100);

        if (number == 0)
        {
            return "";
        }

        if (number <= ONE_DIGITS_MAX_VAL)
        {
            return oneDigits[number];
        }

        if (number <= TWO_DIGITS_MAX_VAL)
        {
            return twoDigits[number % 10];
        }

        int dozensIndex = (number / 10) - DOZENS_INDEX_OFFSET;
        return (number % 10 == 0) ? dozens[dozensIndex] : dozens[dozensIndex] + " " + oneDigits[number % 10];
    }

    public static String hundredsToWords(int number, int position)
    {
        number = Math.abs(number % 1000);
        if (number < 100)
        {
            return dozensToWords(number, position);
        }

        int hundredsIndex = (number / 100) - HUNDREDS_INDEX_OFFSET;
        return (number % 100 == 0) ? hundreds[hundredsIndex] + dozensToWords(number, position) : hundreds[hundredsIndex] + " " + dozensToWords(number, position);
    }

    public static String aux(int number, int position, int primeNum)
    {

        number = Math.abs(number);
        if (position == 0 || primeNum / 1000 == 1 || primeNum / 1000000 == 1 || primeNum / 1000000000 == 1)
        {
            return "";
        }

        int subjectIndex = position - 1; //zgodno�� indeks�w tablicy ko�c�wek - od 0...2

        if (number == 1)
        {
            return getSubjectWithEnding(subjectIndex, 0);
        }

        if (number <= ONE_DIGITS_MAX_VAL)
        {
            switch(number)
            {
                case 0:
                    return "";
                case 2:
                case 3:
                case 4:
                    return getSubjectWithEnding(subjectIndex, 1);
                default:
                    return getSubjectWithEnding(subjectIndex, 2);
            }
        }

        if (number <= TWO_DIGITS_MAX_VAL || number%100 <= TWO_DIGITS_MAX_VAL)
        {
            return getSubjectWithEnding(subjectIndex, 2);
        }

        int lastDigit = number % 10;

        switch (lastDigit)
        {
            case 2:
            case 3:
            case 4:
                return getSubjectWithEnding(subjectIndex, 1);
            default:
                return getSubjectWithEnding(subjectIndex, 2);
        }
    }

    public static String getSubjectWithEnding(int subjectIndex, int endingIndex)
    {
        String ending = (subjectIndex == 0) ? subjectThousandEndings[endingIndex] : subjectOtherEndings[endingIndex];
        return subjects[subjectIndex] + ending;
    }

    public static void main(String[] args)
    {

        System.out.println("ZERO" + ": " + numberToWords("0"));
        System.out.println("MAX" + ": " + numberToWords(Integer.MAX_VALUE));
        System.out.println("MIN" + ": " + numberToWords(Integer.MIN_VALUE));
        System.out.println(-295 + ": " + numberToWords("-295"));
        System.out.println(1990 + ": " + numberToWords("1990"));
        System.out.println(1900 + ": " + numberToWords("1900"));
        System.out.println(113000001 + ": " + numberToWords("113000001"));
        System.out.println(70003 + ": " + numberToWords("70003"));
        System.out.println(1001 + ": " + numberToWords(1001));
    }
}
