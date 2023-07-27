public abstract class AbstractCar implements Carinterface{
    protected int velocity;

    @Override
    public void brake(){
        if(this.velocity < 0) this.velocity = 0;
    }
}
