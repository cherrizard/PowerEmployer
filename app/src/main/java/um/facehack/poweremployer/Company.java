package um.facehack.poweremployer;

import android.graphics.Paint;
import android.util.Pair;

import java.util.HashSet;
import java.util.Map;

/**
 * Created by calvinlow on 18/11/2017.
 */

public class Company extends User {

    private String address;
    private String telNo;
    private HashSet<String> skillsCriteria = new HashSet<>();
    private Pair<Integer, Integer> ageCriteria;
    private Boolean genderCriteria;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTelNo() {
        return telNo;
    }

    public void setTelNo(String telNo) {
        this.telNo = telNo;
    }

    public HashSet<String> getSkillsCriteria() {
        return skillsCriteria;
    }

    public void setSkillsCriteria(HashSet<String> skillsCriteria) {
        this.skillsCriteria = skillsCriteria;
    }

    public Pair<Integer, Integer> getAgeCriteria() {
        return ageCriteria;
    }

    public void setAgeCriteria(Pair<Integer, Integer> ageCriteria) {
        this.ageCriteria = ageCriteria;
    }

    public Boolean getGenderCriteria() {
        return genderCriteria;
    }

    public void setGenderCriteria(Boolean genderCriteria) {
        this.genderCriteria = genderCriteria;
    }
}
