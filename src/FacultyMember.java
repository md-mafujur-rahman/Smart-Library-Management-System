public class FacultyMember extends Member {

    public FacultyMember(int id, String name) {
        super(id, name);
    }

    public void display() {
        super.display();
        System.out.println("Type: Faculty");
    }
}