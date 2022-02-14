package dao;

public class IDaoImpl implements IDao{
    @Override
    public double getData() {
       return 40*4/2*Math.cos(10*Math.PI) ;
    }

}
