package org.ashu.producer.LocationGeenerate;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class LocationUtils {
    private static final Random random = new Random();

    /**
     * Generates a random location (latitude and longitude) globally.
     * @return double array with [latitude, longitude]
     */
    public static Map<String,Double> generateRandomLocationGlobal() {
        double latitude = -90 + 180 * random.nextDouble();     // -90 to +90
        double longitude = -180 + 360 * random.nextDouble();   // -180 to +180
        Map<String,Double> location = new HashMap<>();
        location.put("latitude",latitude);
        location.put("longitude",longitude);
        return location;
    }

    /**
     * Generates a random location within a bounding box.
     * @param minLat minimum latitude
     * @param maxLat maximum latitude
     * @param minLng minimum longitude
     * @param maxLng maximum longitude
     * @return double array with [latitude, longitude]
     */
    public static double[] generateRandomLocationInBounds(double minLat, double maxLat, double minLng, double maxLng) {
        if (minLat > maxLat || minLng > maxLng) {
            throw new IllegalArgumentException("Minimums must be less than maximums.");
        }
        double latitude = minLat + (maxLat - minLat) * random.nextDouble();
        double longitude = minLng + (maxLng - minLng) * random.nextDouble();
        return new double[]{latitude, longitude};
    }
}
