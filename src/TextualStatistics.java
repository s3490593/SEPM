public class TextualStatistics {



        static int gamesPlayed = 3;

        static double winPercentage;

        static int currentStreak = 0;

        static int maxStreak = 1;

        

        

        public TextualStatistics() {

            

        }

        

        public static int calculateGamesPlayed() {

            return gamesPlayed += 1;

        }

        

        public static double winPercentage() {

            return winPercentage = maxStreak/ gamesPlayed;

            

        }

        

        public static void displayStats() {

            System.out.println("Games played: " + gamesPlayed);

            System.out.println("Win percentage: " + winPercentage);

            System.out.println("Current streak: " + currentStreak);

            System.out.println("Max streak: "+ maxStreak);

            

        }

        

        



    }
