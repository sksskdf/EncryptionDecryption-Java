class Converter {

    /**
     * It returns a double value or 0 if an exception occurred
     */
    public static double convertStringToDouble(String input) {
        try {
            Double d = Double.parseDouble(input);
            return d;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }
}