public class UserInterface {

    public void startGame() {
        Scanner in = new Scanner(System.in);
        startScreen();
        System.out.println("You were out hiking with some friends, when you suddenly fell down a hole.");
        System.out.println("You are in " + myAdventure.roomInformation());
        boolean gameFlag = true;
        while (gameFlag) {
            System.out.println("What do you wish to do?");
            String userInput = in.nextLine();
            if (userInput.equals("east") || (userInput.equals("go east")) || (userInput.equals("west")
                    || (userInput.equals("go west"))) || (userInput.equals("south") || (userInput.equals("go south"))
                    || (userInput.equals("north") || (userInput.equals("go north"))))) {
                if (myAdventure.tryToMoveRoom(userInput)) {
                    myAdventure.moveRoom(userInput);
                    System.out.println("You went to " + myAdventure.roomInformation());

                } else {
                    System.out.println("There is not a path here. Try to go another way");
                }


            } else if (userInput.equals("exit")) {
                gameFlag = false;
                System.out.println("You exited the game.");

            } else if (userInput.equals("look")) {
                System.out.println("You are in " + myAdventure.roomInformation());


            } else if (userInput.equals("help")) {
                System.out.println("Type go east, go north, go west, go south to " +
                        "move around the map.");
                System.out.println("Type exit to quit the game. Type look to get " +
                        "a description of the room. Type help for help.");
                System.out.println("Use the word -take- followed by the item you wish to take." +
                        "Example: take lamp.");


            } else if (userInput.equals("take lamp") || (userInput.equals("take sword")) ||
                    (userInput.equals("take statue")) || (userInput.equals("take apple")) ||
                    (userInput.equals("take potato")) || (userInput.equals("take bow"))) {
                String[] arrOfStr = userInput.split(" ");
                if (!myAdventure.roomItemsBool()) {
                    System.out.println("There is nothing to take in the room.");
                } else if (!myAdventure.tryToTakeItem(userInput)) {
                    System.out.println("Item could not be taken since its not in the room.");
                } else {
                    System.out.println(arrOfStr[1] + " taken from room and added to inventory!");
                }


            } else if (userInput.equals("drop lamp") || (userInput.equals("drop sword")) ||
                    (userInput.equals("drop statue")) || (userInput.equals("drop apple")) ||
                    (userInput.equals("drop potato")) || (userInput.equals("drop bow"))) {
                String[] arrOfStr = userInput.split(" ");
                if (!myAdventure.dropItems(userInput)) {
                    System.out.println(arrOfStr[1] + " is not in inventory and could not be dropped.");
                } else {
                    System.out.println(arrOfStr[1] + " dropped.");
                }


            } else if (userInput.equals("inventory")) {
                if (myAdventure.inventoryStatus()) {
                    System.out.println("In your inventory are: " + myAdventure.getStringInventory());
                } else {
                    System.out.println("There is nothing in your inventory");
                }

            } else if (userInput.equals("health")) {
                int health = myAdventure.getPlayerHealth();
                if (health > 50) {
                    System.out.println("You have " + health + " in health. You seem in good shape to fight.");
                } else if (health <= 50) {
                    System.out.println("You have " + health + " in health. You have less than half in health and probably should´nt fight right now.");
                }


            } else if ((userInput.equals("eat apple") || (userInput.equals("eat potato")))) {
                String[] arrOfStr = userInput.split(" ");
                if (myAdventure.lookForFood(userInput)) {
                    boolean myBool = myAdventure.eatFood(userInput);
                    if (myBool) {
                        System.out.println("Food eaten! It tasted great and your health increased!");
                    } else if (!myBool) {
                        System.out.println("The food was bad and you lost health!");
                    }
                } else {
                    System.out.println(arrOfStr[1] + " is neither in your inventory or in room and therefore cannot be eaten.");
                }
                if (myAdventure.getPlayerHealth() <= 0) {
                    System.out.println("You died. Game over!");
                    gameFlag = false;
                    break;
                }

            } else if (userInput.equals("equip bow") || (userInput.equals("equip sword"))) {
                if (myAdventure.weaponEquipped()) {
                    System.out.println("You already have a weapon equipped. Unequip your current weapon to equip a new one. To unequip just write the command: unequip");
                } else if (myAdventure.equipWeapon(userInput)) {
                    System.out.println("Weapon equipped!");
                } else {
                    System.out.println("Could´nt find weapon in inventory or in the room.");
                }

            } else if (userInput.equals("unequip")) {
                if (myAdventure.weaponEquipped()) {
                    myAdventure.unequipWeapon();
                    System.out.println("Weapon unequipped and added to inventory!");

                } else {
                    System.out.println("You have no weapon equipped and therefore nothing to unequip.");
                }


            } else if (userInput.equals("attack")) {
                if (myAdventure.checkForEnemy()) {
                    fightingLoop(in, myAdventure);
                    if (myAdventure.getPlayerHealth() <= 0) {
                        gameFlag = false;
                    }
                } else {
                    System.out.println("There is no enemy in this room.");
                }


            } else {
                System.out.println("Error, wrong input, try again.");
            }
        }
    }

    public void startScreen() {
        StringBuilder buildingString = new StringBuilder();
        buildingString.append("-----------------------------------------------");
        buildingString.append(System.getProperty("line.separator"));
        buildingString.append("                  Welcome to:          ");
        buildingString.append(System.getProperty("line.separator"));
        buildingString.append("            The caves of Darknezz!               ");
        buildingString.append(System.getProperty("line.separator"));
        buildingString.append("-----------------------------------------------");
        System.out.println(buildingString);
    }

}
