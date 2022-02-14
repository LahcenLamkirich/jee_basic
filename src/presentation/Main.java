package presentation;

import dao.IDao;
import dao.IDaoImpl;
import metier.IMetier;
import metier.IMetierImpl;

import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException, FileNotFoundException {
        System.out.println("La version Statique !!");
        IDaoImpl dao = new IDaoImpl();
        IMetierImpl metier = new IMetierImpl();
        metier.setDao(dao);
        System.out.println(metier.calcule());
        /*
           Pour eviter l'initialisation statique
           on peut le faire d'une facon dynamique presenter comme suit:
         */
        // la declaration de la class DAO:
        Scanner scanner = new Scanner(new File("classes.txt"));
        String ClassNameDao = scanner.nextLine();
        Class DAO = Class.forName(ClassNameDao) ;
        IDaoImpl dao1 =(IDaoImpl) DAO.newInstance() ;
        // la declaration de la class Metier :
        Class METIER = Class.forName("metier.IMetierImpl") ;
        IMetierImpl metier1 = (IMetierImpl) METIER.newInstance() ;
        Method methode = metier1.getClass().getMethod("setDao", IDaoImpl.class);
        methode.invoke(metier1, dao1);
        System.out.println("La version Dynamique !!");
        System.out.println(metier1.calcule());
    }
}
