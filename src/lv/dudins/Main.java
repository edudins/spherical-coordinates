package lv.dudins;

import lv.dudins.objects.SpherePoint;

/** Author: Edgars Dudins, 2023 */
public class Main {

    public static void main(String[] args) {
        double circumferenceInKilometers = 40_000;
        double degreesPerKilometer = 360 / circumferenceInKilometers;
        double movementInDegrees = degreesPerKilometer * 1_000;

        System.out.println("circumferenceInKilometers: " + circumferenceInKilometers);
        System.out.println("degreesPerKilometer: " + degreesPerKilometer);
        System.out.println("movementInDegrees: " + movementInDegrees);

        // calculate radius
        double r = circumferenceInKilometers / (2 * Math.PI);
        System.out.println("radius: " + r);

        // starting point
        SpherePoint point = new SpherePoint(r, 0D, 90D);

        // do moves
        point
                .moveHorizontally(movementInDegrees)
                .moveVertically(-movementInDegrees)
                .moveHorizontally(-movementInDegrees)
                .moveVertically(movementInDegrees);
    }
}
