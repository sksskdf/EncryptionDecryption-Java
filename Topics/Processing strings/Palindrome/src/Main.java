class Main {
    public static void main(String[] args) {
        // put your code here
        String str = new java.util.Scanner(System.in).nextLine();
        StringBuilder abc = new StringBuilder(str);
        if (abc.reverse().toString().equals(str)) {
            System.out.println("yes");
        } else {
            System.out.println("no");
        }
    }
}
