package com.example.uno.uno.tttActionMessage.actions;

import com.example.uno.UnoState;
import com.example.uno.game.GameFramework.actionMessage.GameAction;
import com.example.uno.game.GameFramework.infoMessage.GameState;
import com.example.uno.game.GameFramework.players.GamePlayer;

public class unoCallUno extends GameAction implements GameState {
    /**
     * constructor for GameAction
     *
     * @param player the player who created the action
     */
    public unoCallUno(GamePlayer player, UnoState callUno) {
        super(player);
    }
}
