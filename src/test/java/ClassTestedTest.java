import org.easymock.EasyMockRule;
import org.easymock.EasyMockSupport;
import org.easymock.Mock;
import org.easymock.TestSubject;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;


public class ClassTestedTest extends EasyMockSupport {

    @Rule
    public EasyMockRule rule = new EasyMockRule(this);

    @Mock
    private ClassTested.Collaborator collaborator; // 1 Create the mock

    @TestSubject
    private ClassTested classUnderTest = new ClassTested(); // 2 Have it set to the tested class

    @Before
    public void setUp() {
        collaborator = mock(ClassTested.Collaborator.class); // 1
        classUnderTest = new ClassTested();
        classUnderTest.setListener(collaborator);
    }

    @Test
    public void addDocument_call_documentAdded() {
        // Arrange
        collaborator.documentAdded("New Document"); // 3 Record what we expect the mock to do
        replayAll(); // 4 Tell all mocks we are now doing the actual testing

        // Act
        classUnderTest.addDocument("New Document"); // 5 Test

        // Assert
        verifyAll(); // 6 Make sure everything that was supposed to be called was called
    }

    @Test
    public void removeDocument_that_doesnt_exist_do_not_call_documentAdded() {
        // Arrange
        // 2 (we do not expect anything)
        //replayAll(); // 3

        classUnderTest.removeDocument("Does not exist");
    }
}