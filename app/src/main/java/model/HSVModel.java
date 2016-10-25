package model;

import java.util.Observable;

import android.graphics.Color;

/**
 * The model holds the data.
 *
 * Model color.
 * Based on red, green, blue and alpha (transparency).
 *
 * RGB: integer values in the domain range of 0 to 255 (inclusive).
 * Alpha: integer value in the domain range of 0 to 255 (inclusive).
 *
 * @author Gerald.Hurdle@AlgonquinCollege.com
 * @version 1.0
 */
public class HSVModel extends Observable {

    // CLASS VARIABLES
    public static final float MAX_HUE = 359.0f;
    public static final float MIN_HUE = 0.0f;
    public static final float MAX_SATURATION = 100.0f;
    public static final float MIN_SATURATION = 0.0f;
    public static final float MAX_LIGHTNESS = 100.0f;
    public static final float MIN_LIGHTNESS = 0.0f;

    // INSTANCE VARIABLES
    private float hue;
    private float saturation;
    private float value;

    /**
     * No argument constructor.
     *
     * Instantiate a new instance of this class, and
     * initialize red, green, blue, and alpha to max values.
     */
    public HSVModel() {
        this( MIN_HUE, MIN_SATURATION, MIN_LIGHTNESS );
    }

    /**
     * Convenience constructor.
     *
     * @param hue - starting red value
     * @param saturation- starting green value
     * @param value- starting blue value
     */
    public HSVModel( float hue, float saturation, float value) {
        super();

        this.hue = hue;
        this.saturation = saturation;
        this.value = value;
    }

    public void asBlack() {
        this.setHSV(0.0f, 0.0f, 0.0f);
    }

    public void asRed() {
        this.setHSV(0.0f, 1.0f, 1.0f);
    }

    public void asLime() {
        this.setHSV(120.0f, 1.0f, 1.0f);
    }

    public void asBlue() {
        this.setHSV(240.0f, 1.0f, 1.0f);
    }

    public void asYellow() {
        this.setHSV(60.0f, 1.0f, 1.0f);
    }

    public void asCyan() {
        this.setHSV(180.0f, 1.0f, 1.0f);
    }

    public void asMagenta() {
        this.setHSV(300.0f, 1.0f, 1.0f);
    }

    public void asSilver() {
        this.setHSV(0.0f, 0.0f, 0.75f);
    }

    public void asGray() {
        this.setHSV(0.0f, 0.0f, 0.5f);
    }

    public void asMaroon() {
        this.setHSV(0.0f, 1.0f, 0.5f);
    }

    public void asOlive() {
        this.setHSV(60.0f, 1.0f, 0.5f);
    }

    public void asGreen() {
        this.setHSV(120.0f, 1.0f, 0.5f);
    }

    public void asPurple() {
        this.setHSV(300.0f, 1.0f, 0.5f);
    }

    public void asTeal() {
        this.setHSV(180.0f, 1.0f, 0.5f);
    }

    public void asNavy() {
        this.setHSV(240.0f, 1.0f, 0.5f);
    }

    public void setHue(float hue) {
        this.hue = hue;
        this.updateObservers();
    }

    public void setSaturation(float saturation) {
        this.saturation = saturation / 100;
        this.updateObservers();
    }

    public void setValue(float value) {
        this.value = value / 100;
        this.updateObservers();
    }

    public float getHue() {
        return hue;
    }

    public float getSaturation() {
        return saturation * 100;
    }

    public float getValue() {
        return value * 100;
    }

    public int getHSV() {
        return Color.HSVToColor(new float[]{hue, saturation, value});
    }

    // Convenient setter: set R, G, B
    public void setHSV(float hue, float saturation, float value) {
        this.hue = hue;
        this.saturation = saturation ;
        this.value = value;

        this.updateObservers();
    }

    @Override
    public String toString() {
        return "HSV [H=" + hue + " S=" + saturation + " v=" + value + "]";
    }

    // the model has changed!
    // broadcast the update method to all registered observers
    private void updateObservers() {
        this.setChanged();
        this.notifyObservers();
    }
}