package com.company.ButtonPad;

import com.company.CalcCoordinates;

import java.util.ArrayList;

/**
 * This class represents a Pad with some grid specified.
 */
public abstract class GridButtonPad implements ButtonPad {
    private final ArrayList<CalcCoordinates> calcCoordinates;

    /**
     * Constructor
     * @param n : number of rows
     * @param m : number of columns
     * @param size : size of a button
     * @param space : space between buttons
     * @param v : left upper corner coordinates
     */
    public GridButtonPad(int n, int m, int size, int space, CalcCoordinates v) {
        int len = size + space;
        calcCoordinates = new ArrayList<>();
        for(int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++)
                calcCoordinates.add(new CalcCoordinates(v.getX() + len * j, v.getY() + len * i));
        }
    }

    /**
     * Getter. Deletes first vector and returns it.
     * Vectors are ordered like we read text.
     * @return next vector in grid or null when there are no vectors to return.
     */
    protected final CalcCoordinates getNextVector() {
        if(calcCoordinates.isEmpty())
            return null;
        else
            return calcCoordinates.remove(0);
    }
}
