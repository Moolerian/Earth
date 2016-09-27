package test;

import name.gano.astro.time.Time;
import util.AbstractSatellite;
import util.GroundStation;
import util.SatelliteTleSGP4;
import view.JTrackingPanel;

import javax.swing.*;
import java.text.SimpleDateFormat;
import java.util.Hashtable;

/**
 * Created by Mohammad on 9/27/2016.
 */
public class TestTracking {

    private Hashtable<String,AbstractSatellite> satHash = new Hashtable<String, AbstractSatellite>();
    private Hashtable<String,GroundStation> gsHash = new Hashtable<String, GroundStation>();
    private SimpleDateFormat dateformat = new SimpleDateFormat("dd MMM yyyy HH:mm:ss.SSS z");
    Time currentJulianDate = new Time();

    public void testPass() throws Exception {

        AbstractSatellite satellite = new SatelliteTleSGP4("ISS (ZARYA)",
                "1 25544U 98067A   16109.49424856  .00007984  00000-0  12705-3 0  9995",
                "2 25544  51.6424 355.7774 0001421  44.1954  14.5115 15.54274169995696");


        double[] lla = {53.2126,-105.934,488.8};
        GroundStation groundStation = new GroundStation("PASS",lla,2457659.2184953704);
        groundStation.setElevationConst(10);

        satHash.put("ISS (ZARYA)",satellite);
        gsHash.put("PASS",groundStation);

        currentJulianDate.setDateFormat(dateformat);
        JTrackingPanel trackingBrowser = new JTrackingPanel(satHash,
                gsHash,currentJulianDate.getDateTimeStr(),currentJulianDate);

        JFrame frame = new JFrame("fff");
        frame.add(trackingBrowser);
        frame.setSize(500,500);
        frame.setVisible(true);

    }
    public static void main(String[] args) throws Exception {

        TestTracking testTracking = new TestTracking();
        testTracking.testPass();

    }
}
