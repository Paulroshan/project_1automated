package backend.poc.BackEnd;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.mockito.Mockito.when;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class	)
class BackEndApplicationTests
{
	@MockBean
	ResourceRepository repo;
	
	@Autowired
	ResourceService service;
	
	@Test
	public void testlist1()
	
	{
		Resource res1=new Resource(21001, "Manoj Kumar", new String[] {"React","HTML","MUI","BS"}, 400000, "Banglore");
		Resource res2=new Resource(19023, "Aarthi Aiyanar", new String[] {"Python","Spring","React"}, 400000, "Banglore");
		Resource res3=new Resource(20912, "Paul Roshan", new String[] {"HTML","BS","JS","React"}, 341000, "Chennai");
		Resource res4=new Resource(21004, "Kumar", new String[] {"Spring","Hibernate","Java"}, 250000, "Salem");
		
		when(repo.findAll()).thenReturn(Stream.of(res1,res2,res3,res4).collect(Collectors.toList()));

		
		assertNotNull(service.list());
		
	}
     
//	@Test
//	public void testlist2()
//	{
//
//		Resource res1=new Resource(21001, "Manoj Kumar", new String[] {"React","HTML","MUI","BS"}, 400000, "Banglore");
//		Resource res2=new Resource(19023, "Aarthi Aiyanar", new String[] {"Python","Spring","React"}, 400000, "Banglore");
//		Resource res3=new Resource(20912, "Paul Roshan", new String[] {"HTML","BS","JS","React"}, 341000, "Chennai");
//		Resource res4=new Resource(21004, "Kumar", new String[] {"Spring","Hibernate","Java"}, 250000, "Salem");
//		
//		when(repo.findAll()).thenReturn(Stream.of(res1,res2,res3,res4).collect(Collectors.toList()));
//
//		
//		assertNotNull(service.list());
//		
//	}
	
	@Test
	public void testlist3()
	{
		Resource res1=new Resource(21001, "Manoj Kumar", new String[] {"React","HTML","MUI","BS"}, 400000, "Banglore");
	    
		when(repo.save(res1)).thenReturn(res1);
		
		assertSame("Manoj Kumar",service.create(res1).getResName());
	
	}
    
	@Test
	public void testlist4()
	{
		Resource res3=new Resource(20912, "Paul Roshan", new String[] {"HTML","BS","JS","React"}, 341000, "Chennai");
        when(repo.save(res3)).thenReturn(res3);
        assertEquals(20912, service.create(res3).getResId());
	}
	
	@Test
	public void testlist5()
	{
		Resource res2=new Resource(19023, "Aarthi Aiyanar", new String[] {"Python","Spring","React"}, 400000, "Banglore");
	    when(repo.save(res2)).thenReturn(res2);
	    assertEquals(400000, service.create(res2).getResPay());
	
	}
	
	
}

