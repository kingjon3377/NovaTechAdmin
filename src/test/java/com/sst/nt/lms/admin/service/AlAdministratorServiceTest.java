package com.sst.nt.lms.admin.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.sql.SQLException;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.sst.nt.lms.admin.dao.AuthorDao;
import com.sst.nt.lms.admin.dao.PublisherDao;
import com.sst.nt.lms.admin.exception.TransactionException;
import com.sst.nt.lms.admin.model.Author;
import com.sst.nt.lms.admin.model.Book;
import com.sst.nt.lms.admin.model.Borrower;
import com.sst.nt.lms.admin.model.Branch;
import com.sst.nt.lms.admin.model.Publisher;

/**
 * Tests of administrator service.
 *
 * @author Al Amine Ahmed Moussa
 * @author Jonathan Lovelace (integration and polishing)
 */
@ExtendWith(SpringExtension.class)
@SpringBootTest
public class AlAdministratorServiceTest {
	/**
	 * The service under test.
	 */
	@Autowired
	private AdministratorService administratorService;
	/**
	 * Author DAO used in tests.
	 */
	@Autowired
	private AuthorDao authorDao;
	/**
	 * Publisher DAO used in tests.
	 */
	@Autowired
	private PublisherDao publisherDao;


	/**
	 * Test that creating a book works.
	 *
	 * @throws SQLException         on database error
	 * @throws TransactionException on error caught by the service
	 */
	@Test
	public void createBookTest() throws SQLException, TransactionException {
		final String str = "Admin Book Test";

		final Author author = authorDao.findById(1).orElse(null);
		final Publisher publisher = publisherDao.findById(1).orElse(null);

		final Book b = administratorService.createBook(str, author, publisher);

		assertEquals(str, b.getTitle(), "created book has expected title");
	}

	/**
	 * Test that creating an author works.
	 *
	 * @throws SQLException         on database error
	 * @throws TransactionException on error caught by the service
	 */
	@Test
	public void createAuthorTest() throws SQLException, TransactionException {
		final String str = "Author Admin Test";
		final Author author = administratorService.createAuthor(str);
		assertEquals(str, author.getName(), "created author has expected name");
	}

	/**
	 * Test that creating a publisher works.
	 *
	 * @throws SQLException         on database error
	 * @throws TransactionException on error caught by the service
	 */
	@Test
	public void createPublisherTest() throws SQLException, TransactionException {
		final String str1 = "Publisher2";
		final String str2 = "AddressTest2";
		final String str3 = "PhoneTest2";

		final Publisher publisher = administratorService.createPublisher(str1, str2,
				str3);
		assertEquals(str1, publisher.getName(),
				"created publisher has expected name");
		assertEquals(str2, publisher.getAddress(),
				"created publisher has expected address");
		assertEquals(str3, publisher.getPhone(),
				"created publisher has expected phone");
	}

	/**
	 * Test that creating a branch works.
	 *
	 * @throws SQLException         on database error
	 * @throws TransactionException on error caught by the service
	 */
	@Test
	public void createBranchTest() throws SQLException, TransactionException {
		final String str1 = "Branch1";
		final String str2 = "AddressTest1";

		final Branch branch = administratorService.createBranch(str1, str2);
		assertEquals(str1, branch.getName(), "created branch has expected name");
		assertEquals(str2, branch.getAddress(),
				"created branch has expected address");
	}

	/**
	 * Test that creating a borrower works.
	 *
	 * @throws SQLException         on database error
	 * @throws TransactionException on error caught by the service
	 */
	@Test
	public void createBorrowerTest() throws SQLException, TransactionException {
		final String str1 = "Borrower1";
		final String str2 = "AddressTest21";
		final String str3 = "PhoneTest1";

		final Borrower borrower = administratorService.createBorrower(str1, str2,
				str3);
		assertEquals(str1, borrower.getName(), "created borrower has expected name");
		assertEquals(str2, borrower.getAddress(),
				"created borrower has expected address");
		assertEquals(str3, borrower.getPhone(),
				"created borrower has expected phone");
	}
}
