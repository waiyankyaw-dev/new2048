package controller;

import model.GridNumber;
import view.GamePanel;


/**
 * This class is used for interactive with JButton in GameFrame.
 */
public class GameController {
    private GamePanel view;
    private GridNumber model;


    public GameController(GamePanel view, GridNumber model) {
        this.view = view;
        this.model = model;

    }
    public void restartGame() {
        model.restart();
        view.updateGridsNumber();
        view.afterMove();
        System.out.println("Do restart game here");
    }

    public void redoGame() {
        model.redo();
        view.updateGridsNumber();
        System.out.println("Do redo game here");
        view.afterMove();
    }

    public void saveGame(String filePath){
        model.save(filePath);
    }

    public void loadGame(String filePath, String username, int size){
        model.load(filePath, username, size);
        view.updateGridsNumber();;
        view.afterMove();
    }

    public void exitGame(String username){
        model.save(username);
    }




    //todo: add other methods such as loadGame, saveGame...

}
