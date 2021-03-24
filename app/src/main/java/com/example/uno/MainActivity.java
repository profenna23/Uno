package com.example.uno;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.uno.game.GameFramework.GameMainActivity;
import com.example.uno.game.GameFramework.LocalGame;
import com.example.uno.game.GameFramework.gameConfiguration.GameConfig;
import com.example.uno.game.GameFramework.infoMessage.GameState;

public class MainActivity extends GameMainActivity {

    // we need to override the abstract methods from GameMainActivity
    // I can see what that looks like in the TTTMainActivity

    /**
     * sets up a default of one human and one computer player
     */
    @Override
    public GameConfig createDefaultConfig(){
        return null;
    }

    /**
     *
     */
    @Override
    public LocalGame createLocalGame(GameState gameState) {
        return null;
    }
}