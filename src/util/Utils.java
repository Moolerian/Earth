package util;

import gov.nasa.worldwind.Model;
import gov.nasa.worldwind.WorldWind;
import gov.nasa.worldwind.avlist.AVKey;
import gov.nasa.worldwind.awt.WorldWindowGLJPanel;

/**
 * Created by Mohammad on 9/16/2016.
 */
public class Utils {

    private static WorldWindowGLJPanel wwj;

    public static void createWWJ() {
        wwj = new WorldWindowGLJPanel();
        Model m = (Model) WorldWind.createConfigurationComponent(AVKey.MODEL_CLASS_NAME);
        wwj.setModel(m);
    }

    public static WorldWindowGLJPanel getWwj() {
        return wwj;
    }

    public static void setWwj(WorldWindowGLJPanel wwj) {
        Utils.wwj = wwj;
    }
}
