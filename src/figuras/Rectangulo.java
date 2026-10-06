package figuras;

import java.awt.Graphics;
import java.awt.Point;

public class Rectangulo extends Figura {
    protected Point puntoInicial;
    protected Point puntoFinal;

    public Rectangulo() {
        this(new Point(), new Point());
    }

    public Rectangulo(Point puntoInicial) {
        this(puntoInicial, puntoInicial);
    }

    public Rectangulo(Point puntoInicial, Point puntoFinal) {
        this.puntoInicial = puntoInicial;
        this.puntoFinal = puntoFinal;
    }

    protected int getX() {
        return Math.min(puntoInicial.x, puntoFinal.x);
    }

    protected int getY() {
        return Math.min(puntoInicial.y, puntoFinal.y);
    }

    protected int getAncho() {
        return Math.abs(puntoFinal.x - puntoInicial.x);
    }

    protected int getAlto() {
        return Math.abs(puntoFinal.y - puntoInicial.y);
    }

    @Override
    public void dibujar(Graphics g) {
        if (puntoInicial != null && puntoFinal != null) {
            g.setColor(color);
            g.drawRect(getX(), getY(), getAncho(), getAlto());
        }
    }

    @Override
    public void actualizar(Point puntoActual) {
        puntoFinal = puntoActual;
    }
}

class RectanguloRelleno extends Rectangulo {

    public RectanguloRelleno() {
        super();
    }

    public RectanguloRelleno(Point puntoInicial) {
        super(puntoInicial);
    }

    public RectanguloRelleno(Point puntoInicial, Point puntoFinal) {
        super(puntoInicial, puntoFinal);
    }

    @Override
    public void dibujar(Graphics g) {
        if (puntoInicial != null && puntoFinal != null) {
            g.setColor(color);
            g.fillRect(getX(), getY(), getAncho(), getAlto());
        }
    }
}