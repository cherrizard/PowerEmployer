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
        student.setId(jsonObject.getString("id"));
        student.setEmail(jsonObject.getString("email"));
        student.setName(jsonObject.getString("name"));
        student.setAge(jsonObject.getInt("student_age"));
        student.setTelNo(jsonObject.getString("telNo"));
        student.setGender(jsonObject.getString("student_gender").charAt(0));
        student.setCourse(jsonObject.getString("student_course"));
        JSONArray skillsArray = jsonObject.getJSONArray("student_skills");
        for (int i = 0; i < skillsArray.length(); i++) {
            student.getSkills().add(skillsArray.getString(i));
        }
        return student;
    }

    public static Company jsonToCompany(JSONObject jsonObject) throws JSONException {
        Company company = new Company();
        company.setId(jsonObject.getString("id"));
        company.setEmail(jsonObject.getString("email"));
        company.setName(jsonObject.getString("name"));
        company.setAddress(jsonObject.getString("company_address"));
        company.setTelNo(jsonObject.getString("telNo"));
        company.setAgeCriteria(new Pair<>(jsonObject.getInt("company_age_lo_cri"), jsonObject.getInt("company_age_up_cri")));
        company.setGenderCriteria(jsonObject.getString("company_gender_cri").charAt(0));
        JSONArray skillsArray = jsonObject.getJSONArray("company_skills_cri");
        for (int i = 0; i < skillsArray.length(); i++) {
            company.getSkillsCriteria().add(skillsArray.getString(i));
        }
        return company;
    }

    public static StudentCompanyModel jsonToSCModel(JSONObject jsonObject) throws JSONException {
        StudentCompanyModel model = new StudentCompanyModel();
        model.setCompanyName(jsonObject.getString("name"));
        model.setCompanyAddress(jsonObject.getString("address"));
        model.setCompanyEmail(jsonObject.getString("email"));

        return model;
    }
}
