public class Converter {
    static public double[] toHSV(double r, double g, double b) {
        double M = Math.max(r, Math.max(g, b));
        double m = Math.min(r, Math.min(g, b));
        double v = M / 255 * 100;
        double h = -1.0;
        double s;
        if (M > 0) {
            s = (1 - m / M) * 100.0;
        } else {
            s = 0;
        }
        r = r / 255.0;
        g = g / 255.0;
        b = b / 255.0;

        double cmax = Math.max(r, Math.max(g, b));
        double cmin = Math.min(r, Math.min(g, b));
        double diff = cmax - cmin;

        if (cmax == cmin)
            h = 0;
        else if (cmax == r)
            h = (60 * ((g - b) / diff) + 360) % 360;
        else if (cmax == g)
            h = (60 * ((b - r) / diff) + 120) % 360;
        else if (cmax == b)
            h = (60 * ((r - g) / diff) + 240) % 360;
        return new double[]{h, s, v};
    }

    static public double[] toCMYK(int r, int g, int b) {
        double k = 1 - Math.max(r, Math.max(g, b)) / 255.0;
        double c = (1 - r / 255.0 - k) / (1 - k);
        double m = (1 - g / 255.0 - k) / (1 - k);
        double y = (1 - b / 255.0 - k) / (1 - k);
        return new double[]{Math.round(c * 100), Math.round(m * 100), Math.round(y * 100), Math.round(k * 100)};
    }
}
