# Google-Polyline-Encoder
An algorithm to encode GPS coordinates into ASCII characters

### Program Structure
* The [Program](<Java files directory>/Program.java) takes command line arguments and parses them according to the following rules
    - If the first argument is `gps` then the remaining arguments are GPS lat,lng pairs separated by spaces. 
        - These arguments are parsed and passed into [PolylineEncoder](<Java files directory>/PolylineEncoder.java) implementation and the result is printed.
 
* If any of the arguments are invalid then `Invalid argument` is printed to the command line and the program quits
    
### Example Runs of Program
    $ java -cp <directory where you want to store your .class files> <Java files directory>.Program foo
    $ Invalid argument
    $ java -cp <directory where you want to store your .class files> <Java files directory>.Program gps 38.5,-120.2 40.7,-120.95 43.252,-126.453
    $ _p~iF~ps|U_ulLnnqC_mqNvxq`@
    

    

    



