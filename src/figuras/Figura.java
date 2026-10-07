/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package figuras;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

public abstract class Figura {

    public enum TipoFigura {
        LINEA,
        TRAZO,
        RECTANGULO,
        RECTANGULO_RELLENO
    }

    protected Color color = Color.BLACK;
    public Color getColor() {
        return color;
    }
    public void setColor(Color color) {
        this.color = color;
    }
    
    public abstract void dibujar(Graphics g);
    public abstract void actualizar(Point puntoActual);

    public static Figura crear(TipoFigura tipo, Point puntoInicial) {
        switch (tipo) {
            case LINEA -> {
                return new Linea(puntoInicial);
            }
            case TRAZO -> {
                return new Trazo();
            }
            case RECTANGULO -> {
                return new Rectangulo(puntoInicial);
            }
            case RECTANGULO_RELLENO -> {
                return new RectanguloRelleno(puntoInicial);
            }
            default -> throw new IllegalArgumentException("Tipo de figura no soportado: " + tipo);
        }
    } 
}