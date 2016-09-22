package kizema.anton.podcastmvpsample.model;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;
import com.activeandroid.query.Select;
import com.google.gson.annotations.SerializedName;

import java.util.List;


@Table(name = "StationModel")
public class StationModel extends Model{

    @SerializedName("display_name")
    @Column(name = "title", unique = true, onUniqueConflict = Column.ConflictAction.REPLACE)
    public String title;

    @SerializedName("id")
    @Column(name = "description")
    public int description;

    public String getTitle() {
        return title;
    }

    public int getDescription() {
        return description;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(int description) {
        this.description = description;
    }

    @Override
    public String toString(){
        StringBuilder builder =  new StringBuilder();
        builder.append("title").append(" : ").append(title).append("\n")
                .append("descr : ").append(description).append("\n");

        return builder.toString();
    }

    public static List<StationModel> getAll(){
        return new Select().from(StationModel.class).execute();
    }
}
