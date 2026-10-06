/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package figuras;

import java.awt.Graphics;
import java.awt.Point;
import java.util.ArrayList;

/**
 *
 * @author josearielpereyra
 */
public class Trazo extends Figura{
    ArrayList<Point> puntos = new ArrayList<>();
    
    @Override
    public void dibujar(Graphics g) {
        g.setColor(color);
        for (int i = 1; i < puntos.size(); i++) {
            Linea segmento = new Linea(puntos.get(i - 1), puntos.get(i));
            segmento.setColor(color);
            segmento.dibujar(g);
        }
    }

    @Override
    public void actualizar(Point puntoActual) {
        puntos.add(puntoActual);
    }
    
}
