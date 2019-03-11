package junit_mockito_practice.junit_mockito_practice;

import java.util.ArrayList;
import java.util.List;

// WorkBusinessImpl is SUT - System Under Test
// IWorkService is Dependency

public class WorkBusinessImpl {
	private IWorkService workService;

	public WorkBusinessImpl(IWorkService workService) {
		this.workService = workService;
	}

	public List<String> retrieveWorksRelatedToDeveloper(String user) {
		List<String> filteredWorks = new ArrayList<>();
		List<String> allWorks = workService.retrieveWorks(user);
		for (String work : allWorks) {
			if (work.contains("DEV"))
				filteredWorks.add(work);
		}
		return filteredWorks;
	}

}
