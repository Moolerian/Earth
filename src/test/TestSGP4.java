package test;


import model.TLE;
import util.SatelliteTleSGP4;

import java.util.Calendar;
import java.util.Date;


/**
 *
 * @author Shawn Gano, 9 June 2009
 */
public class TestSGP4
{
    public static void main(String[] args)
    {
        // create TLE object
        // TLE = name, line 1, line 2
        TLE newTLE = new TLE("NOAA 19 [+] ",
                "1 33591U 09005A   16266.86889995  .00000421  00000-0  22957-3 0  9993",
                "2 33591  99.0492 224.4928 0013231 307.0114  53.0331 14.12109910393416");

        // Julian Date we are interested in

        double julianDate = 2457655.19943287;    //2454992.0; // 09 Jun 2009 12:00:00.000 UTC

        // Create SGP4 satelite propogator
        SatelliteTleSGP4 prop = null;
        try
        {
            prop = new SatelliteTleSGP4(newTLE.getSatName(), newTLE.getLine1(), newTLE.getLine2());
            prop.setShowGroundTrack(false); // if we arn't using the JSatTrak plots midas well turn this off to save CPU time
        }
        catch(Exception e)
        {
            System.out.println("Error Creating SGP4 Satellite");
            System.exit(1);
        }

        // prop to the desired time
        prop.propogate2JulDate(julianDate);

        // get the lat/long/altitude [radians, radians, meters]
        double[] lla = prop.getLLA();

        System.out.println("Lat [deg]:" + lla[0]*180.0/Math.PI);
        System.out.println("Lon [deg]:" + lla[1]*180.0/Math.PI);
        System.out.println("Alt [m]  :" + lla[2]);

    } // main
}