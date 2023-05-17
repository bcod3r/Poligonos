package com.example.hackatoncun;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Esta clase resuelve el problema de contar el número de zonas negras en polígonos
 * después de llenarlos con tinta china negra.
 */
public class LlenandoPoligonos {
    /**
     * Punto de entrada del programa.
     *
     * @param args Los argumentos de la línea de comandos (no se utilizan).
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            int N = sc.nextInt();
            if (N == 0) {
                break;
            }

            List<Polygon> polygons = new ArrayList<>();

            for (int i = 0; i < N; i++) {
                int t = sc.nextInt();
                List<Point> points = new ArrayList<>();

                for (int j = 0; j < t; j++) {
                    int x = sc.nextInt();
                    int y = sc.nextInt();
                    points.add(new Point(x, y));
                }

                polygons.add(new Polygon(points));
            }

            polygons.stream()
                    .mapToInt(Polygon::countBlackZones)
                    .forEach(System.out::println);
        }

        sc.close();
    }
}

/**
 * Clase que representa un polígono.
 */
class Polygon {
    private List<Point> points;

    /**
     * Crea un polígono con los puntos especificados.
     *
     * @param points Los puntos que forman el polígono.
     */
    public Polygon(List<Point> points) {
        this.points = points;
    }

    /**
     * Cuenta el número de zonas negras en el polígono después de llenarlo con tinta china negra.
     *
     * @return El número de zonas negras.
     */
    public int countBlackZones() {
        int t = points.size();
        int blackZones = 1;

        for (int i = 0; i < t - 1; i++) {
            Point p1 = points.get(i);
            Point p2 = points.get(i + 1);
            int dx = Math.abs(p1.getX() - p2.getX());
            int dy = Math.abs(p1.getY() - p2.getY());
            blackZones += gcd(dx, dy) + 1;
        }

        Point p1 = points.get(t - 1);
        Point p2 = points.get(0);
        int dx = Math.abs(p1.getX() - p2.getX());
        int dy = Math.abs(p1.getY() - p2.getY());
        blackZones += gcd(dx, dy) + 1;

        return blackZones;
    }

    /**
     * Calcula el máximo común divisor de dos números.
     *
     * @param a El primer número.
     * @param b El segundo número.
     * @return El máximo común divisor.
     */
    private int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }
}

/**
 * Clase que representa un punto en un plano.
 */
class Point {
    private int x;
    private int y;


    /**
     * Crea un punto con las coordenadas especificadas.
     *
     * @param x La coordenada x del punto.
     * @param y La coordenada y del punto.
     */
    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Obtiene la coordenada x del punto.
     *
     * @return La coordenada x.
     */
    public int getX() {
        return x;
    }

    /**
     * Obtiene la coordenada y del punto.
     *
     * @return La coordenada y.
     */
    public int getY() {
        return y;
    }
}