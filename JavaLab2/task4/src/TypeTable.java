public class TypeTable {
    public void getTypes() {
        System.out.printf("Type\tMin\t\t\t\t\t\tMax\t\t\t\t\t\tSize%n");
        System.out.printf("Long\t%d\t%d\t\t%d%n", Long.MIN_VALUE, Long.MAX_VALUE, Long.BYTES);
        System.out.printf("Integer\t%d\t\t\t\t%d\t\t\t\t%d%n", Integer.MIN_VALUE, Integer.MAX_VALUE, Integer.BYTES);
        System.out.printf("Short\t%d\t\t\t\t\t%d\t\t\t\t\t%d%n", Short.MIN_VALUE, Short.MAX_VALUE, Short.BYTES);
        System.out.printf("Byte\t%d\t\t\t\t\t%d\t\t\t\t\t\t%d%n", Byte.MIN_VALUE, Byte.MAX_VALUE, Byte.BYTES);
        System.out.printf("Double\t%s\t\t\t\t%s\t%d%n", Double.MIN_VALUE, Double.MAX_VALUE, Double.BYTES);
        System.out.printf("Float\t%s\t\t\t\t\t%s\t\t\t%d%n", Float.MIN_VALUE, Float.MAX_VALUE, Float.BYTES);
        System.out.printf("Char\t%d\t\t\t\t\t\t%d\t\t\t\t\t%d%n", (int) Character.MIN_VALUE, (int) Character.MAX_VALUE, Character.BYTES);
    }
}
