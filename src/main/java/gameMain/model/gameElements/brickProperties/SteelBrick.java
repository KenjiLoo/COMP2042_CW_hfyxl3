package gameMain.model.gameElements.brickProperties;

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

import java.awt.*;
import java.awt.geom.Point2D;
import java.util.Random;

/**
 * This class specifies the properties of the steel brick seen in the gameplay
 *
 * Refactored by:
 * @author LooXuenYi
 */
public class SteelBrick extends Brick {

    //Variable Declaration
    private static final String NAME = "Steel Brick";
    private static final Color DEF_INNER = new Color(203, 203, 201);
    private static final Color DEF_BORDER = Color.BLACK;
    private static final int STEEL_STRENGTH = 1;
    private static final double STEEL_PROBABILITY = 0.4;
    private Random rnd;
    private Shape brickFace;

    /**
     * This constructor specifies the point (location) of the steel brick and dimensions, with the properties specified in the abstract class "Brick"
     *
     * @param point
     * @param size
     */
    public SteelBrick(Point point, Dimension size)
    {
        super(NAME,point,size,DEF_BORDER,DEF_INNER,STEEL_STRENGTH);
        rnd = new Random();
        brickFace = super.brickFace;
    }

    @Override
    protected Shape makeBrickFace(Point pos, Dimension size) {
        return new Rectangle(pos,size);
    }

    /**
     * This method is used to get the steel brick's appearance
     *
     * @return brickFace
     */
    @Override
    public Shape getBrick() {
        return brickFace;
    }

    /**
     * This method checks if the steel brick is broken or have cracks whenever there is an impact on the brick
     *
     * @param point
     * @param dir
     * @return super.isBroken()
     */
    public boolean setImpact(Point2D point , int dir)
    {
        if(super.isBroken())
            return false;
        impact();
        return super.isBroken();
    }

    /**
     * This method sets the instructions on how the steel brick breaks, which is based on chance.
     * It generates a random number, and if it's less than the STEEL_PROBABILITY, it breaks
     */
    public void impact()
    {
        if(rnd.nextDouble() < STEEL_PROBABILITY){
            super.impact();
        }
    }

}
