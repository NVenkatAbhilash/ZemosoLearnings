package DesignPatterns.BridgePattern;

//Abstraction
abstract class ElectronicGoods
{
    //Composition - implementor
    protected State state;

    public State getState()
    {
        return state;
    }

    public void setState(State state)
    {
        this.state = state;
    }

    public void moveToCurrentState()
    {
        System.out.print("The electronic item is functioning at : ");
        state.moveState();
    }

    public void hardButtonPressed()
    {
        state.hardPressed();
    }
}
