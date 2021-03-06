package gameMain.controller;

/*
 *  Brick Destroy - A simple Arcade video game
 *   Copyright (C) 2021  Loo Xuen Yi
 *
 *  This program is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU General Public License as published by
 *  the Free Software Foundation, either version 3 of the License, or
 *  (at your option) any later version.
 *
 *  This program is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details.
 *
 *  You should have received a copy of the GNU General Public License
 *  along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

import gameMain.controller.gameFrameController.GameFrame;

import java.awt.*;
import java.io.IOException;
import java.io.File;
import javax.sound.sampled.*;

/**
 * This class is the main class that executes the software
 *
 * Refactored by:
 * @author LooXuenYi
 */
public class Main {

    /**
     * This method is the main method that runs the software, and outputs the audio for the background music
     *
     * @param args
     */
    public static void main(String[] args) throws UnsupportedAudioFileException, IOException, LineUnavailableException {
        EventQueue.invokeLater(() -> {
            try {
                new GameFrame().initialize();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        //plays the audio
        File file = new File("src/main/java/gameMain/controller/game_music.wav");
        AudioInputStream audioStream = AudioSystem.getAudioInputStream(file);
        Clip clip = AudioSystem.getClip();
        clip.open(audioStream);
        while(true) {
            clip.start();
        }
    }

}
