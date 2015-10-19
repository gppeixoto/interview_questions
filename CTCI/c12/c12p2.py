"""
c12p2: code never crashes on the same place, uses only C std lib. How to debug?

(1) check for "random" variables
    -- bad user input takes to a different place of the code
    -- check for a random number generation that might take
        a different path depending on the value
    -- check for variables that receive time values (e.g.: time of
        the day, timestamp, etc)

(2) check for external dependencies
    -- does software depend on any other machine/application/process?
    -- when the external sw crashes is it checked by the sw? may cause
        to arbitrary point of crashing

(3) memory leak
    -- did the sw ran out of memory?
    -- is memory being deallocated correctly?

(4) unitialized variable
    -- some languages assign random value to unitialized variable
    -- is there any unitialized variable?    
"""