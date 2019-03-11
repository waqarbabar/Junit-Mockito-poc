package junit_mockito_practice.junit_mockito_practice;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class WorkBusinessImplMockTest {

	@Test
	public void testRetrieveWorks_UsingAMock() {
		IWorkService workServiceMock = mock(IWorkService.class);
		
		when(workServiceMock.retrieveWorks("Dummy")).thenReturn(Arrays.asList("DEV-Develop Application",
				"DEV- Make Unit tests", "DEV- Devops", "ADMIN - Manage resources"));
		
		WorkBusinessImpl workBusinessImpl = new WorkBusinessImpl(workServiceMock);
		
		List<String> filteredWorks = workBusinessImpl.retrieveWorksRelatedToDeveloper("Dummy");

		assertEquals(3, filteredWorks.size());
	}
	
	@Test
	public void testRetrieveWorks_UsingAMock_WithEmptyList() {
		IWorkService workServiceMock = mock(IWorkService.class);
		when(workServiceMock.retrieveWorks("Dummy")).thenReturn(Arrays.asList());
		WorkBusinessImpl workBusinessImpl = new WorkBusinessImpl(workServiceMock);
		List<String> filteredWorks = workBusinessImpl.retrieveWorksRelatedToDeveloper("Dummy");

		assertEquals(0, filteredWorks.size());
	}
}
