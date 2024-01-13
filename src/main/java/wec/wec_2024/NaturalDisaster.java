package wec.wec_2024;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class NaturalDisaster {
    private final SimpleStringProperty name;
    private final SimpleStringProperty location;
    private final SimpleIntegerProperty date;
    private final SimpleIntegerProperty intensity;

    public NaturalDisaster(String name, String location, Integer date, Integer intensity) {
        this.name = new SimpleStringProperty(name);
        this.location = new SimpleStringProperty(location);
        this.date = new SimpleIntegerProperty(date);
        this.intensity = new SimpleIntegerProperty(intensity);
    }

    public String getName() {
        return name.get();
    }

    public String getLocation() {
        return location.get();
    }

    public int getDate() {
        return date.get();
    }

    public int getIntensity() {
        return intensity.get();
    }
}
