package presentation;

import dao.IDaoImpl;
import metier.IMetier;
import metier.IMetierImpl;

public class Main {
    public static void main(String[] args) {
        IDaoImpl dao = new IDaoImpl();
        IMetierImpl metier = new IMetierImpl();
        metier.setDao(dao);
        System.out.println(metier.calcule());
        // pour eviter 
    }
}
