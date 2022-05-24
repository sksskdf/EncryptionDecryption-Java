package encryptdecrypt;

import java.io.File;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    private static final String LOWALPHABET = "abcdefghijklmnopqrstuvwxyz";
    private static final String UPPERALPHABET = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

    public static void main(String[] args) {
        startModule(args);
    }

    private static void startModule(String[] args) {
        //make map from configuration arguments
        HashMap<String, String> map = getMapFromCLA(args);

        //read mode from config args, if mode is null defaultvalue is enc
        var mode = map.getOrDefault("-mode", "enc").toString();

        switch (mode) {
            case "enc":
                switchMode("enc", map);
                break;
            case "dec":
                switchMode("dec", map);
                break;
        }
    }

    private static HashMap<String, String> getMapFromCLA(String[] args) {
        HashMap<String, String> map = new HashMap();
        for (int i = 0; i < args.length - 1; i++) {
            map.put(args[i], args[i + 1]);
        }
        return map;
    }

    private static void switchMode(String type, Map map) {
        var key = Integer.parseInt(map.getOrDefault("-key", "0").toString());
        var pass = map.getOrDefault("-data", "").toString();
        var in = map.getOrDefault("-in", "").toString();
        var out = map.getOrDefault("-out", "").toString();
        var alg = map.getOrDefault("-alg","shift").toString();

        //if in and pass both are null, pass is empty string
        if (in.equals("") && pass.equals("")) {
            pass = "";
        }


        var sb = new StringBuffer();

        boolean isOut = !out.equals("");
        boolean checkDataAndIn = !pass.equals("") && !in.equals("");

        if (alg.equals("shift")) {
            EncDec(type, key, pass, in, sb, checkDataAndIn, true);
        } else if (alg.equals("unicode")) {
            EncDec(type, key, pass, in, sb, checkDataAndIn, false);
        }

        fileWrite(out, sb, isOut);
    }

    private static void EncDec(String type, int key, String pass, String in, StringBuffer sb, boolean isDataInBoth, boolean isAlgShift) {
        if (isDataInBoth) {
            if (isAlgShift) {
                consolePrint(type, key, pass, sb, true);
            } else {
                consolePrint(type, key, pass, sb, false);
            }
        } else if (!in.equals("")) {
            if (isAlgShift) {
                File file = new File(in);

                filePrint(type, key, sb, file,true);
            } else {
                File file = new File(in);

                filePrint(type, key, sb, file,false);
            }
        }
    }

    private static void filePrint(String type, int key, StringBuffer sb, File file, boolean isAlgShift) {
        try (Scanner sc = new Scanner(file)) {
            switch (type) {
                case "enc": {
                    if (isAlgShift) {
                        while (sc.hasNext()) {
                            String pass = sc.nextLine();
                            shiftLoopEnc(key, pass, sb);
                        }
                    } else {
                        while (sc.hasNext()) {
                            String pass = sc.nextLine();
                            uniLoopEnc(key, pass, sb);
                        }
                    }
                }
                case "dec": {
                    if (isAlgShift) {
                        while (sc.hasNext()) {
                            String pass = sc.nextLine();
                            shiftLoopDec(key, pass, sb);
                        }
                    } else {
                        while (sc.hasNext()) {
                            String pass = sc.nextLine();
                            uniLoopDec(key, pass, sb);
                        }
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void consolePrint(String type, int key, String pass, StringBuffer sb, boolean isAlgShift) {
        switch (type) {
            case "enc": {
                if (isAlgShift) {
                    shiftLoopEnc(key, pass, sb);
                } else {
                    uniLoopEnc(key, pass, sb);
                }
                break;
            }
            case "dec": {
                if (isAlgShift) {
                    shiftLoopDec(key, pass, sb);
                } else {
                    uniLoopDec(key, pass, sb);
                }
                break;
            }
        }
    }

    private static void uniLoopDec(int key, String pass, StringBuffer sb) {
        for (int i = 0; i < pass.length(); i++) {
            var c = pass.charAt(i);
            c -= key;
            sb.append(c);
        }
    }

    private static void shiftLoopEnc(int key, String pass, StringBuffer sb) {
        for (int i = 0; i < pass.length(); i++) {
            var c = pass.charAt(i);
            EncDec(key, sb, c, "enc");

        }
    }
    private static void shiftLoopDec(int key, String pass, StringBuffer sb) {
        for (int i = 0; i < pass.length(); i++) {
            var c = pass.charAt(i);
            EncDec(key, sb, c, "dec");
        }
    }

    private static void EncDec(int key, StringBuffer sb, char c, String type) {
        if (type.equals("enc")) {
            enc(key, sb, c);
        } else {
            dec(key, sb, c);
        }
    }

    private static void enc(int key, StringBuffer sb, char c) {
        char resultChar;
        if (Character.isUpperCase(c) && Character.isAlphabetic(c)) {
            int i1 = UPPERALPHABET.indexOf(c);
            resultChar = UPPERALPHABET.charAt((i1 + key) % 26);
            sb.append(resultChar);
        } else if (Character.isLowerCase(c) && Character.isAlphabetic(c)) {
            int i1 = LOWALPHABET.indexOf(c);
            resultChar = LOWALPHABET.charAt((i1 + key) % 26);
            sb.append(resultChar);
        } else {
            sb.append(c);
        }
    }

    private static void dec(int key, StringBuffer sb, char c) {
        char resultChar;
        if (Character.isUpperCase(c) && Character.isAlphabetic(c)) {
            int i1 = UPPERALPHABET.indexOf(c);
            int number = i1 - key;
            if (number < 0) {
                resultChar  = UPPERALPHABET.charAt(26 + number);
            } else {
                resultChar  = UPPERALPHABET.charAt((number % 26));
            }
            sb.append(resultChar);
        } else if (Character.isLowerCase(c) && Character.isAlphabetic(c)) {
            int i1 = LOWALPHABET.indexOf(c);
            int number = i1 - key;
            if (number < 0) {
                resultChar  = LOWALPHABET.charAt(26 + number);
            } else {
                resultChar  = LOWALPHABET.charAt(number % 26);
            }
            sb.append(resultChar);
        } else {
            sb.append(c);
        }
    }

    private static void uniLoopEnc(int key, String pass, StringBuffer sb) {
        for (int i = 0; i < pass.length(); i++) {
            var c = pass.charAt(i);
            c += key;
            sb.append(c);
        }
    }


    private static void fileWrite(String out, StringBuffer sb, boolean isOut) {
        if (isOut) {
            try (PrintWriter pw = new PrintWriter(out)) {
                pw.print(sb.toString());
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            System.out.println(sb.toString());
        }
    }
}
