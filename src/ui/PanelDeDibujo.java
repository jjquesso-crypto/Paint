/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ui;

import figuras.Figura;
import figuras.Figura.TipoFigura;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import javax.swing.JPanel;

/**
 *
 * @author josearielpereyra
 */
public class PanelDeDibujo extends JPanel {

    ArrayList<Figura> figuras = new ArrayList<>();
    Figura figuraActual;
    private Color colorSeleccionado = Color.BLACK;
    private TipoFigura tipoSeleccionado = TipoFigura.LINEA;

    public PanelDeDibujo() {
        setBackground(Color.WHITE);
        MouseAdapter manejador = new MouseAdapter() {

            @Override
            public void mousePressed(MouseEvent e) {
                figuraActual = Figura.crear(tipoSeleccionado, e.getPoint());
                figuraActual.setColor(colorSeleccionado);
                figuras.add(figuraActual);
                repaint();
            }

            @Override
            public void mouseDragged(MouseEvent e) {
                figuraActual.actualizar(e.getPoint());
                repaint();
            }

        };
        addMouseListener(manejador);
        addMouseMotionListener(manejador);
    }

    public void setTipoSeleccionado(TipoFigura tipo) {
        this.tipoSeleccionado = tipo;
    }

    public void setColorSeleccionado(Color color) {
        this.colorSeleccionado = color;
    }
    
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        for (Figura figura : figuras) {
            figura.dibujar(g);
        }
    }

}
