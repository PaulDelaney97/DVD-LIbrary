package com.pauldelaney.dvdlibrary.controller;

import com.pauldelaney.dvdlibrary.dao.DvdLibraryDao;
import com.pauldelaney.dvdlibrary.dao.DvdLibraryDaoException;
import com.pauldelaney.dvdlibrary.dto.Dvd;
import com.pauldelaney.dvdlibrary.ui.DvdLibraryView;
import java.util.List;

/**
 *
 * @author pauldelaney
 */
public class DvdLibraryController {

    /* This is the controller for the program. This class will delagate
    *  functionaility from the dvdlibrarydao package and update the UI
    *  using the dvdLibraryView. The controller is the 'brains of the operation
    *  the idea here is that the controller does not do any of the work required
    *  to use the DVD library. This class uses the other 'worker' classes to
    *  control the prorgrams operations.
     */
    // declare variables : dependency injection
    private DvdLibraryView view;
    private DvdLibraryDao dao;

    // contructor
    public DvdLibraryController(DvdLibraryDao dao, DvdLibraryView view) {
        this.dao = dao;
        this.view = view;
    }

    public void run() throws DvdLibraryDaoException {
        // This is the method which runs the program.
        boolean keepGoing = true;
        int menuSelection = 0;
        while (keepGoing) {

            menuSelection = view.printMenuAndGetSelection();

            // Switch case is controlled by user selection
            switch (menuSelection) {
                case 1:
                    createDvd();
                    break;
                case 2:
                    removeDvd();
                    break;
                case 3:
                    editDvd();
                    break;
                case 4:
                    listDvds();
                    break;
                case 5:
                    viewDvd();
                    break;
                case 6:
                    keepGoing = false;
                    break;
                default:
                    unknownCommand();
                    break;
            }
        }

        exitMessage();
    }

    public void createDvd() throws DvdLibraryDaoException {
        // uses the dao and the view to create a new Dvd in the library
        Dvd newDvd = view.getNewDvdInfo();
        dao.addDvd(newDvd.getTitle(), newDvd);
        view.displayCreateDvdSuccessMessage();
    }

    private void listDvds() throws DvdLibraryDaoException {
        // uses dao and view to list all Dvds
        List<Dvd> dvdList = dao.getAllDvds();
        view.displayDvdList(dvdList);
    }

    private void viewDvd() throws DvdLibraryDaoException {
        // uses dao and view to view a dvd for a given title
        String title = view.getDvdTitleChoice();
        Dvd dvd = dao.getDvd(title);
        view.displayDvd(dvd);
    }

    private void removeDvd() throws DvdLibraryDaoException {
        // uses dao and view to remove a given dvd
        String title = view.getDvdTitleChoice();
        Dvd removedDvd = dao.removeDvd(title);
        view.displayRemoveResult(removedDvd);
    }

    private void editDvd() throws DvdLibraryDaoException {
        // Method allows a user to edit a dvd
        int editMenu = 0;
        boolean keepEditing = true;
        String dvdToEdit = view.getDvdTitleChoice();

        while (keepEditing) {

            editMenu = view.printEditMenuAndGetSelection();

            // switch cases are controller by users choice
            switch (editMenu) {
                case 1:
                    editTitle(dvdToEdit);
                    break;
                case 2:
                    editReleaseDate(dvdToEdit);
                    break;
                case 3:
                    editMpaaRating(dvdToEdit);
                    break;
                case 4:
                    editDirectorName(dvdToEdit);
                    break;
                case 5:
                    editStudio(dvdToEdit);
                    break;
                case 6:
                    editReview(dvdToEdit);
                    break;
                case 7:
                    keepEditing = false;
                    break;
                default:
                    unknownCommand();
                    break;
            }
        }
    }

    private void editTitle(String title) throws DvdLibraryDaoException {
        // uses dao and view to allow the user to edit a dvds title
        String newTitle = view.getDvdTitleChoice();
        Dvd editedDvd = dao.editTitle(title, newTitle);
        view.printDvdEditSuccessMessage(editedDvd);
    }

    private void editReleaseDate(String title) throws DvdLibraryDaoException {
        // uses dao and view to allow the user to edit a dvdsrelease date
        String newReleaseDate = view.getDvdReleaseDateChoice();
        Dvd editedDvd = dao.editReleaseDate(title, newReleaseDate);
        view.printDvdEditSuccessMessage(editedDvd);
    }

    private void editMpaaRating(String title) throws DvdLibraryDaoException {
        // uses dao and view to allow the user to edit a Mpaa rating
        String newMpaaRating = view.getDvdMpaaRatingChoice();
        Dvd editedDvd = dao.editMpaaRating(title, newMpaaRating);
        view.printDvdEditSuccessMessage(editedDvd);
    }

    private void editDirectorName(String title) throws DvdLibraryDaoException {
        // uses dao and view to allow the user to edit a dvds director name
        String newDirectorName = view.getDvdDirectorNameChoice();
        Dvd editedDvd = dao.editDirectorName(title, newDirectorName);
        view.printDvdEditSuccessMessage(editedDvd);
    }

    private void editStudio(String title) throws DvdLibraryDaoException {
        // uses dao and view to allow the user to edit a dvds studio
        String newStudio = view.getDvdStudioChoice();
        Dvd editedDvd = dao.editStudio(title, newStudio);
        view.printDvdEditSuccessMessage(editedDvd);
    }

    private void editReview(String title) throws DvdLibraryDaoException {
        // uses dao and view to allow the user to edit a dvds user review
        String newReview = view.getDvdUserNoteChoice();
        Dvd editedDvd = dao.editReview(title, newReview);
        view.printDvdEditSuccessMessage(editedDvd);
    }

    private void unknownCommand() {
        // uses view to display unknown command
        view.displayUnkownCommandMessage();
    }

    private void exitMessage() {
        // uses view to display exit message
        view.displayExitMessage();
    }
}
