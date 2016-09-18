package kizema.anton.podcastmvpsample.model;


import com.google.gson.annotations.SerializedName;

import java.util.List;

public class PodactDtoList {

    @SerializedName("items")
    public List<PodactDto> podcasts;

    public void setPodcasts(List<PodactDto> podcasts) {
        this.podcasts = podcasts;
    }

    public List<PodactDto> getPodcasts() {
        return podcasts;
    }

    public static class PodactDto{
        @SerializedName("display_name")
        public String title;

        @SerializedName("id")
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
//                .append("enclosure url : ").append(enclosure).append("\n");

            return builder.toString();
        }

    }

    //    public String coverUrl;

//    @SerializedName("enclosure")
//    public String enclosure;

}
