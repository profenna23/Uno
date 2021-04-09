package com.example.uno.game.GameFramework.actionMessage;

import com.example.uno.game.GameFramework.players.GamePlayer;

/**
 * An action by which the player tells the game its name
 * (typically the human's name, if it's a GameHumanPlayer).
 *
 * @author Steven R. Vegdahl
 * @version July 2013
 */
public class ReadyAction extends GameAction {
    //Tag for logging
    private static final String TAG = "ReadyAction";
    // to satisfy the Serializable interface
    private static final long serialVersionUID = -5286032209480788772L;

    /** constructor
     *
     * @param p
     * 		the player who sent the action
     */
    public ReadyAction(GamePlayer p) {
        super(p);
    }
}
