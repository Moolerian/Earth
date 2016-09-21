package util;

import gov.nasa.worldwind.Model;
import gov.nasa.worldwind.WorldWind;
import gov.nasa.worldwind.avlist.AVKey;
import gov.nasa.worldwind.awt.WorldWindowGLJPanel;
import gov.nasa.worldwind.geom.Position;
import gov.nasa.worldwind.layers.Layer;
import gov.nasa.worldwind.layers.RenderableLayer;
import gov.nasa.worldwind.render.*;
import gov.nasa.worldwindx.examples.util.BalloonController;
import gov.nasa.worldwindx.examples.util.HotSpotController;

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

    public static void addFacilityToEarth() {
        new HotSpotController(wwj);
        new BalloonController(wwj);

        Position position =  Position.fromDegrees(35.746179170384686d, 51.20007936255699d);
        AbstractBrowserBalloon balloon = new GlobeBrowserBalloon("salaaaaaaaaaaaaaam", position);

        BalloonAttributes attrs = new BasicBalloonAttributes();
        attrs.setSize(new Size(Size.NATIVE_DIMENSION, 0d, null, Size.NATIVE_DIMENSION, 0d, null));
        balloon.setAttributes(attrs);

        PointPlacemark placemark = new PointPlacemark(position);
        placemark.setLabelText("Click to open balloon");

        placemark.setValue(AVKey.BALLOON, balloon);

        RenderableLayer layer = new RenderableLayer();
        layer.setName("Web Browser Balloons");
        layer.addRenderable(balloon);
        layer.addRenderable(placemark);

        wwj.getModel().getLayers().add(layer);
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
