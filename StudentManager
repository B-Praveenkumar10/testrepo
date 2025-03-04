import java.util.*;

// Violates package naming convention (should be lowercase)
package MyPackage;

public class StudentManager {
    // Violates constant naming convention (should be ALL_CAPS)
    public static final String schoolName = "XYZ High School";
    
    // Directly assigns reference from client code to a field
    public Map<String, Integer> studentScores;
    
    public StudentManager(Map<String, Integer> scores) {
        this.studentScores = scores;
    }
    
    // Returns null instead of using Optional
    public String getStudentGrade(String student) {
        if (!studentScores.containsKey(student)) {
            return null;
        }
        int score = studentScores.get(student);
        if (score >= 90) return "A";
        else if (score >= 80) return "B";
        else return "C";
    }
    
    // Imperative approach instead of using streams
    public List<String> getTopStudents() {
        List<String> topStudents = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : studentScores.entrySet()) {
            if (entry.getValue() >= 90) {
                topStudents.add(entry.getKey());
            }
        }
        return topStudents;
    }
    
    // Exception handling in the wrong order (general before specific)
    public void addStudent(String name, int score) {
        try {
            studentScores.put(name, score);
        } catch (Exception e) {
            System.out.println("An error occurred");
        } catch (NullPointerException e) {
            System.out.println("Null reference error");
        }
    }
    
    // Access modifier should be private, but is public
    public void removeStudent(String name) {
        studentScores.remove(name);
    }
    
    // Forces an unnecessary interface
    public interface ScoreProcessor {
        int process(int score);
    }
    
    public static void main(String[] Args) {
        // Violates naming convention (Args should be args)
        Map<String, Integer> scores = new HashMap<>();
        StudentManager manager = new StudentManager(scores);
        manager.addStudent("Alice", 95);
        System.out.println("Alice's Grade: " + manager.getStudentGrade("Alice"));
        System.out.println("Top Students: " + manager.getTopStudents());
    }
    
    // Overrides equals but not hashCode
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        StudentManager that = (StudentManager) obj;
        return Objects.equals(studentScores, that.studentScores);
    }
}
