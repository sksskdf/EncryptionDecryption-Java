

class Main {
    public static void main(String[] args) {
        // put your code here
        System.out.print(
                new java.util.Scanner(System.in)
                        .nextLine()
                        .replaceAll("(.)", "$1$1")
        );
    }
}