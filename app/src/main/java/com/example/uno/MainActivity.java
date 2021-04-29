package com.example.uno;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.uno.game.GameFramework.GameMainActivity;
import com.example.uno.game.GameFramework.LocalGame;
import com.example.uno.game.GameFramework.gameConfiguration.GameConfig;
import com.example.uno.game.GameFramework.gameConfiguration.GamePlayerType;
import com.example.uno.game.GameFramework.infoMessage.GameState;
import com.example.uno.game.GameFramework.players.GamePlayer;
import com.example.uno.uno.players.unoEasyCP;
import com.example.uno.uno.players.unoHardCP;
import com.example.uno.uno.players.unoHumanPlayer;

import java.util.ArrayList;

public class MainActivity extends GameMainActivity {

    // we need to override the abstract methods from GameMainActivity
    // I can see what that looks like in the TTTMainActivity

    /**
     * sets up a default of one human and one computer player
     */
    @Override
    public GameConfig createDefaultConfig(){

        ArrayList<GamePlayerType> playerTypes = new ArrayList <>();


        playerTypes.add(new GamePlayerType("Local Human Player (blue-yellow)") {
            public GamePlayer createPlayer(String name) {
                return new unoHumanPlayer(name, R.layout.activity_main);
            }
        });

        playerTypes.add(new GamePlayerType("Computer Player (dumb)") {
            public GamePlayer createPlayer(String name) {
                return new unoEasyCP(name);
            }
        });

        playerTypes.add(new GamePlayerType("Computer Player (smart)") {
            public GamePlayer createPlayer(String name) {
                return new unoHardCP(name);
            }
        });

        GameConfig defaultConfig = new GameConfig(playerTypes, 2,4, "Uno", 0);

        defaultConfig.addPlayer("Human", 0); // yellow-on-blue GUI
        defaultConfig.addPlayer("Computer", 1);
        defaultConfig.addPlayer("Computer", 1);
        defaultConfig.addPlayer("Computer", 1);

        return defaultConfig;


    }

    /**
     *
     */
    @Override
    public LocalGame createLocalGame(GameState gameState) {
        if(gameState == null) {
            return new UnoLocalGame();
        }
        return new UnoLocalGame((UnoState) gameState);


    }
}