package org.brijlabs;

public class TVShow {

    private String name;
    private String runtime_of_series;
    private String certificate;
    private String runtime_of_episodes;
    private String genre;
    private double imdb_rating;
    private String overview;
    private long no_of_votes;
    private long id;

    public String getName() {
        return name;
    }
    public String getRuntime_of_series() {
        return runtime_of_series;
    }
    public String getCertificate() {
        return certificate;
    }
    public String getRuntime_of_episodes() {
        return runtime_of_episodes;
    }
    public String getGenre() {
        return genre;
    }
    public double getImdb_rating() {
        return imdb_rating;
    }
    public String getOverview() {
        return overview;
    }
    public long getNo_of_votes() {
        return no_of_votes;
    }
    public long getId() {
        return id;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("TVShow{");
        sb.append("name=").append(name);
        sb.append(", runtime_of_series=").append(runtime_of_series);
        sb.append(", certificate=").append(certificate);
        sb.append(", runtime_of_episodes=").append(runtime_of_episodes);
        sb.append(", genre=").append(genre);
        sb.append(", imdb_rating=").append(imdb_rating);
        sb.append(", overview=").append(overview);
        sb.append(", no_of_votes=").append(no_of_votes);
        sb.append(", id=").append(id);
        sb.append('}');
        return sb.toString();
    }

    public boolean isRuntimeInRange(int startYear, int endYear) {

        //System.out.println("Before: " + runtime_of_series);
        runtime_of_series = runtime_of_series.replaceAll("[^0-9-]", "");
        //System.out.println("After: " + runtime_of_series);

        String[] years = runtime_of_series.split("-");
        int start = Integer.parseInt(years[0].trim());
        int end = (years.length > 1 && !years[1].trim().isEmpty()) ? Integer.parseInt(years[1].trim()) : Integer.MAX_VALUE;

        return start >= startYear && (end <= endYear || endYear == -1);

    }
}
