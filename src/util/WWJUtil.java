package util;

import gov.nasa.worldwind.Model;
import gov.nasa.worldwind.WorldWind;
import gov.nasa.worldwind.avlist.AVKey;
import gov.nasa.worldwind.awt.WorldWindowGLJPanel;
import gov.nasa.worldwind.layers.Layer;

/**
 * Created by Mohammad on 9/16/2016.
 */
public class WWJUtil {

    private static WorldWindowGLJPanel wwj;

    private static Layer worldMapLayer;
    private static Layer compassLayer;
    private static Layer scaleLayer;

    public static void createWWJ() {
        wwj = new WorldWindowGLJPanel();
        Model m = (Model) WorldWind.createConfigurationComponent(AVKey.MODEL_CLASS_NAME);
        wwj.setModel(m);

        worldMapLayer = wwj.getModel().getLayers().getLayerByName("World Map");
        wwj.getModel().getLayers().remove(worldMapLayer);
        compassLayer = wwj.getModel().getLayers().getLayerByName("Compass");
        wwj.getModel().getLayers().remove(compassLayer);
        scaleLayer = wwj.getModel().getLayers().getLayerByName("Scale bar");
        wwj.getModel().getLayers().remove(scaleLayer);
    }

    public static WorldWindowGLJPanel getWwj() {
        return wwj;
    }

    public static void setWwj(WorldWindowGLJPanel wwj) {
        WWJUtil.wwj = wwj;
    }

    public static Layer getWorldMapLayer() {
        return worldMapLayer;
    }

    public static void setWorldMapLayer(Layer worldMapLayer) {
        WWJUtil.worldMapLayer = worldMapLayer;
    }

    public static Layer getCompassLayer() {
        return compassLayer;
    }

    public static void setCompassLayer(Layer compassLayer) {
        WWJUtil.compassLayer = compassLayer;
    }

    public static Layer getScaleLayer() {
        return scaleLayer;
    }

    public static void setScaleLayer(Layer scaleLayer) {
        WWJUtil.scaleLayer = scaleLayer;
    }
}
