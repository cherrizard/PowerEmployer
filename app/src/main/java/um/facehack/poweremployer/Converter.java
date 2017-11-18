package um.facehack.poweremployer;

import android.util.Pair;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashSet;

/**
 * Created by calvinlow on 18/11/2017.
 */

public class Converter {

    public static Student jsonToStudent(JSONObject jsonObject) throws JSONException {
        Student student = new Student();
        student.setId(jsonObject.getLong("id"));
        student.setEmail(jsonObject.getString("email"));
        student.setName(jsonObject.getString("name"));
        student.setAge(jsonObject.getInt("age"));
        student.setGender(jsonObject.getBoolean("gender"));
        student.setCourse(jsonObject.getString("course"));
        JSONArray skillsArray = jsonObject.getJSONArray("skills");
        for (int i = 0; i < skillsArray.length(); i++) {
            student.getSkills().add(skillsArray.getString(i));
        }
        return student;
    }

    public static Company jsonToCompany(JSONObject jsonObject) throws JSONException {
        Company company = new Company();
        company.setId(jsonObject.getLong("id"));
        company.setEmail(jsonObject.getString("email"));
        company.setName(jsonObject.getString("name"));
        company.setAddress(jsonObject.getString("address"));
        company.setTelNo(jsonObject.getString("telNo"));
        company.setAgeCriteria(new Pair<>(jsonObject.getInt("start"), jsonObject.getInt("endInclusive")));
        company.setGenderCriteria(jsonObject.getBoolean("genderCriteria"));
        JSONArray skillsArray = jsonObject.getJSONArray("skillsCriteria");
        for (int i = 0; i < skillsArray.length(); i++) {
            company.getSkillsCriteria().add(skillsArray.getString(i));
        }
        return company;
    }
}
