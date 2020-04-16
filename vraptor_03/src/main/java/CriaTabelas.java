/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author maeh
 */
import javax.persistence.Persistence;

public class CriaTabelas {
    public static void main(String[] args) {
        Persistence.createEntityManagerFactory("vraptorc");
    }
}