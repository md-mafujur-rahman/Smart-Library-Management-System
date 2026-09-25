public class StudentMember extends Member {

    public StudentMember(int id, String name) {
        super(id, name);
    }

    public void display() {
        super.display();
        System.out.println("Type: Student");
    }
}