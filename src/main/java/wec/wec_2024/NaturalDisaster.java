package wec.wec_2024;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

import java.text.SimpleDateFormat;

public class NaturalDisaster {
    private final SimpleStringProperty name;
    private final SimpleDoubleProperty longitude;
    private final SimpleDoubleProperty latitude;
    private final SimpleStringProperty date;
    private final SimpleIntegerProperty intensity;
    private final SimpleStringProperty type;

    public NaturalDisaster(String name, Double longitude, Double latitude, String date, Integer intensity, String type) {
        this.name = new SimpleStringProperty(name);
        this.longitude = new SimpleDoubleProperty(longitude);
        this.latitude = new SimpleDoubleProperty(latitude);
        this.date = new SimpleStringProperty(date);
        this.intensity = new SimpleIntegerProperty(intensity);
        this.type = new SimpleStringProperty(type);
    }

    public String getName() {
        return name.get();
    }

    public String getDate() {
        return date.get();
    }

    public int getIntensity() {
        return intensity.get();
    }

    public String getLocation() {
        return latitude.get() + ", " + longitude.get();
    }
}
