package lv.dudins.objects;

public class SpherePoint {
    private double x = 0;
    private double y = 0;
    private double z = 0;
    private double latitudeRad = 0; // fi
    private double longitudeRad = 0; // theta

    private double radiusKm = 0;

    public SpherePoint(double radiusKm, double longitudeDegrees, double latitudeDegrees) {
        this.radiusKm = radiusKm;
        this.latitudeRad = Math.toRadians(latitudeDegrees);
        this.longitudeRad = Math.toRadians(longitudeDegrees);
        this.calculatePoint();
    }

    // formula works, precision penalty based on floating point precision of language
    private void calculatePoint() {
        this.x = this.radiusKm * Math.sin(this.latitudeRad) * Math.cos(this.longitudeRad);
        this.y = this.radiusKm * Math.sin(this.latitudeRad) * Math.sin(this.longitudeRad);
        this.z = this.radiusKm * Math.cos(this.latitudeRad);
        System.out.println(this);
    }

    public SpherePoint moveHorizontally(double angle) {
        this.longitudeRad = this.longitudeRad + Math.toRadians(angle);
        this.calculatePoint();
        return this;
    }

    public SpherePoint moveVertically(double angle) {
        this.latitudeRad = this.latitudeRad + Math.toRadians(angle);
        this.calculatePoint();
        return this;
    }

    @Override
    public String toString() {
        return "Point{" +
                "x=" + this.x +
                ", y=" + this.y +
                ", z=" + this.z +
                '}';
    }
}
