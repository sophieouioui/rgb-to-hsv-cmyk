import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int r = scanner.nextInt();
        int g = scanner.nextInt();
        int b = scanner.nextInt();
        double[] hsv = Converter.toHSV(r, g, b);
        System.out.println("hsv");
        for (int i = 0; i < 3; i++) {
            System.out.print((int) hsv[i] + " ");
        }
        System.out.println();
        double[] cmyk = Converter.toCMYK(r, g, b);
        System.out.println("cmyk");
        for (int i = 0; i < 4; i++) {
            System.out.print((int) cmyk[i] + " ");
        }
    }
}
