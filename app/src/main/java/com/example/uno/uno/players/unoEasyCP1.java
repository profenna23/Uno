package com.example.uno.uno.players;

import com.example.uno.game.GameFramework.infoMessage.GameInfo;
import com.example.uno.game.GameFramework.players.GameComputerPlayer;

public class unoEasyCP1 extends GameComputerPlayer {

    // add constructor - takes string name
    // call super

    @Override
    protected void receiveInfo(GameInfo info) {
        // if gameinfo is a gamestate obj
        // randomly pick card from hand
        // take game, send new playcard action

        game.sendAction(new unoPlayCard(cardToPlay));

    }
}
