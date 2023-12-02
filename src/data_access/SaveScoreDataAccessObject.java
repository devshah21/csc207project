package data_access;

import java.io.*;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
public class SaveScoreDataAccessObject {

    // Needs the current users final score and username to function correctly

    private final String csvPath;

    // Prevent instantiation. */
    public SaveScoreDataAccessObject(String csvPath) throws IOException {

        this.csvPath = csvPath ;

    }

    public boolean CheckIfHighScore(int totScore, String userName) throws IOException {

        // This will look at the highscore we got from the game and check if player beat their highscore, if they did then new highscore is writen in place
        // of the old one if not then nothing happens, this programs lets what called it know if a new highscore was reached or not by returning a
        // boolean false for no highscore and true for yes highscore

        BufferedReader fr = new BufferedReader(new java.io.FileReader(csvPath));

        String currLine;
        String[] userParts;
        String oldUser = "";
        String newUser = "";

        String oldLines = ""; //Holds old lines as we look

        currLine = fr.readLine(); //Reads initial line of uneeded text
        oldLines = oldLines + currLine + System.lineSeparator(); //Adds it to what we might need to write back


        currLine = fr.readLine(); //Reads first line

        //boolean flag = false; // If this flag is set to true then that means

        // While loop will run looking untill same username is found
        while (currLine != null) {

            oldLines = oldLines + currLine + System.lineSeparator(); //Adds it to what we might need to write back
            userParts = currLine.split(",");

            // If we find same username run this to check scores
            if (userParts[0].equals(userName)){
                int oldHigh = Integer.parseInt(userParts[2]);

                // Check if highScore is greater than the one currently loaded in
                if (oldHigh < totScore){
                    // Now hold onto the old line and new line to be added on for later writing
                    oldUser = currLine;
                    newUser = userParts[0]+","+userParts[1]+","+ String.valueOf(totScore);
                }
                else{
                    // Now we know we dont need to bother anymore so just drop everything and leave
                    fr.close();
                    return false;
                }
            }

            currLine = fr.readLine(); // Look at next line

        }

        // If we get here that means we got a new highscore so its time to write it

        // First swap lines
        String newLines = oldLines.replaceAll(oldUser, newUser);

        // Rewrite the file, now with the news lines
        FileWriter wr = new FileWriter(csvPath);
        wr.write(newLines);

        fr.close();
        wr.close();
        return true;
    }



}
