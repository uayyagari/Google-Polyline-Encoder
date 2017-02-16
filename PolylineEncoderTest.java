package edu.nyu.cs9053.homework2;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * User: blangel
 * Date: 8/17/14
 * Time: 9:06 AM
 */
public class PolylineEncoderTest {

    @Test
    public void encodePolyline() throws Exception {
        PolylineEncoder polylineEncoder = new PolylineEncoder();

        Gps[] readings = new Gps[] { new Gps(38.5d, -120.2d), new Gps(40.7d, -120.95d), new Gps(43.252d, -126.453d) };
        String encoded = polylineEncoder.encodePolyline(readings);
        assertEquals("_p~iF~ps|U_ulLnnqC_mqNvxq`@", encoded);

        // ensure same value as prior (delta 0) is encoded as '?'
        readings = new Gps[] { new Gps(52.11d, 9.22d), new Gps(52.34d, 9.22d) };

        encoded = polylineEncoder.encodePolyline(readings);
        assertEquals("ov`}H_xgw@o|k@?", encoded);

        // ensure backslash is escaped
        readings = new Gps[] { new Gps(35.6d, -82.55d), new Gps(35.59985d, -82.55015d) };

        encoded = polylineEncoder.encodePolyline(readings);
        assertEquals("_chxEn`zvN\\\\", encoded);

    }


}
