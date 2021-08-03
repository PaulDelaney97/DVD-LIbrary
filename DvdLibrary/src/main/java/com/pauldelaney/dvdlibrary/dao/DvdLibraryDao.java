package com.pauldelaney.dvdlibrary.dao;

import com.pauldelaney.dvdlibrary.dto.Dvd;
import java.util.List;

/**
 *
 * @author pauldelaney
 */
public interface DvdLibraryDao {

    /**
     * Adds a DVD to the library and associates it with the given movie title.If
     * there is already a DVD associated with this title it will return that DVD
     * object, otherwise it will return null.
     *
     * @param title title which the Dvd is to be associated
     * @param dvd Dvd object to be added to the library
     * @return the Dvd object previously associated with the given title if it
     * exists, otherwise returns null
     * @throws com.pauldelaney.dvdlibrary.dao.DvdLibraryDaoException
     */
    Dvd addDvd(String title, Dvd dvd) throws DvdLibraryDaoException;

    /**
     * Returns a particular Dvd in the library.
     *
     * @param title title of Dvd to be retrieved.
     * @return Dvd object
     * @throws com.pauldelaney.dvdlibrary.dao.DvdLibraryDaoException
     */
    Dvd getDvd(String title) throws DvdLibraryDaoException;

    /**
     * Returns a list of all Dvds in the library.
     *
     * @return list containing object containing all Dvds in the library
     * @throws com.pauldelaney.dvdlibrary.dao.DvdLibraryDaoException
     */
    List<Dvd> getAllDvds() throws DvdLibraryDaoException;

    /**
     * Remove the Dvd associated with the given name from the library.Returns
     * the Dvd object that is being removed or null if there is no Dvd
     * associated with the given title
     *
     * @param title title of the Dvd to be removed
     * @return Dvd object associated with the given title, null if no such Dvd
     * object exits
     * @throws com.pauldelaney.dvdlibrary.dao.DvdLibraryDaoException
     */
    Dvd removeDvd(String title) throws DvdLibraryDaoException;

    /**
     * Edit a Dvd entry in the library from a given Dvd title.Returns the newly
     * updated Dvd object based on the edits made by the user.
     *
     * @param title title of the Dvd to be edited
     * @param dvd
     * @return Dvd object which has been updated
     * @throws com.pauldelaney.dvdlibrary.dao.DvdLibraryDaoException
     */
    Dvd editDvd(String title, Dvd dvd) throws DvdLibraryDaoException;

    /**
     * @param title
     * @param newTitle
     * @return Dvd object with edited title
     * @throws DvdLibraryDaoException
     */
    Dvd editTitle(String title, String newTitle) throws DvdLibraryDaoException;

    /**
     *
     * @param title
     * @param releaseDate
     * @return Dvd object with edited release date
     * @throws DvdLibraryDaoException
     */
    Dvd editReleaseDate(String title, String releaseDate) throws DvdLibraryDaoException;

    /**
     *
     * @param title
     * @param mpaaRating
     * @return Dvd object with edited Mpaa Rating
     * @throws DvdLibraryDaoException
     */
    Dvd editMpaaRating(String title, String mpaaRating) throws DvdLibraryDaoException;

    /**
     *
     * @param title
     * @param directorName
     * @return Dvd object with edited director name
     * @throws DvdLibraryDaoException
     */
    Dvd editDirectorName(String title, String directorName) throws DvdLibraryDaoException;

    /**
     *
     * @param title
     * @param studio
     * @return Dvd object with edited studio
     * @throws DvdLibraryDaoException
     */
    Dvd editStudio(String title, String studio) throws DvdLibraryDaoException;

    /**
     *
     * @param title
     * @param review
     * @return Dvd object with edited Review
     * @throws DvdLibraryDaoException
     */
    Dvd editReview(String title, String review) throws DvdLibraryDaoException;

}
