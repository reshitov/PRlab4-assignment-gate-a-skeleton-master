package com.company.gate.logic;

/**
 * This file defines the Gate class.
 */
public class Gate { //класс gate использован в качестве воображаемых ворот загона
    // TODO -- Fill in your code here
    public static final int IN  = 1;//открытое внутреннее положение позволяя входить в загон
    public static final int OUT = -1; //открытое наружное положение позволяет улиткам покинуть загон
    public static final int CLOSED = 0; //закрытое положение
    private int mSwing;
    public Gate(){mSwing=CLOSED;}
    public boolean setSwing( int direction) //сетер
    {

        if(direction < -1 || direction > 1)
        {
            return false;
        }
        else
        {
            mSwing = direction;
            return true;
        }
    }
    public boolean open( int direction) //указывет направление при попытке открыть ворота
    {
        if(direction == IN || direction == OUT) {//Почему не сработало с direction != IN || direction != OUT
            setSwing(direction);//вспомогательный метод
            return true;
        }
        else
        {
            return false;
        }

    }
    public int thru(int count) //метод управления движения улиток внутри и снаружи загона
    {

        if(getSwingDirection() == IN){return count;}
        else if(getSwingDirection() == OUT){return -count;}
        else return 0;
    }

    public int getSwingDirection()
    {
        return mSwing;
    } //гетер


    public String toString() //резулотирующий вывод
    {
        String message;
        if(getSwingDirection() == CLOSED){message="This gate is closed";}
        else if (getSwingDirection()==IN){message="This gate is open and swings to enter the pen only";}
        else if (getSwingDirection()==OUT){message = "This gate is open and swings to exit the pen only";}
        else {message="This gate has an invalid swing direction";}
        return message;
    }

    public boolean close()
    {
        if(mSwing==IN||mSwing==OUT)
        {
            return false;
        }
        else
        {
            return true;
        }
    }

}
