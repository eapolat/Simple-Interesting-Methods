import java.util.Scanner;

public class Lab05_Q3 {
    
    

    public static String displayMenu() {

        return "\n1 - Find Probability of Same Birthday \n2 - Draw Chart \n3 - Convert Word \n4 - QUIT";

    } 

    public static int getChoice() {

        Scanner myscan = new Scanner (System.in);

        System.out.print("Enter choice:");
        int choice = myscan.nextInt();

        // myscan.close();

        return choice;

    }

    public static double sameBirthday(int group_size) {

        float days = 365;
        float probability = 1;
        float calculation = 1;

        for ( float num_people = group_size ; num_people >= 2; num_people--) {

            calculation = calculation * ((days-(num_people-1)) / days); 

            }

            probability = 1 - calculation;
            return probability;

    }

    public static int findMax(int input_num) {

        int max_digit = 0;

        for (int new_num = input_num; new_num <= 0; new_num = new_num / 10 ){

            int last_digit = new_num % 10;

            if (last_digit > max_digit){

                max_digit = new_num;

            }

        }
        return max_digit;

    }

    public static String displayChart(String chartData) {            
        
        
                String review_print = "";

                for (int review_num = 0; review_num < chartData.length(); review_num++ ) {

                review_print = review_print + " Review " + (review_num+1);
                }

                System.out.println(review_print);

                int height = 9;
                String review_line = "";

            
                for (int j = height; j > 1; j-- ) {

                review_line = "";

                for (int review_num = 0; review_num < chartData.length(); review_num++ ) {

                    char c = chartData.charAt(review_num);
                    int character_numeric = Character.getNumericValue(c);

                if (character_numeric >= j) {
                    review_line = review_line + "      ***";
                } else {
                    review_line = review_line + "         ";
                }

                }

                    System.out.println(review_line);

                }
                return review_line;


    }

    

    public static boolean isValidNumeric(String control_numeric ) {

        boolean numeric_char = false;

        for (int i = 0 ; i < control_numeric.length() ; i++ ) {

            char character = control_numeric.charAt(i);

            if (Character.isDigit(character)) {

                numeric_char = true;

            }

            if (!Character.isDigit(character)) {

                numeric_char = false;
                System.out.println("Invalid chart data!");
                i = 1000; 
            }

        }
        return numeric_char;
    }

    public static int countLetter(String count_String, int index_of_letter) {

        int count = 0;

            for (int j = 0 ; j < count_String.length(); j++) {

                if (count_String.charAt(j)==count_String.charAt(index_of_letter)) {

                    count++;

                }
            }
        return count;

    }

    public static String convertWord(String word_to_convert) {

        String converted_input = " ";


        for (int i = 0; i < word_to_convert.length(); i++) {

            char character = word_to_convert.charAt(i);


            if (!Character.isLetter(character)) {

                converted_input = converted_input + "*";
            } else {

                if (word_to_convert.indexOf(character) == i && word_to_convert.lastIndexOf(character) == i) {

                    converted_input = converted_input + "(";


                }
                else {

                converted_input = converted_input + ")";
            }

            }

        }
        return converted_input;

    }

    public static void main(String[] args) {


        Scanner myscan_2 = new Scanner (System.in);
        int choice = 0;
        
        while (choice != 4) {

            System.out.println(displayMenu());

            choice = getChoice();

            if (choice > 4) {
                System.out.println("Invalid choice");
            }
            else if (choice == 1) {

                
                System.out.print("Enter the group size: ");
                int group_size = myscan_2.nextInt();

                double probability = sameBirthday(group_size);

                probability = Math.round(probability);

                System.out.printf("The probability of two people in a group of 50 having the same birthday is %.2f", probability);

            }

            else if (choice == 2) {

                System.out.print("Enter chart data: ");
                String chartData = myscan_2.next();


                if (isValidNumeric(chartData)) {

                    System.out.println(displayChart(chartData));

                } else {
                    System.out.println("Invalid data, only enter numeric!");
                }


            }

            else if (choice == 3) {

                System.out.print("Enter word to convert:");
                String word_to_convert = myscan_2.next();
                System.out.println();

                System.out.printf("Original Word: %s  Converted Word: %s",word_to_convert, convertWord(word_to_convert));

            }
        }

        myscan_2.close();

        System.out.println("GOODBYE!");
    }

}


