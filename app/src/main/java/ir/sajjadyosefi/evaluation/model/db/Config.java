package ir.sajjadyosefi.evaluation.model.db;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;

@Table(name = "Config")
public class Config extends Model {

    @Column(name = "ServerConfig")
    public String ServerConfig;


    @Column(name = "Day")
    public int Day;

}
