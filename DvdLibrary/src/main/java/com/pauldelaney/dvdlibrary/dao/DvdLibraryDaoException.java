package com.pauldelaney.dvdlibrary.dao;

/**
 *
 * @author pauldelaney
 */
public class DvdLibraryDaoException extends Exception {

    // This class inherits from the Exception class
    // We want the DvdLibraryDaoException to act just like Exception
    // We call super on both these constructors so that the base class
    // constructors can do all the hard work of initialising our object.
    public DvdLibraryDaoException(String message) {
        super(message);
    }

    public DvdLibraryDaoException(String message, Throwable cause) {
        super(message, cause);
    }
}
