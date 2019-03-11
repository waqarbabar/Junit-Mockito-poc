package junit_mockito_practice.junit_mockito_practice;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.Test;



public class ListTest {

	@Test
	public void mockListSize() {
		List mockList = mock(List.class);
		when(mockList.size()).thenReturn(10);
		assertEquals(10, mockList.size());
	}

	@Test
	public void mockListWithMultiSize() {
		List mockList = mock(List.class);
		when(mockList.size()).thenReturn(10);
		assertEquals(10, mockList.size());
		when(mockList.size()).thenReturn(20).thenReturn(1);
		assertEquals(20, mockList.size());
		assertEquals(1, mockList.size());
	}
	
	@Test
	public void mockListWithGetMethod() {
		List mockList = mock(List.class);
		when(mockList.get(5)).thenReturn("this is 5");
		assertEquals("this is 5", mockList.get(5));
		assertEquals(null, mockList.get(100));
	}
	
	@Test
	public void mockListWithGetMethod_ArgMatcher() {
		List mockList = mock(List.class);
		when(mockList.get(anyInt())).thenReturn("this is 5");
		assertEquals("this is 5", mockList.get(5));
		assertEquals("this is 5", mockList.get(100));
	}
	
	@Test(expected=RuntimeException.class)
	public void mockListWithGetMethod_ThrowException() {
		List mockList = mock(List.class);
		when(mockList.get(anyInt())).thenThrow(new RuntimeException("Somthing went wrong!"));
		mockList.get(5);
	}
}
