package edu.nyu.cs9053.homework2;

/**
 * User: blangel
 * Date: 8/17/14
 * Time: 9:02 AM
 *
 * Implements the Polyline Algorithm defined here
 * {@literal https://developers.google.com/maps/documentation/utilities/polylinealgorithm}
 */

public class PolylineEncoder {

    public String encodePolyline(Gps[] gpsPoints) 
    {
    	double prevLat = 0;
    	double prevLon = 0;
    	StringBuilder finalEncoding = new StringBuilder();

    	for(int i = 0; i < gpsPoints.length; i++ )
    	{
    		double latDiff = gpsPoints[i].getLatitude() - prevLat;
    		double lonDiff = gpsPoints[i].getLongitude() - prevLon;

    		finalEncoding.append(encodePoint(latDiff));
    		finalEncoding.append(encodePoint(lonDiff));

    		prevLat = gpsPoints[i].getLatitude();
    		prevLon = gpsPoints[i].getLongitude();

    	}
    	 return finalEncoding.toString();
    }

    private String encodePoint(double coordinate){

    	int scaledVar = scaleAndRound(coordinate);
		int shiftedVar = leftShift(scaledVar);
		int invertedVar = invertBin(shiftedVar);

		return encode(invertedVar);
    }

    private int scaleAndRound(double decVal) 
    {
    	return (int)Math.round(decVal*100000);
    }

    private int leftShift(int intVal)
    {
    	return intVal << 1;
    }

    private int invertBin(int intVal)
    {
    	if(intVal < 0)
		{
			return ~intVal;
		}
		else
		{
			return intVal;
		}
    }


    private String encode(int intVal)
    {
    	StringBuilder encodedString = new StringBuilder();
    	int fiveBitChunk = intVal;

    	while(fiveBitChunk >= 0x20) 
    	{
    		 	    
	    	int finalValue = (fiveBitChunk & 0x1f | 0x20) + 63;
	    	char finalChar = (char)finalValue;

	    	encodedString.append(finalChar);
	    	fiveBitChunk >>= 5;
    	}
    	
    	fiveBitChunk += 63;
		encodedString.append((char)fiveBitChunk);

		String result = replaceBackslash(encodedString.toString());

    	return result;
    }	

    private String replaceBackslash(String encoding){
    	return encoding.replace("\\","\\\\");

    }

}
