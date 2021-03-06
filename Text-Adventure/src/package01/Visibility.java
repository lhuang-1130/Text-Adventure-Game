package package01;

public class Visibility {
    userInterface ui;
    public Visibility(userInterface ui){
        this.ui = ui;
    }

    public void showTitleScreen(){
        //display the title screen
        ui.titleNamePanel.setVisible(true);
        ui.start.setVisible(true);

        //hide the game screen
        ui.mainTextPanel.setVisible(false);
        ui.choiceButtonPanel.setVisible(false);
        ui.playerPanel.setVisible(false);
    }

    public void showGameScreen(){
        ui.titleNamePanel.setVisible(false);
        ui.start.setVisible(false);

        //hide the game screen
        ui.mainTextPanel.setVisible(true);
        ui.choiceButtonPanel.setVisible(true);
        ui.playerPanel.setVisible(true);
    }
}

