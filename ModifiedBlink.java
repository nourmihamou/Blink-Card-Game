import java.util.Scanner;

/**
 * This program prompts the user to input the cards to match, player one's 
 * cards, and player two's cards, and then outputs the result of the hand. Each 
 * card is entered as a 5 character string. The cards to match are entered on one line. 
 * E.g., if 1YEMO 3BLST is entered, the cards to match are One Yellow Moon and 
 * Three Blue Stars. Player one's cards are enterend on one line, as are player two's 
 * cards. After the input is read, each player's hand is printed followed by the result 
 * of the match.
 *
 * @author Nour M. and Lulama N.
 * @version 03/28/2021
 */
public class ModifiedBlink
{
    public static void main(String[] args)
    {
        Scanner keyboard = new Scanner(System.in);

        System.out.print("Input the cards to match: ");
        String cardsDrawn = keyboard.nextLine();
        System.out.println();

        System.out.print("Input player one's cards: ");
        String cardsPlayerOne = keyboard.nextLine();
        System.out.println();

        System.out.print("Input player two's cards: ");
        String cardsPlayerTwo = keyboard.nextLine();
        System.out.println();

        keyboard.close();

        System.out.println("Player One's Hand: ");
        printPlayersCardsMatches(1, cardsPlayerOne, cardsDrawn);
        System.out.println();

        System.out.println("Player Two's Hand: ");
        printPlayersCardsMatches(2, cardsPlayerTwo, cardsDrawn);
        System.out.println();

        printHandResults(cardsPlayerOne, cardsPlayerTwo, cardsDrawn);
    }

    /**
     * This function prints the player's hand, the cards on the table, and how the 
     * player's cards match the cards on the table. 
     * E.g., if the input cards to match are 1YEMO 3BLST and the input player one's 
     * hand is 3REMO 2YELB 1BLMO, then this function would print
     * 
     * Player One's Hand:
     * Three Red Moons matches One Yellow Moon on Shape
     * Three Red Moons matches Three Blue Stars on Number
     * Two Yellow Lightning Bolts matches One Yellow Moon on Color
     * Two Yellow Lightning Bolts does not match Three Blue Stars
     * One Blue Moon matches One Yellow Moon on Number, Shape
     * One Blue Moon matches Three Blue Stars on Color
     *
     * @param playerNumber 
     * @param playersCards
     * @param cardsToMatch
     * 
     */
    public static void printPlayersCardsMatches(int playerNumber, String playersCards, String cardsToMatch)
    {
        String card1 = playersCards.substring(0,5);
        String card2 = playersCards.substring(6,11);
        String card3 = playersCards.substring(12,17);

        String cardToMatch1 = cardsToMatch.substring(0,5);
        String cardToMatch2 = cardsToMatch.substring(6,11);

        if(isMatch(card1, cardToMatch1) == true || isMatch(card1, cardToMatch1) != true){
            System.out.println(getMatchDescription(card1, cardToMatch1));
        } 

        if(isMatch(card1, cardToMatch2) == true || isMatch(card1, cardToMatch2) != true){
            System.out.println(getMatchDescription(card1, cardToMatch2));
        } 

        if(isMatch(card2, cardToMatch1) == true || isMatch(card2, cardToMatch1) != true){
            System.out.println(getMatchDescription(card2, cardToMatch1));
        }

        if(isMatch(card2, cardToMatch2) == true || isMatch(card2, cardToMatch2) != true){
            System.out.println(getMatchDescription(card2, cardToMatch2));
        } 

        if(isMatch(card3, cardToMatch1) == true || isMatch(card3, cardToMatch1) != true){
            System.out.println(getMatchDescription(card3, cardToMatch1));
        }

        if(isMatch(card3, cardToMatch2) == true || isMatch(card3, cardToMatch2) != true){
            System.out.println(getMatchDescription(card3, cardToMatch2));
        }

    }

    /**
     * This function returns a string describing how the first card matches the second card. E.g.,
     * Three Red Moons matches One Yellow Moon on Shape
     * If the cards do not match, an appropriate string is returned. E.g.,
     * Two Yellow Lightning Bolts does not match Three Blue Stars
     * 
     * @param firstCard The first card to match.
     * @param secondCard The second card to match.
     * @return A string describing how the strings match
     */
    public static String getMatchDescription(String firstCard, String secondCard)
    {
        String matchDescription = "";

        if(isMatch(firstCard, secondCard) == true) {
            matchDescription = getCardName(firstCard) + " matches " + getCardName(secondCard) + " on " + getMatches(firstCard, secondCard);
        } else {
            matchDescription = getCardName(firstCard) + " does not match " + getCardName(secondCard); 
        }

        return matchDescription;

    }

    /**
     * This function prints the results of a single hand. A hand is first won on cards. 
     * If a single card of one player matches both of the cards on the table, that card is counted 
     * only as one match. The player with the most matching cards wins. If there is a tie on cards, 
     * then a hand is won on points. One point is awarded for each way a player's card matches either or 
     * both cards on the table. If there is still a tie, then the hand ends in a tie.

     * 
     * @param card1 String The first player's hand.
     * @param card2 String The second player's hand.
     * @param cardsToMatch String The cards that each player is trying to match.
     * 
     * 
     */
    public static void printHandResults(String player1, String player2, String cardToMatch)
    {
        String c1P1= player1.substring(0,5); 
        String c2P1= player1.substring(6,11);
        String c3P1= player1.substring(12,17);

        String c1P2= player2.substring(0,5);
        String c2P2= player2.substring(6,11);
        String c3P2= player2.substring(12,17);

        String cardToMatch1= cardToMatch.substring(0,5);
        String cardToMatch2= cardToMatch.substring(6,11);

        int tallyP1 = 0;
        int tallyP2 = 0;
        int playerPts1 = 0;
        int playerPts2 = 0;

        if(isMatch(c1P1, cardToMatch1) == true || isMatch(c1P1, cardToMatch2) == true){
            tallyP1 += 1;
        }

        if(isMatch(c2P1, cardToMatch1) == true || isMatch(c2P1, cardToMatch2) == true){
            tallyP1 += 1;
        }

        if(isMatch(c3P1, cardToMatch1) == true || isMatch(c3P1, cardToMatch2) == true){
            tallyP1 += 1;
        }

        if(isMatch(c1P2, cardToMatch1) == true || isMatch(c1P2, cardToMatch2) == true){
            tallyP2 += 1;
        }

        if(isMatch(c2P2, cardToMatch1) == true || isMatch(c2P2, cardToMatch2) == true){
            tallyP2 += 1;
        }

        if(isMatch(c3P2, cardToMatch1) == true || isMatch(c3P2, cardToMatch2) == true){
            tallyP2 += 1;
        }

        if (tallyP1 > tallyP2){
            System.out.println("Player 1 wins on cards!");
        } else if (tallyP1< tallyP2){
            System.out.println("Player 2 wins on cards!");        
        } else if (tallyP1 == tallyP2){
            playerPts1 = getIndividualPoints(c1P1, cardToMatch1) + getIndividualPoints(c1P1, cardToMatch2); 
            playerPts1 = playerPts1 + getIndividualPoints(c2P1, cardToMatch1) + getIndividualPoints(c2P1, cardToMatch2);
            playerPts1 = playerPts1 + getIndividualPoints(c3P1, cardToMatch1) + getIndividualPoints(c3P1, cardToMatch2);

            playerPts2 = getIndividualPoints(c1P2, cardToMatch1) + getIndividualPoints(c1P2, cardToMatch2);
            playerPts2 = playerPts2 + getIndividualPoints(c2P2, cardToMatch1) + getIndividualPoints(c2P2, cardToMatch2);
            playerPts2 = playerPts2 + getIndividualPoints(c3P2, cardToMatch1) + getIndividualPoints(c3P2, cardToMatch2);
            if(playerPts1 > playerPts2){
                System.out.println("Player 1 wins on points!");        
            } else if (playerPts1 < playerPts2){
                System.out.println("Player 2 wins on points!");
            } else {
                System.out.println("Player 1 and Player 2 Tie!");
            }
        } 
    }

    /**
     * This function returns true if the input cards match in at least one way (number, color, or shape), and
     * false otherwise. E.g., if the first card is 3REMO and the second card is 3BLSU, this function returns 
     * true because both cards have the number 3.
     * 
     * @param card1 String The first card.
     * @param card2 String The second card.
     * @return True if the cards match false otherwise.
     * 
     */
    public static boolean isMatch(String card1, String card2)
    {
        boolean match = false ;

        if(getIndividualPoints(card1, card2) >= 1){
            match = true;
        }

        return match;
    }

    /**
     * This function determines the number of ways the cards match. Each way they match is one point.
     * Cards can match on number, color, or shape. E.g., if the first card is 3REMO and the second 
     * card is 3BLSU, this function would return 1 because the cards only match on number.
     * 
     * @param card1 The first card.
     * @param card2 The second card.
     * @return The number of ways the cards match.
     * 
     */
    public static int getIndividualPoints(String card1, String card2)
    {
        int individualPoints = 0;
        String totalMatches = getMatches(card1, card2);

        if(totalMatches.length() >= 5){
            individualPoints = 1;
        }

        if (totalMatches.length() >= 8){
            individualPoints = 2;
        } 

        if (totalMatches.length() == 20){
            individualPoints = 3;
        }

        return individualPoints;
    }

    /**
     * This function returns a desription of how the two input cards match. Commas seperates matches. 
     * If the cards do not match, the empty string is returned.
     * 
     * @param card1 The first card. E.g., 3REMO
     * @param card2 The second card. E.g., 3BLMO
     * @return A description of how the two input cards match. E.g., for this example, Number, Shape
     * 
     */
    public static String getMatches(String card1, String card2)
    {
        String finalMatches = "";

        String numbersMatch = "";
        String colorsMatch = "";
        String shapesMatch = "";

        if(card1.charAt(0) == card2.charAt(0)){
            numbersMatch = "Number";
            if(card1.substring(1,3).equals(card2.substring(1,3))){
                colorsMatch = ", Color";
            }
            if(card1.substring(3,5).equals(card2.substring(3,5))){
                shapesMatch = ", Shape";
            }
        } else if(card1.substring(1,3).equals(card2.substring(1,3))){
            colorsMatch = "Color";
            if(card1.substring(3,5).equals(card2.substring(3,5))){
                shapesMatch = ", Shape";
            }
        } else if(card1.substring(3,5).equals(card2.substring(3,5))){
            shapesMatch = "Shape";
        }

        finalMatches = numbersMatch + colorsMatch + shapesMatch;

        return finalMatches;
    }

    /**
     * This function returns the name of the card in long form. E.g., if the input card 
     * is 3REMO, this function would return Three Red Moons. If the input card is 1BLSU, 
     * this function would return One Blue Sun.
     * 
     * @param shortName The short name of the card.
     * @return The long form name of the card using the correct plural noun.
     */
    public static String getCardName(String shortname)
    {
        String fullNum = "";
        String fullColor = "";
        String fullShape = "";

        for(int i = 0; i <= 5; i++)
        {
            int numberFromInput = Integer.parseInt(shortname.substring(0,1));

            String colorFromInput = shortname.substring(1,3);

            String shapeFromInput = shortname.substring(3,5);

            if(numberFromInput == i) {
                fullNum = getNumberName(numberFromInput);
            }

            if(colorFromInput.equals("YE")){
                fullColor = getColorName(colorFromInput);
            } else if(colorFromInput.equals("RE")){
                fullColor = getColorName(colorFromInput);
            } else if(colorFromInput.equals("GR")){
                fullColor = getColorName(colorFromInput);
            } else if(colorFromInput.equals("BL")){
                fullColor = getColorName(colorFromInput);
            } else if(colorFromInput.equals("BR")){
                fullColor = getColorName(colorFromInput);
            } else if(colorFromInput.equals("GY")){
                fullColor = getColorName(colorFromInput);
            }

            if(shapeFromInput.equals("MO") && numberFromInput > 1){
                fullShape = getShapeName(shapeFromInput) + "s";
            } else if(shapeFromInput.equals("SU")&& numberFromInput > 1){
                fullShape = getShapeName(shapeFromInput) + "s";
            } else if(shapeFromInput.equals("ST") && numberFromInput > 1){
                fullShape = getShapeName(shapeFromInput) + "s";
            } else if(shapeFromInput.equals("SN") && numberFromInput > 1){
                fullShape = getShapeName(shapeFromInput) + "s";
            } else if(shapeFromInput.equals("LB") && numberFromInput > 1){
                fullShape = getShapeName(shapeFromInput) + "s";
            } else if(shapeFromInput.equals("RA") && numberFromInput > 1){
                fullShape = getShapeName(shapeFromInput) + "s";
            } else {
                fullShape = getShapeName(shapeFromInput);
            }
        }

        return fullNum + " " + fullColor + " " + fullShape;

    }

    /**
     * This function returns the name of the input number for numbers in [1, 5]. 
     * E.g., if 1 is input, One is returned.
     * 
     * @param num An integer in [1,5].
     * @return The name of the number
     */
    public static String getNumberName(int num)
    {
        String numName = "";

        if(num == 1){
            numName = "One";
        } else if(num == 2){
            numName = "Two";
        } else if(num == 3){
            numName = "Three";
        } else if(num == 4){
            numName = "Four";
        } else if(num == 5){
            numName = "Five";
        }

        return numName;
    }

    /**
     * This function returns the name of the input color. Colors include Yellow (YE), 
     * Red (RE), Green (GR),Blue (BL), Brown (BR), and Grey (GY). E.g., if BR is input, 
     * Brown is output.
     * 
     * @param color The short form of the color.
     * @return The name of the color/
     */
    public static String getColorName(String color)
    {
        String colorName = "";

        if(color.equals("YE")){
            colorName = "Yellow";
        } else if(color.equals("RE")){
            colorName = "Red";
        } else if(color.equals("GR")){
            colorName = "Green";
        } else if(color.equals("BL")){
            colorName = "Blue";
        } else if(color.equals("BR")){
            colorName = "Brown";
        } else if(color.equals("GY")){
            colorName = "Grey";
        }

        return colorName;
    }

    /**
     * This function returns the name of the input shape. Shapes include Moon (MO), Sun (SU), 
     * Star (ST), Snowflake (SN), Lightning Bolt (LB), and Raindrop (RA). E.g., if MO is 
     * input, Moon is output.
     * 
     * @param shape The Short form of the shape.
     * @return The name of the shape.
     * 
     */
    public static String getShapeName(String shape)
    {
        String shapeName = "";

        if(shape.equals("MO")){
            shapeName = "Moon";
        } else if(shape.equals("SU")){
            shapeName = "Sun";
        } else if(shape.equals("ST")){
            shapeName = "Star";
        } else if(shape.equals("SN")){
            shapeName = "Snowflake";
        } else if(shape.equals("LB")){
            shapeName = "Lightning Bolt";
        } else if(shape.equals("RA")){
            shapeName = "Raindrop";
        }

        return shapeName;
    }
}
