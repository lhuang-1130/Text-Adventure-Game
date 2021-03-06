package package01;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Game {
    userInterface ui = new userInterface();
    ChoiceHandler choiceHandler = new ChoiceHandler();
    Visibility visibility = new Visibility(ui);
    Story story = new Story(this, ui, visibility);

    String nextPosition1, nextPosition2, nextPosition3, nextPosition4;

    public static void main(String[] args) {
        new Game();
    }

    public Game(){
        ui.createUI(choiceHandler);
        visibility.showTitleScreen();
        story.defaultSetup();
    }

    public class ChoiceHandler implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            String choice = e.getActionCommand();
            switch (choice){
                case "Start":
                    visibility.showGameScreen();
                    story.townGate();
                    break;
                case "choice1":
                    story.selectPosition(nextPosition1);
                    break;
                case "choice2":
                    story.selectPosition(nextPosition2);
                    break;
                case "choice3":
                    story.selectPosition(nextPosition3);
                    break;
                case "choice4":
                    story.selectPosition(nextPosition4);
                    break;
            }
        }

        }
}
