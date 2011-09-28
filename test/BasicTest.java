import org.junit.*;
import java.util.*;
import play.test.*;
import models.*;

public class BasicTest extends UnitTest {

	@Before
    public void setup() {
        Fixtures.deleteAll();
    }
 	@Test
	    public void createArticle(){
	    	new Article("Hello World", "Welcome to the summary", "And the content").save();

	    	Article a = Article.find("byTitle","Hello World").first();
	    	assertNotNull(a);
            // Check postedAt is being set automagically.
            assertNotNull(a.postedAt);
	    }

		@Test
		public void articleFullTest(){
			Fixtures.loadModels("articles.yml");
			assertEquals(2, Article.count());

		}

}
