package gameMain.view.debugConsole;

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

import gameMain.controller.wallProperties.Wall;
import javax.swing.*;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionListener;

/**
 * This class defines the style and layout of the debug console
 *
 * Refactored by:
 * @author LooXuenYi
 */
public class RenderDebugConsole extends JPanel {

    //Variable Declaration
    private static final Color DEF_BKG = Color.WHITE;
    private JButton skipLevel;
    private JButton resetBalls;
    private JSlider ballXSpeed;
    private JSlider ballYSpeed;
    private Wall wall;

    /**
     * This constructor renders all the components in the debug console
     *
     * @param wall
     */
    public RenderDebugConsole(Wall wall)
    {
        this.wall = wall;

        initialize();

        skipLevel = makeButton("Skip Level",e -> wall.nextLevel());
        resetBalls = makeButton("Reset Balls",e -> wall.resetBallCount());

        ballXSpeed = makeSlider(-4,4,e -> wall.setBallXSpeed(ballXSpeed.getValue()));
        ballYSpeed = makeSlider(-4,4,e -> wall.setBallYSpeed(ballYSpeed.getValue()));

        this.add(skipLevel);
        this.add(resetBalls);

        this.add(ballXSpeed);
        this.add(ballYSpeed);
    }

    /**
     * This method defines the layout of the debug console
     */
    private void initialize()
    {
        this.setBackground(DEF_BKG);
        this.setLayout(new GridLayout(2,2));
    }

    /**
     * This method defines the style of the button
     *
     * @param title
     * @param e
     * @return out
     */
    private JButton makeButton(String title, ActionListener e)
    {
        JButton out = new JButton(title);
        out.addActionListener(e);
        return out;
    }

    /**
     * This method defines the slider component in the debug console and make it functional
     *
     * @param min
     * @param max
     * @param e
     * @return out
     */
    private JSlider makeSlider(int min, int max, ChangeListener e)
    {
        JSlider out = new JSlider(min,max);
        out.setMajorTickSpacing(1);
        out.setSnapToTicks(true);
        out.setPaintTicks(true);
        out.addChangeListener(e);
        return out;
    }

    /**
     * This method allows the user to change the ball speed from the debug console
     *
     * @param x
     * @param y
     */
    public void setValues(int x,int y)
    {
        ballXSpeed.setValue(x);
        ballYSpeed.setValue(y);
    }

}
