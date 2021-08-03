package com.pauldelaney.dvdlibrary.ui;

import com.pauldelaney.dvdlibrary.dto.Dvd;
import java.util.List;

/**
 *
 * @author pauldelaney
 */
public class DvdLibraryView {

    private UserIO io;  // Create user input output

    //constructor
    public DvdLibraryView(UserIO io) {
        this.io = io;
    }

    public int printMenuAndGetSelection() {
        /*  This method us used to print the main DVD library menu
        *   This method returns an integer input by the user.
         */

        io.print("================================================");
        io.print("DVD MENU");
        io.print("Welcome to the DVD Library! ");
        io.print("================================================");
        io.print("1. Add a Dvd to the library");
        io.print("2. Remove a Dvd from the library");
        io.print("3. Edit a Dvd in the library");
        io.print("4. List all Dvds in the library");
        io.print("5. View information for a particular Dvd");
        io.print("6. Exit");
        io.print("================================================");

        return io.readInt("Please select the operation you wish"
                + " to perform. ", 1, 6);

    }

    public int printEditMenuAndGetSelection() {
        /*  This method is used to print the options for editing an entry in
        *   the library. This method returns an integer input by the user.
         */

        io.print("DVD EDIT MENU");
        io.print("1. Edit Dvd Title");
        io.print("2. Edit Dvd Release Date");
        io.print("3. Edit MPAA Rating");
        io.print("4. Edit Director's Name");
        io.print("5. Edit Studio");
        io.print("6. Edit Review");
        io.print("7. Back to Main Menu");

        return io.readInt("Please select the operation you wish"
                + " to perform. ", 1, 7);
    }

    public void printDvdEditSuccessMessage(Dvd editDvd) {
        // This method confirms that a DVD has been edited
        io.print("Dvd has been successfully edited. ");
        displayDvd(editDvd);
    }

    public Dvd getNewDvdInfo() {
        //  This method is used to get all the info required to add a new dvd
        String title = io.readString("Please enter the title of the Dvd: ");
        String releaseDate = io.readString("Please enter the release date: ");
        String mpaaRating = io.readString("Please enter the MPAA rating: ");
        String directorName = io.readString("Please enter the director's name:");
        String studio = io.readString("Please enter the studio of the Dvd: ");
        String userNote = io.readString("Please leave a review/note: ");

        // sets input info to correct dvd fields
        Dvd currentDvd = new Dvd(title);
        currentDvd.setReleaseDate(releaseDate);
        currentDvd.setMpaaRating(mpaaRating);
        currentDvd.setDirectorName(directorName);
        currentDvd.setStudio(studio);
        currentDvd.setUserNote(userNote);

        return currentDvd;
    }

    public void displayCreateDvdSuccessMessage() {
        // Display confirmation that a dvd has been added
        io.print("Dvd Successfully added to the library.");
        io.readString("Please press enter to continue.");
    }

    public void displayDvdList(List<Dvd> dvdList) {
        // Method displays all Dvds in the library
        for (Dvd currentDvd : dvdList) {
            String dvdInfo = String.format(" %s \n %s \n %s \n %s \n %s \n %s",
                    currentDvd.getTitle(),
                    currentDvd.getReleaseDate(),
                    currentDvd.getMpaaRating(),
                    currentDvd.getDirectorName(),
                    currentDvd.getStudio(),
                    currentDvd.getUserNote());
            io.print(dvdInfo);
            io.print("================================================");

        }
        io.readString("Please hit enter to continue.");
    }

    public String getDvdTitleChoice() {
        // This method lets the user choose a Dvd by title
        return io.readString("Please enter the title of the Dvd: ");
    }

    public void displayDvd(Dvd dvd) {
        // This method prints out the information on a given dvd
        if (dvd != null) {   //ensures the dvd exists
            String dvdInfo = String.format(" %s \n %s \n %s \n %s \n %s \n %s",
                    dvd.getTitle(),
                    dvd.getReleaseDate(),
                    dvd.getMpaaRating(),
                    dvd.getDirectorName(),
                    dvd.getStudio(),
                    dvd.getUserNote());
            io.print(dvdInfo);
        } else {
            io.print("No such Dvd.");
        }
        io.readString("Please hit enter to continue.");
    }

    public void displayRemoveResult(Dvd dvdRecord) {
        // This method confirms that a dvd has been removed
        if (dvdRecord != null) {
            io.print("Dvd successfully removed.");
        } else {
            io.print("No such Dvd");
        }
        io.readString("Please hit enter to continue.");
    }

    public String getDvdReleaseDateChoice() {
        // This method lets the user choose release date
        return io.readString("Please enter the release date of the Dvd: ");
    }

    public String getDvdMpaaRatingChoice() {
        // This method lets the user choose MpaaRating
        return io.readString("Please enter the Mpaa rating of the Dvd: ");
    }

    public String getDvdDirectorNameChoice() {
        // This method lets the user choose directors name
        return io.readString("Please enter the director's name: ");
    }

    public String getDvdStudioChoice() {
        // This method lets the user choose studio
        return io.readString("Please enter the studio of the Dvd: ");
    }

    public String getDvdUserNoteChoice() {
        // This method lets the user leave a review
        return io.readString("Please leave a review of the Dvd: ");
    }

    public void displayUnkownCommandMessage() {
        // prints unknown command
        io.print("Unknown Command!");
    }

    public void displayExitMessage() {
        // prints exit message
        io.print("Thank you for using the DVD Library! Good Bye!");
    }

    public void displayErrorMessage(String errorMsg) {
        // prints error message
        io.print("==== ERROR ====");
        io.print(errorMsg);
    }
}
