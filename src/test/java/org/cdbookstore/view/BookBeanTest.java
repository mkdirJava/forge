package org.cdbookstore.view;


import javax.inject.Inject;
import org.cdbookstore.model.Author;
import org.cdbookstore.model.Book;
import org.cdbookstore.model.Language;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;


@RunWith(Arquillian.class)
public class BookBeanTest {

	@Inject
	private BookBean bookBean;

	@Deployment
	public static JavaArchive createDeployment() {

	return ShrinkWrap.create(JavaArchive.class)
            .addClasses(Book.class, Language.class, Author.class)
            .addClass(BookBean.class)
            .addAsManifestResource("META-INF/persistence.xml", "persistence.xml")
            .addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml");

	}

	@Test
	public void should_be_deployed() {
		Assert.assertNotNull(bookBean);
	}
}
