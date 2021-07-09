package controller;

public class MouseCoordinates {
    private int Coord;
    private int Coord1;
    private MouseCoordinates mouse;

    public MouseCoordinates(int Coord,int Coord1)
    {
        this.Coord = Coord;
        this.Coord1 = Coord1;
    }

    public int getCoord()
    {
        return Coord;
    }

    public void setCoord(int Coord)
    {
        this.Coord = Coord;
    }

    public int getCoord1()
    {
        return Coord1;
    }

    public MouseCoordinates getMouse()
    {
        return mouse;
    }

    public void setCoord1(int Coord1)
    {
        this.Coord1 = Coord1;
    }
}
