public class main {
    public static void main(String[] args) {
        System.out.println(derivative(5, 5));
        System.out.println(derivative(5, 6));
        System.out.println(derivative(5, 10));
        System.out.println(derivative(5, 95));
        System.out.println(derivative(5, -95));
        System.out.println(derivative(5, 1));
        System.out.println(derivative(5, -1));
        System.out.println(derivative(5, -2));
    }

    public static String derivative(int constant, int power) {
        String result = "The derivative of " + constant + "x" + numberToExponent(power) + " is ";
        if (power == 0) return result;
        if (power != 1) {
            constant *= power;
            power -= 1;
        } else {
            power = 0;
        }
        return power != 0 ? result + constant + "x" + numberToExponent(power) : result + String.valueOf(constant);
    }

    public static String numberToExponent(int num) {
        char[] characters = String.valueOf(num).toCharArray();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < characters.length; i++) {
            switch (characters[i]) {
                case '-':
                    sb.append("⁻");
                    break;
                case '0':
                    sb.append("⁰");
                    break;
                case '1':
                    sb.append("¹");
                    break;
                case '2':
                    sb.append("²");
                    break;
                case '3':
                    sb.append("³");
                    break;
                case '4':
                    sb.append("⁴");
                    break;
                case '5':
                    sb.append("⁵");
                    break;
                case '6':
                    sb.append("⁶");
                    break;
                case '7':
                    sb.append("⁷");
                    break;
                case '8':
                    sb.append("⁸");
                    break;
                case '9':
                    sb.append("⁹");
                    break;
            }
        }
        return sb.toString();
    }
}
