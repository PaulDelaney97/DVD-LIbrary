package com.pauldelaney.dvdlibrary.dao;

import com.pauldelaney.dvdlibrary.dto.Dvd;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author pauldelaney
 */
public class DvdLibraryDaoFileImpl implements DvdLibraryDao {

    private Map<String, Dvd> dvds = new HashMap<>();    // This is the library
    public static final String LIBRARY_FILE = "DvdLibrary.txt"; // memory file
    public static final String DELIMITER = "::";

    @Override
    public Dvd addDvd(String title, Dvd dvd) throws DvdLibraryDaoException {
        // Adds Dvd to library
        loadLibrary();
        Dvd newDvd = dvds.put(title, dvd);
        writeLibrary();
        return newDvd;
    }

    @Override
    public Dvd getDvd(String title) throws DvdLibraryDaoException {
        // gets a dvd from the library by title
        loadLibrary();
        return dvds.get(title);
    }

    @Override
    public List<Dvd> getAllDvds() throws DvdLibraryDaoException {
        // gets all dvds in the library
        loadLibrary();
        return new ArrayList<Dvd>(dvds.values());
    }

    @Override
    public Dvd removeDvd(String title) throws DvdLibraryDaoException {
        // removes a dvd from the library
        loadLibrary();
        Dvd removedDvd = dvds.remove(title);
        writeLibrary();
        return removedDvd;
    }

    @Override
    public Dvd editDvd(String title, Dvd dvd) throws DvdLibraryDaoException {
        //allows a user to edit a dvd in the library.
        loadLibrary();
        Dvd editedDvd = dvds.put(title, dvd);
        writeLibrary();
        return editedDvd;
    }

    @Override
    public Dvd editTitle(String title, String newTitle) throws DvdLibraryDaoException {
        // edits a title of a given dvd
        Dvd dvdToEdit = dvds.get(title);
        dvds.remove(title);
        Dvd editedDvd = addDvd(newTitle, dvdToEdit);
        return editedDvd;
    }

    @Override
    public Dvd editReleaseDate(String title, String releaseDate) throws DvdLibraryDaoException {
        // edits the release date of a given dvd
        Dvd dvdToEdit = dvds.get(title);
        dvdToEdit.setReleaseDate(releaseDate);
        return dvdToEdit;
    }

    @Override
    public Dvd editMpaaRating(String title, String mpaaRating) throws DvdLibraryDaoException {
        // edits the mpaarating of a given dvd
        Dvd dvdToEdit = dvds.get(title);
        dvdToEdit.setMpaaRating(mpaaRating);
        return dvdToEdit;
    }

    @Override
    public Dvd editDirectorName(String title, String directorName) throws DvdLibraryDaoException {
        // edits the director name of a given dvd
        Dvd dvdToEdit = dvds.get(title);
        dvdToEdit.setDirectorName(directorName);
        return dvdToEdit;
    }

    @Override
    public Dvd editStudio(String title, String studio) throws DvdLibraryDaoException {
        // edits the studio of a given dvd
        Dvd dvdToEdit = dvds.get(title);
        dvdToEdit.setStudio(studio);
        return dvdToEdit;
    }

    @Override
    public Dvd editReview(String title, String review) throws DvdLibraryDaoException {
        // edits the review of a given dvd
        Dvd dvdToEdit = dvds.get(title);
        dvdToEdit.setUserNote(review);
        return dvdToEdit;
    }

    private Dvd unmarshallDvd(String dvdAsText) {
        // dvdAsText is expecting a line read in from our file.
        // For example, one line would look like:
        //
        // The Lord of the Rings: The Fellowship of The Ring::2001::PG::
        // Peter Jackson::New Line Cinema::Best Film Ever!
        //
        // We then split that line on our DELIMITER - which is ::
        // This then leaves us an array of Strings, stored in DvdTokens
        //
        // For our example, this gives us:
        //
        // dvdTokens[0] = The Lord of the Rings: The Fellowship of The Ring
        // dvdTokens[1] = 2001
        // dvdTokens[2] = PG
        // dvdTokens[3] = Peter Jackson
        // dvdTokens[4] = New Line Cinema
        // dvdTokens[5] = Best Film Ever!
        //
        // With the pattern above, title is index 0 of the array

        String[] dvdTokens = dvdAsText.split(DELIMITER);
        String title = dvdTokens[0];

        // We can then use this to create a new Dvd object using constructor
        Dvd dvdFromFile = new Dvd(title);

        // Now manually set the remaining properties using setters
        // Index 1 - Release Date
        dvdFromFile.setReleaseDate(dvdTokens[1]);
        // Index 2 - MPAA Rating
        dvdFromFile.setMpaaRating(dvdTokens[2]);
        // Index 3 - Director Name
        dvdFromFile.setDirectorName(dvdTokens[3]);
        // Index 4 - Studio
        dvdFromFile.setStudio(dvdTokens[4]);
        // Index 5 - Review
        dvdFromFile.setUserNote(dvdTokens[5]);

        // We now return the created Dvd
        return dvdFromFile;
    }

    private void loadLibrary() throws DvdLibraryDaoException {
        Scanner scanner;

        try {
            // Create Scanner for reading the file
            scanner = new Scanner(
                    new BufferedReader(
                            new FileReader(LIBRARY_FILE)));
        } catch (FileNotFoundException e) {
            throw new DvdLibraryDaoException(
                    "-_- Could not load roster library into memory.", e);
        }
        // currentLine holds the most recent line read from the file
        String currentLine;
        // currentDvd holds the most recent Dvd unmarshalled
        Dvd currentDvd;
        // Go through DvdLibrary.txt file line by line, decoding each line into a
        // Dvd object by calling the unmarshallDvd method.
        // Process while we have more lines in the file
        while (scanner.hasNextLine()) {
            // get the next line in the file
            currentLine = scanner.nextLine();
            // unmarshall the line into a Dvd
            currentDvd = unmarshallDvd(currentLine);

            // We are going to use the title as the map key for our Dvd objects.
            // Put currentDvd into the map using title as the key
            dvds.put(currentDvd.getTitle(), currentDvd);
        }
        // close scanner
        scanner.close();
    }

    private String marshallDvd(Dvd aDvd) {
        // We need to turn a Dvd object into a line of text for out file.
        // For example, we need an in memory object to end up like this:

        // The Lord of the Rings: The Fellowship of The Ring::2001::PG::
        // Peter Jackson::New Line Cinema::Best Film Ever!
        // We just get out each property and concatenate it with our DELIMITER
        // Start with the dvd title, since that's supposed to be first.
        String dvdAsText = aDvd.getTitle() + DELIMITER;

        // add the rest of the properties in the correct order:
        // Release Date
        dvdAsText += aDvd.getReleaseDate() + DELIMITER;

        // Mpaa Rating
        dvdAsText += aDvd.getMpaaRating() + DELIMITER;

        // Director name
        dvdAsText += aDvd.getDirectorName() + DELIMITER;

        // studio
        dvdAsText += aDvd.getStudio() + DELIMITER;

        // user review - We do not place any delimiter her
        dvdAsText += aDvd.getUserNote();
        return dvdAsText;
    }

    /**
     * Writes all Dvds in the library out to a LIBRARY_FILE. See loadLibrary for
     * file format.
     *
     * @throws DvdLibraryDaoException if an error occurs writing to the file
     */
    private void writeLibrary() throws DvdLibraryDaoException {

        PrintWriter out;

        try {
            out = new PrintWriter(new FileWriter(LIBRARY_FILE));
        } catch (IOException e) {
            throw new DvdLibraryDaoException(
                    "Could not save student data.", e);
        }

        // Write out the dvd objects to the library file.
        String dvdAsText;
        List<Dvd> dvdList = this.getAllDvds();
        for (Dvd currentDvd : dvdList) {
            // turn a Dvd into a String
            dvdAsText = marshallDvd(currentDvd);
            // write the Dvd object to the file
            out.println(dvdAsText);
            // force PrintWriter to write line to the file
            out.flush();
        }
        // Clean up
        out.close();
    }

}
