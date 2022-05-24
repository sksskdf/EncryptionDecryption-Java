class Person implements Comparable<Person> {
    private String name;
    private int age;
    private int height;
    private int weight;

    public Person(String name, int age, int height, int weight) {
        this.name = name;
        this.age = age;
        this.height = height;
        this.weight = weight;
    }

    public String getName() {
        return this.name;
    }

    public int getAge() {
        return this.age;
    }

    public int getHeight() {
        return this.height;
    }

    public int getWeight() {
        return this.weight;
    }

    @Override
    public int compareTo(Person otherPerson) {
        // add your code here!
        int compareByName = getName().compareTo(otherPerson.getName());
        int compareByAge = Integer.valueOf(getAge()).compareTo(otherPerson.getAge());
        return compareByName == 0 ? compareByAge : compareByName;
    }
}