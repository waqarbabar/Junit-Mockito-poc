package junit_mockito_practice.junit_mockito_practice;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
public class WorkBusinessImplStubTest {

	@Test
	public void testRetrieveWorks_UsingStubs() {
		IWorkService workServiceStub = new WorkServiceStub();
		WorkBusinessImpl workBusinessImpl = new WorkBusinessImpl(workServiceStub);
		List<String> filteredWorks = workBusinessImpl.retrieveWorksRelatedToDeveloper("Dummy");
		
		assertEquals(3, filteredWorks.size());
	}
}
