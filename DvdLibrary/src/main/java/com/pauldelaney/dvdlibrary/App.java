package com.pauldelaney.dvdlibrary;

import com.pauldelaney.dvdlibrary.controller.DvdLibraryController;
import com.pauldelaney.dvdlibrary.dao.DvdLibraryDao;
import com.pauldelaney.dvdlibrary.dao.DvdLibraryDaoException;
import com.pauldelaney.dvdlibrary.dao.DvdLibraryDaoFileImpl;
import com.pauldelaney.dvdlibrary.ui.DvdLibraryView;
import com.pauldelaney.dvdlibrary.ui.UserIO;
import com.pauldelaney.dvdlibrary.ui.UserIOConsoleImpl;

/**
 *
 * @author pauldelaney
 */
public class App {

    public static void main(String[] args) throws DvdLibraryDaoException {

        // This is the main apilication of the Dvd Library.
        // Create user input/output
        UserIO myIo = new UserIOConsoleImpl();
        // Create view
        DvdLibraryView myView = new DvdLibraryView(myIo);
        // Create Dao
        DvdLibraryDao myDao = new DvdLibraryDaoFileImpl();
        // Create controller
        DvdLibraryController controller = new DvdLibraryController(myDao, myView);
        // Run the program
        controller.run();
    }
}
