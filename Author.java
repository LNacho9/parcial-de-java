public class Author {
    private String name;
    private String nationality;
    private int birthYear;

    public Author(String name, String nationality, int birthYear) {
        this.name = name;
        this.nationality = nationality;
        this.birthYear = birthYear;
    }

    public String getName() {
        return name;
    }

    public String getNationality() {
        return nationality;
    }

    public int getBirthYear() {
        return birthYear;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public void setBirthYear(int birthYear) {
        this.birthYear = birthYear;
    }

    @Override
    public String toString() {
        return name + " (" + nationality + ", " + birthYear + ")";
    }
}