package junit_mockito_practice.junit_mockito_practice;

import java.util.Arrays;
import java.util.List;

public class WorkServiceStub implements IWorkService {

	@Override
	public List<String> retrieveWorks(String user) {
		return Arrays.asList("DEV-Develop Application", "DEV- Make Unit tests", "DEV- Devops", "ADMIN - Manage resources");
	}

}
