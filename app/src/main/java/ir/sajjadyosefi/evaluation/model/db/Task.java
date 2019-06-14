package ir.sajjadyosefi.evaluation.model.db;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;

@Table(name = "Tasks")
public class Task extends Model {

    @Column(name = "taskID")
    public String taskID;

    @Column(name = "orginalTask")
    public String orginalTask;

    @Column(name = "editedTask")
    public String editedTask;

    @Column(name = "Category")
    public Category category;
}
