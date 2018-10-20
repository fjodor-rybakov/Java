package task4;

public class TypeTable {
    public void getTypes() {
        System.out.printf("Type\tMin\tMax\tSize%n");
        System.out.printf("Long\t%d\t%d\t%d%n", Long.MIN_VALUE, Long.MAX_VALUE, Long.BYTES);
        System.out.printf("Integer\t%d\t%d\t%d%n", Integer.MIN_VALUE, Integer.MAX_VALUE, Integer.BYTES);
        System.out.printf("Short\t%d\t%d\t%d%n", Short.MIN_VALUE, Short.MAX_VALUE, Short.BYTES);
        System.out.printf("Byte\t%d\t%d\t%d%n", Byte.MIN_VALUE, Byte.MAX_VALUE, Byte.BYTES);
        System.out.printf("Double\t%f\t%f\t%d%n", Double.MIN_VALUE, Double.MAX_VALUE, Double.BYTES);
        System.out.printf("Float\t%f\t%f\t%d%n", Float.MIN_VALUE, Float.MAX_VALUE, Float.BYTES);
        System.out.printf("Char\t%c\t%c\t%d%n", Character.MIN_VALUE, Character.MAX_VALUE, Character.BYTES);
    }
}
