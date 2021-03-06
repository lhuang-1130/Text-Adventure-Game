package package01;

import package02.*;

public class Story {
    Game game;
    userInterface ui;
    Visibility visibility;
    Player player = new Player();
    SuperMonster monster;
    int treasure;
    public Story(Game game, userInterface ui, Visibility visibility){
        this.game = game;
        this.ui = ui;
        this.visibility = visibility;
    }

    public void defaultSetup(){
        player.hp = 15;
        ui.hpLabelNumber.setText("" + player.hp);

        player.currentWeapon = new Knife();
        ui.weaponLabelName.setText(player.currentWeapon.name);
        treasure = 0;
    }

    public void selectPosition(String position){
        switch (position){
            case "talkGuard":
                talkGuard();
                break;
            case "attackGuard":
                attackGuard();
                break;
            case "crossRoad":
                crossRoad();
                break;
            case "townGate":
                townGate();
                break;
            case "north":
                north();
                break;
            case "east":
                east();
                break;
            case "west":
                west();
                break;
            case "fight":
                fight();
                break;
            case "playerAttack":
                playerAttack();
                break;
            case "monsterAttack":
                monsterAttack();
                break;
            case "win":
                win();
                break;
            case "lose":
                lose();
                break;
            case "ending":
                ending();
                break;
            case "toTitle":
                toTitle();
                break;
        }
    }

    public void townGate(){
        //position = "Gate";
        ui.mainTextArea.setText("You are at the gate of the Wonderland! \nA guard is standing in front of you.  \n\nWhat are you planning to do?");
        ui.choice1.setText("Have a conversation.");
        ui.choice2.setText("Attack!");
        ui.choice3.setText("Say nothing and leave.");
        ui.choice4.setText("Stay and do nothing.");

        game.nextPosition1 = "talkGuard";
        game.nextPosition2 = "attackGuard";
        game.nextPosition3 = "crossRoad";
        game.nextPosition4 = "townGate";

    }

    public void talkGuard(){
        if(treasure == 0){
            ui.mainTextArea.setText("Hello kiddo. \nSorry but we cannot let a stranger in!");
            ui.choice1.setText("Go back.");
            ui.choice2.setText(" ");
            ui.choice3.setText(" ");
            ui.choice4.setText(" ");

            game.nextPosition1 = "townGate";
            game.nextPosition2 = " ";
            game.nextPosition3 = " ";
            game.nextPosition4 = " ";
        } else {
            ending();
        }
    }

    public void attackGuard(){
        ui.mainTextArea.setText("Guard: What? You think you can defeat me? \nThe Guard fought back and hit you! \n\n(You received 3 damage!)");
        player.hp -= 3;
        ui.hpLabelNumber.setText(""+ player.hp);
        ui.choice1.setText("Oops! Go back.");
        ui.choice2.setText(" ");
        ui.choice3.setText(" ");
        ui.choice4.setText(" ");

        game.nextPosition1 = "townGate";
        game.nextPosition2 = " ";
        game.nextPosition3 = " ";
        game.nextPosition4 = " ";
    }

    public void crossRoad(){
        ui.mainTextArea.setText("You are at a crossroad. \nIf you go south, you will go back to the Gate!");
        ui.choice1.setText("Go south");
        ui.choice2.setText("Go north");
        ui.choice3.setText("Go west");
        ui.choice4.setText("Go east");

        game.nextPosition1 = "townGate";
        game.nextPosition2 = "north";
        game.nextPosition3 = "west";
        game.nextPosition4 = "east";
    }

    public void north(){
        ui.mainTextArea.setText("There is a river.\nYou drink the water from the river and take a nap.\n\n(Your HP is increased by 2.)");
        player.hp += 2;
        ui.hpLabelNumber.setText(""+player.hp);
        ui.choice1.setText("Go south");
        ui.choice2.setText(" ");
        ui.choice3.setText(" ");
        ui.choice4.setText(" ");

        game.nextPosition1 = "crossRoad";
        game.nextPosition2 = " ";
        game.nextPosition3 = " ";
        game.nextPosition4 = " ";
    }

    public void east(){
        ui.mainTextArea.setText("You walk into a forest.\nThere is a sword on the ground.\nIt looks very cool!\n\n(You obtain a sword!)");
        player.currentWeapon = new Sword();
        ui.weaponLabelName.setText(player.currentWeapon.name);
        ui.choice1.setText("Go west");
        ui.choice2.setText(" ");
        ui.choice3.setText(" ");
        ui.choice4.setText(" ");

        game.nextPosition1 = "crossRoad";
        game.nextPosition2 = " ";
        game.nextPosition3 = " ";
        game.nextPosition4 = " ";
    }

    public void west(){
        int random = new java.util.Random().nextInt(13);

        if(random <= 3){
            monster = new Goblin();
        } else if (random > 3 && random <=7){
            monster = new Gandalf();
        } else if (random > 7 && random <=10){
            monster = new Fairy();
        } else {
            monster = new Voldemort();
        }

        ui.mainTextArea.setText("Oh!\nYou encounter a " + monster.name + "!");
        ui.choice1.setText("Fight!");
        ui.choice2.setText("Run!");
        ui.choice3.setText(" ");
        ui.choice4.setText(" ");

        game.nextPosition1 = "fight";
        game.nextPosition2 = "crossRoad";
        game.nextPosition3 = " ";
        game.nextPosition4 = " ";
    }

    public void fight(){
        ui.mainTextArea.setText("Monster HP: " + monster.hp + "\nThink about it again...\nWhat are you planning to do?");
        ui.choice1.setText("Ahh Attack!");
        ui.choice2.setText("Run!");
        ui.choice3.setText(" ");
        ui.choice4.setText(" ");

        game.nextPosition1 = "playerAttack";
        game.nextPosition2 = "crossRoad";
        game.nextPosition3 = " ";
        game.nextPosition4 = " ";
    }

    public void playerAttack(){
        int playerDamage = new java.util.Random().nextInt(player.currentWeapon.damage);;

        monster.hp -= playerDamage;

        ui.mainTextArea.setText("You attacked the monster and gave " + playerDamage + " damage!");

        ui.choice1.setText("->");
        ui.choice2.setText(" ");
        ui.choice3.setText(" ");
        ui.choice4.setText(" ");

        if(monster.hp < 1){
            game.nextPosition1 = "win";
            game.nextPosition2 = " ";
            game.nextPosition3 = " ";
            game.nextPosition4 = " ";
        } else {
            game.nextPosition1 = "monsterAttack";
            game.nextPosition2 = " ";
            game.nextPosition3 = " ";
            game.nextPosition4 = " ";
        }

    }

    public void monsterAttack(){
        int monsterDamage = new java.util.Random().nextInt(monster.damage);

        player.hp -= monsterDamage;
        ui.hpLabelNumber.setText("" + player.hp);

        ui.mainTextArea.setText(monster.attackMessage + "\nThe monster attacked you and gave  " + monsterDamage + " damage!");

        ui.choice1.setText("->");
        ui.choice2.setText(" ");
        ui.choice3.setText(" ");
        ui.choice4.setText(" ");

        if(player.hp < 0){
            game.nextPosition1 = "lose";
            game.nextPosition2 = " ";
            game.nextPosition3 = " ";
            game.nextPosition4 = " ";
        } else {
            game.nextPosition1 = "fight";
            game.nextPosition2 = " ";
            game.nextPosition3 = " ";
            game.nextPosition4 = " ";
        }
    }

    public void win(){

        ui.mainTextArea.setText("You defeat the monster! Yayyyy!\nThe monster drops a ring.\n\n(You obtain a ring!)");

        treasure = 1;

        ui.choice1.setText("Go east");
        ui.choice2.setText(" ");
        ui.choice3.setText(" ");
        ui.choice4.setText(" ");

        game.nextPosition1 = "east";
        game.nextPosition2 = " ";
        game.nextPosition3 = " ";
        game.nextPosition4 = " ";
    }

    public void lose(){
        ui.mainTextArea.setText("  Oh no :( You are dead...\n  Try again next time!\n\n  <GAME OVER>");

        ui.choice1.setText("Try again");
        ui.choice2.setText(" ");
        ui.choice3.setText(" ");
        ui.choice4.setText(" ");

        game.nextPosition1 = "toTitle";
        game.nextPosition2 = " ";
        game.nextPosition3 = " ";
        game.nextPosition4 = " ";
    }

    public void ending(){
        ui.mainTextArea.setText("  Guard: Oh I see your ring!\n  What a hero!\n  Welcome to Lily's Wonderland!\n\n  <Congrats!>");
        ui.choice1.setVisible(false);
        ui.choice2.setVisible(false);
        ui.choice3.setVisible(false);
        ui.choice4.setVisible(false);
    }

    public void toTitle(){
        defaultSetup();
        visibility.showTitleScreen();
    }





}
