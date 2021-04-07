package com.example.uno.uno.players;

import android.view.View;

import com.example.uno.game.GameFramework.players.GameHumanPlayer;

public class unoHumanPlayer extends GameHumanPlayer {

    // on clicks/taps - send the game a move (as in cp)
    // this class is the actual GUI interface - links to surfaceView
    @Override
    public View getTopView() {
        return null;
    }

    @Override
    public void receiveInfo(GameInfo info) {

    }

    @Override
    public void setAsGui(GameMainActivity activity) {

    }
}
