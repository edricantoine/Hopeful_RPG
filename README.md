# Hopeful RPG

## A simple, turn-based role-playing game.

This is a fully functional, mostly text-based role-playing game. Each level consists of a grid of rooms. To beat a level, 
find and beat all 3 bosses in that level. Also, there is something vaguely resembling a plot.

This project was inspired by turn-based RPGs and roguelike dungeon crawlers that I enjoy playing. I began work on this 
project in order to use some game ideas I had come up with in my spare time, and to solidify my knowledge of GUI and 
object-oriented programming. The game is not yet complete, but I am trying to make steady progress when I can. 

This project is written in the Java language, and uses the Swing framework along with the IntelliJ GUI designer 
for GUI creation. While it does not have data persistence in the form of a database or JSON files, it does have a 
password system to save progress (think games like Mega Man for the NES.)

### To Install and Run

Navigate to the folder containing the .jar file, on the command line:

out -> artifacts -> Hopeful_RPG_jar

Run the command 

java -jar Hopeful_RPG.jar

The .jar file may also work if it is double-clicked, but this is less reliable.


### To Run and Add Tests
This project uses the JUnit 5.0 testing framework.

Add any test files in the test directory, and please name it something like (ClassName)Test, like how the other test 
files are named.

To run the tests:
- Stay in the outermost directory of the project (should have a JUnit platform standalone console .jar file)
- Run this exact command:

java -jar junit-platform-console-standalone-1. 8.2.jar --class-path out/production/Hopeful_RPG --scan-class-path

- Make sure to compile the project (using an IDE or other method of choice) before running newly created tests!


### To Contribute

As this is a relatively small personal project, I don't really mind how you write your code as long as it's, you know, 
actually readable and has proper formatting and whatnot.

**Be sure to open a new issue and new branches / pull requests 
for each new feature you want to add, though!** (Just so I, and other contributors, know what's going on.)

Also, please build a new .jar file (can be easily done using the IntelliJ IDE) before submitting a pull request.

### Credits

Created in 2021 by Edric Antoine. (That's me.)

### Thanks for taking the time to look at this project!
