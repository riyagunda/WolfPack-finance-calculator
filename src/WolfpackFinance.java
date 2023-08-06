import java.util.Scanner;

import java.lang.*;

/**
 * This program is meant to calculate the possibilty of granting a loan to a user by checking their
 * income, requested loan ammount, and credit score s long as they have applied for one within the 
 * given application period of June 1st to August 15th. If accepted, the day the loan 
 * would be fully paid out will also be outputted based on whether the user opts for 
 * express processing with an extra fee of $30.
 * 
 * @author Riya Gunda
 */

public class WolfpackFinance {
    /**
     * setting variable for the month June as 6
     */
    public static final int JUNE = 6;

    /**
     * setting variable for the month July as 7
     */
    public static final int JULY = 7;
    
    /**
     * setting variable for the month August as 8
     */
    public static final int AUGUST = 8;
    
    /**
     * setting variable for the current year as 2023
     */
    public static final int CURRENT_YEAR = 2023;

    /**
     * setting variable for the number of days in a week as 7
     */
    public static final int DAYS_OF_WEEK = 7;

    /**
     * setting variable for the number of months in a year 12
     */
    public static final int MONTHS_IN_YEAR = 12;

    /**
     * setting variable for the maximum possible credit score the program 
     * can accept as 850
     */
    public static final int MAX_CREDIT_SCORE = 850;

    /**
     * setting variable for the lowest possible credit score the program 
     * can accept as 300
     */
    public static final int MIN_CREDIT_SCORE = 300;
    
    /**
     * setting variable for the upper testing credit score as 720
     */
    public static final int UPPER_TEST_CREDIT_SCORE = 720;
    
    /**
     * setting variable for the middle testing credit score as 500
     */
    public static final int MID_TEST_CREDIT_SCORE = 500;

    /**
     * setting variable for the lower testing credit score as 720
     */
    public static final int LOWER_TEST_CREDIT_SCORE = 350;

    /**
     * setting variable for the time period for the user to pay the loan
     * off as 48 months
     */
    public static final int TIME_PERIOD_MONTHS = 48;
    
    /**
     * setting variable for the express processing fee as 30
     */
    public static final int EXPRESS_PROCESSING_FEE = 30;

    /**
     * setting variable for the minimum loan amount as 1000
     */
    public static final int MIN_LOAN_AMOUNT = 1000;
    
    /**
     * setting variable for the maximum loan amount as 10000
     */
    public static final int MAX_LOAN_AMOUNT = 10000;

    /**
     * setting variable for multiplier of loan amount to check if income value is high enough as 3
     */
    public static final int LOAN_AMOUNT_3 = 3;
    
    /**
     * setting variable for multiplier of loan amount to check if income value 
     * is high enough as 5
     */
    public static final int LOAN_AMOUNT_5 = 5;

    /**
     * setting variable for a possible value of final annual interest rate as 9.0
     */
    public static final double FINAL_INTEREST_RATE_9 = 9.0;
    
    /**
     * setting variable for a possible value of final annual interest rate as 8.5
     */
    public static final double FINAL_INTEREST_RATE_85 = 8.5;
    
    /**
     * setting variable for a possible value of final annual interest rate as 8.0
     */
    public static final double FINAL_INTEREST_RATE_8 = 8.0;
    
    /**
     * setting variable for a possible value of final annual interest rate as 7.5
     */
    public static final double FINAL_INTEREST_RATE_75 = 7.5;
    
    /**
     * setting variable for value of final annual interest rate as -1.0 if the 
     * conditions are not met
     */
    public static final double INTEREST_RATE_DENIED = -1.0;
    
    /**
     * setting variable for a total number of days in June as 30 
     */
    public static final int TOTAL_DAYS_JUNE = 30;
    
    /**
     * setting variable for a total number of days in July as 31
     */
    public static final int TOTAL_DAYS_JULY = 31;
    
    /**
     * setting variable for a total valid days to use in August as 15
     */
    public static final int ALLOWED_DAYS_AUGUST = 15;
    
    /**
     * setting variable for a condition to check if interest rate
     * is valid as 0.5
     */
    public static final double INTEREST_RATE_CHECKER_VALUE = 0.5;
    
    /**
     * setting variable for a converting interest rate to a percentage as 100
     */
    public static final int PERCENTAGE_100 = 100;

    /**
     * setting variable for the value to add to application date to
     * obtain disbursement date if express prcoessing was requested as 3
     */
    public static final int EXPRESS_PROCESSING_DATE_Y = 3;

    /**
     * setting variable for the value to add to application date to
     * obtain disbursement date if express prcoessing was requested as 21
     */
    public static final int EXPRESS_PROCESSING_DATE_N = 21;
    
    /**
     * setting variable for a total mumber of days in a week as 7
     */
    public static final int DAYS_IN_WEEK = 7;
    
    /**
     * setting variable for constant in Zeller's formula as 400
     */
    public static final int ZELLERS_VARIABLE_400 = 400;
    
    /**
     * setting variable for constant in Zeller's formula as 14
     */
    public static final int ZELLERS_VARIABLE_14 = 14;
    
    /**
     * setting variable for constant in Zeller's formula as 4
     */
    public static final int ZELLERS_VARIABLE_4 = 4;
    
    /**
     * setting variable for a border value while calculating 
     * the disbursement date as 10
     */
    public static final int DATE_LIMIT_10 = 10;
    
    /**
     * setting variable for a border value while calculating 
     * the disbursement date as 9
     */
    public static final int DATE_LIMIT_9 = 9;
    
    /**
     * setting variable for a border value while calculating 
     * the disbursement date as 27
     */
    public static final int DATE_CHECK_27 = 27;
    
    /**
     * setting variable for a border value while calculating 
     * the disbursement date as 28
     */
    public static final int DATE_CHECK_28 = 28;
    
    /**
     * setting variable for a border value while calculating 
     * the disbursement date as 29
     */
    public static final int DATE_CHECK_29 = 29;
    
    /**
     * setting a variable for case 3 in a switch statement
     */
    public static final int DAY_OF_WEEK_CASE3 = 3;
    
    /**
     * setting a variable for case 4 in a switch statement
     */
    public static final int DAY_OF_WEEK_CASE4 = 4;
    
    /**
     * setting a variable for case 5 in a switch statement
     */
    public static final int DAY_OF_WEEK_CASE5 = 5;
    
    /**
     * setting a variable for case 6 in a switch statement
     */
    public static final int DAY_OF_WEEK_CASE6 = 6;    

    /**
     * Test the power of pre-defined test cases. 
     * @param args command line arguments (not used)
     */
    public static void main(String[] args){

        System.out.println("                   Welcome to Wolfpack finance!"); 
        System.out.println("Applications for loans from $1000 to $10000 will be accepted from");
        System.out.println("June 1 to August 15, 2023. All loans will be paid back over a");
        System.out.println("4 year period. When prompted, please enter today's date, your credit");
        System.out.println("score, your 2022 income, and the loan amount. Loans are normally paid");
        System.out.println("out 21 days after the application date, but for a fee of $30, which");
        System.out.println("will be added to the loan amount, you may request Express Processing");
        System.out.println("in which case the loan will be paid out 3 days after the application");
        System.out.println("date. If your loan is approved, the loan amount, interest rate,");
        System.out.println("disbursement date, and monthly payment amount will be output.");
        System.out.println("");

        Scanner console = new Scanner(System.in);
        System.out.print("Month & Day (eg. 5 25 (May 25th)): ");
        int month = console.nextInt();
        int day = console.nextInt();
        if(!isValidDate(month, day)) {
            System.out.println("Invalid date");
            System.exit(1);
        }

        console.nextLine();

        System.out.print("Credit Score (300 - 850): ");
        int creditScore = console.nextInt();
        if(creditScore < MIN_CREDIT_SCORE || creditScore > MAX_CREDIT_SCORE){
            System.out.println("Invalid credit score");
            System.exit(1);
        }

        System.out.print("2022 Income: ");
        int income = console.nextInt();
        if(income < 0){
            System.out.println("Invalid income");
            System.exit(1);
        }

        System.out.print("Loan Amount ($1000 - $10000): ");
        int loanAmount = console.nextInt();
        if(loanAmount < MIN_LOAN_AMOUNT || loanAmount > MAX_LOAN_AMOUNT){
            System.out.println("Invalid loan amount");
            System.exit(1);
        }

        System.out.print("Express Processing (y/n):");
        String ep = console.next();
        char epf = ep.charAt(0);
        boolean expressProcessing = false;
        if(epf == 'y' || epf == 'Y') {
            expressProcessing = true;
        } else {
            expressProcessing = false;
        }

        if(expressProcessing){
            loanAmount += EXPRESS_PROCESSING_FEE;
        }

        System.out.println(" ");

        double la = getInterestRate(loanAmount,creditScore,income);
        if(isValidDate(month, day) && la != -1.0) {
            System.out.println("Loan Amount: $" + (double) loanAmount);
            System.out.println("Interest Rate: " + la + "%");
            double mp = getMonthlyPayment(loanAmount, la, TIME_PERIOD_MONTHS);
            String print = "Monthly payment: $%.2f";
            System.out.printf(print,mp);
            System.out.println("");
            String dd = getDisbursementDate(month, day, expressProcessing);
            System.out.println("Disbursement date: " + dd);
        } else {
            System.out.println("Loan denied");
        }

    }

    /**
     * Checks to see if the date entered by the user in valid
     * @param month of the current date
     * @param day of the current date
     * @return true if the date is between June 1 and August 15, otherwise false
     */
    public static boolean isValidDate(int month, int day){

        if(month == JUNE && (day > 0 && day <= TOTAL_DAYS_JUNE)){
            return true;
        } else if(month == JULY && (day > 0 && day <= TOTAL_DAYS_JULY)) {
            return true;
        } else if (month == AUGUST){
            if (day >= 1 && day <= ALLOWED_DAYS_AUGUST){
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    /**
     * Determines if a loan can be approved by checking if the data entered are within the
     * parameters given; loan amount, credit score, and income from 2022.
     * @param loanAmount user needs to borrow
     * @param creditScore from 2022
     * @param income made in 2022
     * @return interest rate if loan is approved else, -1.0 if the loan is not approved
     * @throws IllegalArgumentException if loan amount is less than or equal to zero
     * @throws IllegalArgumentException if credit score is less than 300 or greater than 850
     * @throws IllegalArgumentException if income is less than zero
     */
    public static double getInterestRate(int loanAmount, int creditScore, int income){
        if (loanAmount <= 0){
            throw new IllegalArgumentException("Invalid loan amount");
        } else if(creditScore < MIN_CREDIT_SCORE || creditScore > MAX_CREDIT_SCORE){
            throw new IllegalArgumentException("Invalid credit score");
        } else if(income < 0){
            throw new IllegalArgumentException("Invalid income");
        }
        double finalRate = 0;
        if(creditScore >= UPPER_TEST_CREDIT_SCORE){
            finalRate = FINAL_INTEREST_RATE_75;
        } else if(creditScore < UPPER_TEST_CREDIT_SCORE && income >= LOAN_AMOUNT_5 * loanAmount){
            finalRate = FINAL_INTEREST_RATE_8;
        } else if(creditScore >= MID_TEST_CREDIT_SCORE && income >= LOAN_AMOUNT_3 * loanAmount) {
            finalRate = FINAL_INTEREST_RATE_85;
        } else if(creditScore >= LOWER_TEST_CREDIT_SCORE && income >= 2 * loanAmount){
            finalRate = FINAL_INTEREST_RATE_9;
        } else {
            finalRate = INTEREST_RATE_DENIED;
        }
        return finalRate;
    }

    /**
     * Calculates the monthly payment amount for the loan based on the loan amount, annual interest
     * rate, and the number of months using the monthly payment formula
     * @param loanAmount the amount of money the user wants to borrow
     * @param annualInterestRate the interest rate for the loan given
     * @param numberOfMonths over which the loan is being repaid
     * @return monthly payment amount
     * @throws IllegalArgumentException if loan amount is less than or equal to zero
     * @throws IllegalArgumentException if the interest rate is less than 0.5
     * @throws IllegalArgumentException if the number of months is less than or equal to zero
     */
    public static double getMonthlyPayment(double loanAmount, double annualInterestRate, 
        int numberOfMonths ){
        if(loanAmount <= 0){
            throw new IllegalArgumentException("Invalid loan amount");
        } else if (annualInterestRate < INTEREST_RATE_CHECKER_VALUE) {
            throw new IllegalArgumentException("Invalid interest rate");
        } else if (numberOfMonths <= 0){
            throw new IllegalArgumentException("Invalid number of months");
        }
        //loanAmount += 30; DO I NEED TO ADD THE EXPRESS PROCESSING RATE TO THE INCOME WHEN CALCULATING THIS?
        double numerator = ((annualInterestRate / MONTHS_IN_YEAR) / PERCENTAGE_100)
                * Math.pow(1 + ((annualInterestRate / MONTHS_IN_YEAR) / PERCENTAGE_100),
                numberOfMonths);
        double denominator = Math.pow(1 + ((annualInterestRate / MONTHS_IN_YEAR) / PERCENTAGE_100),
                numberOfMonths) - 1;
        double monthlyAmount = loanAmount * (numerator / denominator);
        return monthlyAmount;
    }

    /**
     * Determines the day of the week, date, month, and year the loan will be fully 
     * paid out based on the day and month of the application and if the user chooses 
     * express processing
     * @param applicationMonth month the loan application was submitted
     * @param applicationDay day the loan application was submitted
     * @param expressProcessing how long it took for the user to receive their loans
     * @return String with day of the week, date, month, and year the loan will be disbursed
     * @throws IllegalArgumentException if the application month and day are not between June 1 and
     * August 15
     */
    public static String getDisbursementDate(int applicationMonth, int applicationDay, 
        boolean expressProcessing){
        if(!isValidDate(applicationMonth, applicationDay)){
            throw new IllegalArgumentException("Invalid date");
        }
        int date = 0;
        int dMonth = applicationMonth;
        if(expressProcessing) {
            if(applicationMonth == JUNE) {
                if(applicationDay > 0 && applicationDay <= DATE_CHECK_27){
                    date += applicationDay + EXPRESS_PROCESSING_DATE_Y;
                } else if (applicationDay == DATE_CHECK_28) {
                    date = 1;
                    dMonth += 1;
                } else if (applicationDay == DATE_CHECK_29) {
                    date = 2;
                    dMonth += 1;
                } else if (applicationDay == TOTAL_DAYS_JUNE) {
                    date = 3;
                    dMonth += 1;
                }
            } else if (applicationMonth == JULY) {
                if(applicationDay > 0 && applicationDay <= DATE_CHECK_28){
                    date += applicationDay + EXPRESS_PROCESSING_DATE_Y;
                } else if (applicationDay == DATE_CHECK_29) {
                    date = 1;
                    dMonth += 1;
                } else if (applicationDay == TOTAL_DAYS_JUNE) {
                    date = 2;
                    dMonth += 1;
                } else if (applicationDay == TOTAL_DAYS_JULY) {
                    date = 3;
                    dMonth += 1;
                }
            } else if (applicationMonth == AUGUST) {
                date += applicationDay + EXPRESS_PROCESSING_DATE_Y;
            }
        } else if (!expressProcessing){
            if(applicationMonth == JUNE) {
                if(applicationDay > 0 && applicationDay <= DATE_LIMIT_9){
                    date += applicationDay + EXPRESS_PROCESSING_DATE_N;
                } else if (applicationDay > DATE_LIMIT_9) {
                    date = applicationDay - DATE_LIMIT_9;
                    dMonth += 1;
                }
            } else if (applicationMonth == JULY) {
                if(applicationDay > 0 && applicationDay <= DATE_LIMIT_10){
                    date += applicationDay + EXPRESS_PROCESSING_DATE_N;
                } else if (applicationDay > DATE_LIMIT_10) {
                    date = applicationDay - DATE_LIMIT_10;
                    dMonth += 1;
                }
            } else if (applicationMonth == AUGUST) {
                if(applicationDay > 0 && applicationDay <= DATE_LIMIT_10){
                    date += applicationDay + EXPRESS_PROCESSING_DATE_N;
                } else if (applicationDay > DATE_LIMIT_10) {
                    date = applicationDay - DATE_LIMIT_10;
                    dMonth += 1;
                }
            }
        }
        int w = CURRENT_YEAR - (ZELLERS_VARIABLE_14 - dMonth) / MONTHS_IN_YEAR;
        int x = w + w / ZELLERS_VARIABLE_4 - w / PERCENTAGE_100 + w / ZELLERS_VARIABLE_400;
        int z = dMonth + MONTHS_IN_YEAR * ((ZELLERS_VARIABLE_14 - dMonth) / MONTHS_IN_YEAR) - 2;
        int dow = (date + x + (TOTAL_DAYS_JULY * z) / MONTHS_IN_YEAR) % DAYS_IN_WEEK;

        String dayName = "";
        switch(dow) {
            case 0:
                dayName = "Sun";
                break;
            case 1:
                dayName = "Mon";
                break;
            case 2:
                dayName = "Tue";
                break;
            case DAY_OF_WEEK_CASE3:
                dayName = "Wed";
                break;
            case DAY_OF_WEEK_CASE4:
                dayName = "Thu";
                break;
            case DAY_OF_WEEK_CASE5:
                dayName = "Fri";
                break;
            case DAY_OF_WEEK_CASE6:
                dayName = "Sat";
                break;
            default:
                dayName = "Sun";
                break;
        }

        String finalDisbursementDate = dayName + ", " + dMonth + " " + date + " " + CURRENT_YEAR;
        return finalDisbursementDate;
    }
}
