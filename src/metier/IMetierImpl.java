package metier;

import dao.IDao;
import dao.IDaoImpl;

public class IMetierImpl implements IMetier {
    IDaoImpl dao; // eq : dao = null

    @Override
    public double calcule() {
        double result = dao.getData() * 2;
        return result;
    }

    public void setDao(IDaoImpl dao) {
        this.dao = dao;
    }
}
