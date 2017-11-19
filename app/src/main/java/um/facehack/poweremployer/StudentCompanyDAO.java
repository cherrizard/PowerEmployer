package um.facehack.poweremployer;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

/**
 * Created by calvinlow on 19/11/2017.
 */
@Dao
public interface StudentCompanyDAO {

    @Query("SELECT * FROM student_company")
    List<StudentCompanyModel> getAll();

    @Insert
    void insertAll(StudentCompanyModel... studentCompanyModels);

}
