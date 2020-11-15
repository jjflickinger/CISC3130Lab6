import java.util.Scanner;

public class GradeCalculator {
    
    //ask user for the 3 test scores. Store the values in an array and return it
    public static double[] getTestScores(Scanner scanner) {
        double[] testScores = new double[3];
        System.out.print("First test score (/10)? ");
        testScores[0] = scanner.nextDouble();
        System.out.print("Second test score (/10)? ");
        testScores[1] = scanner.nextDouble();
        System.out.print("Third and final test score (/20)? ");
        testScores[2] = scanner.nextDouble();
        return testScores;
    }
    
    //print each of the 3 test scores and the average of the 3 as a percent
    public static void printTestScores(double[] testScores) {
        System.out.println("Midterm 1: " + testScores[0]);
        System.out.println("Midterm 2: " + testScores[1]);
        System.out.println("Final: " + testScores[2]);
        System.out.println("Average test score: " + (testScores[0] + testScores[1] + testScores[2])*2.5 + "%" );
    }
    
    //ask user for the 8 practice problem scores. Store the values in an array and return it
    public static double[] getPracticeScores(Scanner scanner) {
        double[] practiceProblems = new double[8];
        for (int i = 0; i < 8; i++) {
            System.out.print("Practice problems " + (i+1) );
            if ( i == 0) {
                System.out.print(" (/2)? ");
            } else {
                System.out.print(" (/6)? ");
            }
            practiceProblems[i] = scanner.nextInt();
        }
        return practiceProblems;
    }
    
    //ask user for the 8 practice problem scores. Store the values in an array and return it
    public static double[] getLabScores(Scanner scanner) {
        double[] labs = new double[8];
        for (int i = 0; i < 8; i++) {
            System.out.print("Lab " + (i+1) + " (/2)? ");
            labs[i] = scanner.nextInt();
        }
        return labs;
    }
    
    //given integer grade out of 100, return equivalent letter grade
    // + and - grades are not considered
    public static char getLetterGrade(double avg) {
        if (avg < 65) {
            return 'F';
            //a negative number will return F. It is not considered invalid here
        } else if (avg < 70) {
            return 'D';
        } else if (avg < 80) {
            return 'C';
        } else if (avg < 90) {
            return 'B';
        } else {
            return 'A';
            //any avg over 100 simply counts as an A. It is not considered invalid here
        }
    }
    
    //calculate the points needed to obtain the specified letter grade
    public static double pointsNeededForLetterGrade(char c, double pointsEarned) {
        if (c == 'A') {
            return 90 - pointsEarned;
        } else if (c == 'B') {
            return 80 - pointsEarned;
        } else if (c == 'C') {
            return 70 - pointsEarned;
        } else if (c == 'D') {
            return 65 - pointsEarned;
        } else return 0;
    }
    
    //given integer grade out of 100, return equivalent grade on four point scale (i.e. out of 4.0)
    public static double getFourPointGrade(double avg) {
        return avg/20 - 1;
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        //scores are doubles because decimal grades are permitted
        double pointsPossible = 0;
        double pointsEarned = 0;
        
        double[] testScores = getTestScores(scanner);
        System.out.print("Tests given so far (<= 3)? ");
        int testsSoFar = scanner.nextInt();
        if (testsSoFar == 1) {
            pointsPossible += 10;
        } else if (testsSoFar == 2) {
            pointsPossible += 20;
        } else if (testsSoFar == 3) {
            pointsPossible += 40;
        }
        for (int i = 0; i < testsSoFar; i++) {
            pointsEarned += testScores[i];
        }
        
        
        double[] practiceProblems = getPracticeScores(scanner);
        System.out.print("Number of practice problem assignments so far (<= 8)? ");
        int practiceSoFar = scanner.nextInt();
        for (int i = 0; i < practiceSoFar; i++) {
            if (i == 0) {
                pointsPossible += 2;
                //the first one is only worth 2 points instead of 6
            } else {
                pointsPossible += 6;
            }
            pointsEarned += practiceProblems[i];
        }
        
        double[] labs = getLabScores(scanner);
        System.out.print("Number of labs assigned so far (<= 8)? ");
        int labsSoFar = scanner.nextInt();
        for (int i = 0; i < labsSoFar; i++) {
            pointsPossible += 2;
            pointsEarned += labs[i];
        }

        scanner.close();
        
        double pointsRemaining = 100 - pointsPossible;
        double maxGrade = pointsEarned + pointsRemaining;
        
        System.out.println("Points possible: " + pointsPossible);
        System.out.println("Points earned: " + pointsEarned);
        System.out.println("Max grade: " + maxGrade);
    }
}
