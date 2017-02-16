package edu.nyu.cs9053.homework2;
import java.math.BigDecimal;


/**
 * User: blangel
 * Date: 8/17/14
 * Time: 10:21 AM
 */
public class Program {

    public static void main(String[] args) {
    	

        Program mainProgramObj = new Program();
        String task = args[0];

        if(task.equals("gps"))
    	{
    		mainProgramObj.gpsTask(args);
    	}

    	else
    	{
    		System.out.println("Invalid argument");
    	}

    }

    private void gpsTask(String[] args)
    {
        Gps[] gpsPoints = new Gps[args.length - 1];
        boolean flag = false;

        for(int i = 1; i < args.length; i++)
        {
            String[] coordinates = args[i].split(",");

            // Checking if arguments fall within -180 to 180 range.

            for(int j = 0; j < coordinates.length; j++)
            {
                if(coordinates[j].compareTo("180") > 0 && coordinates[j].compareTo("-180") > 0)
                {
                    flag = true;
                    System.out.println("Invalid argument");
                    break;
                }

                Gps newCoordinate = new Gps(Double.valueOf(coordinates[0]),Double.valueOf(coordinates[1]));
                gpsPoints[i-1] = newCoordinate;
            }

            
        }

        if(!flag) 
        {
            PolylineEncoder encoder = new PolylineEncoder();
            String finalString = encoder.encodePolyline(gpsPoints);
            System.out.println(finalString);
        }
        
    }

}
