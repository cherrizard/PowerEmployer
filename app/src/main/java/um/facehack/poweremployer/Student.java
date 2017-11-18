package um.facehack.poweremployer;

import java.util.HashSet;
import java.util.List;

/**
 * Created by calvinlow on 18/11/2017.
 */

public class Student extends User {

    private int age;
    private Boolean gender;
    private String course;
    private HashSet<String> skills = new HashSet<>();

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Boolean getGender() {
        return gender;
    }

    public void setGender(Boolean gender) {
        this.gender = gender;
    }

    public HashSet<String> getSkills() {
        return skills;
    }

    public void setSkills(HashSet<String> skills) {
        this.skills = skills;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }
}
