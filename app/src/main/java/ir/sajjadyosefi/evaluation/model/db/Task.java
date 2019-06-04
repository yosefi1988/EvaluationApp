package ir.sajjadyosefi.evaluation.model.db;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;

@Table(name = "Items")
public class Task extends Model {

    @Column(name = "Name")
    public String name;

    @Column(name = "Category")
    public Category category;
}
